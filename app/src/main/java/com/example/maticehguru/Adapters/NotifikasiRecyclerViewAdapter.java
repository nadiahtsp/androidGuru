package com.example.maticehguru.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maticehguru.NotifikasiModel;

import java.util.ArrayList;

import com.example.maticehguru.R;

public class NotifikasiRecyclerViewAdapter extends RecyclerView.Adapter<NotifikasiRecyclerViewAdapter.ViewHolder>{
    Context context;
    ArrayList<NotifikasiModel> notifikasiModels = new ArrayList<>();
    private static final String TAG = "NotifikasiRecyclerViewA";

    public NotifikasiRecyclerViewAdapter(Context context, ArrayList<NotifikasiModel> notifikasiModels) {
        this.context = context;
        this.notifikasiModels = notifikasiModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_notifikasi, viewGroup, false);
        NotifikasiRecyclerViewAdapter.ViewHolder holder = new NotifikasiRecyclerViewAdapter.ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        NotifikasiModel notifikasiModel = notifikasiModels.get(i);
        viewHolder.tv_pesannotifikasi.setText(notifikasiModel.getPesan());
        viewHolder.tv_tglnotifikasi.setText(notifikasiModel.getTgl_notifikasi());

    }

    @Override
    public int getItemCount() {
        return notifikasiModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_pesannotifikasi;
        TextView tv_tglnotifikasi;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_pesannotifikasi = itemView.findViewById(R.id.tv_pesannotifikasi);
            tv_tglnotifikasi = itemView.findViewById(R.id.tv_tglnotifikasi);
        }
    }
}
