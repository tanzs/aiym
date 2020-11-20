package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @author tanzs
* @date 2020-08-05
*/
@Data
public class ArticleQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String title;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String content;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String tags;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String type;

    /** 精确 */
    @Query
    private String status;

    /** 精确 */
    @Query
    private Integer uid;
    /** BETWEEN */
    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}