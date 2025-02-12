package com.example.mobiledev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.ViewHolder> {

    private final ArrayList<ModelMakanan> listMakanan;

    public AdapterMakanan(ArrayList<ModelMakanan> listMakanan) {
        this.listMakanan = listMakanan;
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
        ModelMakanan namaMakanan = listMakanan.get(position);
        holder.tvNamaMakanan.setText(namaMakanan.getNamaMakanan());
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMakanan = itemView.findViewById(R.id.tvMakanan);
        }
    }
}
