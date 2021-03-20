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
import de.uniks.start_hack_21.ui.profile.ProfileFragment;

public class CardViewComponent extends ConstraintLayout {
    private String name;
    private Drawable drawable;
    private FragmentActivity activity;
    private Fragment nextFragment;
    private String suggestionText;
    // 0 = BAD, 1 = OKAY, 2 = GOOD, 3 = INFO
    private int cardState; // never code like that! it's freaking disgusting, but we have no time left!

    public CardViewComponent(String name, Drawable drawable, FragmentActivity activity, Fragment nextFragment, String suggestionText, int cardState) {
        super(activity);
        this.name = name;
        this.drawable = drawable;
        this.activity = activity;
        this.nextFragment = nextFragment;
        this.suggestionText = suggestionText;
        this.cardState = cardState;
    }

    public void setupCardView(View view) {
        TextView textView = view.findViewById(R.id.text_view);
        ImageView imageView = view.findViewById(R.id.image_view);
        CardView cardView = view.findViewById(R.id.main_card_view);

        cardView.setOnClickListener(event -> {
            if (nextFragment instanceof ProfileFragment) {
                ((MainActivity) activity).changeFragment(nextFragment);
            } else {
                ((MainActivity) activity).changeToDashboard(nextFragment, suggestionText);
                activity.setTitle(name);
            }
        });

        switch (cardState) {
            case 0:
                cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.cardBadColor));
                break;
            case 1:
                cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.cardOkayColor));
                break;
            case 2:
                cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.cardGoodColor));
                break;
            case 3:
                cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.cardInformationColor));
                break;
        }

        textView.setText(name);
        imageView.setImageDrawable(drawable);
    }
}
