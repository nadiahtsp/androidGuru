package com.example.maticehguru;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ListViewAdapter extends ListView.Adapter<ListViewAdapter.ViewHolder> {
    private ArrayList<PesananModel> notifikasiModels = new ArrayList<>();
    private UserModel currentUser;
    private Context mContext;

    public ListViewAdapter(ArrayList<PesananModel> notifikasiModels, Context mContext, UserModel currentUser) {
        this.currentUser = currentUser;
        this.notifikasiModels = notifikasiModels;
        this.mContext = mContext;
    }

    @Override
    public ListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pesanan, parent, false);
        RecyclerViewAdapter.ViewHolder holder = new RecyclerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
//        viewHolder.teacherNameTV.setText(mTeacherName.get(position));
//        viewHolder.institusiTV.setText(mTeacherInstitution.get(position));
        viewHolder.namaPemesanTV.setText(pesananModels.get(position).getPemesan_name());
        viewHolder.kabupatenKotaTV.setText(pesananModels.get(position).getPemesan_kabupaten_kota());
        viewHolder.provinsiTV.setText(pesananModels.get(position).getPemesan_provinsi());

        viewHolder.listPesananLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPesanan.class);
                intent.putExtra("currentUser", currentUser);
                intent.putExtra("currentPesanan", pesananModels.get(position));

                Log.d(TAG, "onBindViewHolder: id pemesan = "+ pesananModels.get(position).getId_pemesan());
//                Toast.makeText(mContext, "id guru = "+ id + "/n id pemesan = " + currentUser.getId(), Toast.LENGTH_LONG).show();

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pesananModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout listPesananLL;
        private TextView namaPemesanTV, provinsiTV, kabupatenKotaTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listPesananLL = itemView.findViewById(R.id.listPesananLL);

            namaPemesanTV = itemView.findViewById(R.id.namaPemesanTV);
            provinsiTV = itemView.findViewById(R.id.provinsiTV);
            kabupatenKotaTV = itemView.findViewById(R.id.kabupatenKotaTV);
        }
    }

}
