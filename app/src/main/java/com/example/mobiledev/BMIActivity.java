package com.example.mobiledev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMIActivity extends AppCompatActivity {

    private EditText edtTB, edtBB;
    private Button btnHitung;
    private TextView tvHasil, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmiactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtTB = findViewById(R.id.edtTB);
        edtBB = findViewById(R.id.edtBB);
        btnHitung = findViewById(R.id.btnHitung);
        tvHasil = findViewById(R.id.tvHasil);
        tvStatus = findViewById(R.id.tvStatus);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TB = edtTB.getText().toString();
                String BB = edtBB.getText().toString();

                if (TB.isEmpty() && BB.isEmpty()) {
                    edtTB.setError("Masukkan Tinggi Badan");
                    edtBB.setError("Masukkan Berat Badan");
                    Toast.makeText(BMIActivity.this, "Masukkan Tinggi Badan & Berat Badan", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TB.isEmpty()) {
                    edtTB.setError("Masukkan Tinggi Badan");
                    Toast.makeText(BMIActivity.this, "Masukkan Tinggi Badan", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (BB.isEmpty()) {
                    edtBB.setError("Masukkan Berat Badan");
                    Toast.makeText(BMIActivity.this, "Masukkan Berat Badan", Toast.LENGTH_SHORT).show();
                    return;
                }


                double tinggi = Double.parseDouble(TB) / 100;
                double berat = Double.parseDouble(BB);

                Double bmi = berat / (tinggi * tinggi);
                tvHasil.setText(String.format("BMI: %.2f", bmi));

                String status;
                if (bmi < 18.5) {
                    status = "Kurus";
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    status = "Normal";
                } else if (bmi >= 25 && bmi < 29.9) {
                    status = "Kelebihan Berat Badan";
                } else {
                    status = "Obesitas";
                }

                tvStatus.setText(status);
            }});

    }
}


