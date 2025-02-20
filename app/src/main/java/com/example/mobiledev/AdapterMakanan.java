package com.example.mobiledev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.ViewHolder> {

    ArrayList<ModelMakanan> dataMakanan;

    public AdapterMakanan(ArrayList<ModelMakanan> dataMakanan) {
        this.dataMakanan = dataMakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_makanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelMakanan makanan = this.dataMakanan.get(position);
        holder.tvNamaMakanan.setText(makanan.getNamaMakanan());
        holder.tvHargaMakanan.setText(makanan.getHargaMakanan());
        holder.imgMakanan.setImageResource(makanan.getGambarMakanan());
    }

    @Override
    public int getItemCount() {
        return dataMakanan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan;
        TextView tvHargaMakanan;
        ImageView imgMakanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            tvHargaMakanan = itemView.findViewById(R.id.tvHargaMakanan);
            imgMakanan = itemView.findViewById(R.id.imgMakanan);
        }
    }
}
