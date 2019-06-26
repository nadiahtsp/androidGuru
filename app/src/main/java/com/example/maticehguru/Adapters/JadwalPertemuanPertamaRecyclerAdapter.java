package com.example.maticehguru.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.belom ada, parent, false);
        JadwalPertemuanPertamaRecyclerAdapter.ViewHolder holder = new JadwalPertemuanPertamaRecyclerAdapter().ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        pesananModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
