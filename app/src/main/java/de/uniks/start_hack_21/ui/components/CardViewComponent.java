package de.uniks.start_hack_21.ui.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import de.uniks.start_hack_21.R;

public class CardViewComponent extends ConstraintLayout {
    public CardViewComponent(Context context) {
        super(context);
    }

    public void setupCardView(View view, String key, Drawable drawable){
        TextView textView = view.findViewById(R.id.text_view);
        ImageView imageView = view.findViewById(R.id.image_view);

        textView.setText(key);
        imageView.setImageDrawable(drawable);
    }

}
