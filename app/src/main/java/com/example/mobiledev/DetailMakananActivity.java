package com.example.mobiledev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMakananActivity extends AppCompatActivity {

    TextView tvNamaMakanan, tvHargaMakanan, tvDeskripsiMakanan, tvDetailMakanan;
    ImageView imgMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        tvNamaMakanan = findViewById(R.id.tvNamaMakanan);
        tvHargaMakanan = findViewById(R.id.tvHargaMakanan);
        tvDeskripsiMakanan = findViewById(R.id.tvDeskripsiMakanan);
        tvDetailMakanan = findViewById(R.id.tvDetailMakanan);
        imgMakanan = findViewById(R.id.imgMakanan);

        Intent intent = getIntent();
        tvNamaMakanan.setText(intent.getStringExtra("namaMakanan"));
        tvHargaMakanan.setText("Harga: " + intent.getStringExtra("hargaMakanan"));
        tvDeskripsiMakanan.setText(intent.getStringExtra("deskripsiMakanan"));
        tvDetailMakanan.setText(intent.getStringExtra("detailMakanan"));
        imgMakanan.setImageResource(intent.getIntExtra("gambarMakanan", 0));
    }
}
