package com.example.maticehguru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    Button btnlogin;
    EditText email;
    EditText pass;
    String emailStr,passStr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    login();
            }
        });
    }

    private void init(){

        btnlogin = findViewById(R.id.loginBtn);
        email = findViewById(R.id.emailET);
        pass = findViewById(R.id.passwordET);


    }

    private void login(){
        emailStr= email.getText().toString();
        passStr = pass.getText().toString();

        class Login extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginActivity.this,"Verifying...","Please wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d("s contains: ", s);
//                Toast.makeText(LoginActivity.this,s,Toast.LENGTH_LONG).show();
                loading.dismiss();
                verify(s);
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_USER_EMAIL,emailStr);
                params.put(Config.KEY_USER_PASSWORD,passStr);

                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(Config.URL_GET_LOGIN, params);

                return s;
            }
        }

        Login l = new Login();
        l.execute();


    }

    private void verify(String jsonStr){
        String id, name, email, password, remember_token, alamat, provinsi, kabupatenKota, status, role, no_hp, jenis_kelamin, created_at, updated_at;
        String direktoriCV, institusi;
        try {

//            Toast.makeText(LoginActivity.this,JSON_STRING,Toast.LENGTH_LONG).show();
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);

            Log.d("Json string contains",jsonStr);

            id = c.getString("id");
            name = c.getString("name");
            email = c.getString("email");
            password = c.getString("password");
            remember_token = c.getString("remember_token");
            alamat = c.getString("alamat");
            provinsi = c.getString("provinsi");
            kabupatenKota = c.getString("kabupatenKota");
            status = c.getString("status");
            role = c.getString("role");
            no_hp = c.getString("no_hp");
            jenis_kelamin = c.getString("jenis_kelamin");
            created_at = c.getString("created_at");
            updated_at = c.getString("updated_at");
            direktoriCV = c.getString("direktori_cv");
            institusi = c.getString("institusi");
//            int statusInt = result.length();

            if (!id.equals("null")){
                Toast.makeText(LoginActivity.this,"Welcome "+name,Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);

                UserModel userModel = new UserModel(id, name, email, password, remember_token, alamat, provinsi, kabupatenKota, status, role, no_hp, jenis_kelamin, created_at, updated_at);
                userModel.fillDataGuru(direktoriCV, institusi);
                intent1.putExtra("currentUser", userModel);

//                UserModel userModel = (UserModel) getIntent().getParcelableExtra("currentUser");
                startActivity(intent1);
                finish();
            }
            else {
                Toast.makeText(LoginActivity.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                pass.setText("");
//                Toast.makeText(LoginActivity.this,status,Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            Toast.makeText(LoginActivity.this,"Failed to connect",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}
