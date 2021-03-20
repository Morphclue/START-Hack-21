package de.uniks.start_hack_21.ui.insurances;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;

import de.uniks.start_hack_21.R;

public class InsurancesFragment extends Fragment {

    private InsuranceViewModel insuranceViewModel;
    private View root;
    private LayoutInflater inflater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        insuranceViewModel = new ViewModelProvider(this).get(InsuranceViewModel.class);
        this.inflater = inflater;
        this.root = inflater.inflate(R.layout.fragment_insurances, container, false);

        generateInsurances();
        return root;
    }

    private void generateInsurances(){
        LinearLayout insuranceContainer = root.findViewById(R.id.fragment_container_insurances);
        HashMap<String, Drawable> insuranceMap = new HashMap<>();
        insuranceMap.put("Hospital Extra", getResources().getDrawable(R.drawable.ic_check, null));
        insuranceMap.put("Dental Insurance", getResources().getDrawable(R.drawable.ic_bolt, null));
        insuranceMap.put("CURA", getResources().getDrawable(R.drawable.ic_check, null));

        for (String key : insuranceMap.keySet()) {
            View view = inflater.inflate(R.layout.component_insurance_card, null);
            TextView insurance_text = view.findViewById(R.id.text_insurance_card);
            ImageView imageView = view.findViewById(R.id.icon_insurance);

            insurance_text.setText(key);
            imageView.setImageDrawable(insuranceMap.get(key));

            insuranceContainer.addView(view);
        }
    }
}