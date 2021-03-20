package de.uniks.start_hack_21.ui.medicines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MedicinesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MedicinesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is medicines fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}