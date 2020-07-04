package com.example.adminsidedealsonwheels.ui.Bookings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminsidedealsonwheels.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.List;

public class Booking_Adapter extends RecyclerView.Adapter<Booking_Adapter.MyViewHolder>  {


    private LayoutInflater mInflater;
    private Context context;
    private List<BookingPojo> list;
    private FirebaseStorage mstorage = FirebaseStorage.getInstance();
    private onNoteListner monNoteListner;




    public Booking_Adapter(Context context, List<BookingPojo> bookings, onNoteListner onNoteListner) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = bookings;
        this.monNoteListner = onNoteListner;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.image_bookings, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view,monNoteListner);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {



        holder.carname.setText(list.get(position).getCarName());
        holder.fromDate.setText(list.get(position).getFromDate());
        holder.toDate.setText(list.get(position).getToDate());
        holder.cityFrom.setText(list.get(position).getCityFrom());
        holder.cityTo.setText(list.get(position).getCityTo());


        try{

            StorageReference storageReference = mstorage.getReferenceFromUrl(list.get(position).getMetaData());

            final File file= File.createTempFile("image","jpg");
            storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap= BitmapFactory.decodeFile(file.getAbsolutePath());
                    holder.images.setImageBitmap(bitmap);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
        catch (Exception e)
        {}

    }




    @Override
    public int getItemCount() {
        return list.size();    }

    public interface onNoteListner
    {
        void onNoteClick(int position);

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener

    {
        ImageView images;
        TextView carname;
        TextView fromDate;
        TextView toDate;
        TextView cityFrom;
        TextView cityTo;
        onNoteListner onNoteListner;


        public MyViewHolder(@NonNull View itemView, onNoteListner onNoteListner) {
            super(itemView);

            images = itemView.findViewById(R.id.image_view_upload);
            carname = itemView.findViewById(R.id.car_name_admin_req);
            fromDate = itemView.findViewById(R.id.from_date_request);
            toDate = itemView.findViewById(R.id.to_date_request);
            cityFrom = itemView.findViewById(R.id.from_city_request);
            cityTo = itemView.findViewById(R.id.to_city_request);
            this.onNoteListner = onNoteListner;


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());
        }
    }



}
