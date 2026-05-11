package com.example.testeruts1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etTicketCount, etDate;
    private Spinner spinnerDestination;
    private RadioGroup rgGender;
    private CheckBox cbTransport, cbMeal, cbHotel;
    private ImageView imgDestination;
    private Button btnBook, btnCall, btnMaps, btnEmail;
    private ImageButton btnLogout;
    private FloatingActionButton fabShare, fabHistory;

    private final String[] destinations = {
            "Pilih Destinasi Wisata",
            "Bali - Pantai Kuta",
            "Yogyakarta - Borobudur",
            "Lombok - Gunung Rinjani",
            "Raja Ampat - Papua",
            "Labuan Bajo - NTT"
    };

    private final double[] prices = {0, 1500000, 800000, 1200000, 3500000, 2000000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupSpinner();
        setupDatePicker();
        setupButtons();
    }

    private void initViews() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etTicketCount = findViewById(R.id.etTicketCount);
        etDate = findViewById(R.id.etDate);
        spinnerDestination = findViewById(R.id.spinnerDestination);
        rgGender = findViewById(R.id.rgGender);
        cbTransport = findViewById(R.id.cbTransport);
        cbMeal = findViewById(R.id.cbMeal);
        cbHotel = findViewById(R.id.cbHotel);
        imgDestination = findViewById(R.id.imgDestination);
        btnBook = findViewById(R.id.btnBook);
        btnCall = findViewById(R.id.btnCall);
        btnMaps = findViewById(R.id.btnMaps);
        btnEmail = findViewById(R.id.btnEmail);
        btnLogout = findViewById(R.id.btnLogout);
        fabShare = findViewById(R.id.fabShare);
        fabHistory = findViewById(R.id.fabHistory);
    }

    private void setupSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, destinations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestination.setAdapter(adapter);

        spinnerDestination.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                updateDestinationImage(position);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });
    }

    private void updateDestinationImage(int position) {
        int imageRes;
        switch (position) {
            case 1: imageRes = R.drawable.ic_destination; break;
            case 2: imageRes = R.drawable.ic_destination; break;
            case 3: imageRes = R.drawable.ic_destination; break;
            case 4: imageRes = R.drawable.ic_destination; break;
            case 5: imageRes = R.drawable.ic_destination; break;
            default: imageRes = R.drawable.ic_destination; break;
        }
        imgDestination.setImageResource(imageRes);
    }

    private void setupDatePicker() {
        etDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year1, month1, dayOfMonth) -> {
                        String date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                        etDate.setText(date);
                    }, year, month, day);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.show();
        });
    }

    private void setupButtons() {
        btnBook.setOnClickListener(v -> processBooking());

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:081234567890"));
            startActivity(intent);
        });

        btnMaps.setOnClickListener(v -> {
            int pos = spinnerDestination.getSelectedItemPosition();
            String query = destinations[pos].replace(" ", "+");
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + query);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/search/?api=1&query=" + query));
                startActivity(browserIntent);
            }
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:cs@pesonawisata.id"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Pertanyaan Pemesanan Tiket Wisata");
            startActivity(intent);
        });

        fabShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                    "Yuk liburan ke destinasi wisata Indonesia bersama Pesona Wisata! " +
                            "Download aplikasinya sekarang.");
            startActivity(Intent.createChooser(shareIntent, "Bagikan via"));
        });

        fabHistory.setOnClickListener(v -> {
            findViewById(R.id.fragmentContainer).setVisibility(View.VISIBLE);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, new HistoryFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        btnLogout.setOnClickListener(v -> {
            SharedPreferences sessionPrefs = getSharedPreferences("UserSession", MODE_PRIVATE);
            SharedPreferences.Editor editor = sessionPrefs.edit();
            editor.clear();
            editor.apply();

            Toast.makeText(this, "Logout berhasil!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }

    private void processBooking() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String ticketStr = etTicketCount.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        int destPos = spinnerDestination.getSelectedItemPosition();

        if (!validateInput(name, email, phone, ticketStr, date, destPos)) {
            return;
        }

        int ticketCount = Integer.parseInt(ticketStr);
        double basePrice = prices[destPos];
        double totalPrice = basePrice * ticketCount;

        StringBuilder facilities = new StringBuilder();
        if (cbTransport.isChecked()) {
            facilities.append("Transportasi ");
            totalPrice += 200000 * ticketCount;
        }
        if (cbMeal.isChecked()) {
            facilities.append("Makanan ");
            totalPrice += 150000 * ticketCount;
        }
        if (cbHotel.isChecked()) {
            facilities.append("Penginapan ");
            totalPrice += 500000 * ticketCount;
        }

        if (facilities.length() == 0) {
            facilities.append("Tidak ada fasilitas tambahan");
        }

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        RadioButton rbGender = findViewById(selectedGenderId);
        String gender = rbGender.getText().toString();

        BookingData bookingData = new BookingData(
                name, email, phone, destinations[destPos], date,
                gender, facilities.toString(), ticketCount, totalPrice
        );

        saveToHistory(bookingData);

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("BOOKING_DATA", bookingData);
        startActivity(intent);
    }

    private boolean validateInput(String name, String email, String phone, String ticketStr, String date, int destPos) {
        if (TextUtils.isEmpty(name)) {
            etName.setError("Nama tidak boleh kosong");
            etName.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email tidak boleh kosong");
            etEmail.requestFocus();
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            etEmail.setError("Email harus mengandung '@' dan '.'");
            etEmail.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Nomor HP tidak boleh kosong");
            etPhone.requestFocus();
            return false;
        }

        if (!phone.matches("\\d+")) {
            etPhone.setError("Nomor HP harus berupa angka");
            etPhone.requestFocus();
            return false;
        }

        if (phone.length() < 10) {
            etPhone.setError("Nomor HP minimal 10 digit");
            etPhone.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(ticketStr)) {
            etTicketCount.setError("Jumlah tiket tidak boleh kosong");
            etTicketCount.requestFocus();
            return false;
        }

        if (!ticketStr.matches("\\d+")) {
            etTicketCount.setError("Jumlah tiket harus berupa angka");
            etTicketCount.requestFocus();
            return false;
        }

        int ticketCount = Integer.parseInt(ticketStr);
        if (ticketCount <= 0) {
            etTicketCount.setError("Jumlah tiket minimal 1");
            etTicketCount.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(date)) {
            etDate.setError("Tanggal keberangkatan harus dipilih");
            etDate.requestFocus();
            return false;
        }

        if (destPos == 0) {
            Toast.makeText(this, "Silakan pilih destinasi wisata", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Silakan pilih jenis kelamin", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void saveToHistory(BookingData data) {
        SharedPreferences prefs = getSharedPreferences("BookingHistory", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int count = prefs.getInt("count", 0);
        count++;

        editor.putInt("count", count);
        editor.putString("name_" + count, data.getName());
        editor.putString("email_" + count, data.getEmail());
        editor.putString("phone_" + count, data.getPhone());
        editor.putString("destination_" + count, data.getDestination());
        editor.putString("date_" + count, data.getDate());
        editor.putString("gender_" + count, data.getGender());
        editor.putString("facilities_" + count, data.getFacilities());
        editor.putInt("ticketCount_" + count, data.getTicketCount());
        editor.putLong("totalPrice_" + count, (long) data.getTotalPrice());
        editor.apply();

        Toast.makeText(this, "Pemesanan berhasil disimpan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            findViewById(R.id.fragmentContainer).setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}
