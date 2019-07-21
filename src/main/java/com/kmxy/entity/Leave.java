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
public class Leave extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 留言id
     */
    private Integer leaveId;

    /**
     * 留言内容
     */
    private String content;
}