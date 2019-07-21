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
public class Score extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 奖惩记录
     */
    private String experience;

    /**
     * 用户id
     */
    private Integer userId;
    private User user;

    /**
     * 考勤
     */
    private Integer attendance;
}