package com.example.maticehguru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GuruListPesananFragment extends Fragment {
    RecyclerView listPesananRV;
    ArrayList<PesananModel> pesananModels;
    UserModel currentUser;
    Intent currentIntent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_fragment_list_pesanan, container, false);
        init(view);
        getJSON();

        return view;
    }

    private void init(View view){
        listPesananRV = view.findViewById(R.id.listPesananRV);
        currentIntent = getActivity().getIntent();
        currentUser = currentIntent.getParcelableExtra("currentUser");
    }

    private void getJSON() {
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
                Log.d("JSON in fetchPesanan", JSON_STRING);
                fetchPesanan(JSON_STRING);
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_PESANAN_ID_GURU, currentUser.getId());

                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(Config.URL_GET_ALL_PESANAN, params);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void fetchPesanan(String JSON_STRING){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                //Mengubah JSON menjadi bentuk objek
                JSONObject c = result.getJSONObject(i);

                String id, id_guru, id_pemesan, status, created_at, updated_at, guru_name, pemesan_name, pemesan_provinsi, pemesan_kabupaten_kota, pemesan_alamat;

                //Memasukkan semua yang ada di JSON Object ke guruModels
                id = c.getString(Config.KEY_PESANAN_ID);
                id_guru = c.getString(Config.KEY_PESANAN_ID_GURU);
                id_pemesan = c.getString(Config.KEY_PESANAN_ID_PEMESAN);
                status = c.getString(Config.KEY_PESANAN_STATUS);
                created_at = c.getString(Config.KEY_PESANAN_CREATED_AT);
                updated_at = c.getString(Config.KEY_PESANAN_UPDATED_AT);
                guru_name = c.getString(Config.KEY_PESANAN_GURU_NAME);
                pemesan_name = c.getString(Config.KEY_PESANAN_PEMESAN_NAME);
                pemesan_provinsi = c.getString(Config.KEY_PESANAN_PEMESAN_PROVINSI);
                pemesan_kabupaten_kota = c.getString(Config.KEY_PESANAN_PEMESAN_KABUPATEN_KOTA);
                pemesan_alamat = c.getString(Config.KEY_PESANAN_PEMESAN_ALAMAT);

                PesananModel pesananModel = new PesananModel(id, id_guru, id_pemesan, status, created_at, updated_at, guru_name, pemesan_name, pemesan_provinsi, pemesan_kabupaten_kota, pemesan_alamat);
                pesananModels.add(pesananModel);
            }

//            Log.d("guruModels.size : ", Integer.toString(this.pesananModels.size()));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
