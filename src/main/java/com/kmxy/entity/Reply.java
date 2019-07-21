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
public class Reply extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 回复id
     */
    private Integer replyId;

    /**
     * 回复内容
     */
    private String content;
}