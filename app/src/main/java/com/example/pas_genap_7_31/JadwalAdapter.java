package com.example.pas_genap_7_31;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {
    private List<JadwalModel> jadwalList;

    public JadwalAdapter(List<JadwalModel> jadwalList) {
        this.jadwalList = jadwalList;
    }

    @NonNull
    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.ViewHolder holder, int position) {
        JadwalModel jadwal = jadwalList.get(position);
        holder.tvJadwalPertandingan.setText(jadwal.getDateEventLocal() + " • " + jadwal.getStrTimeLocal());
        holder.tvHomeTeam.setText(jadwal.getStrHomeTeam());
        holder.tvHomeScore.setText(jadwal.getIntHomeScore());
        holder.tvAwayTeam.setText(jadwal.getStrAwayTeam());
        holder.tvAwayScore.setText(jadwal.getIntAwayScore());
        Glide.with(holder.itemView.getContext()).load(jadwal.getStrHomeTeamBadge()).into(holder.ivHomeTeam);
        Glide.with(holder.itemView.getContext()).load(jadwal.getStrAwayTeamBadge()).into(holder.ivAwayTeam);
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJadwalPertandingan;
        TextView tvHomeTeam;
        TextView tvHomeScore;
        TextView tvAwayTeam;
        TextView tvAwayScore;
        ImageView ivHomeTeam;
        ImageView ivAwayTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJadwalPertandingan = itemView.findViewById(R.id.tvJadwalPertandingan);
            tvHomeTeam = itemView.findViewById(R.id.tvHomeTeam);
            tvHomeScore = itemView.findViewById(R.id.tvHomeScore);
            tvAwayTeam = itemView.findViewById(R.id.tvAwayTeam);
            tvAwayScore = itemView.findViewById(R.id.tvAwayScore);
            ivHomeTeam = itemView.findViewById(R.id.ivHomeTeam);
            ivAwayTeam = itemView.findViewById(R.id.ivAwayTeam);
        }
    }
}
