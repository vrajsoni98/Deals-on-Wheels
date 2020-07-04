package com.example.adminsidedealsonwheels.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.adminsidedealsonwheels.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CarAdapter.onNoteListner {


    private DatabaseReference mDatabaseRef;
    List<CarPojo> carPojoList = new ArrayList<CarPojo>();
    CarAdapter carAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        // it is a special thing for merging any non activity class for example fragment to is xml file

        View v=inflater.inflate(R.layout.fragment_home,null);

        recyclerView=v.findViewById(R.id.recyclerview_cars);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("car");// its carshow

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //bookingsList.clear();
                carPojoList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren())
                {
                    CarPojo carPojo = postSnapshot.getValue(CarPojo.class);

                    carPojoList.add(carPojo);

                }


                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);

                callable();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database Error", Toast.LENGTH_LONG).show();
            }
        });

        return v;

    }



    public void callable()
    {
        try
        {
            carAdapter = new CarAdapter(getActivity(), carPojoList,this);
            recyclerView.setAdapter(carAdapter);
        }
        catch (Exception e)
        {}

    }


    @Override
    public void onNoteClick(int position) {



    }








}
