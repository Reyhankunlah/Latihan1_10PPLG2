package com.example.mobiledev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalInfoActivity extends AppCompatActivity {

    private EditText edtNama, edtEmail, edtNoHP;
    private RadioButton rbMale, rbFemale;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        // Pairing XML <--> Java
        edtNama = findViewById(R.id.edtNama);
        edtEmail = findViewById(R.id.edtEmail);
        edtNoHP = findViewById(R.id.edtNoHP);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edtNama.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String noHP = edtNoHP.getText().toString().trim();
                String gender = rbMale.isChecked() ? "Laki-Laki" :
                        rbFemale.isChecked() ? "Perempuan" : null;

                // Validasi input
                if (!rbMale.isChecked() && !rbFemale.isChecked()) {
                    Toast.makeText(PersonalInfoActivity.this, "Pilih salah satu jenis kelamin", Toast.LENGTH_SHORT).show();
                } else if (nama.isEmpty()) {
                    edtNama.setError("Nama Harus Diisi");
                } else if (email.isEmpty()) {
                    edtEmail.setError("Email Harus Diisi");
                } else if (!email.contains("@")) {
                    edtEmail.setError("Format Email Tidak Valid");
                } else if (noHP.isEmpty()) {
                    edtNoHP.setError("Nomor HP Harus Diisi");
                } else {

                    // Ambil data dari Intent
                    Intent cache = getIntent();
                    String username = cache.getStringExtra("username");
                    String password = cache.getStringExtra("password");

                    SharedPreferences sharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    btnSignUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            editor.putString("username", username);
                            editor.putString("password", password);
                            editor.putString("email", email);
                            editor.putString("noHP", noHP);
                            editor.putString("gender", gender);
                            editor.apply();

                            Toast.makeText(PersonalInfoActivity.this, "Signup Berhasil", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(PersonalInfoActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });

                }
            }
        });
    }
}
