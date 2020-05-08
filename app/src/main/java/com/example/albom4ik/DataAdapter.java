package com.example.albom4ik;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
//    private List<User> userList;

    public DataAdapter(Context context, ArrayList userList) {
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
    }



    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
//        final User user = userList.get(position);
//        holder.imageView.setImageResource(R.drawable.who);
//        holder.nameView.setText(user.getName());
//        holder.idView.setText(user.getUserName());
    }



    @Override
    public int getItemCount() {
//        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        final View itemLayout;
        final ImageView imageView;
//        final TextView nameView, idView;
        ViewHolder(View view){
            super(view);
            itemLayout = view.findViewById(R.id.item_layout);
            imageView = (ImageView)view.findViewById(R.id.image);
//            nameView = (TextView) view.findViewById(R.id.name);
//            idView = (TextView) view.findViewById(R.id.id);
        }
    }
}
