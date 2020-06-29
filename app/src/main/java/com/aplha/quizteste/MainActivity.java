
package com.aplha.quizteste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aplha.quizteste.bancodedados.PerguntasDB;
import com.aplha.quizteste.modelos.Questao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textTitulo;
    private RadioGroup radioGroup;
    private RadioButton primeiraQuestao, segundaQuestao, terceiraQuestao, quartaQuestao;
    private Button buttonResponder, buttonVoltar, buttonPular;


    private List <Questao> questaoList;
    private Questao questaoAtual;
    private boolean respondida;
    private int totalDeQuestoes, numeroDaQuestao;
    private int gabarito;

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




            PerguntasDB perguntasDB = new PerguntasDB(this);

            questaoList = perguntasDB.listar();
            totalDeQuestoes = questaoList.size();

            //Collections.shuffle(questaoList);  -- Deixar a lista no aleatório


        proximaQuestao();

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonResponder.setText("Responder");
                if(!respondida) {
                    if (primeiraQuestao.isChecked() || segundaQuestao.isChecked() || terceiraQuestao.isChecked() || quartaQuestao.isChecked()) {
                        respondida = true;
                        buttonResponder.setEnabled(true);


                        mostrarCorreta();
                    } else {
                        Toast.makeText(MainActivity.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
                        respondida = false;

                    }
                }else{
                    proximaQuestao();
                }
            }
        });

    }

    public void proximaQuestao(){
        radioGroup.clearCheck();

        if (numeroDaQuestao < totalDeQuestoes){
            questaoAtual =  questaoList.get(numeroDaQuestao);
            textTitulo.setText(questaoAtual.getPergunta());
            primeiraQuestao.setText(questaoAtual.getResp1());
            segundaQuestao.setText(questaoAtual.getResp2());
            terceiraQuestao.setText(questaoAtual.getResp3());
            quartaQuestao.setText(questaoAtual.getResp4());

            coresOriginais();
            numeroDaQuestao++;
            respondida = false;


        }else{

               finish();
            // telaDeResultado();
        }
    }

    public void mostrarCorreta() {
        RadioButton radioEscolhida = findViewById(radioGroup.getCheckedRadioButtonId());

            gabarito = questaoAtual.getGabarito();
            int resposta = 0;

            if(radioEscolhida == primeiraQuestao){
                resposta = 1;

            }
            if(radioEscolhida == segundaQuestao){
                resposta = 2;

             }
            if(radioEscolhida == terceiraQuestao){
                resposta = 3;

               }
           if(radioEscolhida == quartaQuestao){
               resposta = 4;

              }
            if (gabarito == resposta){
                radioEscolhida.setTextColor(getResources().getColor(R.color.colorAccent));
                buttonResponder.setText("Próxima Questão");
            }else{
                buttonResponder.setText("Próxima Questão");
                switch (resposta) {
                    case 1:
                        primeiraQuestao.setTextColor(getResources().getColor(R.color.respostaErrada));
                        break;
                    case 2:
                        segundaQuestao.setTextColor(getResources().getColor(R.color.respostaErrada));
                        break;
                    case 3:
                        terceiraQuestao.setTextColor(getResources().getColor(R.color.respostaErrada));
                        break;
                    case 4:
                        quartaQuestao.setTextColor(getResources().getColor(R.color.respostaErrada));
                        break;
                }
                switch (gabarito){
                        case 1:
                            primeiraQuestao.setTextColor(getResources().getColor(R.color.colorAccent));
                            break;
                        case 2:
                            segundaQuestao.setTextColor(getResources().getColor(R.color.colorAccent));
                            break;
                        case 3:
                            terceiraQuestao.setTextColor(getResources().getColor(R.color.colorAccent));
                            break;
                        case 4:
                            quartaQuestao.setTextColor(getResources().getColor(R.color.colorAccent));
                            break;

                }
            }
    }

    public void coresOriginais(){
        primeiraQuestao.setTextColor(getResources().getColor(R.color.textoQuestoes));
        segundaQuestao.setTextColor(getResources().getColor(R.color.textoQuestoes));
        terceiraQuestao.setTextColor(getResources().getColor(R.color.textoQuestoes));
        quartaQuestao.setTextColor(getResources().getColor(R.color.textoQuestoes));

    }
}