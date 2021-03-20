package de.uniks.start_hack_21.ui.cardview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.ui.home.HomeViewModel;

public class CardViewFragment extends Fragment {

    private CardViewViewModel cardViewViewModel;
    private String text;
    private Drawable drawable;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_card_view, container, false);
        cardViewViewModel = new ViewModelProvider(this).get(CardViewViewModel.class);

        final ImageView imageView = root.findViewById(R.id.image_view);
        final TextView textView = root.findViewById(R.id.text_view);

        imageView.setImageDrawable(drawable);
        textView.setText(text);

        cardViewViewModel.getText().observe(this, item -> {
            // Perform an action with the latest item data
        });

        cardViewViewModel.getImage().observe(this, item -> {
            // Perform an action with the latest item data
        });

        return root;
    }

    public void setData(String text, Drawable drawable) {
        this.text = text;
        this.drawable = drawable;
    }

}