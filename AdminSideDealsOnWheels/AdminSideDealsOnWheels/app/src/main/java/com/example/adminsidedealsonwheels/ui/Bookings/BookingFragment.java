package com.example.adminsidedealsonwheels.ui.Bookings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminsidedealsonwheels.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class BookingFragment extends Fragment implements Booking_Adapter.onNoteListner{




    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    List<BookingPojo> bookingsList = new ArrayList<BookingPojo>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    Booking_Adapter booking_adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_booking, container, false);



        recyclerView = root.findViewById(R.id.recycler_view12);


        try
        {

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference().child("bookings");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    bookingsList.clear();

                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                    {

                        BookingPojo bookingPojo = dataSnapshot1.getValue(BookingPojo.class);


                            bookingsList.add(bookingPojo);


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
            booking_adapter = new Booking_Adapter(getActivity(), bookingsList,this);
            recyclerView.setAdapter(booking_adapter);
        }
        catch (Exception e)
        {}
    }

    @Override
    public void onNoteClick(int position) {



    }



}
