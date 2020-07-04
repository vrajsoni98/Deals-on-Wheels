package com.example.adminsidedealsonwheels.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminsidedealsonwheels.R;

import java.util.List;

public class DashboardAdapterProvider extends RecyclerView.Adapter<DashboardAdapterProvider.MyViewHolder>
{
    private Context context;
    private List<DashboardPOJOProvider> dashboardPOJOProviderList;
    private LayoutInflater mInflater;
    private onNoteListner monNoteListner;




    public DashboardAdapterProvider(Context context, List<DashboardPOJOProvider> dashboardPOJOProviderList, onNoteListner monNoteListner )
    {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.dashboardPOJOProviderList = dashboardPOJOProviderList;
        this.monNoteListner=monNoteListner;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.dashboardadapter, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view,monNoteListner);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {




        holder.Name.setText(dashboardPOJOProviderList.get(position).getNameOfProvider());
        holder.Email.setText(dashboardPOJOProviderList.get(position).getPersonemail());
        holder.ContactNum.setText(dashboardPOJOProviderList.get(position).getCtnum());
        holder.AdharCard.setText(dashboardPOJOProviderList.get(position).getAdharcard());


    }

    @Override
    public int getItemCount() {
        return dashboardPOJOProviderList.size();
    }


    public interface onNoteListner
    {
        void onNoteClick(int position);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {


        public TextView Name,Email, ContactNum, AdharCard;
        onNoteListner onNoteListner;


        public MyViewHolder(@NonNull View itemView, DashboardAdapterProvider.onNoteListner onNoteListner) {
            super(itemView);

            Name = itemView.findViewById(R.id.firstname);
            Email = itemView.findViewById(R.id.email);
            ContactNum = itemView.findViewById(R.id.contactnumber);
            AdharCard = itemView.findViewById(R.id.licencenumber);
            this.onNoteListner = onNoteListner;


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());
        }

    }
}
