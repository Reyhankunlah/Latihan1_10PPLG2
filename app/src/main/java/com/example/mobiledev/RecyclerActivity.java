package com.example.mobiledev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements AdapterMakanan.OnItemClickListener {

    private RecyclerView recyclerView;
    private AdapterMakanan adapter;

    @Override   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.rvMakanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ModelMakanan> dataMakanan = new ArrayList<>();
        dataMakanan.add(new ModelMakanan("Soto Ayam", "5.000", "Makanan gurih", "INI DESKRIPSI SOTO AYAM", R.drawable.soto_ayam));
        dataMakanan.add(new ModelMakanan("Nasi Goreng", "10.000", "SEDAP karena micin", "INI DESKRIPSI NASI GORENG", R.drawable.nasi_goreng));
        dataMakanan.add(new ModelMakanan("Ayam Geprek", "8.000", "Pedes tapi gak terlalu", "INI DESKRIPSI AYAM GEPREK", R.drawable.ayam_geprek));
        dataMakanan.add(new ModelMakanan("Sate Ayam", "7.000", "Manis tapi mantap", "INI DESKRIPSI SATE AYAM", R.drawable.sate_ayam));
        dataMakanan.add(new ModelMakanan("Rendang", "25.000", "Nomor 1 no debat", "INI DESKRIPSI RENDANG", R.drawable.rendang));
        dataMakanan.add(new ModelMakanan("STEAK WAHYU A5", "5.000.000", "OVERRATED", "INI DESKRIPSI WAHYU A5", R.drawable.wahyu_a5));

        adapter = new AdapterMakanan(dataMakanan, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(ModelMakanan makanan) {
        Toast.makeText(this, "Kamu memilih: " + makanan.getNamaMakanan(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RecyclerActivity.this, DetailMakananActivity.class);
        intent.putExtra("namaMakanan", makanan.getNamaMakanan());
        intent.putExtra("hargaMakanan", makanan.getHargaMakanan());
        intent.putExtra("deskripsiMakanan", makanan.getDeskripsiMakanan());
        intent.putExtra("detailMakanan", makanan.getDetailMakanan());
        intent.putExtra("gambarMakanan", makanan.getGambarMakanan());
        startActivity(intent);
    }
}
