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

    private final ArrayList<ModelMakanan> dataMakanan;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ModelMakanan makanan);
    }

    public AdapterMakanan(ArrayList<ModelMakanan> dataMakanan, OnItemClickListener listener) {
        this.dataMakanan = dataMakanan;
        this.listener = listener;
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
        ModelMakanan makanan = dataMakanan.get(position);
        holder.tvNamaMakanan.setText(makanan.getNamaMakanan());
        holder.tvHargaMakanan.setText("Rp " + makanan.getHargaMakanan());
        holder.tvDeskripsiMakanan.setText(makanan.getDeskripsiMakanan());
        holder.imgMakanan.setImageResource(makanan.getGambarMakanan());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(makanan));
    }

    @Override
    public int getItemCount() {
        return dataMakanan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan, tvHargaMakanan, tvDeskripsiMakanan;
        ImageView imgMakanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            tvHargaMakanan = itemView.findViewById(R.id.tvHargaMakanan);
            tvDeskripsiMakanan = itemView.findViewById(R.id.tvDeskripsiMakanan);
            imgMakanan = itemView.findViewById(R.id.imgMakanan);
        }
    }
}
