package com.kmxy.controller.admin;

import com.kmxy.entity.Files;
import com.kmxy.service.FilesService;
import com.kmxy.utils.Const;
import com.kmxy.utils.PageBean;
import com.kmxy.utils.pathUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.List;


/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Controller
@RequestMapping("/admin/files")
public class FilesController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private FilesService filesService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav, Integer pageNum, Integer pageSize, Files files, HttpServletRequest request) {
        if (request.getParameter("name") != null && request.getParameter("name") != " "
                && request.getParameter("name") != "") {
            String name = request.getParameter("name");
            files.setName(name);
        }
        if (request.getParameter("format") != null && request.getParameter("format") != " "
                && request.getParameter("format") != "") {
            String format = request.getParameter("format");
            files.setFormat(format);
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }

        PageBean pageBean = filesService.findbyCondition(pageNum, pageSize, files);
        pageBean.setUrl("admin/files/list");
        mav.addObject("data", pageBean);
        mav.setViewName("files/list");
        return mav;
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("fileName");
        /*Files files = filesService.selectById(filesId);
        String filesName = files.getName();
        String filesFormat = files.getFormat();
        String realName=filesName + filesFormat;*/
        String realPath = request.getServletContext().getRealPath("/static/document/"+fileName);
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + new String(fileName.getBytes("utf-8"), "iso-8859-1"));

        //String path = request.getServletContext().getRealPath("/static/document/"+fileName);
        System.out.println("*****" + realPath);
        FileInputStream is = new FileInputStream(realPath);
        OutputStream out = response.getOutputStream();
        IOUtils.copy(is, out);
        is.close();
        out.flush();
        out.close();

    }

    @RequestMapping("/deleteByPrimaryKey")
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        int filesId = Integer.parseInt(request.getParameter("filesId"));
        Files files = filesService.selectById(filesId);
        String filesName = files.getName();
        String filesFormat = files.getFormat();
        int delete = filesService.deleteByPrimaryKey(filesId);
        String realPath = request.getServletContext().getRealPath("/static/document/");
        File file = new File(realPath + filesName + filesFormat);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (delete > 0) {//成功
            request.setAttribute("url", "list");
            try {
                request.getRequestDispatcher("/comm/success.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {//失败
            try {
                request.getRequestDispatcher("/comm/error.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest request, HttpServletResponse response, Files files) {
        String filename = request.getParameter("filename");
        String info = request.getParameter("info");
        String fileName = (String) request.getSession().getAttribute("fileName");
        String firstName = (String) request.getSession().getAttribute("firstName");
        files.setName(firstName);
        Files files1 = filesService.selectByName(files);
        Integer id = files1.getId();

        files.setId(id);
        files.setName(filename);
        files.setInfo(info);
        int i = filesService.update(files);

        String suffix = fileName.substring(fileName.lastIndexOf("."));//获取后缀
        String realPath = request.getServletContext().getRealPath("/static/document/");
        File oldFile = new File( realPath+ fileName);
        File newFile = new File( realPath+ filename + suffix);
        oldFile.renameTo(newFile);

        if (i > 0) {//成功
            request.setAttribute("url", "list");
            try {
                request.getRequestDispatcher("/comm/success.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {//失败
            try {
                request.getRequestDispatcher("/comm/error.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mav, Files files) {
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mav, Files files) {
        return mav;
    }

    @RequestMapping("/fileUploadServlet1")
    public void FileUploadServlet1(HttpServletRequest request, Files files) {
        // 1.创建DiskFileItemFactory对象，配置缓存用
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 2. 创建 ServletFileUpload对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        // 3. 设置文件名称编码
        servletFileUpload.setHeaderEncoding("utf-8");
        // 4. 开始解析文件
        try {
            Thread.sleep(2000);
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : items) {
                if (fileItem.isFormField()) { // 普通数据
                    String info = fileItem.getString("utf-8");
                    System.out.println("info:" + info);
                } else { // 文件
                    // 1. 获取文件名称
                    String name = fileItem.getName();
                    // 2. 获取文件的实际内容
                    InputStream is = fileItem.getInputStream();
                    // 3. 保存文件
                    String suffix = name.substring(name.lastIndexOf("."));//获取后缀
                    String firstName = name.substring(0, name.indexOf("."));//获取前缀
                    request.getSession().setAttribute("fileName", name);
                    request.getSession().setAttribute("firstName", firstName);
                    files.setName(firstName);
                    files.setFormat(suffix);
                    filesService.add(files);
                   // String path = pathUtil.getPath(servletContext);
                    String realPath = request.getServletContext().getRealPath("/static/document/");
                    System.out.println("path"+realPath);
                    FileUtils.copyInputStreamToFile(is, new File(realPath+ name));

                    // String path = pathRoot.substring(0, pathRoot.indexOf(t"));
                    //System.out.println(path);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

