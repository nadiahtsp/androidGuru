package com.example.maticehguru;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.maticehguru.Adapters.DaftarMuridDetailRecyclerViewAdapter;
import com.example.maticehguru.Models.AbsenModel;
import com.example.maticehguru.Models.PesananModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailDaftarMuridActivity extends AppCompatActivity {
    PesananModel currentMurid;
    ArrayList<AbsenModel> absenModels = new ArrayList<>();
    private static final String TAG = "DetailDaftarMuridActivi";

    RecyclerView daftarMuridRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_daftar_murid);
        init();
        getJson();
    }

    private void init(){
        Log.d(TAG, "init: called");
        currentMurid = getIntent().getParcelableExtra("currentMurid");
        daftarMuridRV = findViewById(R.id.daftarAbsenRV);
    }

    private void getJson(){
        Log.d(TAG, "getJson: called");
        class GetJson extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailDaftarMuridActivity.this, "Fetching...", "Please wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d(TAG, "onPostExecute: s = "+s);
                loading.dismiss();
                fetchAbsen(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_ABSEN_ID_PEMESANAN, currentMurid.getId());
                Log.d(TAG, "doInBackground: id_pemesanan = "+currentMurid.getId());

                String s = rh.sendPostRequest(Config.URL_GET_ALL_ABSEN, params);

                return s;
            }
        }
        GetJson gj = new GetJson();
        gj.execute();

    }

    private void fetchAbsen(String s){
        Log.d(TAG, "fetchAbsen: called");
        JSONObject jo = null;
        try{
            jo = new JSONObject(s);
            JSONArray ja = jo.getJSONArray(Config.TAG_JSON_ARRAY);

            Log.d(TAG, "fetchAbsen: ja.length = "+ja.length());

            for(int i = 0; i<ja.length(); i++) {
                JSONObject j = ja.getJSONObject(i);
                String id, id_pemesanan, status, created_at, updated_at;
                String nama_guru, nama_murid, nama_pemesan, mapel, jenjang;

                id = j.getString(Config.KEY_ABSEN_ID);
                id_pemesanan = j.getString(Config.KEY_ABSEN_ID_PEMESANAN);
                status = j.getString(Config.KEY_ABSEN_STATUS);
                created_at = j.getString(Config.KEY_ABSEN_CREATED_AT);
                updated_at = j.getString(Config.KEY_ABSEN_UPDATED_AT);
                nama_guru = j.getString(Config.KEY_ABSEN_NAMA_GURU);
                nama_murid = j.getString(Config.KEY_ABSEN_NAMA_MURID);
                nama_pemesan = j.getString(Config.KEY_ABSEN_NAMA_PEMESAN);
                mapel = j.getString(Config.KEY_ABSEN_NAMA_MAPEL);
                jenjang = j.getString(Config.KEY_ABSEN_JENJANG);

                AbsenModel am = new AbsenModel(id, id_pemesanan, status, created_at, updated_at);
                am.setNama_guru(nama_guru);
                am.setNama_murid(nama_murid);
                am.setNama_pemesan(nama_pemesan);
                am.setMapel(mapel);
                am.setJenjang(jenjang);

                absenModels.add(am);
            }
            Log.d(TAG, "fetchAbsen: absenModels.size = "+absenModels.size());

        }catch (JSONException e){
            e.printStackTrace();
        }

        DaftarMuridDetailRecyclerViewAdapter adapter = new DaftarMuridDetailRecyclerViewAdapter(this, absenModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        daftarMuridRV.setAdapter(adapter);
        daftarMuridRV.setLayoutManager(layoutManager);
    }
}
