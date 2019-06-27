package com.example.maticehguru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.maticehguru.Adapters.NotifikasiRecyclerViewAdapter;
import com.example.maticehguru.Adapters.PesananRecyclerViewAdapter;
import com.example.maticehguru.Models.PesananModel;
import com.example.maticehguru.Models.UserModel;
import com.example.maticehguru.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuruNotifikasiFragment extends Fragment {
    RecyclerView notifikasiRV;
    ArrayList<NotifikasiModel> notifikasiModels = new ArrayList<>();
    UserModel currentUser;
    Intent currentIntent;
    private static final String TAG = "GuruNotifikasiFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_fragment_notifikasi, container, false);
        init(view);
        getJSON();
        return view;
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: called");
        NotifikasiRecyclerViewAdapter notifikasiRecyclerViewAdapter = new NotifikasiRecyclerViewAdapter(getActivity(), notifikasiModels);
        notifikasiRV.setAdapter(notifikasiRecyclerViewAdapter);
        notifikasiRV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    private void init(View view){
        Log.d(TAG, "init: called");
        notifikasiRV = view.findViewById(R.id.notifikasiRV);
        currentIntent = getActivity().getIntent();
        currentUser = currentIntent.getParcelableExtra("currentUser");
    }

    private void getJSON() {
        Log.d(TAG, "getJSON: called");
        class GetJSON extends AsyncTask<Void, Void, String> {
            String JSON_STRING;
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getActivity(), "Fetching data...", "Please wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                Log.d(TAG, "s = "+JSON_STRING);
                fetchPesanan(JSON_STRING);
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_PESANAN_ID, currentUser.getId());

                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(Config.URL_GET_NOTIFIKASI, params);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void fetchPesanan(String JSON_STRING) {
        Log.d(TAG, "fetchPesanan: called");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray jsonArray = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject j = jsonArray.getJSONObject(i);

                String id, pesan, status, tgl_notifikasi, id_user;
                String nama_jenjang;

                id = j.getString(Config.KEY_NOTIFIKASI_ID);
                pesan = j.getString(Config.KEY_NOTIFIKASI_PESAN);
                status = j.getString(Config.KEY_NOTIFIKASI_STATUS);
                tgl_notifikasi = j.getString(Config.KEY_NOTIFIKASI_TGL);
                id_user = j.getString(Config.KEY_NOTIFIKASI_ID_USER);

                NotifikasiModel notifikasiModel = new NotifikasiModel(id, pesan, status, tgl_notifikasi, id_user);
//                notifikasiModel.setNama_jenjang(nama_jenjang);

                notifikasiModels.add(notifikasiModel);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        initRecyclerView();
    }
}
