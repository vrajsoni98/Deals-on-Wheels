package com.example.adminsidedealsonwheels.ui.logout.ui.logout;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adminsidedealsonwheels.LogInActivity;
import com.example.adminsidedealsonwheels.MainActivity;
import com.example.adminsidedealsonwheels.R;

public class LogoutFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // it is a special thing for merging any non activity class for example fragment to is xml file

        View v = inflater.inflate(R.layout.logout_fragment, null);

        Intent intent3 = new Intent(getActivity(), LogInActivity.class);
        startActivity(intent3);
        getActivity().finish();
        return v;

    }


}
