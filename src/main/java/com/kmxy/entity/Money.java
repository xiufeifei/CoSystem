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
public class Money extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;
    private User user;

    /**
     * 金额
     */
    private Double amount;
}