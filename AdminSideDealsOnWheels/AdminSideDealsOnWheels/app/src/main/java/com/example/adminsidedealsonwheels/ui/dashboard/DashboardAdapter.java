package com.example.adminsidedealsonwheels.ui.dashboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminsidedealsonwheels.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder>
{

    private Context context;
    private List<DashboardPOJOCleint> dashboardPOJOCleintList;
    private LayoutInflater mInflater;
    private onNoteListner monNoteListner;




    public DashboardAdapter(Context context, List<DashboardPOJOCleint> dashboardPOJOCleintList,onNoteListner monNoteListner)
    {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.dashboardPOJOCleintList = dashboardPOJOCleintList;
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

        holder.FirstName.setText(dashboardPOJOCleintList.get(position).getFname());
        holder.Email.setText(dashboardPOJOCleintList.get(position).getUemail());
        holder.ContactInfo.setText(dashboardPOJOCleintList.get(position).getCnum());
        holder.LicenceNum.setText(dashboardPOJOCleintList.get(position).getLnum());

    }

    @Override
    public int getItemCount() {
        return dashboardPOJOCleintList.size();
    }

    public interface onNoteListner
    {
        void onNoteClick(int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView FirstName, Email, ContactInfo, LicenceNum;
        onNoteListner onNoteListner;


        public MyViewHolder(@NonNull View itemView,onNoteListner onNoteListner) {
            super(itemView);

            FirstName = itemView.findViewById(R.id.firstname);
            Email = itemView.findViewById(R.id.email);
            ContactInfo = itemView.findViewById(R.id.contactnumber);
            LicenceNum = itemView.findViewById(R.id.licencenumber);
            this.onNoteListner = onNoteListner;

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());

        }
    }

}