package com.example.mobiledev;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements AdapterMakanan.OnItemClickListener{

    private RecyclerView recyclerView;
    private AdapterMakanan adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.rvMakanan);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ModelMakanan> dataMakanan = new ArrayList<>();
        dataMakanan.add(new ModelMakanan("Soto Ayam", "5.000", "Makanan gurih", R.drawable.soto_ayam));
        dataMakanan.add(new ModelMakanan("Nasi Goreng", "10.000", "SEDAP karena micin", R.drawable.nasi_goreng));
        dataMakanan.add(new ModelMakanan("Ayam Geprek", "8.000", "Pedes tapi gak terlalu",R.drawable.ayam_geprek));
        dataMakanan.add(new ModelMakanan("Sate Ayam", "7.000", "manis tapi mantap",R.drawable.sate_ayam));
        dataMakanan.add(new ModelMakanan("Rendang", "25.000", "Nomor 1 no debat",R.drawable.rendang));
        dataMakanan.add(new ModelMakanan("STEAK WAHYU A5", "5.000.000", "OVERRATED",R.drawable.wahyu_a5));

        AdapterMakanan adapter = new AdapterMakanan(dataMakanan, this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(ModelMakanan makanan) {
        Toast.makeText(this, makanan.getNamaMakanan(), Toast.LENGTH_SHORT).show();
    }
}
