package com.example.task;

import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        user = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v){

                SharedPreferences sp = getSharedPreferences("com.example.userpass_persist", MODE_PRIVATE);
                String s_user = sp.getString("user", "user");
                String s_pass = sp.getString("pass", "any");

                if (s_user.equals(user.getText().toString()) && s_pass.equals(pass.getText().toString()))
                    startActivity(new Intent(MainActivity.this, Success.class));
                else
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    protected void onResume() {

        super.onResume();
        SharedPreferences sp = getSharedPreferences("com.example.task", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("user", "utkarshaga9@gmail.com");
        ed.putString("pass", "123456");
        ed.apply();
    }

}