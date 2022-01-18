package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitService;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final RetrofitService apiService;

    public ArticleRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(RetrofitService.class);
    }

    public LiveData<ArticleResponse> getHeadlines(
            String country,
            String key
    ) {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiService.getHeadlines(country, key)
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        Log.d(TAG, " onResponse: " + response);
                        Log.d(TAG, " onResponse: " + response);
                        if (response.body() != null) {
                            Log.d(TAG, "onResponse: articles" + response.body().getArticles().toString());
                            data.setValue(response.body());


                            Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                            Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                            Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
