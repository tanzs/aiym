package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author tanzs
* @date 2020-08-05
*/
@Data
public class ArticleDto implements Serializable {

    private Integer id;

    /** 文章标题 */
    private String title;

    /** 文章内容（富文本） */
    private String content;

    /** 文章html内容 */
    private String html;

    /** 标签 */
    private String tags;

    /** 类型 */
    private String type;

    /** 状态（0 已发布 1 草稿箱 2 待审核  3审核不通过） */
    private String status;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /** 审核时间 */
    private Timestamp checkTime;

    /** 用户id */
    private Integer uid;

    private String back1;

    private String back2;

    private String back3;

    private String back4;

    private String back5;
}