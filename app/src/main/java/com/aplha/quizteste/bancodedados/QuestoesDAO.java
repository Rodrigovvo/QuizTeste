package com.aplha.quizteste.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.aplha.quizteste.modelos.Questao;

import java.util.ArrayList;
import java.util.List;

public class QuestoesDAO  {

    SQLiteDatabase leia, escreva;

    public QuestoesDAO(Context context) {
        PerguntasDB database = new PerguntasDB(context);

        leia = database.getReadableDatabase();
        escreva = database.getWritableDatabase();


    }
    public boolean salvarQuestoes (Questao questao){

        ContentValues cv = new ContentValues();
        cv.put("pergunta", questao.getPergunta());
        cv.put("resp1", questao.getResp1());
        cv.put("resp2", questao.getResp2());
        cv.put("resp3", questao.getResp3());
        cv.put("resp4", questao.getResp4());
        cv.put("gabarito", questao.getGabarito());

        try {
            escreva.insert(PerguntasDB.NOME_DA_TABELA_1, null, cv);
            Log.i("DB Salva: ", " Sucesso ao adicionar conteúdo");
        }catch (Exception e){
            e.printStackTrace();
            Log.i("DB Salva: ",  "Erro ao salvar a tabela " + e.getMessage());
            return false;
        }
        return true;
    }

    public List<Questao> listar() {

        List <Questao> listaDeQuestoes = new ArrayList<>();

        String sql = "SELECT * FROM " + PerguntasDB.NOME_DA_TABELA_1 + ";";

        Cursor cursor = leia.rawQuery(sql, null);

        while(cursor.moveToNext()){

            Questao questao = new Questao();

            String pergunta = cursor.getString(cursor.getColumnIndex("pergunta"));
            String resp1 = cursor.getString(cursor.getColumnIndex("resp1"));
            String resp2 = cursor.getString(cursor.getColumnIndex("resp2"));
            String resp3 = cursor.getString(cursor.getColumnIndex("resp3"));
            String resp4 = cursor.getString(cursor.getColumnIndex("resp4"));

            int gabarito = cursor.getInt(cursor.getColumnIndex("gabarito"));
            int id = cursor.getInt(cursor.getColumnIndex("id"));

            questao.setId(id);
            questao.setGabarito(gabarito);
            questao.setPergunta(pergunta);
            questao.setResp1(resp1);
            questao.setResp1(resp2);
            questao.setResp1(resp3);
            questao.setResp1(resp4);


            listaDeQuestoes.add(questao);

        }
        return listaDeQuestoes;
    }

}
