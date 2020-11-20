package me.zhengjie.modules.system.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author tanzs
* @date 2020-08-05
*/
@Entity
@Data
@Table(name="article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** 文章标题 */
    @Column(name = "title")
    private String title;

    /** 文章内容（富文本） */
    @Column(name = "content")
    private String content;

    /** 文章html内容 */
    @Column(name = "html")
    private String html;

    /** 标签 */
    @Column(name = "tags")
    private String tags;

    /** 类型 */
    @Column(name = "type")
    private String type;

    /** 状态（0 已发布 1 草稿箱 2 待审核  3审核不通过） */
    @Column(name = "status")
    private String status;

    /** 创建时间 */
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    /** 修改时间 */
    @Column(name = "update_time")
    private Timestamp updateTime;

    /** 审核时间 */
    @Column(name = "check_time")
    private Timestamp checkTime;

    /** 用户id */
    @Column(name = "uid")
    private Integer uid;

    @Column(name = "back1")
    private String back1;

    @Column(name = "back2")
    private String back2;

    @Column(name = "back3")
    private String back3;

    @Column(name = "back4")
    private String back4;

    @Column(name = "back5")
    private String back5;

    public void copy(Article source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}