package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;

import java.util.List;

public class HeadlinesResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("articles")
    @Expose
    private List<Headline> headlines = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Headline> getHeadlines() {
        return headlines;
    }

    public void setHeadlines(List<Headline> headlines) {
        this.headlines = headlines;
    }
}
