package com.kmxy.entity;

import com.kmxy.utils.Const;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 *
 * @author kmxy
 * @date 2019-04-15
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Notice  {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 发布时间
     */
    private LocalDateTime ncreateTime;

    /**
     * 更新时间
     */
    private LocalDateTime nupdateTime;

    /**
     * 发布来源
     */
    private String origin;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 简介
     */
    private String ninfo;

    /**
     * 设置简介
     *
     * @param ninfo 简介
     */
    public void setInfo(String ninfo) {
        this.ninfo = ninfo == null ? null : ninfo.trim();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public String getCreateTimeStr() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        String format = dtf.format(ncreateTime);
        return format.substring(0, format.indexOf('日')+1)+"<br>"+format.substring( format.indexOf('日')+1);
    }

    public String getUpdateTimeStr() {
        if(nupdateTime!=null){

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String format = dtf.format(nupdateTime);
            return format.substring(0, format.indexOf('日')+1)+"<br>"+format.substring( format.indexOf('日')+1);
        }
        return null;
    }


    //////////////////////////////////分页相关///////////////////////////////////////
    private Integer pageNum = 1;
    private Integer pageSize = Const.PAGE_SIZE;

    public Integer getPageNum() {
        return (pageNum - 1) * pageSize;//返回pageNum页的第一条数据
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



    private Byte state;
}