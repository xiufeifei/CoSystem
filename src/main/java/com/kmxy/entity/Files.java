package com.kmxy.entity;

import lombok.*;

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
public class Files extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 文件、图片名
     */
    private String name;

    /**
     * 格式
     */
    private String format;

    /**
     * 地址
     */
    private String url;

    /**
     * 管理员id
     */
    private Integer adminId;

    private Admin admin;
}