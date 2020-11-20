package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.system.domain.Article;
import me.zhengjie.modules.system.service.dto.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author tanzs
* @date 2020-08-05
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper extends BaseMapper<ArticleDto, Article> {

}