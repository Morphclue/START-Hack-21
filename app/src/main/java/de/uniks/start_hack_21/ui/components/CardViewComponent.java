package de.uniks.start_hack_21.ui.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import de.uniks.start_hack_21.R;

public class CardViewComponent extends ConstraintLayout {
    private String name;
    private Drawable drawable;

    public CardViewComponent(Context context) {
        super(context);
    }

    public CardViewComponent(Context context, String name, Drawable drawable) {
        super(context);
        this.name = name;
        this.drawable = drawable;
    }

    public void setupCardView(View view){
        TextView textView = view.findViewById(R.id.text_view);
        ImageView imageView = view.findViewById(R.id.image_view);
        CardView cardView = view.findViewById(R.id.main_card_view);

        cardView.setOnClickListener(event -> {
            System.out.println("HELLO");
        });

        cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.cardGoodColor));
        textView.setText(name);
        imageView.setImageDrawable(drawable);
    }
}
