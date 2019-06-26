package com.example.maticehguru.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.maticehguru.Config;
import com.example.maticehguru.R;
import com.example.maticehguru.RequestHandler;
import com.example.maticehguru.Models.UserModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class GuruScanFragment extends Fragment {
    private Button scan_btn;
    private Context context;
    private static final String TAG = "GuruScanFragment";
    private UserModel currentUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: called");
        View view = inflater.inflate(R.layout.user_fragment_scan, container, false);

        Button scan_btn = view.findViewById(R.id.scan_btn);
        context = getActivity();
        currentUser = getActivity().getIntent().getParcelableExtra("currentUser");

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                integrator.forSupportFragment(GuruScanFragment.this).setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.forSupportFragment(GuruScanFragment.this).setPrompt("Scan");
                integrator.forSupportFragment(GuruScanFragment.this).setCameraId(0);
                integrator.forSupportFragment(GuruScanFragment.this).setBeepEnabled(false);
                integrator.forSupportFragment(GuruScanFragment.this).setBarcodeImageEnabled(false);
                integrator.forSupportFragment(GuruScanFragment.this).initiateScan();
//                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
//                integrator.setPrompt("Scan");
//                integrator.setCameraId(0);
//                integrator.setBeepEnabled(false);
//                integrator.setBarcodeImageEnabled(false);
//                integrator.initiateScan();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: called");
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String resultStr = "";

        if (result != null){
            if (((IntentResult) result).getContents() == null ){
                Toast.makeText(getActivity(),"QR Code tidak dapat dibaca", Toast.LENGTH_LONG).show();
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

    private void addAbsen(final String jsonStr){
        Log.d(TAG, "addAbsen: called");

        class AddAbsen extends AsyncTask<Void, Void, String>{

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(getActivity(), "Mohon tunggu...", "Menambahkan absen", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                Log.d(TAG, "onPostExecute: s = " + s);
//                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
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
