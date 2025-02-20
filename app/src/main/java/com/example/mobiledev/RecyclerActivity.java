package com.example.mobiledev;

import android.os.Bundle;

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

        ArrayList<ModelMakanan> dataMakanan = new ArrayList<>();
        dataMakanan.add(new ModelMakanan("Soto Ayam", "5.000", R.drawable.soto_ayam));
        dataMakanan.add(new ModelMakanan("Nasi Goreng", "10.000", R.drawable.nasi_goreng));
        dataMakanan.add(new ModelMakanan("STEAK WAGYU A5", "5.000.000", R.drawable.wahyu_a5));

        adapter = new AdapterMakanan(dataMakanan);
        recyclerView.setAdapter(adapter);
    }
}
