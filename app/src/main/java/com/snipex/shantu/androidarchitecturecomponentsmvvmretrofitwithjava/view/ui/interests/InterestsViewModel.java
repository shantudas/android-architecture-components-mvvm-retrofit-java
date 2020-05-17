package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.ui.interests;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class InterestsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InterestsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}