package com.example.testeruts1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvPhone, tvDestination, tvDate,
            tvGender, tvFacilities, tvTicketCount, tvTotalPrice;
    private Button btnShareResult, btnNewBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();

        BookingData data = (BookingData) getIntent().getSerializableExtra("BOOKING_DATA");
        if (data == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        displayData(data);
        setupButtons(data);
    }

    private void initViews() {
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvDestination = findViewById(R.id.tvDestination);
        tvDate = findViewById(R.id.tvDate);
        tvGender = findViewById(R.id.tvGender);
        tvFacilities = findViewById(R.id.tvFacilities);
        tvTicketCount = findViewById(R.id.tvTicketCount);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnShareResult = findViewById(R.id.btnShareResult);
        btnNewBooking = findViewById(R.id.btnNewBooking);
    }

    private void displayData(BookingData data) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        tvName.setText("Nama: " + data.getName());
        tvEmail.setText("Email: " + data.getEmail());
        tvPhone.setText("No. HP: " + data.getPhone());
        tvDestination.setText("Destinasi: " + data.getDestination());
        tvDate.setText("Tanggal: " + data.getDate());
        tvGender.setText("Jenis Kelamin: " + data.getGender());
        tvFacilities.setText("Fasilitas: " + data.getFacilities());
        tvTicketCount.setText("Jumlah Tiket: " + data.getTicketCount());
        tvTotalPrice.setText("Total Harga: " + formatter.format(data.getTotalPrice()));
    }

    private void setupButtons(BookingData data) {
        btnShareResult.setOnClickListener(v -> {
            String message = "Detail Pemesanan Tiket Wisata\n" +
                    "Nama: " + data.getName() + "\n" +
                    "Destinasi: " + data.getDestination() + "\n" +
                    "Tanggal: " + data.getDate() + "\n" +
                    "Jumlah Tiket: " + data.getTicketCount() + "\n" +
                    "Total: Rp " + data.getTotalPrice();

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(shareIntent, "Bagikan Detail Pemesanan"));
        });

        btnNewBooking.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
