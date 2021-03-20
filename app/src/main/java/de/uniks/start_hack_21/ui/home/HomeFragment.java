package de.uniks.start_hack_21.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.ui.components.CardViewComponent;
import de.uniks.start_hack_21.ui.insurances.InsurancesFragment;
import de.uniks.start_hack_21.ui.medicines.MedicinesFragment;
import de.uniks.start_hack_21.ui.nutrition.NutritionFragment;
import de.uniks.start_hack_21.ui.profile.ProfileFragment;
import de.uniks.start_hack_21.ui.sleep.SleepFragment;
import de.uniks.start_hack_21.ui.training.TrainingsFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<CardViewComponent> cardViewComponents = new ArrayList<>();
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_nutrition), getResources().getDrawable(R.drawable.ic_nutrition, null), requireActivity(), new NutritionFragment()));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_activities), getResources().getDrawable(R.drawable.ic_activities, null), requireActivity(), new TrainingsFragment()));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_medicines), getResources().getDrawable(R.drawable.ic_medicines, null), requireActivity(), new MedicinesFragment()));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_sleep), getResources().getDrawable(R.drawable.ic_sleep, null), requireActivity(), new SleepFragment()));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_profile), getResources().getDrawable(R.drawable.ic_profile, null), requireActivity(), new ProfileFragment()));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_insurances), getResources().getDrawable(R.drawable.ic_insurances, null), requireActivity(), new InsurancesFragment()));

        LinearLayout leftContainerHome = root.findViewById(R.id.left_container_home);
        LinearLayout rightContainerHome = root.findViewById(R.id.right_container_home);
        int i = 0;

        for (CardViewComponent component : cardViewComponents) {
            View view = inflater.inflate(R.layout.component_card_view, null);

            component.setupCardView(view);

            if (i % 2 == 0) {
                leftContainerHome.addView(view);
            } else {
                rightContainerHome.addView(view);
            }
            i++;
        }

        return root;
    }
}