package com.aplha.quizteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aplha.quizteste.bancodedados.PacoteDeQuestoes;
import com.aplha.quizteste.bancodedados.QuestoesDAO;
import com.aplha.quizteste.modelos.Questao;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textTitulo;
    RadioGroup radioGroup;
    RadioButton primeiraQuestao, segundaQuestao, terceiraQuestao, quartaQuestao;
    Button buttonResponder, buttonVoltar, buttonPular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTitulo      = findViewById(R.id.textTitulo);
        radioGroup      = findViewById(R.id.radioGroup);
        primeiraQuestao = findViewById(R.id.primeiraQuestao);
        segundaQuestao  = findViewById(R.id.segundaQuestao);
        terceiraQuestao = findViewById(R.id.terceiraQuestao);
        quartaQuestao   = findViewById(R.id.quartaQuestao);
        buttonPular     = findViewById(R.id.buttonPular);
        buttonResponder = findViewById(R.id.buttonResponder);
        buttonVoltar    = findViewById(R.id.buttonVoltar);

        ArrayList<Questao> arrayDeQuestao = PacoteDeQuestoes.simuladoUm();

        for (Questao questao: arrayDeQuestao){
            QuestoesDAO questoesDAO = new QuestoesDAO(getApplicationContext());
            questoesDAO.salvarQuestoes(questao);
        }

    }
}