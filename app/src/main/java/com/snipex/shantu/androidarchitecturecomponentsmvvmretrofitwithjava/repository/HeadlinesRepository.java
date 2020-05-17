package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository;

import androidx.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;

import java.util.ArrayList;
import java.util.List;

public class HeadlinesRepository {
    private static HeadlinesRepository instance;
    private ArrayList<Headline> headlineArrayList = new ArrayList<>();

    public static HeadlinesRepository getInstance() {
        if (instance == null) {
            instance = new HeadlinesRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Headline>> getHeadlines() {
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
