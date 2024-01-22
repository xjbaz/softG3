package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class yuzatouroku extends AppCompatActivity {

    // 追加：入力フィールドの変数
    private EditText userIdEdt, addressEdt, nameEdt, passwordEdt, profImgEdt, bioEdt, regionEdt, birthEdt;

    private Button submitBtn;

    private String userId,address,name,password,profImg,bio,region,birth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzatouroku);

        // 追加：入力フィールドを初期化
        userIdEdt = findViewById(R.id.userId);
        addressEdt = findViewById(R.id.address);
        nameEdt = findViewById(R.id.name);
        passwordEdt = findViewById(R.id.password);
        profImgEdt = findViewById(R.id.profImg);
        bioEdt = findViewById(R.id.bio);
        regionEdt = findViewById(R.id.region);
        birthEdt = findViewById(R.id.birth);
        //imageView = findViewById(R.id.imageView);

        submitBtn = findViewById(R.id.third_button2);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = userIdEdt.getText().toString();
                address = addressEdt.getText().toString();
                name = nameEdt.getText().toString();
                password = passwordEdt.getText().toString();
                profImg = profImgEdt.getText().toString();
                bio = bioEdt.getText().toString();
                region = regionEdt.getText().toString();
                birth = birthEdt.getText().toString();

                //入力値がからでないか確認
                if (TextUtils.isEmpty(userId)) {
                    userIdEdt.setError("Please enter Name");
                } else if (TextUtils.isEmpty(address)) {
                    addressEdt.setError("Please enter Age");
                } else if (TextUtils.isEmpty(name)) {
                    nameEdt.setError("Please enter Sex");
                } else if (TextUtils.isEmpty(password)) {
                    passwordEdt.setError("Please enter Sex");
                } else if (TextUtils.isEmpty(profImg)) {
                    profImgEdt.setError("Please enter Sex");
                } else if (TextUtils.isEmpty(bio)) {
                    bioEdt.setError("Please enter Sex");
                } else if (TextUtils.isEmpty(region)) {
                    regionEdt.setError("Please enter Sex");
                } else if (TextUtils.isEmpty(birth)) {
                    birthEdt.setError("Please enter Sex");
                } else {
                    sendDataToServer(userId, address, name, password, profImg, bio, region, birth);
                }
            }
        });
    }

    // 以下のメソッドがボタンクリック時に呼ばれる

    public void third_button1(View view) {
        finish();
    }

    public void third_button2(View view) {
        // 入力された情報を取得
        String userId = userIdEdt.getText().toString();
        String address = addressEdt.getText().toString();
        String name = nameEdt.getText().toString();
        String password = passwordEdt.getText().toString();
        String profImg = profImgEdt.getText().toString();
        String bio = bioEdt.getText().toString();
        String region = regionEdt.getText().toString();
        String birth = birthEdt.getText().toString();

        // データをWebサーバーに送信
        sendDataToServer(userId, address, name, password, profImg, bio, region, birth);
    }

    // Webサーバーにデータを送信するメソッド
    private void sendDataToServer(String userId, String address, String name, String password,
                                  String profImg, String bio, String region, String birth) {
        // WebサーバーのURL
        String url = "http://192.168.3.5/courseApp/yuzatouroku.php"; // 送信先のPHPスクリプトのURLを指定

        // リクエストキューを初期化
        RequestQueue queue = Volley.newRequestQueue(this);

        // StringRequestを作成
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", "RESPONSE IS " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(yuzatouroku.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        userIdEdt.setText("");
                        addressEdt.setText("");
                        nameEdt.setText("");
                        passwordEdt.setText("");
                        profImgEdt.setText("");
                        bioEdt.setText("");
                        regionEdt.setText("");
                        birthEdt.setText("");
                       }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 送信失敗時の処理
                        Toast.makeText(yuzatouroku.this, "Failed to send data", Toast.LENGTH_SHORT).show();
                        String errorMessage = error.toString();
                        Log.e("VolleyError", errorMessage);
                    }
                }) {
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
            @Override
            protected Map<String, String> getParams() {
                // 送信するデータをMapに格納
                Map<String, String> params = new HashMap<>();
                params.put("user_id", userId);
                params.put("address", address);
                params.put("name", name);
                params.put("password", password);
                params.put("prof_img", profImg);
                params.put("bio", bio);
                params.put("region", region);
                params.put("birth", birth);
                return params;
            }
        };

        // リクエストをキューに追加して送信
        queue.add(request);
    }
}
