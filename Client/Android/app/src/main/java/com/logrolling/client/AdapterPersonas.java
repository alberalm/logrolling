package com.logrolling.client;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPersonas extends RecyclerView.Adapter<AdapterPersonas.ViewHolderPersonas> {

    ArrayList<Persona> listaPersonas;

    public AdapterPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ViewHolderPersonas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personas,null,false);
        return new AdapterPersonas.ViewHolderPersonas(view);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonas holder, int position) {
        holder.name.setText(listaPersonas.get(position).getName());
        holder.last_message.setText(listaPersonas.get(position).getLast_message());
        holder.photo.setImageResource(listaPersonas.get(position).getPhoto());
    }

    public class ViewHolderPersonas extends RecyclerView.ViewHolder {
        TextView name,last_message;
        ImageView photo;
        public ViewHolderPersonas(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.Name);
            last_message=(TextView)itemView.findViewById(R.id.last_message);
            photo=(ImageView)itemView.findViewById(R.id.Photo);
        }
    }
}