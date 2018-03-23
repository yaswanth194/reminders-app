package edu.niu.z1805839.reminderapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private JSONObject myObj;
    private JSONArray myArray;
    private JsonParser jParser = new JsonParser();
    private String uname,upassword;
    private EditText username, password;
    private Button loginBtn, registerBtn, btnPwd;

    String strUrl = "http://10.166.236.144:8080/user/"+uname;
    private static final String TAG = "Query1";
    String value ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LOGIN");
        username = (EditText) findViewById(R.id.loginName);
        password = (EditText) findViewById(R.id.loginPwd);
        loginBtn = (Button) findViewById(R.id.loginButton);
        registerBtn = (Button) findViewById(R.id.loginRegBtn);
        btnPwd = (Button) findViewById(R.id.buttonpwd);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = username.getText().toString();
                upassword = password.getText().toString();

                new passwordTask().execute();

            }
        });
    }

    public class passwordTask extends AsyncTask<String,String,String> {

           @Override
           protected void onPreExecute() {
               super.onPreExecute();
           }

           @Override
           protected void onPostExecute(String s) {
               super.onPostExecute(s);
           }

           @Override
           protected String doInBackground(String... strings) {
              // Log.d(TAG,"entered");

               try {
                   URL url = new URL(strUrl);
                   HttpURLConnection con = (HttpURLConnection)url.openConnection();
                   con.setRequestMethod("GET");
                   con.connect();
                   //Log.d(TAG,"entered");

                   BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                   value = bf.readLine();
                   System.out.println("result is" +value);
                   Log.d(TAG,value +" check");
                   //Toast.makeText(MainActivity.this, "the password is" + value, Toast.LENGTH_SHORT).show();
               }
               catch (java.io.IOException e) {
                   e.printStackTrace();
               }
               return value;
           }
       }

    }

