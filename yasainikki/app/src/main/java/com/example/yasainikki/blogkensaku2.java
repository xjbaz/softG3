package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class blogkensaku2 extends AppCompatActivity {

    private LinearLayout layoutPosts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogkensaku2);

        String url = "http://192.168.3.5/courseApp/blogkensaku.php";

        RequestQueue queue = Volley.newRequestQueue(this);

        //textViewPost = findViewById(R.id.textViewPost);
        layoutPosts = findViewById(R.id.layout_posts);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //JSONArray firstItem = response.getJSONArray("SQL_test");
                            JSONArray sqlTestArray = response.getJSONArray("kensaku");

                            // JSONデータから必要な情報を抽出
                            // 例: 最初の要素のpost_textを取得
                            if (sqlTestArray.length() > 0) {
                                //JSONArray firstItem = response.getJSONArray("SQL_test");
                                for (int i = 0;i < sqlTestArray.length();i++) {
                                    JSONObject firstItem = sqlTestArray.getJSONObject(i);
                                    String postContent = firstItem.getString("post_text");
                                    // テキストビューに内容をセット


                                    View postView = getLayoutInflater().inflate(R.layout.post_item, layoutPosts, false);
                                    TextView textViewPost = postView.findViewById(R.id.textViewPost);
                                    textViewPost.setText(postContent);

                                    layoutPosts.addView(postView);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String errorMessage = "通信に失敗しました。";
                        if (error.getMessage() != null) {
                            errorMessage += "\n詳細: " + error.getMessage();
                            Log.e("NetworkError", "エラー詳細: " + error.getMessage());
                        }

                        // ネットワークレスポンスの取得(サーバが動いていないなどのネットワークエラーの場合networkResponse=nullの可能性がある)
                        if (error.networkResponse != null) {
                            errorMessage += "\nステータスコード: " + error.networkResponse.statusCode;
                            Log.e("NetworkError", "ステータスコード: " + error.networkResponse.statusCode);

                            if (error.networkResponse.data != null) {
                                String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                                errorMessage += "\nレスポンス本文: " + responseBody;
                                Log.e("NetworkError", "レスポンス本文: " + responseBody);
                            }
                            // 他のネットワーク情報を取得する場合もあります
                        }
                        Toast.makeText(blogkensaku2.this,"通信に失敗しました。",Toast.LENGTH_SHORT).show();
                    }
                });

        // リクエストをRequestQueueに追加する
        queue.add(jsonObjectRequest);

    }

    public void blog_button3(View view){ finish(); }

    public void blog_button4(View view){
        Intent intent = new Intent(this,main.class);
        startActivities(new Intent[]{intent});
    }
}