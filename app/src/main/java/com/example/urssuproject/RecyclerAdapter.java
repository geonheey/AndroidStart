package com.example.urssuproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>
{
    private ArrayList<Information> list;
    private Context context;

    public RecyclerAdapter(ArrayList<Information> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position)
    {

        holder.tv_name.setText(list.get(position).getName());
        holder.tv_number.setText(list.get(position).getNum());

    }


    @Override
    public int getItemCount()
    {
        return (list !=null ? list.size():0);
    }



    class CustomViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name;
        TextView tv_number;

        public CustomViewHolder(@NonNull View item)
        {
            super(item);

            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_number = itemView.findViewById(R.id.tv_num);


        }
    }
}
