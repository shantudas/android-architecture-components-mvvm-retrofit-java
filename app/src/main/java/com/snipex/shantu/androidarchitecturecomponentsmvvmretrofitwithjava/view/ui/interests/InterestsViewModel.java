package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.ui.interests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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