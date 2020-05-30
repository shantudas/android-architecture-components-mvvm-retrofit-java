package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.HeadlinesResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ApiRequest;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeadlinesRepository {
    private static final String TAG = HeadlinesRepository.class.getSimpleName();
    private static HeadlinesRepository instance;
    private static ApiRequest apiRequest;
    private List<Headline> headlineArrayList = new ArrayList<>();

    public static HeadlinesRepository getInstance() {
        if (instance == null) {
            instance = new HeadlinesRepository();
            apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        }
        return instance;
    }


    public MutableLiveData<HeadlinesResponse> getHeadlines(String country, String apiKey) {
        MutableLiveData<HeadlinesResponse> data = new MutableLiveData<>();

        apiRequest.getHeadlines(country, apiKey).enqueue(new Callback<HeadlinesResponse>() {
            @Override
            public void onResponse(Call<HeadlinesResponse> call, Response<HeadlinesResponse> response) {
                if (response.body() != null) {
                    Log.i(TAG, "response code :: " + response.code());
                    Log.i(TAG, "response status :: " + response.body().getStatus());
                    data.setValue(response.body());


                    headlineArrayList=response.body().getHeadlines();
                    for (int i=0; i<headlineArrayList.size(); i++){
                        Headline headline= headlineArrayList.get(i);
                        Log.i(TAG, headline.toString());
                    }
                    Log.i(TAG, String.valueOf(data.getValue().getHeadlines().size()));
                }
            }

            @Override
            public void onFailure(Call<HeadlinesResponse> call, Throwable t) {

            }
        });
        return data;
    }


    /**
     * fake data
     */
    public MutableLiveData<List<Headline>> getFakeHeadlines() {
        headlineArrayList.clear();
        getFakeData();

        MutableLiveData<List<Headline>> data = new MutableLiveData<>();
        data.setValue(headlineArrayList);
        return data;
    }

    private void getFakeData() {
        headlineArrayList.add(new Headline("JCPenney department store files for bankruptcy - Sky News Australia",
                "JCPenney has become the latest retail casualty of the coronavirus crisis. The iconic United States department store chain has filed for bankruptcy and will c...",
                "https://i.ytimg.com/vi/m-HGjazxQQw/maxresdefault.jpg"));
        headlineArrayList.add(new Headline("JCPenney department store files for bankruptcy - Sky News Australia",
                "JCPenney has become the latest retail casualty of the coronavirus crisis. The iconic United States department store chain has filed for bankruptcy and will c...",
                "https://i.ytimg.com/vi/m-HGjazxQQw/maxresdefault.jpg"));
        headlineArrayList.add(new Headline("JCPenney department store files for bankruptcy - Sky News Australia",
                "JCPenney has become the latest retail casualty of the coronavirus crisis. The iconic United States department store chain has filed for bankruptcy and will c...",
                "https://i.ytimg.com/vi/m-HGjazxQQw/maxresdefault.jpg"));
        headlineArrayList.add(new Headline("JCPenney department store files for bankruptcy - Sky News Australia",
                "JCPenney has become the latest retail casualty of the coronavirus crisis. The iconic United States department store chain has filed for bankruptcy and will c...",
                "https://i.ytimg.com/vi/m-HGjazxQQw/maxresdefault.jpg"));
    }
}
