package com.aplha.quizteste.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

import com.aplha.quizteste.modelos.Questao;

import java.util.ArrayList;
import java.util.List;

public class PerguntasDB extends SQLiteOpenHelper {

    public static final String NOME_DA_TABELA_1 = "perguntas";
    public static final String NOME_DO_BANCO_DE_DADOS_ = "quizdb";
    public static final int VERSION_ = 1;
    private SQLiteDatabase database;

    public PerguntasDB(@Nullable Context context) {
        super(context, NOME_DO_BANCO_DE_DADOS_, null, VERSION_);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.database = db;
        String tabela_sql = "CREATE TABLE IF NOT EXISTS " + NOME_DA_TABELA_1 + " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " pergunta TEXT," +
                " resp1 TEXT," +
                " resp2 TEXT," +
                " resp3 TEXT," +
                " resp4 TEXT, " +
                " gabarito INT(1) )";

            db.execSQL(tabela_sql);
            Log.i("INFO Basededados: ", "Tabela criada " + db);

            iniciarQuestões();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + NOME_DA_TABELA_1);
        onCreate(db);

    }



    public void iniciarQuestões() {

        Questao questao1 = new Questao(
                "Os sinais de trânsito podem ser caracterizados por: placas, desenhos pintados nas vias, e também:",
                "Sinais luminosos, sonoros ou gestos",
                "Apenas sinais luminosos.",
                "Sinais luminosos e gestos.",
                "Apenas gestos.",
                3);
        adicionarQuestoesNaTabela(questao1);

        Questao questao2 = new Questao(
                "O objetivo principal da sinalização de trânsito é informar sobre:",
                "Apenas sobre as obrigações do trânsito.",
                "A ausência da fiscalização de trânsito.",
                "A proibição de cometer atos imprudentes.",
                "As condições, restrições, obrigações e proibições de uso de uma certa via.",
                2);
        adicionarQuestoesNaTabela(questao2);
        Questao questao3 = new Questao(
                "A forma de sinalização que se prevalece sobre as demais é:",
                "Dos condutores.",
                "Do passageiro de um transporte qualquer.",
                "Do agente de trânsito.",
                "Dos semáforos e sinais luminosos.",
                1);
        adicionarQuestoesNaTabela(questao3);
        Questao questao4 = new Questao( "O melhor local do corpo para se verificar a pulsação de vítima adulta inconsciente é:",
                "A perna.",
                "O pescoço.",
                "O peito.",
                "O pulso.",
                4);
        adicionarQuestoesNaTabela(questao4);
        Questao questao5 = new Questao( "A segurança na direção de um veículo no trânsito depende:",
                "Dos pedestres.",
                "Da marca do veículo.",
                "Do trânsito.",
                "Da categoria da CNH.",
                4);
        adicionarQuestoesNaTabela(questao5);

    }


    public void adicionarQuestoesNaTabela(Questao questao){
        ContentValues contentValues = new ContentValues();

       // database = getWritableDatabase();


        contentValues.put("pergunta", questao.getPergunta());
        contentValues.put("resp1", questao.getResp1());
        contentValues.put("resp2", questao.getResp2());
        contentValues.put("resp3", questao.getResp3());
        contentValues.put("resp4", questao.getResp4());
        contentValues.put("gabarito", questao.getGabarito());

        database.insert(NOME_DA_TABELA_1, null, contentValues);
    }


    public List<Questao> listar() {

        List <Questao> listaDeQuestoes = new ArrayList<>();

        //database = getReadableDatabase();
        database = getReadableDatabase();

        String sql = "SELECT * FROM " + NOME_DA_TABELA_1;

        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.moveToFirst()){
            do{
                Questao questao = new Questao();
                String pergunta = cursor.getString(cursor.getColumnIndex("pergunta"));
                String resp1 = cursor.getString(cursor.getColumnIndex("resp1"));
                String resp2 = cursor.getString(cursor.getColumnIndex("resp2"));
                String resp3 = cursor.getString(cursor.getColumnIndex("resp3"));
                String resp4 = cursor.getString(cursor.getColumnIndex("resp4"));
                int gabarito = cursor.getInt(cursor.getColumnIndex("gabarito"));

                questao.setGabarito(gabarito);
                questao.setPergunta(pergunta);
                questao.setResp1(resp1);
                questao.setResp2(resp2);
                questao.setResp3(resp3);
                questao.setResp4(resp4);

                listaDeQuestoes.add(questao);

            }while (cursor.moveToNext());

        }
        cursor.close();
        return listaDeQuestoes;
    }



}
