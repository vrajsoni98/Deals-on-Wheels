package com.example.adminsidedealsonwheels.ui.home;

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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
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

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>
{

    private Context context;
    private List<CarPojo> mCarPojo;
    FirebaseStorage mstorage = FirebaseStorage.getInstance();
    private LayoutInflater mInflater;
    private onNoteListner monNoteListner;



    public CarAdapter(Context context,List<CarPojo> carPojoList ,onNoteListner onNoteListner)
    {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mCarPojo = carPojoList;
        this.monNoteListner=onNoteListner;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.image_car, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, monNoteListner);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {




        holder.carName.setText(mCarPojo.get(position).getCarName());
        holder.fuelType.setText(mCarPojo.get(position).getFuelType());
        holder.seater.setText(mCarPojo.get(position).getSeater());
        holder.carModel.setText(mCarPojo.get(position).getCarModel());
        holder.pricePerKm.setText(mCarPojo.get(position).getPricePerKm());
        holder.ownerName.setText(mCarPojo.get(position).getOwnerName());
        holder.ownerContactNumber.setText(mCarPojo.get(position).getOwnerContactNumber());
        holder.status.setText(mCarPojo.get(position).getStatus());
        holder.rating.setText("4/5");



       final StorageReference storageReference = mstorage.getReferenceFromUrl(mCarPojo.get(position).getCarImgMetaData()); // this will be used for loading the image

        try {
            final File file = File.createTempFile("image", "jpg");
            storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    holder.imageView.setImageBitmap(bitmap);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context.getApplicationContext(), "File not loaded", Toast.LENGTH_LONG).show();

                }
            });
        } catch (IOException e) {
        }



    }

    @Override
    public int getItemCount() {
        return mCarPojo.size();
    }

    public interface onNoteListner
    {
        void onNoteClick(int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView carName,fuelType, seater, carModel, pricePerKm, ownerName, ownerContactNumber, status, rating;
        public ImageView imageView;
        onNoteListner onNoteListner;

        public MyViewHolder(@NonNull View itemView, onNoteListner onNoteListner) {
            super(itemView);

            carName = itemView.findViewById(R.id.car_name);
            fuelType = itemView.findViewById(R.id.fuel_type);
            seater = itemView.findViewById(R.id.seater_type);
            carModel = itemView.findViewById(R.id.car_model);
            pricePerKm = itemView.findViewById(R.id.price_KM);
            ownerName = itemView.findViewById(R.id.owner_name);
            ownerContactNumber = itemView.findViewById(R.id.owner_num);
            status = itemView.findViewById(R.id.status_car);
            rating = itemView.findViewById(R.id.rating_car);
            imageView = itemView.findViewById(R.id.image_view_upload);

            this.onNoteListner=onNoteListner;

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());
        }
    }

}