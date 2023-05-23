package com.example.mykino;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public myAdapter(Context context, List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_film, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemImage.setImageResource(dataList.get(position).getDataImage());
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recAge.setText(dataList.get(position).getDataAge());
        holder.descriptionDesc.setText(dataList.get(position).getDataDescription());




        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, filmDetails.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDescription());
                intent.putExtra("Age", dataList.get(holder.getAdapterPosition()).getDataAge());


                intent.putExtra("Year", dataList.get(holder.getAdapterPosition()).getDataYear());
                intent.putExtra("Ganr", dataList.get(holder.getAdapterPosition()).getDataGanr());
                intent.putExtra("Time", dataList.get(holder.getAdapterPosition()).getDataTime());
                intent.putExtra("Director", dataList.get(holder.getAdapterPosition()).getDataDirector());



                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView itemImage;
    TextView recTitle, descriptionDesc, recAge;

    TextView recYear, recGanre, recTime, recDirector;

    CardView recCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        itemImage = itemView.findViewById(R.id.itemImage);
        recTitle = itemView.findViewById(R.id.recTitle);
        descriptionDesc = itemView.findViewById(R.id.descriptionDesc);
        recAge = itemView.findViewById(R.id.recAge);

        recYear = itemView.findViewById(R.id.yearDetails);
        recGanre = itemView.findViewById(R.id.genreDetails);
        recTime = itemView.findViewById(R.id.timeDetails);
        recDirector = itemView.findViewById(R.id.directorDetails);




        recCard = itemView.findViewById(R.id.recCard);

    }
}