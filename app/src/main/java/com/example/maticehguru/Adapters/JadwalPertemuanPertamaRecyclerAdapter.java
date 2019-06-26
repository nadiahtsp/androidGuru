package com.example.maticehguru.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maticehguru.Models.PesananModel;
import com.example.maticehguru.Models.UserModel;
import com.example.maticehguru.R;

import java.util.ArrayList;

public class JadwalPertemuanPertamaRecyclerAdapter extends RecyclerView.Adapter<JadwalPertemuanPertamaRecyclerAdapter.ViewHolder>{
    private static final String TAG = "JadwalPertemuanPertamaR";
    private ArrayList<PesananModel> pesananModels = new ArrayList<>();
    private UserModel currentUser;
    private Context mContext;

    public JadwalPertemuanPertamaRecyclerAdapter(ArrayList<PesananModel> pesananModels, UserModel currentUser, Context mContext) {
        this.pesananModels = pesananModels;
        this.currentUser = currentUser;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal_guru, parent, false);
        JadwalPertemuanPertamaRecyclerAdapter.ViewHolder holder = new JadwalPertemuanPertamaRecyclerAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PesananModel pm = pesananModels.get(i);
        viewHolder.namaTV.setText(pm.getNama_murid());
        viewHolder.bidangTV.setText(pm.getNama_mapel());
        viewHolder.jenjangTV.setText(pm.getNama_jenjang());
        viewHolder.tanggalTV.setText(pm.getTgl_pertemuan_pertama());
    }

    @Override
    public int getItemCount() {
        return pesananModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView namaTV, bidangTV, jenjangTV, tanggalTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaTV = itemView.findViewById(R.id.namaTV);
            bidangTV = itemView.findViewById(R.id.bidangTV);
            jenjangTV = itemView.findViewById(R.id.jenjangTV);
            tanggalTV = itemView.findViewById(R.id.tanggalTV);
        }
    }
}
