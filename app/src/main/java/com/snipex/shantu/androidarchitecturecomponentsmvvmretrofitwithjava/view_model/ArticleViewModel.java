package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ArticleRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;

import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.API_KEY;
import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.ARTICLE_QUERY;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles(ARTICLE_QUERY, API_KEY);
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}
