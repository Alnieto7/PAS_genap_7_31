package com.example.pas_genap_7_31;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalFragment extends Fragment {

    RecyclerView rvJadwal;
    ProgressBar pbLoading1;
    JadwalAdapter jadwalAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);

        rvJadwal = view.findViewById(R.id.rvJadwal);
        pbLoading1 = view.findViewById(R.id.pbLoading1);
        rvJadwal.setLayoutManager(new LinearLayoutManager(getContext()));

        SoccerAPI api = RetrofitClient.getInstance().create(SoccerAPI.class);
        fetchJadwal(api);

        return view;
    }

    private void fetchJadwal(SoccerAPI api) {
        api.getJadwalLaliga("Jadwal").enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<JadwalModel> jadwal = response.body().getJadwalLaliga();
                    jadwalAdapter = new JadwalAdapter(jadwal);
                    rvJadwal.setAdapter(jadwalAdapter);
                    rvJadwal.setVisibility(View.VISIBLE);
                    pbLoading1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}
