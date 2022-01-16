package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ArticleDto;

import java.util.List;

public class HeadlinesResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("articles")
    @Expose
    private List<ArticleDto> articleDtoList = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ArticleDto> getArticleDtoList() {
        return articleDtoList;
    }

    public void setArticleDtoList(List<ArticleDto> articleDtoList) {
        this.articleDtoList = articleDtoList;
    }
}
