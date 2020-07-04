package com.example.adminsidedealsonwheels.ui.CustomerService;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adminsidedealsonwheels.MainActivity;
import com.example.adminsidedealsonwheels.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CustomerService extends Fragment  implements CustomerServiceAdapter.onNoteListner {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,gDatabaseRef;

    List<CustomerServicePOJO> customerServicePOJOList = new ArrayList<CustomerServicePOJO>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    CustomerServiceAdapter customerServiceAdapter;
    String phoneNumber;
    private static final int REQUEST_CALL = 1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.customer_fragment, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_customer_service);


        try
        {

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference().child("customerService");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    customerServicePOJOList.clear();

                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                    {

                        CustomerServicePOJO customerServicePOJO = dataSnapshot1.getValue(CustomerServicePOJO.class);

                        customerServicePOJOList.add(customerServicePOJO);
                    }

                    callable();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        catch (Exception e)
        {}

        return root;
    }


    public void callable()
    {
        try
        {
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            customerServiceAdapter = new CustomerServiceAdapter(getActivity(), customerServicePOJOList,this);
            recyclerView.setAdapter(customerServiceAdapter);
        }
        catch (Exception e)
        {}
    }

    @Override
    public void onNoteClick(int position)
    {


    }

    @Override
    public void onChangeStatus(int position)
    {
        CustomerServicePOJO selectedItem1 = customerServicePOJOList.get(position);

        if(selectedItem1.getStatus().equals("Active"))
        {
            String acc="Done";
            gDatabaseRef = FirebaseDatabase.getInstance().getReference().child("customerService").child(selectedItem1.getId()).child("status");

            Toast.makeText(getActivity(),"You Changed Your Status To "+acc,Toast.LENGTH_LONG).show();
            gDatabaseRef.setValue(acc);
        }
        else
        {
            String acc="Active";
            gDatabaseRef = FirebaseDatabase.getInstance().getReference().child("customerService").child(selectedItem1.getId()).child("status");

            Toast.makeText(getActivity(),"You Changed Your Status To "+acc,Toast.LENGTH_LONG).show();
            gDatabaseRef.setValue(acc);
        }

    }

    @Override
    public void callPerson(int position)
    {

        CustomerServicePOJO selectedItem1 = customerServicePOJOList.get(position);

        phoneNumber = selectedItem1.getPhoneNumber();

        makePhoneCall();



    }

    private void makePhoneCall() {
        String number = phoneNumber;
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(getActivity(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
