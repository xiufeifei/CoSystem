package com.kmxy.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kmxy.utils.BeanStateEnum;
import com.kmxy.utils.Const;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 *
 * @author kmxy
 * @date 2019-04-16
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class User  {
    /**
     * 编号
     */
    private Integer uid;

    /**
     * 账号
     */
    private String uaccount;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 学号/教职工编号
     */
    private String num;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private Boolean ugender;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 入党状态
     */
    private Byte politic;

    /**
     * 培养人
     */
    private Integer foster;

    /**
     * 所属支部
     */
    private String branch;

    /**
     * 学历
     */
    private String education;

    /**
     * 院系
     */
    private String faculty;

    /**
     * 年级
     */
    private String junior;

    /**
     * 班级
     */
    private String grades;

    /**
     * 电话
     */
    private String tell;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 综合成绩id
     */
    private Integer scoreId;

    /**
     * 管理员id
     */
    private Integer adminId;

    private Admin admin;

    /**
     * 简介
     */
    private String uinfo;

    /**
     * 角色分类
     */
    private Byte player;

    /**
     * 职务
     */
    private String duty;

    private LocalDateTime ucreateTime;

    /**
     * 更新时间
     */
    private LocalDateTime uupdateTime;

    private Byte state;


    public String getStateStr(){
        if (state!=null){

        return BeanStateEnum.getNameByType(state);
        }
        return null;
    }

    /**
     * 设置简介
     *
     * @param uinfo 简介
     */
    public void setInfo(String uinfo) {
        this.uinfo = uinfo == null ? null : uinfo.trim();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public String getCreateTimeStr() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        String format = dtf.format(ucreateTime);
        return format.substring(0, format.indexOf('日')+1)+"<br>"+format.substring( format.indexOf('日')+1);
    }

    public String getUpdateTimeStr() {
        if(uupdateTime!=null){

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String format = dtf.format(uupdateTime);
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

}