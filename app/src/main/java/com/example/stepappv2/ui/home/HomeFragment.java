package com.example.stepappv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepappv2.R;
import com.example.stepappv2.databinding.FragmentHomeBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView stepCountsView;
    private CircularProgressIndicator progressBar;

    private Button start;
    private Button count;

    private int counter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);



        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        stepCountsView = (TextView) root.findViewById(R.id.counter);
        stepCountsView.setText("1000");

        progressBar = (CircularProgressIndicator) root.findViewById(R.id.progressBar);

        progressBar.setMax(100);
        progressBar.setProgress(counter);

        start = root.findViewById(R.id.start_button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepCountsView.setText("0");
            }
        });



        count = root.findViewById(R.id.count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter += 1;
                if (counter == 100){
                    counter = 0;
                }
                progressBar.setProgress(counter);
                stepCountsView.setText(Integer.toString(counter));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}