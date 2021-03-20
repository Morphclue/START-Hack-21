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
        cardViewComponents.add(new CardViewComponent(
                getString(R.string.menu_nutrition),
                getResources().getDrawable(R.drawable.ic_nutrition, null),
                requireActivity(),
                new NutritionFragment(),
                "Hey Florian! We already see that you are eating very well and healthy. " +
                        "Please check out the recipes we provided down below if you are searching " +
                        "for inspiration. Otherwise: Keep up the good work champ!", 2));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_training),
                getResources().getDrawable(R.drawable.ic_activities, null),
                requireActivity(),
                new TrainingsFragment(),
                "Peace Florian," +
                        "we see, that you are currently trying to gain that muscles. " +
                        "You could try challenging your friends to motivate you even more! " +
                        "What about beating the other Florian in a swimming challenge?", 2));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_medicines),
                getResources().getDrawable(R.drawable.ic_medicines, null),
                requireActivity(),
                new MedicinesFragment(),
                "Bad News Florian!" +
                        "We've found out that there might be a correlation between your" +
                        "headaches and your smoking habit. Try chewing a gum instead of smoking" +
                        "when the addiction kicks in. If that is too hard we advise you to call " +
                        "42-42-1337 if you need help with that.", 0));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_sleep),
                getResources().getDrawable(R.drawable.ic_sleep, null),
                requireActivity(),
                new SleepFragment(),
                "Sleep is for the weak! Or isn't it? You would be quiet surprised " +
                        "that sleeping well can make you feel stronger and more productive. " +
                        "We suggest to sleep at a regular time, even if that means less League " +
                        "of Legends for you... At least you got the chance to win those ranked games " +
                        ", because of the improved concentration from your new sleeping schedule! " +
                        "Escape Elo-Hell!", 1));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_profile),
                getResources().getDrawable(R.drawable.ic_profile, null),
                requireActivity(),
                new ProfileFragment(),
                "-", 3));
        cardViewComponents.add(new CardViewComponent(getString(R.string.menu_insurances),
                getResources().getDrawable(R.drawable.ic_insurances, null),
                requireActivity(),
                new InsurancesFragment(),
                "Hey Florian. We noticed that you have not participated in any additional " +
                        "dental insurance. Your teeth are a precious commodity that should " +
                        "definitely be valued. For this reason, we recommend that you participate" +
                        " in an additional insurance, as beautiful teeth do not get " +
                        "healthier with age.", 3));

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