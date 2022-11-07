package com.example.contact;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class RecylerContactAdapter extends RecyclerView.Adapter<RecylerContactAdapter.viewholder> {
    Context context;
    ArrayList<contact_model> arraycontacts;
    String name;
    RecylerContactAdapter(Context context, ArrayList<contact_model> array_contact){
        this.context=context;
        this.arraycontacts=array_contact;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item=LayoutInflater.from(context).inflate(R.layout.contact_row, parent,false);
        viewholder view_holder=new viewholder(item);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.txtname.setText(arraycontacts.get(position).name);
        holder.txtphone.setText(arraycontacts.get(position).phone);
    }

    @Override
    public int getItemCount() {
        return arraycontacts.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView txtname, txtphone;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            txtname=itemView.findViewById(R.id.contact_text);
            txtphone=itemView.findViewById(R.id.phone_no);
        }
    }
}
