package de.uniks.start_hack_21.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.ui.cardview.CardViewFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final LinearLayout containerHome = root.findViewById(R.id.container_home);

        HashMap<String, Drawable> cardViewData = new HashMap<>();
        cardViewData.put(getString(R.string.menu_nutrition), getResources().getDrawable(R.drawable.ic_nutrition, null));
        cardViewData.put(getString(R.string.menu_activities), getResources().getDrawable(R.drawable.ic_activities, null));
        cardViewData.put(getString(R.string.menu_medicines), getResources().getDrawable(R.drawable.ic_medicines, null));
        cardViewData.put(getString(R.string.menu_sleep), getResources().getDrawable(R.drawable.ic_sleep, null));
        cardViewData.put(getString(R.string.menu_insurances), getResources().getDrawable(R.drawable.ic_insurances, null));

        System.out.println("AKSDBKJASBDKASBD: " + getChildFragmentManager().findFragmentById(R.id.card_view_nutrition));

        View view = containerHome.findViewById(R.id.card_view_nutrition);
        System.out.println("View: " + view);

        return root;
    }
}