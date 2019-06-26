package com.example.maticehguru.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maticehguru.Models.AbsenModel;
import com.example.maticehguru.R;

import java.util.ArrayList;

public class RiwayatAbsenRecyclerViewAdapter extends RecyclerView.Adapter<RiwayatAbsenRecyclerViewAdapter.ViewHolder>{
    Context mContext;
    ArrayList<AbsenModel> absenModels = new ArrayList<>();
    private static final String TAG = "RiwayatAbsenRecyclerVie";

    public RiwayatAbsenRecyclerViewAdapter(Context mContext, ArrayList<AbsenModel> absenModels) {
        this.mContext = mContext;
        this.absenModels = absenModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        Log.d(TAG, "onCreateViewHolder: called");
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
//        RiwayatAbsenRecyclerViewAdapter.ViewHolder holder = new RiwayatAbsenRecyclerViewAdapter().ViewHolder(view);
//        return holder;
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return absenModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
