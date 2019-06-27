package com.example.maticehguru;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.maticehguru.R;

public class GuruNotifikasiFragment extends Fragment {
    ListView notifikasiLV;
    ArrayList<NotifikasiModel> notifikasiModels = new ArrayList<>();
    UserModel currentUser;
    Intent currentIntent;
    private static final String TAG = "GuruNotifikasiFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_fragment_notifikasi, container, false);
        init(view);

        return view;
    }

    private void initListView(){
        Log.d(TAG, "initRecyclerView: called");
        RecyclerViewAdapter listViewAdapter = new RecyclerViewAdapter(this.notifikasiModels, getActivity(), this.currentUser);
        notifikasiLV.setAdapter(listViewAdapter);
        notifikasiLV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void init(View view){
        Log.d(TAG, "init: called");
        notifikasiLV = view.findViewById(R.id.listview);
        currentIntent = getActivity().getIntent();
        currentUser = currentIntent.getParcelableExtra("currentUser");
    }
}
