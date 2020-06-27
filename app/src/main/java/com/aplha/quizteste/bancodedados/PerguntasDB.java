package com.aplha.quizteste.bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

public class PerguntasDB extends SQLiteOpenHelper {

    public static final String NOME_DA_TABELA_1 = "perguntas";
    public static final String NOME_DO_BANCO_DE_DADOS_ = "QUIZDB";
    public static final int VERSION_ = 1;



    public PerguntasDB(@Nullable Context context) {
        super(context, NOME_DO_BANCO_DE_DADOS_, null, VERSION_);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String tabela_sql = "CREATE TABLE IF NOT EXISTS " + NOME_DA_TABELA_1 + " ( id INTEGER PRIMARY KEY, " +
                 " pergunta TEXT, resp1 TEXT, resp2 TEXT, resp3 TEXT, resp4 TEXT, " +
                 " gabarito INT(1) );";

        try {
            db.execSQL(tabela_sql);
            Log.i("INFO Basededados: ", "Tabela criada " + db);
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao iniciar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
