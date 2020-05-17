package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.ui.Headlines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeadlinesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HeadlinesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}