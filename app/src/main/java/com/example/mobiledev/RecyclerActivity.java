package com.example.mobiledev;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public AdapterMakanan adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.rvMakanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi ArrayList Makanan
        ArrayList<ModelMakanan> listMakanan = new ArrayList<>();

        ModelMakanan nasigoreng = new ModelMakanan();
        nasigoreng.setNamaMakanan("Nasi Goreng");

        ModelMakanan ayamGoreng = new ModelMakanan();
        ayamGoreng.setNamaMakanan("Ayam Goreng"); // Perbaikan kesalahan variabel

        listMakanan.add(nasigoreng);
        listMakanan.add(ayamGoreng);

        // Set Adapter ke RecyclerView
        adapter = new AdapterMakanan(listMakanan);
        recyclerView.setAdapter(adapter);
    }
}
