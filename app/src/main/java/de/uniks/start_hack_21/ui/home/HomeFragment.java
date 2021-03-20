package de.uniks.start_hack_21.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.ui.components.CardViewComponent;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<CardViewComponent> cardViewComponents = new ArrayList<>();
        cardViewComponents.add(new CardViewComponent(getContext(), getString(R.string.menu_nutrition), getResources().getDrawable(R.drawable.ic_nutrition, null)));
        cardViewComponents.add(new CardViewComponent(getContext(), getString(R.string.menu_activities), getResources().getDrawable(R.drawable.ic_activities, null)));
        cardViewComponents.add(new CardViewComponent(getContext(), getString(R.string.menu_medicines), getResources().getDrawable(R.drawable.ic_medicines, null)));
        cardViewComponents.add(new CardViewComponent(getContext(), getString(R.string.menu_sleep), getResources().getDrawable(R.drawable.ic_sleep, null)));
        cardViewComponents.add(new CardViewComponent(getContext(), getString(R.string.menu_insurances), getResources().getDrawable(R.drawable.ic_insurances, null)));

        LinearLayout containerHome = root.findViewById(R.id.container_home);

        for (CardViewComponent component : cardViewComponents) {
            View view = inflater.inflate(R.layout.component_card_view, null);
            CardView cardView = view.findViewById(R.id.main_card_view);
            cardView.setOnClickListener(event -> {
                System.out.println("HELLO");
            });

            component.setupCardView(view);
            containerHome.addView(view);
        }

        return root;
    }
}