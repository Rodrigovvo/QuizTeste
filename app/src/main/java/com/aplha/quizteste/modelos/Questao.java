package com.aplha.quizteste.modelos;

import java.io.Serializable;

public class Questao implements Serializable {
    // pergunta TEXT, resp1 TEXT, resp2 TEXT, resp3 TEXT, resp4 TEXT, " +
    //                 " gabarito INT(1)
    private String pergunta, resp1, resp2, resp3, resp4;
    private int gabarito;

    public Questao() {
    }

    public Questao( String pergunta, String resp1, String resp2, String resp3, String resp4, int gabarito) {

        this.pergunta = pergunta;
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
        this.resp4 = resp4;
        this.gabarito = gabarito;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResp1() {
        return resp1;
    }

    public void setResp1(String resp1) {
        this.resp1 = resp1;
    }

    public String getResp2() {
        return resp2;
    }

    public void setResp2(String resp2) {
        this.resp2 = resp2;
    }

    public String getResp3() {
        return resp3;
    }

    public void setResp3(String resp3) {
        this.resp3 = resp3;
    }

    public String getResp4() {
        return resp4;
    }

    public void setResp4(String resp4) {
        this.resp4 = resp4;
    }

    public int getGabarito() {
        return gabarito;
    }

    public void setGabarito(int gabarito) {
        this.gabarito = gabarito;
    }
}
