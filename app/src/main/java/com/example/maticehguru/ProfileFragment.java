package com.example.maticehguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maticehguru.Models.UserModel;
import com.example.maticehguru.Web_bantuan;

public class ProfileFragment extends Fragment {
    @Nullable

    TextView nama, email, no_hp, logoutTV;
    ImageView editIV;
    Button btn_help,btn_kontak;
    UserModel userModel;

    private static final String TAG = "ProfilFragment";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
       init(view);


        logoutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;

    }


    private void init(View view){
        userModel = (UserModel) getActivity().getIntent().getParcelableExtra("currentUser");
        nama = (TextView) view.findViewById(R.id.namaTV);
        email = (TextView) view.findViewById(R.id.emailTV);
        no_hp = (TextView) view.findViewById(R.id.no_hpTV);
        logoutTV = (TextView) view.findViewById(R.id.tv_logout);
        btn_kontak=(Button)view.findViewById(R.id.btnURL1);
        btn_kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebKontak.class);
                startActivity(intent);
            }
        });
        btn_help = (Button)view.findViewById(R.id.btnHelp);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Web_bantuan.class);
                startActivity(intent);
            }
        });

        nama.setText(userModel.getName());
        email.setText(userModel.getEmail());
        no_hp.setText(userModel.getNo_hp());
    }
}
