package com.example.maticehguru;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maticehguru.Models.PesananModel;
import com.example.maticehguru.Models.UserModel;

import java.util.HashMap;

public class DetailPesanan extends AppCompatActivity {
    TextView namaPemesanTV, provinsiTV, kabupatenKotaTV, alamatTV,jadwalTV;
    Button acceptBtn, declineBtn;

    UserModel currentUser;
    PesananModel currentPesanan;

    String idPesananStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);
        init();

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_PESANAN_ID, idPesananStr);
                updatePesanan(Config.URL_ACC_PESANAN_BARU, params);
            }
        });

        declineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_PESANAN_ID, idPesananStr);
                updatePesanan(Config.URL_DEC_PESANAN_BARU, params);
            }
        });
    }

    private void init(){
        namaPemesanTV = findViewById(R.id.namaPemesanTV);
        provinsiTV = findViewById(R.id.provinsiTV);
        kabupatenKotaTV = findViewById(R.id.kabupatenKotaTV);
        alamatTV = findViewById(R.id.alamatTV);
        jadwalTV=findViewById(R.id.jadwalTV);

        acceptBtn = findViewById(R.id.btnAccept);
        declineBtn = findViewById(R.id.btnDecline);

        currentUser = getIntent().getParcelableExtra("currentUser");
        currentPesanan = getIntent().getParcelableExtra("currentPesanan");
        idPesananStr = currentPesanan.getId();

        namaPemesanTV.setText(currentPesanan.getNama_murid());
        provinsiTV.setText(currentPesanan.getPemesan_provinsi());
        kabupatenKotaTV.setText(currentPesanan.getPemesan_kabupaten_kota());
        alamatTV.setText(alamatTV.getText().toString()+" "+currentPesanan.getPemesan_alamat());
        jadwalTV.setText(jadwalTV.getText().toString()+" "+currentPesanan.getTgl_pertemuan_pertama());
    }

    private void updatePesanan(final String url, final HashMap<String, String> params){
        class UpdatePesanan extends AsyncTask<Void, Void, String>{
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
               // progressDialog = ProgressDialog.show(DetailPesanan.this,"Mohon tunggu...","Pesanan sedang diproses...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //progressDialog.dismiss();
                Toast.makeText(DetailPesanan.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler requestHandler = new RequestHandler();
                String s = requestHandler.sendPostRequest(url, params);
                return s;
            }
        }

        UpdatePesanan updatePesanan = new UpdatePesanan();
        updatePesanan.execute();
        finish();
    }
}
