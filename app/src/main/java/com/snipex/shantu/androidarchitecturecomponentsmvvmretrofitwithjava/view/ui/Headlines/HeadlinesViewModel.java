package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.ui.Headlines;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.HeadlinesRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.HeadlinesResponse;

import java.util.ArrayList;
import java.util.List;

public class HeadlinesViewModel extends ViewModel {

    private static final String TAG = HeadlinesViewModel.class.getSimpleName();
    private MutableLiveData<HeadlinesResponse> headlines;
    private HeadlinesRepository repository;

    public void init() {
        if (headlines != null) {
            return;
        }

        repository = HeadlinesRepository.getInstance();
        headlines=repository.getHeadlines("us","84a7decf3110498ea372bd16dd0601e8");

    }

    public LiveData<HeadlinesResponse> getAllHeadlines() {
        return headlines;
    }
}