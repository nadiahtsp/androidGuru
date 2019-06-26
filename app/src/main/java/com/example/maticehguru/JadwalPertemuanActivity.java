package com.example.maticehguru;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.maticehguru.Adapters.JadwalPertemuanPertamaRecyclerAdapter;
import com.example.maticehguru.Models.PesananModel;
import com.example.maticehguru.Models.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JadwalPertemuanActivity extends AppCompatActivity {
    UserModel currentUser;
    ArrayList<PesananModel> pesananModels = new ArrayList<>();
    Intent currentIntent;
    RecyclerView jadwalPertemuanRV;
    private static final String TAG = "JadwalPertemuanActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_pertemuan);
        init();
        getJson();
    }

    private void init(){
        currentIntent = getIntent();
        currentUser = currentIntent.getParcelableExtra("currentUser");

        jadwalPertemuanRV = findViewById(R.id.jadwalPertemuanRV);
    }

    private void getJson(){
        class GetJson extends AsyncTask<Void, Void, String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d(TAG, "onPostExecute: s = "+s);
                fetchJadwalPertemuan(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();

                params.put(Config.KEY_PESANAN_ID_GURU, currentUser.getId());
                String s = rh.sendPostRequest(Config.URL_GET_ALL_PESANAN, params);
                return s;
            }
        }

        GetJson gj = new GetJson();
        gj.execute();
    }

    private void fetchJadwalPertemuan(String s){
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

                pesananModels.add(pesananModel);
            }

        }catch(JSONException e){
            e.printStackTrace();
        }

        initJadwalPertemuanRV();
    }

    private void initJadwalPertemuanRV(){
        JadwalPertemuanPertamaRecyclerAdapter adapter = new JadwalPertemuanPertamaRecyclerAdapter(pesananModels, currentUser, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        jadwalPertemuanRV.setAdapter(adapter);
        jadwalPertemuanRV.setLayoutManager(layoutManager);

    }
}
