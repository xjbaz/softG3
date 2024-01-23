package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class bloghyouji extends AppCompatActivity {

    private TextView textViewPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloghyouji);

        String url = "http://172.21.39.140/courseApp/myblog.php";

        RequestQueue queue = Volley.newRequestQueue(this);

        textViewPost = findViewById(R.id.textViewPost);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // レスポンスを処理する
                        // ここで取得したデータをUIに表示する処理を書く
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // エラーを処理する
                        // 例: Toastを表示するなど
                    }
                });

        // リクエストをRequestQueueに追加する
        queue.add(jsonObjectRequest);

        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // JSONデータから必要な情報を抽出
                    String postContent = response.getString("post_text");

                    // テキストビューに内容をセット
                    textViewPost.setText(postContent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        //RequestQueue queue = Volley.newRequestQueue(this);
    }

    public void thirteenth_button1(View view){ finish(); }
}