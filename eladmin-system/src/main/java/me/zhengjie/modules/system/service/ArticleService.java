package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.Article;
import me.zhengjie.modules.system.service.dto.ArticleDto;
import me.zhengjie.modules.system.service.dto.ArticleQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author tanzs
* @date 2020-08-05
*/
public interface ArticleService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ArticleQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ArticleDto>
    */
    List<ArticleDto> queryAll(ArticleQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ArticleDto
     */
    ArticleDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return ArticleDto
    */
    ArticleDto create(Article resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(Article resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Integer[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<ArticleDto> all, HttpServletResponse response) throws IOException;
}