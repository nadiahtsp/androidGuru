package com.example.maticehguru;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.maticehguru.Models.UserModel;
import com.example.maticehguru.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class GuruFragmentHome extends Fragment {
    Button btnMurid, btnJadwal, btnPendapatan;
    UserModel currentUser;
    Intent currentIntent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment_home, container, false);
        init(view);

        btnMurid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DaftarMurid.class);
                intent.putExtra("currentUser", currentUser);
                startActivity(intent);
            }
        });

        btnJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), );
//                intent.putExtra("currentUser", currentUser);
//                startActivity(intent);
            }
        });

        btnPendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PendapatanActivity.class);
                intent.putExtra("currentUser", currentUser);
                startActivity(intent);
            }
        });

        return view;
    }

    private void init(View v){
        btnMurid = v.findViewById(R.id.btnMurid);
        btnJadwal = v.findViewById(R.id.btnJadwal);
        btnPendapatan = v.findViewById(R.id.btnPendapatan);

        currentIntent = getActivity().getIntent();
        currentUser = currentIntent.getParcelableExtra("currentUser");
    }
}
