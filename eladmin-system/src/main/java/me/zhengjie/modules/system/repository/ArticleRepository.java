package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author tanzs
* @date 2020-08-05
*/
public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {
}