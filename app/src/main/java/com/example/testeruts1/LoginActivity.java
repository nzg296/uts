package com.example.testeruts1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etConfirmPassword;
    private Button btnAction;
    private TextView tvToggle, tvTitle, tvSubtitle;
    private boolean isLoginMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sessionPrefs = getSharedPreferences("UserSession", MODE_PRIVATE);
        boolean isLoggedIn = sessionPrefs.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
            return;
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnAction = findViewById(R.id.btnAction);
        tvToggle = findViewById(R.id.tvToggle);
        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);

        updateUI();

        btnAction.setOnClickListener(v -> {
            if (isLoginMode) {
                doLogin();
            } else {
                doRegister();
            }
        });

        tvToggle.setOnClickListener(v -> {
            isLoginMode = !isLoginMode;
            updateUI();
        });
    }

    private void updateUI() {
        etUsername.setText("");
        etPassword.setText("");
        etConfirmPassword.setText("");
        etConfirmPassword.setVisibility(isLoginMode ? View.GONE : View.VISIBLE);

        if (isLoginMode) {
            tvTitle.setText("Login");
            tvSubtitle.setText("Silakan login untuk melanjutkan");
            btnAction.setText("LOGIN");
            tvToggle.setText("Belum punya akun? Daftar di sini");
        } else {
            tvTitle.setText("Register");
            tvSubtitle.setText("Buat akun baru untuk memesan tiket wisata");
            btnAction.setText("REGISTER");
            tvToggle.setText("Sudah punya akun? Login di sini");
        }
    }

    private void doLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            etUsername.setError("Username tidak boleh kosong");
            etUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password tidak boleh kosong");
            etPassword.requestFocus();
            return;
        }

        SharedPreferences userPrefs = getSharedPreferences("UserAccounts", MODE_PRIVATE);
        String savedPassword = userPrefs.getString(username, null);

        if (savedPassword == null) {
            Toast.makeText(this, "Username tidak ditemukan. Silakan register terlebih dahulu.", Toast.LENGTH_LONG).show();
            return;
        }

        if (!savedPassword.equals(password)) {
            Toast.makeText(this, "Password salah!", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sessionPrefs = getSharedPreferences("UserSession", MODE_PRIVATE);
        SharedPreferences.Editor editor = sessionPrefs.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("username", username);
        editor.apply();

        Toast.makeText(this, "Login berhasil! Selamat datang " + username, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private void doRegister() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            etUsername.setError("Username tidak boleh kosong");
            etUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password tidak boleh kosong");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password minimal 6 karakter");
            etPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.setError("Konfirmasi password tidak boleh kosong");
            etConfirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password dan konfirmasi tidak cocok");
            etConfirmPassword.requestFocus();
            return;
        }

        SharedPreferences userPrefs = getSharedPreferences("UserAccounts", MODE_PRIVATE);
        if (userPrefs.contains(username)) {
            Toast.makeText(this, "Username sudah terdaftar! Silakan login.", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = userPrefs.edit();
        editor.putString(username, password);
        editor.apply();

        Toast.makeText(this, "Register berhasil! Silakan login dengan akun Anda.", Toast.LENGTH_LONG).show();
        isLoginMode = true;
        updateUI();
    }
}
