package de.uniks.start_hack_21.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        LinearLayout container_overview = root.findViewById(R.id.container_overview);
        LinearLayout container_history = root.findViewById(R.id.container_history);
        LinearLayout container_friends = root.findViewById(R.id.container_friends);



        return root;
    }

}
