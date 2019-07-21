package com.kmxy.entity;

import com.kmxy.utils.BeanStateEnum;
import com.kmxy.utils.Const;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseBean {
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private Byte state;

    private String info;

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }


    public Byte getState() {
        return state;
    }


    public void setState(Byte state) {
        this.state = state;
    }
    /**
     * 获取简介
     *
     * @return info 简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置简介
     *
     * @param info 简介
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

//////////////////////////////////////////////////////////////////////////////////////////
public String getCreateTimeStr() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
    String format = dtf.format(createTime);
    return format.substring(0, format.indexOf('日')+1)+"<br>"+format.substring( format.indexOf('日')+1);
}

    public String getUpdateTimeStr() {
        if(updateTime!=null){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        String format = dtf.format(updateTime);
        return format.substring(0, format.indexOf('日')+1)+"<br>"+format.substring( format.indexOf('日')+1);
        }
        return null;
    }


    public String getStateStr(){
        if (state!=null) {
            return BeanStateEnum.getNameByType(state);
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
