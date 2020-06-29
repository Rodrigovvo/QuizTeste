package com.aplha.quizteste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    Button botaoRetorno;
    TextView textErradas, textCorretas;
    String erradas, corretas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        botaoRetorno = findViewById(R.id.botaoRetorno);
        textCorretas = findViewById(R.id.textCorretas);
        textErradas = findViewById(R.id.textErradas);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            erradas = bundle.getString("erradas");
            corretas = bundle.getString("corretas");
        }

        Log.i("Bundle: ", " corretas " + corretas + " erradas " +erradas);

        textErradas.setText(erradas);
        textCorretas.setText(corretas);

        botaoRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}