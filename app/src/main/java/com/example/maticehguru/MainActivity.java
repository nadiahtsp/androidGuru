package com.example.maticehguru;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.maticehguru.Models.UserModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    UserModel currentUser;
    boolean backIsPressed = false;

    public static Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;

        currentUser = getIntent().getParcelableExtra("currentUser");

        BottomNavigationView user_bottom_nav = findViewById(R.id.user_bottomnavigation);
        user_bottom_nav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.guru_fragment_container,
                new GuruFragmentHome()).commit();
    }

    @Override
    public void onBackPressed() {
        if(backIsPressed){
            super.onBackPressed();
        }

        this.backIsPressed = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backIsPressed = false;
            }
        }, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: called");
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String resultStr = "";

        if (result != null){
            if (((IntentResult) result).getContents() == null ){
                Toast.makeText(MainActivity.this,"QR Code tidak dapat dibaca", Toast.LENGTH_LONG).show();
            }
            else {
                resultStr = ((IntentResult) result).getContents();
                addAbsen(resultStr);
//                Toast.makeText(getActivity(), resultStr,Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.guru_bottomnav_home:
                            selectedFragment = new GuruFragmentHome();
                            break;
                        case R.id.guru_bottomnav_pemesanan:
                            selectedFragment = new GuruListPesananFragment();
                            break;
                        case R.id.guru_bottomnav_scan:
                            selectedFragment = new GuruFragmentHome();
//                            selectedFragment = new GuruHistoryFragment();
                            startScanner();
                            break;
//                        case R.id.guru_bottomnav_history:
//                            selectedFragment = new GuruHistoryFragment();
//                            break;
                        case R.id.guru_bottomnav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.guru_bottomnav_notification:
                            selectedFragment = new GuruNotifikasiFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.guru_fragment_container,
                            selectedFragment).commit();
                    return true;

                }
            };

    private void startScanner(){
        IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    private void addAbsen(final String jsonStr){
        Log.d(TAG, "addAbsen: called");

        class AddAbsen extends AsyncTask<Void, Void, String> {

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(MainActivity.this, "Mohon tunggu...", "Menambahkan absen", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                Log.d(TAG, "onPostExecute: s = " + s);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                String resultStr = "";
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    resultStr = jsonObject.getString("id_pemesanan");
                }catch (JSONException e){
                    e.printStackTrace();
                }

                RequestHandler requestHandler = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();
                params.put("id_pemesanan", resultStr);
                params.put("id_guru", currentUser.getId());

                Log.d(TAG, "doInBackground: id_pemesanan = "+resultStr);

                String s = requestHandler.sendPostRequest(Config.URL_ADD_ABSEN_BARU, params);
                return s;
            }
        }
        AddAbsen ab = new AddAbsen();
        ab.execute();

    }
}
