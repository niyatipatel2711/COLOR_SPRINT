package com.example.colorsprint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Identify extends AppCompatActivity {

    EditText et1, et2, et3;
    Button identify;
    String r1, g1, b1;
    int r, g, b;
    ColorN recent = new ColorN();
    String colName;
    TextView col;
    ImageView imgView;
    private static final String tag = "Identify";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        et1 = findViewById(R.id.e1);
        et2 = findViewById(R.id.e2);
        et3 = findViewById(R.id.e3);
        identify = findViewById(R.id.iBtn);
        col = findViewById(R.id.color);
        imgView = findViewById(R.id.View);

        identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(tag, "Hello:");
                r1 = et1.getText().toString();
                g1 = et2.getText().toString();
                b1 = et3.getText().toString();

                int r = Integer.parseInt(r1);
                int g = Integer.parseInt(g1);
                int b = Integer.parseInt(b1);

                imgView.setBackground(getDrawable(R.drawable.bg));
                imgView.setBackgroundColor(Color.rgb(r, g, b));
                //colName = recent.getColorName(r1, g1, b1);
                //Log.d(tag, "After");
                if (r > 255 || g > 255 || b > 255) {
                    Log.d(tag, "After");
                    Toast.makeText(Identify.this, "Enter valid number", Toast.LENGTH_LONG).show();
                } else {
                    colName = recent.getColor(r1, g1, b1);
                    col.setText(new StringBuilder().append(colName).toString());
                }
            }
        });
    }
}