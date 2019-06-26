package com.example.maticehguru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maticehguru.Config;
import com.example.maticehguru.Models.PesananModel;
import com.example.maticehguru.R;
import com.example.maticehguru.Adapters.PesananRecyclerViewAdapter;
import com.example.maticehguru.RequestHandler;
import com.example.maticehguru.Models.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GuruListPesananFragment extends Fragment {
    RecyclerView listPesananRV;
    ArrayList<PesananModel> pesananModels = new ArrayList<>();
    UserModel currentUser;
    Intent currentIntent;
    private static final String TAG = "GuruListPesananFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_fragment_list_pesanan, container, false);
        init(view);
        getJSON();

        return view;
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: called");
        PesananRecyclerViewAdapter pesananRecyclerViewAdapter = new PesananRecyclerViewAdapter(this.pesananModels, getActivity(), this.currentUser);
        listPesananRV.setAdapter(pesananRecyclerViewAdapter);
        listPesananRV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void init(View view){
        Log.d(TAG, "init: called");
        listPesananRV = view.findViewById(R.id.listPesananRV);
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
                params.put(Config.KEY_PESANAN_ID_GURU, currentUser.getId());
                params.put(Config.KEY_PESANAN_STATUS, "0");

                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(Config.URL_GET_ALL_PESANAN, params);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void fetchPesanan(String JSON_STRING){
        Log.d(TAG, "fetchPesanan: called");
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray jsonArray = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject j = jsonArray.getJSONObject(i);

                String id, id_guru, id_pemesan, id_mapel, nama_murid, kelas, tgl_pertemuan_pertama, status, created_at, updated_at, guru_name, pemesan_name, pemesan_provinsi, pemesan_kabupaten_kota, pemesan_alamat, mapel_name;
                String nama_jenjang;

                id = j.getString(Config.KEY_PESANAN_ID);
                id_guru = j.getString(Config.KEY_PESANAN_ID_GURU);
                id_pemesan = j.getString(Config.KEY_PESANAN_ID_PEMESAN);
                id_mapel = j.getString(Config.KEY_PESANAN_ID_MAPEL);
                nama_murid = j.getString(Config.KEY_PESANAN_NAMA_MURID);
                kelas = j.getString(Config.KEY_PESANAN_KELAS);
                tgl_pertemuan_pertama = j.getString(Config.KEY_PESANAN_TGL_PERTEMUAN_PERTAMA);
                status = j.getString(Config.KEY_PESANAN_STATUS);
                created_at = j.getString(Config.KEY_PESANAN_CREATED_AT);
                updated_at = j.getString(Config.KEY_PESANAN_UPDATED_AT);
                guru_name = j.getString(Config.KEY_PESANAN_GURU_NAME);
                pemesan_name = j.getString(Config.KEY_PESANAN_PEMESAN_NAME);
                pemesan_provinsi = j.getString(Config.KEY_PESANAN_PEMESAN_PROVINSI);
                pemesan_kabupaten_kota = j.getString(Config.KEY_PESANAN_PEMESAN_KABUPATEN_KOTA);
                pemesan_alamat = j.getString(Config.KEY_PESANAN_PEMESAN_ALAMAT);
                mapel_name = j.getString(Config.KEY_PESANAN_MAPEL_NAME);
                nama_jenjang = j.getString(Config.KEY_PESANAN_JENJANG_NAME);

                PesananModel pesananModel = new PesananModel(id, id_guru, id_pemesan, id_mapel, nama_murid, kelas, tgl_pertemuan_pertama, status, created_at, updated_at, guru_name, pemesan_name, pemesan_provinsi, pemesan_kabupaten_kota, pemesan_alamat, mapel_name);
                pesananModel.setNama_jenjang(nama_jenjang);

                pesananModels.add(pesananModel);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        initRecyclerView();
    }
}
