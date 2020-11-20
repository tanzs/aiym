package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.domain.Article;
import me.zhengjie.modules.system.service.ArticleService;
import me.zhengjie.modules.system.service.dto.ArticleQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author tanzs
* @date 2020-08-05
*/
@Api(tags = "文章管理")
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('article:list')")
    public void download(HttpServletResponse response, ArticleQueryCriteria criteria) throws IOException {
        articleService.download(articleService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询文章")
    @ApiOperation("查询文章")
    @PreAuthorize("@el.check('article:list')")
    public ResponseEntity<Object> getArticles(ArticleQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(articleService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增文章")
    @ApiOperation("新增文章")
    @PreAuthorize("@el.check('article:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Article resources){
        return new ResponseEntity<>(articleService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改文章")
    @ApiOperation("修改文章")
    @PreAuthorize("@el.check('article:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Article resources){
        articleService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除文章")
    @ApiOperation("删除文章")
    @PreAuthorize("@el.check('article:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Integer[] ids) {
        articleService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}