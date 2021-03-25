package de.uniks.start_hack_21.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public MutableLiveData<String> beeFlorian = new MutableLiveData<String>();

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        beeFlorian.setValue("Test");
    }

    public LiveData<String> getText() {
        return mText;
    }
}