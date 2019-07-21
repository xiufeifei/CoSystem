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
public class Admin extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 管理员账号
     */
    private String account;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 
     */
    private String name;

    /**
     * 性别
     */
    private Byte gender;
}