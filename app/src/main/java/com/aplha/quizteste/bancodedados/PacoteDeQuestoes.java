package com.aplha.quizteste.bancodedados;

import com.aplha.quizteste.modelos.Questao;

import java.util.ArrayList;

public class PacoteDeQuestoes {

    public static ArrayList<Questao> simuladoUm(){

        ArrayList <Questao> questoesSimuladoUm = new ArrayList<>();

        Questao questao1 = new Questao(1, "pergunta 1", "reposta A ", "resposta B", " resposta C",
                "resposta D", 2 );
        questoesSimuladoUm.add(questao1);


        Questao questao2 = new Questao(1, "pergunta 2", "reposta A ", "resposta B", " resposta C",
                "resposta D", 1 );
        questoesSimuladoUm.add(questao2);

        Questao questao3 = new Questao(1, "pergunta 3", "reposta A ", "resposta B", " resposta C",
                "resposta D", 1 );
        questoesSimuladoUm.add(questao3);

        return questoesSimuladoUm;
    }
}
