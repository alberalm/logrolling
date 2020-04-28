package com.logrolling.client;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFavores extends RecyclerView.Adapter<AdapterFavores.ViewHolderFavor> {
    ArrayList<Favor> listaFavores;

    public AdapterFavores(ArrayList<Favor> listaFavores) {
        this.listaFavores = listaFavores;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewHolderFavor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_favores,parent,false);
        return new AdapterFavores.ViewHolderFavor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavor holder, int position) {
        holder.name.setText(listaFavores.get(position).getName());
        holder.description.setText(listaFavores.get(position).getDescription());
        //holder.photo.setImageResource(listaFavores.get(position).getPhoto());
        holder.adress.setText(listaFavores.get(position).getAdress());
        holder.favor.setText(listaFavores.get(position).getFavor());
        holder.price.setText(Integer.toString(listaFavores.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return listaFavores.size();
    }

    public class ViewHolderFavor extends RecyclerView.ViewHolder {
        TextView name,description,adress,favor,price;
        ImageView photo;
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolderFavor(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.Name);
            description=(TextView)itemView.findViewById(R.id.Descripcion);
            photo=(ImageView)itemView.findViewById(R.id.Photo);
            adress=(TextView)itemView.findViewById(R.id.Adress);
            favor=(TextView)itemView.findViewById(R.id.Favor);
            price=(TextView)itemView.findViewById(R.id.Price);

            photo.setClipToOutline(true);
        }
    }
}
