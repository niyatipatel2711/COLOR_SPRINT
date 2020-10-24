package com.example.colorsprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Identify extends AppCompatActivity {

    EditText et1, et2, et3;
    Button identify;
    int r1, g1, b1;
    Color recent = new Color();
    String colName, tag;
    TextView col;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        et1 = findViewById(R.id.e1);
        et2 = findViewById(R.id.e2);
        et3 = findViewById(R.id.e3);
        identify = findViewById(R.id.iBtn);
        col = findViewById(R.id.color);

        identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(tag, "HEllo");
                r1 = Integer.parseInt(et1.getText().toString());
                g1 = Integer.parseInt(et2.getText().toString());
                b1 = Integer.parseInt(et3.getText().toString());

                colName = recent.getColorName(r1, g1, b1);

                if (r1>255 || g1>255 || b1>255){
                    Toast.makeText(Identify.this, "Enter valid number", Toast.LENGTH_LONG).show();
                }else {
                    col.setText("Color name : "+colName);
                }
            }
        });
    }
}