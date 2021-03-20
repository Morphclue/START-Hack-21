package de.uniks.start_hack_21.ui.components;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import de.uniks.start_hack_21.MainActivity;
import de.uniks.start_hack_21.R;

public class CardViewComponent extends ConstraintLayout {
    private String name;
    private Drawable drawable;
    private FragmentActivity activity;
    private Fragment nextFragment;
    private String suggestionText;

    public CardViewComponent(String name, Drawable drawable, FragmentActivity activity, Fragment nextFragment, String suggestionText) {
        super(activity);
        this.name = name;
        this.drawable = drawable;
        this.activity = activity;
        this.nextFragment = nextFragment;
        this.suggestionText = suggestionText;
    }

    public void setupCardView(View view) {
        TextView textView = view.findViewById(R.id.text_view);
        ImageView imageView = view.findViewById(R.id.image_view);
        CardView cardView = view.findViewById(R.id.main_card_view);

        cardView.setOnClickListener(event -> {
            ((MainActivity) activity).changeToDashboard(nextFragment, suggestionText);
            activity.setTitle(name);
        });

        cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.cardGoodColor));
        textView.setText(name);
        imageView.setImageDrawable(drawable);
    }
}
