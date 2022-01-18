package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.HeadlinesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

   /**
    * get query articles
    *
    * @param query  query can be movies,
    */
    @GET("v2/everything/")
    Call<ArticleResponse> getMovieArticles(
            @Query("q") String query,
            @Query("apikey") String apiKey
    );


    /**
     * get headlines from a country
     *
     * @param country which country you want to fetch articles from
     * @param apiKey  api key for news api org
     */
    @GET("v2/top-headlines/")
    Call<ArticleResponse> getHeadlines(
            @Query("country") String country,
            @Query("apikey") String apiKey
    );
}
