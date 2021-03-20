package de.uniks.start_hack_21.ui.cardview;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CardViewViewModel extends ViewModel {

    private MutableLiveData<String> text;
    private MutableLiveData<Drawable> drawable;

    public CardViewViewModel() {
        text = new MutableLiveData<>();
        drawable = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return text;
    }

    public LiveData<Drawable> getImage() {
        return drawable;
    }

}