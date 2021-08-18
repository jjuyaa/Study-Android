package com.example.mission08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CUSTOMER = 201;
    public static final int REQUEST_CODE_OUTPUT = 202;
    public static final int REQUEST_CODE_ITEM = 203;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // process received intent
        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");
        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                intent.putExtra("menu", "고객관리 화면");
                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
                finish();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                intent.putExtra("menu", "매출관리 화면");
                startActivityForResult(intent, REQUEST_CODE_OUTPUT);
                finish();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemActivity.class);
                intent.putExtra("menu", "상품관리 화면");
                startActivityForResult(intent, REQUEST_CODE_ITEM);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null) {
            if (requestCode == REQUEST_CODE_CUSTOMER) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    showToast("고객관리 응답, result code : " + resultCode + ", message : " + message);
                }
            } else if (requestCode == REQUEST_CODE_OUTPUT) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    showToast("매출관리 응답, result code : " + resultCode + ", message : " + message);
                }
            } else if (requestCode == REQUEST_CODE_ITEM) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    showToast("상품관리 응답, result code : " + resultCode + ", message : " + message);
                }
            }
        }

    }

    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}