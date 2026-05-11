package com.example.testeruts1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView tvEmpty;
    private ImageButton btnBack;
    private HistoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recyclerHistory);
        tvEmpty = view.findViewById(R.id.tvEmpty);
        btnBack = view.findViewById(R.id.btnBack);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadHistory();

        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
            requireActivity().findViewById(R.id.fragmentContainer).setVisibility(View.GONE);
        });

        return view;
    }

    private void loadHistory() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("BookingHistory", requireActivity().MODE_PRIVATE);
        int count = prefs.getInt("count", 0);

        List<BookingData> historyList = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String name = prefs.getString("name_" + i, "");
            String email = prefs.getString("email_" + i, "");
            String phone = prefs.getString("phone_" + i, "");
            String destination = prefs.getString("destination_" + i, "");
            String date = prefs.getString("date_" + i, "");
            String gender = prefs.getString("gender_" + i, "");
            String facilities = prefs.getString("facilities_" + i, "");
            int ticketCount = prefs.getInt("ticketCount_" + i, 0);
            long totalPrice = prefs.getLong("totalPrice_" + i, 0);

            if (!name.isEmpty()) {
                historyList.add(new BookingData(name, email, phone, destination, date,
                        gender, facilities, ticketCount, totalPrice));
            }
        }

        if (historyList.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter = new HistoryAdapter(historyList);
            recyclerView.setAdapter(adapter);
        }
    }
}
