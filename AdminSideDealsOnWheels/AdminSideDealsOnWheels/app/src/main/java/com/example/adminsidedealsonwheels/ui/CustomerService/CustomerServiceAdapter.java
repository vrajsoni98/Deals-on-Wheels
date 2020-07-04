package com.example.adminsidedealsonwheels.ui.CustomerService;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminsidedealsonwheels.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class CustomerServiceAdapter extends  RecyclerView.Adapter<CustomerServiceAdapter.MyViewHolder>

{
    private Context context;
    private List<CustomerServicePOJO> customerServicePOJOList;
    private LayoutInflater mInflater;
    private onNoteListner monNoteListner;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    public CustomerServiceAdapter(Context context, List<CustomerServicePOJO> customerServicePOJOList, onNoteListner monNoteListner) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.customerServicePOJOList = customerServicePOJOList;
        this.monNoteListner = monNoteListner;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.customer_service, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view,monNoteListner);
        return myViewHolder;    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.problem.setText(customerServicePOJOList.get(position).getProblem());
        holder.contactInfo.setText(customerServicePOJOList.get(position).getPhoneNumber());
        if(customerServicePOJOList.get(position).getStatus().equals("Done"))
        {
            holder.status.setText(customerServicePOJOList.get(position).getStatus());
            holder.status.setTextColor(ContextCompat.getColor(context, R.color.green));
        }
        else
        {
            holder.status.setText(customerServicePOJOList.get(position).getStatus());
            holder.status.setTextColor(ContextCompat.getColor(context, R.color.red));
        }


        try
        {
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference().child("client").child(customerServicePOJOList.get(position).getPersonId());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    holder.firstName.setText(dataSnapshot.child("fname").getValue().toString());
                    holder.email.setText(dataSnapshot.child("uemail").getValue().toString());
                    holder.uId.setText(dataSnapshot.child("uid").getValue().toString());
                    holder.licenceNum.setText(dataSnapshot.child("lnum").getValue().toString());

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


        catch(Exception e)
        {}



    }

    @Override
    public int getItemCount() {
        return customerServicePOJOList.size();
    }

    public interface onNoteListner
    {
        void onNoteClick(int position);

        void onChangeStatus(int position);

        void callPerson(int position);

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {


        public TextView firstName,problem, email, contactInfo, licenceNum,uId,status;
        onNoteListner onNoteListner;


        public MyViewHolder(@NonNull View itemView,onNoteListner onNoteListner) {
            super(itemView);

            firstName = itemView.findViewById(R.id.firstname_customer);
            problem = itemView.findViewById(R.id.problem_customer);
            email = itemView.findViewById(R.id.email_customer);
            contactInfo = itemView.findViewById(R.id.contact_customer);
            licenceNum = itemView.findViewById(R.id.license_customer);
            uId = itemView.findViewById(R.id.uid_customer);
            status = itemView.findViewById(R.id.status_customer);
            this.onNoteListner = onNoteListner;

            itemView.setOnCreateContextMenuListener(this);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());

            if(onNoteListner != null)
            {
                int position =getAdapterPosition();

                if(position != RecyclerView.NO_POSITION)
                {
                    onNoteListner.onNoteClick(position);
                }
            }

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            if(onNoteListner != null)
            {
                int position =getAdapterPosition();

                if(position != RecyclerView.NO_POSITION)
                {
                    switch (item.getItemId())
                    {
                        case 1:
                            onNoteListner.onChangeStatus(position);
                            return true;

                        case 2:
                            onNoteListner.callPerson(position);
                            return true;

                    }
                }
            }

            return false;
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("Select Action");


            MenuItem  edit1;

            edit1 = menu.add(Menu.NONE,1,1,"Change Status");
            edit1.setOnMenuItemClickListener(this);


            MenuItem  call = menu.add(Menu.NONE,2,2,"Call");

            call.setOnMenuItemClickListener(this);

        }
    }




}
