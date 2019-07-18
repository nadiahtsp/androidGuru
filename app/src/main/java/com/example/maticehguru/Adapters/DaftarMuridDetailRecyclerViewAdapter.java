package com.example.maticehguru.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maticehguru.DaftarMurid;
import com.example.maticehguru.Models.AbsenModel;
import com.example.maticehguru.R;

import java.util.ArrayList;

public class DaftarMuridDetailRecyclerViewAdapter extends RecyclerView.Adapter<DaftarMuridDetailRecyclerViewAdapter.ViewHolder>{
    Context context;
    ArrayList<AbsenModel> absenModels = new ArrayList<>();
    private static final String TAG = "DaftarMuridDetailRecycl";

    public DaftarMuridDetailRecyclerViewAdapter(Context context, ArrayList<AbsenModel> absenModels) {
        Log.d(TAG, "DaftarMuridDetailRecyclerViewAdapter: called");
        this.context = context;
        this.absenModels = absenModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(context).inflate(R.layout.item_daftar_detail_murid, parent, false);
        DaftarMuridDetailRecyclerViewAdapter.ViewHolder viewHolder = new DaftarMuridDetailRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called");
        AbsenModel am = absenModels.get(i);
        viewHolder.tglAbsen.setText(am.getCreated_at());
        viewHolder.namaMuridTV.setText(am.getNama_murid());
        viewHolder.mapelTV.setText(am.getMapel());
    }

    @Override
    public int getItemCount() {
        return absenModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "ViewHolder";
        TextView tglAbsen, namaMuridTV, mapelTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: called");
            tglAbsen = itemView.findViewById(R.id.tanggalAbsenTV);
            namaMuridTV = itemView.findViewById(R.id.namaMuridTV);
            mapelTV = itemView.findViewById(R.id.mapelTV);
        }
    }
}
