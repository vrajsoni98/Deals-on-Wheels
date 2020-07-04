package com.example.adminsidedealsonwheels.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminsidedealsonwheels.R;
import com.example.adminsidedealsonwheels.ui.dashboard.DashboardAdapter;
import com.example.adminsidedealsonwheels.ui.dashboard.DashboardAdapterProvider;
import com.example.adminsidedealsonwheels.ui.dashboard.DashboardPOJOCleint;
import com.example.adminsidedealsonwheels.ui.dashboard.DashboardPOJOProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements DashboardAdapter.onNoteListner, DashboardAdapterProvider.onNoteListner {




    TextView client,provider;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    List<DashboardPOJOProvider> dashboardPOJOProviderList = new ArrayList<DashboardPOJOProvider>();
    List<DashboardPOJOCleint> dashboardPOJOCleintList = new ArrayList<DashboardPOJOCleint>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    DashboardAdapter dashboard_adapter;
    DashboardAdapterProvider dashboard_adapter_provider;
    int flag1=0;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        client=root.findViewById(R.id.client);
        provider=root.findViewById(R.id.provider);

        recyclerView = root.findViewById(R.id.recycler_view_dashboard);


        try
        {

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference().child("client");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    dashboardPOJOCleintList.clear();

                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                    {

                        DashboardPOJOCleint dashboardPOJOCleint = dataSnapshot1.getValue(DashboardPOJOCleint.class);

                        dashboardPOJOCleintList.add(dashboardPOJOCleint);

                    }

                    flag1=1;
                    callable();


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        catch (Exception e)
        {}



        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {

                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference().child("client");

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            dashboardPOJOCleintList.clear();

                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                            {

                                DashboardPOJOCleint dashboardPOJOCleint = dataSnapshot1.getValue(DashboardPOJOCleint.class);

                                dashboardPOJOCleintList.add(dashboardPOJOCleint);

                            }

                            flag1=1;
                            callable();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

                catch (Exception e)
                {}
            }
        });


        provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //client.setBackground();

                try
                {

                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference().child("provider");

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            dashboardPOJOProviderList.clear();

                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                            {

                                DashboardPOJOProvider dashboardPOJOProvider = dataSnapshot1.getValue(DashboardPOJOProvider.class);


                                    dashboardPOJOProviderList.add(dashboardPOJOProvider);


                            }

                            flag1=2;
                            callable();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

                catch (Exception e)
                {}
            }
        });



        return root;
    }


    public void callable()
    {
        try
        {
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            if(flag1==1)
            {
            dashboardPOJOProviderList.clear();
            dashboard_adapter = new DashboardAdapter(getActivity(), dashboardPOJOCleintList,this);
            recyclerView.setAdapter(dashboard_adapter);
            }
            else if(flag1==2)
            {
                dashboardPOJOCleintList.clear();
                dashboard_adapter_provider = new DashboardAdapterProvider(getActivity(), dashboardPOJOProviderList,this);
                recyclerView.setAdapter(dashboard_adapter_provider);
            }
        }
        catch (Exception e)
        {}
    }


    @Override
    public void onNoteClick(int position) {


        //customer service


    }

}
