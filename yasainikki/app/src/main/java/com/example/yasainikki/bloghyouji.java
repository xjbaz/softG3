package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bloghyouji extends AppCompatActivity {

    //private TextView textViewPost;
    private LinearLayout layoutPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloghyouji);

        String url = "http://192.168.3.5/courseApp/myblog.php";

        RequestQueue queue = Volley.newRequestQueue(this);

        //textViewPost = findViewById(R.id.textViewPost);
        layoutPosts = findViewById(R.id.layout_posts);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //JSONArray firstItem = response.getJSONArray("SQL_test");
                            JSONArray sqlTestArray = response.getJSONArray("SQL_test");

                            // JSONデータから必要な情報を抽出
                            // 例: 最初の要素のpost_textを取得
                            if (sqlTestArray.length() > 0) {
                                //JSONArray firstItem = response.getJSONArray("SQL_test");
                                for (int i = 0;i < sqlTestArray.length();i++) {
                                    JSONObject firstItem = sqlTestArray.getJSONObject(i);
                                    String postContent = firstItem.getString("post_text");
                                    // テキストビューに内容をセット
                                    /*TextView textView = new TextView(bloghyouji.this);
                                    textView.setText(postContent);

                                    textView.setLayoutParams(new LinearLayout.LayoutParams(
                                            LinearLayout.LayoutParams.MATCH_PARENT,
                                            LinearLayout.LayoutParams.WRAP_CONTENT));*/

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
                            // 他のネットワーク情報を取得する場合もあります
                        }
                            Toast.makeText(bloghyouji.this,"通信に失敗しました。",Toast.LENGTH_SHORT).show();
                    }
                });

        // リクエストをRequestQueueに追加する
        queue.add(jsonObjectRequest);

    }

    public void thirteenth_button1(View view){ finish(); }
}