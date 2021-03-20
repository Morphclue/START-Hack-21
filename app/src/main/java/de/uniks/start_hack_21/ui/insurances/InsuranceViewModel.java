package de.uniks.start_hack_21.ui.insurances;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InsuranceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InsuranceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is insurance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}