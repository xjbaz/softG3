package com.example.yasainikki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.Manifest;
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

public class blogsakusei extends AppCompatActivity {
    //設定した画像
    private ImageView imageView;
    //入力フィールドの変数
    private EditText posttextEdt;
    private Spinner selectedItemEdt;
    private String posttext,selectedItem;
    //投稿するボタン
    private Button postbutton;
    private Spinner spinner;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogsakusei);

        imageView = findViewById(R.id.imageView);

        //プルダウン選択を設定
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //選択をする際のボタン
        Button buttonSelectImage = findViewById(R.id.buttonSelectImage);
        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //画像選択するための画面遷移の設定
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }

        //入力フィールドに入力されたテキストを変数に格納
        posttextEdt = findViewById(R.id.TextPost);
        selectedItemEdt = findViewById(R.id.spinner);
        postbutton = findViewById(R.id.postbutton);

        /*postbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                posttext = posttextEdt.getText().toString();
                selectedItem = spinner.getSelectedItem().toString();
                addDataToDatabase(posttext, selectedItem);
            }
        });*/

    }
    private static final int PICK_IMAGE = 1;

    public void tenth_button1(View view){ finish(); }

    public void tenth_button2(View view){

        String posttext2 = posttextEdt.getText().toString();
        String selectedItem2 = spinner.getSelectedItem().toString();

        addDataToDatabase(posttext2,selectedItem2);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("ImageSelection", "onActivityResult called");
        //選択した画像のデータ取得
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            Log.d("ImageSelection", "Image URI: " + imageUri.toString());
            imageView.setImageURI(imageUri);
        } else {
            Log.d("ImageSelection", "Valid image was not selected");
        }
    }


    private void addDataToDatabase(String posttext, String selectedItem) {
        //リクエストの作成ユーザからの入力をサーバに送信するPOSTリクエストが処理
        String url = "http:/192.168.3.5/courseApp/blogsakusei.php";
        RequestQueue queue = Volley.newRequestQueue(blogsakusei.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(blogsakusei.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                posttextEdt.setText(""); // EditTextのテキストをクリア
                spinner.setSelection(0); // Spinnerの選択を最初のアイテムにリセット

                Intent intent = new Intent(blogsakusei.this,blogtoukoukanryou.class);
                startActivities(new Intent[]{intent});
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(blogsakusei.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
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
                params.put("post_text", posttext);
                params.put("vegetables", selectedItem);
                return params;
            }
        };
        queue.add(request);
    }
    //@Override
    /*public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // パーミッションが許可された場合の処理
            } else {
                // パーミッションが拒否された場合の処理
            }
        }
    }*/
}