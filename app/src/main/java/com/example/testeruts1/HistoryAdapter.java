package com.example.testeruts1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<BookingData> historyList;

    public HistoryAdapter(List<BookingData> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        BookingData data = historyList.get(position);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        holder.tvDest.setText(data.getDestination());
        holder.tvDate.setText(data.getDate());
        holder.tvName.setText(data.getName());
        holder.tvTickets.setText(data.getTicketCount() + " Tiket");
        holder.tvPrice.setText(formatter.format(data.getTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvDest, tvDate, tvName, tvTickets, tvPrice;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDest = itemView.findViewById(R.id.tvHistoryDest);
            tvDate = itemView.findViewById(R.id.tvHistoryDate);
            tvName = itemView.findViewById(R.id.tvHistoryName);
            tvTickets = itemView.findViewById(R.id.tvHistoryTickets);
            tvPrice = itemView.findViewById(R.id.tvHistoryPrice);
        }
    }
}
