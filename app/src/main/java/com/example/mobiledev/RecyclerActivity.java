package com.example.mobiledev;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterMakanan adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.rvMakanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ModelMakanan> listMakanan = new ArrayList<>();

        ModelMakanan nasiGoreng = new ModelMakanan();
        nasiGoreng.setNamaMakanan("Nasi Goreng");
        listMakanan.add(nasiGoreng);

        ModelMakanan ayamGoreng = new ModelMakanan();
        ayamGoreng.setNamaMakanan("Ayam Goreng");
        listMakanan.add(ayamGoreng);

        ModelMakanan soto = new ModelMakanan();
        soto.setNamaMakanan("Soto Ayam");
        listMakanan.add(soto);

        Log.d("RecyclerView", "Jumlah item: " + listMakanan.size());
        for (ModelMakanan makanan : listMakanan) {
            Log.d("RecyclerView", "Makanan: " + makanan.getNamaMakanan());
        }

        // Set Adapter ke RecyclerView
        adapter = new AdapterMakanan(listMakanan);
        recyclerView.setAdapter(adapter);
    }
}
