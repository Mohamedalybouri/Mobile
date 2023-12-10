package com.example.mohamedalibourilsi3_tp2.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamedalibourilsi3_tp2.Controller.Controller;
import com.example.mohamedalibourilsi3_tp2.R;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur;
    private TextView tv;
    private SeekBar sb;
    private RadioGroup rg;
    private RadioButton rboui,rbnon;
    private Button b;
    private TextView txview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        etValeur = findViewById(R.id.etValeur);
        tv = findViewById(R.id.tvage);
        sb = findViewById(R.id.sbAge);
        rboui = findViewById(R.id.rbtOui);
        rbnon = findViewById(R.id.rbtNon);
        b = findViewById(R.id.btnConsulter);
        txview = findViewById(R.id.txview);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                 Log.i("Information", "onProgressChanged "+progress);
                 // affichage dans le Log de Android studio pour voir le changements détectés sur le SeekBar ..
                 tv.setText("Votre âge : "+ progress);
                 // Mise à jour du TextView par la valeur : progress à chaqu changement.
             }
             public void onStartTrackingTouch(SeekBar seekBar) {}
             public void onStopTrackingTouch(SeekBar seekBar) {}
         });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
            }
        });
    }
        public void calculer() {
            int age = sb.getProgress();
            System.out.println("age =" + age);
            String valmesurestr = (etValeur.getText().toString());

            if (age == 0) {
                Toast.makeText(MainActivity.this, "please set a value >0", Toast.LENGTH_SHORT).show();
            } else {
                if (valmesurestr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "the value is empty", Toast.LENGTH_SHORT).show();
                } else {
                    float valmesure = Float.parseFloat(valmesurestr);
                    txview.setText("val =" + valmesure);
                    boolean isFasting = rboui.isChecked();
                    txview.setText("isFasting? =" + isFasting);
                    Controller c = new Controller();
                    c.createPatient(age,isFasting,valmesure);
                    txview.setText(c.getResponse());
                }
            }
        }
}
