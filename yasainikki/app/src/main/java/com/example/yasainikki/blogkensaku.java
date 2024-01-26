package com.example.yasainikki;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class blogkensaku extends AppCompatActivity {

    private Spinner spinner;
    //選択したテキストを格納
    private Spinner selectedItemEdt;
    private String vegetables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogkensaku);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        selectedItemEdt = findViewById(R.id.spinner);


    }


    public void blog_button1(View view){ finish(); }

    //public void blog_button2(View view){ finish(); }

    public void blog_button2(View view){
        String vegetables = spinner.getSelectedItem().toString();

        addDataToDatabase(vegetables);
    }

    private void addDataToDatabase(String vegetables) {
        //リクエストの作成ユーザからの入力をサーバに送信するPOSTリクエストが処理
        String url = "http://192.168.3.5/courseApp/blogkensaku.php";
        RequestQueue queue = Volley.newRequestQueue(blogkensaku.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(blogkensaku.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                spinner.setSelection(0); // Spinnerの選択を最初のアイテムにリセット

                Intent intent = new Intent(blogkensaku.this,blogkensaku2.class);
                startActivity(intent);

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(blogkensaku.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                String errorMessage = error.toString();
                Log.e("VolleyError", errorMessage);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("vegetables", vegetables);
                return params;
            }
        };
        queue.add(request);
    }

}