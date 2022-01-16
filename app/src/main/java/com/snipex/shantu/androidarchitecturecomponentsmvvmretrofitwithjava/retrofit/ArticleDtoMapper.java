package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit;


import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.utilities.DomainMapper;

import java.util.ArrayList;
import java.util.List;

public class ArticleDtoMapper implements DomainMapper{

    @Override
    public Article mapToDomainModel(ArticleDto dto) {
        Article article=new Article();
        article.setTitle(dto.getTitle());
        article.setAuthor(dto.getAuthor());
        return article;
    }

    public List<Article> mapToDomainList(List<ArticleDto> articleDtoList) {
        List<Article> headlineList = new ArrayList<>();
        for (int i = 0; i < articleDtoList.size(); i++) {
            headlineList.add(mapToDomainModel(articleDtoList.get(i)));
        }
        return headlineList;
    }
}
