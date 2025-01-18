package com.example.mobiledev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {

    // Deklarasi elemen UI
    private TextView txtSignUp;
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private ImageView imgGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Terapkan padding untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi elemen UI
        txtSignUp = findViewById(R.id.txtSignup);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        imgGoogle = findViewById(R.id.imgGoogle);

        // Ambil data yang tersimpan di SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");

        // Event untuk tombol Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String logUser = edtUsername.getText().toString();
                String logPass = edtPassword.getText().toString();

                if (logUser.isEmpty() || logPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (logUser.equals(savedUsername) && logPass.equals(savedPassword)) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TXT Sign Up
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        // Konfigurasi Goo
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Event untuk tombol Google Sign-In
        imgGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}