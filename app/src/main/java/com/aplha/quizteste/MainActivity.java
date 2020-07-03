
package com.aplha.quizteste;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aplha.quizteste.bancodedados.PerguntasDB;
import com.aplha.quizteste.modelos.Questao;

import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 1800000;
    private TextView textTitulo, cronometro;
    private RadioGroup radioGroup;
    private RadioButton primeiraQuestao, segundaQuestao, terceiraQuestao, quartaQuestao;
    private Button buttonResponder, buttonPular;

    private List <Questao> questaoList;
    private Questao questaoAtual;
    private boolean respondida;
    private int totalDeQuestoes, numeroDaQuestao;
    private int gabarito;
    private int corretas, erradas;

    private CountDownTimer countDownTimer;
    long tempoPassadoEmMillis;


    @RequiresApi(api = Build.VERSION_CODES.N)
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
        cronometro     = findViewById(R.id.Cronometro);
        tempoPassadoEmMillis = START_TIME_IN_MILLIS;

        iniciarCronometro();

        corretas = 0;
        erradas = 0;


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
            telaResultado();
            finish();
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
                corretas++;
            }else{
                buttonResponder.setText("Próxima Questão");
                erradas++;
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

    public void telaResultado(){
        Intent intent = new Intent (MainActivity.this, ResultadoActivity.class);
        String e = Integer.toString(erradas);
        String c = Integer.toString(corretas);
        intent.putExtra("erradas", e);
        intent.putExtra("corretas", c);
        Log.i("Intent: ", " corretas " + corretas + " erradas " + erradas);

        startActivity(intent);
    }

    private void iniciarCronometro(){
        countDownTimer = new CountDownTimer(tempoPassadoEmMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tempoPassadoEmMillis = millisUntilFinished;
                updateCronometro();
            }

            @Override
            public void onFinish() {
                telaResultado();
                finish();
            }
        }.start();
    }

    private void updateCronometro(){
        int minutos= (int) (tempoPassadoEmMillis / 1000) / 60;
        int segundos= (int) (tempoPassadoEmMillis / 1000) % 60;
        String tempo_do_contador = String.format(Locale.getDefault(),"%02d:%02d",  minutos, segundos);
        cronometro.setText(tempo_do_contador);
    }
}