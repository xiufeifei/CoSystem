package com.kmxy.entity;

import com.kmxy.utils.Const;
import lombok.*;

import java.time.LocalDateTime;

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
public class Dynamic extends BaseBean{
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
     * 发布来源
     */
    private String origin;

    /**
     * 管理员id
     */
    private Integer adminId;


}