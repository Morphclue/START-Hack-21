package de.uniks.start_hack_21.ui.dashboard.activities;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}