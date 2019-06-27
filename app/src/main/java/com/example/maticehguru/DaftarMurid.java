package com.example.maticehguru;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.maticehguru.Adapters.DaftarMuridRecyclerViewAdapter;
import com.example.maticehguru.Models.PesananModel;
import com.example.maticehguru.Models.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarMurid extends AppCompatActivity {
    RecyclerView daftarMuridRecyclerView;
    UserModel currentUser;
    Intent currentIntent;

    ArrayList<PesananModel> pesananModelArrayList = new ArrayList<>();

    private static final String TAG = "DaftarMurid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_murid);
        init();
        getJson();
    }

    private void init(){
        Log.d(TAG, "init: called");
        currentIntent = getIntent();
        currentUser = currentIntent.getParcelableExtra("currentUser");

        daftarMuridRecyclerView = findViewById(R.id.daftarMuridRV);
    }

    private void getJson(){
        Log.d(TAG, "getJson: called");
        class GetJson extends AsyncTask<Void, Void, String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d(TAG, "onPostExecute: s = "+s);
                fetchDaftarMurid(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_PESANAN_ID_GURU, currentUser.getId());
                params.put(Config.KEY_PESANAN_STATUS, "1");

                String s = rh.sendPostRequest(Config.URL_GET_ALL_PESANAN, params);

                return s;
            }
        }

        GetJson gj = new GetJson();
        gj.execute();

    }

    private void fetchDaftarMurid(String s){
        Log.d(TAG, "fetchDaftarMurid: called");
        JSONObject jo = null;
        try {
            jo = new JSONObject(s);
            JSONArray ja = jo.getJSONArray(Config.TAG_JSON_ARRAY);

            for (int i = 0; i<ja.length(); i++){
                JSONObject j = ja.getJSONObject(i);
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

                pesananModelArrayList.add(pesananModel);
            }

        }catch(JSONException e){
            e.printStackTrace();
        }


        initRecyclerView();

    }

    private void initRecyclerView(){
        DaftarMuridRecyclerViewAdapter adapter = new DaftarMuridRecyclerViewAdapter(this, pesananModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        daftarMuridRecyclerView.setAdapter(adapter);
        daftarMuridRecyclerView.setLayoutManager(layoutManager);
    }
}
