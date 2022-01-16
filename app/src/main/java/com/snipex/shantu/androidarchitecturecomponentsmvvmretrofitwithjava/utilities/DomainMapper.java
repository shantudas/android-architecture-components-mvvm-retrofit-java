package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.utilities;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ArticleDto;

public interface DomainMapper {
    Article mapToDomainModel(ArticleDto dto);
}
