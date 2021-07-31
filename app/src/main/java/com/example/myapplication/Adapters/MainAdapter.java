 package com.example.myapplication.Adapters;


import android.content.Context;
import android.content.Intent;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DeatailActivity;
import com.example.myapplication.Models.MainModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {
    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull

    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
                return new viewholder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull  MainAdapter.viewholder holder, int position) {
    final MainModel model = list.get(position);
    holder.foodimage.setImageResource(model.getImage());
    holder.mainname.setText(model.getName());
    holder.price.setText(model.getOrderPrice());
    holder.description.setText(model.getDescription());

    holder.itemView.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View view){
            Intent intent= new Intent(context, DeatailActivity.class);
         intent.putExtra("image",model.getImage());
         intent.putExtra("price",model.getOrderPrice());
         intent.putExtra("description",model.getDescription());
         intent.putExtra("name",model.getName());
         intent.putExtra("type",1);
         context.startActivity(intent);

        }


    });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView foodimage;
        TextView mainname,price,description;

        public viewholder(@NonNull  View itemView) {
            super(itemView);
            foodimage =itemView.findViewById(R.id.imageView);
            mainname =itemView.findViewById(R.id.name);
            price =itemView.findViewById(R.id.orderPrice);
            description =itemView.findViewById(R.id.description);
        }
    }

}
