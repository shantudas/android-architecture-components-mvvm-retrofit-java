package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.ui.Headlines;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.HeadlinesRepository;

import java.util.ArrayList;
import java.util.List;

public class HeadlinesViewModel extends ViewModel {

    private static final String TAG = HeadlinesViewModel.class.getSimpleName();
    private MutableLiveData<List<Headline>> headlines;
    private HeadlinesRepository repository;

    public void init() {
        if (headlines != null) {
            return;
        }

        repository = HeadlinesRepository.getInstance();
        headlines = repository.getHeadlines();

    }

    public LiveData<List<Headline>> getAllHeadlines() {
        Log.i(TAG, " data :: " + headlines.getValue());
        return headlines;
    }
}