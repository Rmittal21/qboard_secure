package com.example.qboard_secure;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText Ed1;
    EditText Ed2;
    Button B1, B2;
    char c;
    String s, k;
    float a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ed1=(EditText)findViewById(R.id.EditText1);
        Ed2=(EditText) findViewById(R.id.EditText2);
        B1=(Button)findViewById(R.id.button);
        B2=(Button)findViewById(R.id.button2);

        Ed2.setCursorVisible(false);
        Ed2.setLongClickable(false);
        Ed2.setClickable(false);
        Ed2.setFocusable(false);
        Ed2.setSelected(false);
        Ed2.setKeyListener(null);
        Ed2.setBackgroundResource(
                android.R.color.transparent);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k = " ";
                s = Ed1.getText().toString();
                for(int i = 0; i<s.length(); i++){
                    c = s.charAt(i);
                    a = c;
                    a = a%10;
                    k = k + Float.toString(a);
                }
                 Ed2.setText(k);
                Ed1.setText("");
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,Ed2.getText().toString());
                Intent chooser=Intent.createChooser(i,"Choose an application");

                if(i.resolveActivity(getPackageManager())!=null){
                    startActivity(chooser);
                }
            }
        });

//

    }
}