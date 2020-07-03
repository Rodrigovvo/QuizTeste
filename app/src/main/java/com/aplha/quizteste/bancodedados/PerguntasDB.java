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
                4);
        adicionarQuestoesNaTabela(questao2);
        Questao questao3 = new Questao(
                "A forma de sinalização que se prevalece sobre as demais é:",
                "Do agente de trânsito.",
                "Dos condutores.",
                "Do passageiro de um transporte qualquer.",
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
                "Do comportamento adequado do condutor.",
                "Do trânsito.",
                "Da categoria da CNH.",
                2);
        adicionarQuestoesNaTabela(questao5);
        Questao questao6 = new Questao( "A classificação geral dos veículos é:",
                "Misto, passageiros, carga, tração e coleção.",
                "Tração, espécie e categoria.",
                "Aluguel, aprendizagem, oficial e diplomático.",
                "Automotor, Misto e Particular.",
                2);
        adicionarQuestoesNaTabela(questao6);

        Questao questao7 = new Questao( "Sobre o Seguro Obrigatório DPVAT é correto afirmar:",
                "Indeniza acidentes ocorridos com ao menos um veículo automotor terrestre, em qualquer ponto do país.",
                "Indeniza apenas vítimas fatais.",
                "Indeniza apenas 1 vítima por acidente.",
                "Independente do número de vítimas, o seguro é pago apenas para o proprietário do veículo.",
                1);
        adicionarQuestoesNaTabela(questao7);

        Questao questao8 = new Questao( "É proibido aos condutores:",
                "Ouvir rádio enquanto dirige.",
                "Utilizar o telefone  celular, para envio de mensagens",
                "Parar para dar passagem a veículo precedido de batedores.",
                "Dar setas, para sinalização de conversão.",
                2);
        adicionarQuestoesNaTabela(questao8);

        Questao questao9 = new Questao( "A direção defensiva tem elementos fundamentais que possibilitam ao motorista a prevenção de acidentes. Entre os princípios da direção defensiva, encontra-se:",
                "Respeito ao direito do pedestre apenas na faixa a ele destinada.",
                "Aumento da velocidade do veículo para aproveitar o sinal amarelo.",
                "Guarda de distância de segurança entre o seu veículo e o que segue à sua frente.",
                "Aumento da velocidade do veículo ao entrar numa curva para compensar a força centrípeta.",
                3);
        adicionarQuestoesNaTabela(questao9);

        Questao questao10 = new Questao( "A buzina pode ser utilizada, na seguinte situação:",
                "Em situações de simples toque breve, como advertência afim de evitar acidentes.",
                "Em engarrafamentos.",
                "Em semáforos, após às 24hrs.",
                "Para sinalização a outros motoristas que pararam em fila dupla.",
                1);
        adicionarQuestoesNaTabela(questao10);

        Questao questao11 = new Questao( "Dentre as afirmações abaixo, representa uma situação de direção segura:",
                "Ao se aproximar de um cruzamento, deve-se reduzir a velocidade, apenas se houver sinalização de regulamentação.",
                "Veículos não podem trafegar na calçada, mas podem estacionar sobre ela se houver espaço para a passagem de pedestres.",
                "Os condutores só terão permissão para efetuar uma ultrapassagem pela direita caso não haja passagem pela esquerda.",
                "Caso não haja sinalização de regulamentação em um cruzamento, deve-se dar preferência ao veículo que vier pela esquerda.",
                2);
        adicionarQuestoesNaTabela(questao11);

        Questao questao12 = new Questao( "Em caso de acidente:",
                "Não existe obrigação legal em socorrer.",
                "É obrigação de todos prestar auxílio desde que não corra risco pessoal.",
                "A obrigação de socorrer é apenas de quem causou o acidente.",
                "É obrigação de todos sempre prestar auxílio à vítima.",
                2);
        adicionarQuestoesNaTabela(questao12);

        Questao questao13 = new Questao( "É o gás incolor, sem cheiro ou gosto, resultante da queima incompleta de combustíveis:",
                "O monóxido de carbono.",
                "Os hidrocarbonetos.",
                "Os óxidos de nitrogênio.",
                "O gás de ozônio.",
                1);
        adicionarQuestoesNaTabela(questao13);

        Questao questao14 = new Questao( "A função do silenciador no veículo é:",
                "Criar a centelha necessária para a explosão da mistura de ar e combustível.",
                "Permitir uma partida suave do veículo.",
                "Diminuir os ruídos gerados pelas explosões do carburante no motor.",
                "Reduzir, drasticamente, os níveis de emissão de gases.",
                3);
        adicionarQuestoesNaTabela(questao14);

        Questao questao15 = new Questao( "A parada respiratória é um fato grave, pois sabemos que a pessoa sem respirar pode morrer caso sua respiração não seja restabelecida o mais rápido possível. Qual o procedimento correto ao socorrer uma pessoa cuja respiração parou?",
                "Procurar remover qualquer coisa que esteja obstruindo a boca da vítima.",
                "Inclinar a cabeça da vítima ao máximo para trás para soltar a língua do fundo da garganta.",
                "Utilizar o método boca-a-boca.",
                "Todas as alternativas acima estão corretas.",
                1);
        adicionarQuestoesNaTabela(questao15);

        Questao questao16 = new Questao( "Pode ser considerado um ato ou comportamento INSEGURO na direção defensiva",
                "Manter certa distância do veículo que circula a frente.",
                "Realizar pausas de descanso em viagens longas.",
                "Planejar antecipadamente o trajeto e procurar cumpri-lo.",
                "Responder a buzinas, cumprimentos ou atos obscenos de outros motoristas.",
                4);
        adicionarQuestoesNaTabela(questao16);

        Questao questao17 = new Questao( "Ao acionar a chave de ignição e o motor do veículo não dar sinal de partida, o defeito pode ser:",
                "Na bateria ou motor de arranque.",
                "Falta de combustível.",
                "Entupimento no carburador.",
                "Falta de água no radiador.",
                1);
        adicionarQuestoesNaTabela(questao17);

        Questao questao18 = new Questao( "Pode-se afirmar que a \"aquaplanagem\" ou \"hidroplanagem\", muito discutida em Direção Defensiva é:",
                "A forma correta de dirigir, aumentando a velocidade.",
                "A falta de estabilidade quando a pista está muito seca.",
                "A falta de contato do pneu com o solo, em dia de chuva",
                "O aumento de contato do pneu com o solo, quando a velocidade aumenta.",
                3);
        adicionarQuestoesNaTabela(questao18);

        Questao questao19 = new Questao( "Estamos em constante interrelacionamento no trânsito. Nessa situação:",
                "Respeitar as normas e os códigos estabelecidos, conforme o caso.",
                "Compreender perfeitamente os erros dos outros",
                "Devemos agir com responsabilidade e respeito às normas e às pessoas",
                "Agir agressivamente",
                3);
        adicionarQuestoesNaTabela(questao19);

        Questao questao20 = new Questao( "São distúrbios provocados aos seres humanos causados pela exposição em excesso ao ruído: ",
                "Irritabilidade e agressividade.",
                "Deficiência auditiva.",
                "Insônia, agitação e dispersão.",
                "Para sinalização a outros motoristas que pararam em fila dupla.",
                1);
        adicionarQuestoesNaTabela(questao20);

        Questao questao21 = new Questao("Quatro passageiros estão no interior do carro e os cabos elétricos rompidos de um poste estão sobre a parte externa do veículo. Nesta situação, o procedimento indicado é:",
                "Retirar os passageiros após afastar os cabos com um cano de ferro.",
                "Orientar os passageiros para que permaneçam no interior do carro, aguardando o resgate.",
                "Retirar os cabos, enquanto se aguarda o resgate.",
                "Solicitar ajuda para a retirada dos passageiros, sem provocar a movimentação do carro.",
                2);
        adicionarQuestoesNaTabela(questao21);

        Questao questao22 = new Questao("O condutor de veículo que estiver habilitado na categoria 'B' , poderá dirigir inicialmente:",
                "Veículos motorizados, que não excedam a 8 lugares, sem contar o condutor e que não ultrapasse a 3.500 quilos de peso bruto total (PTB).",
                "Veículos motorizados, de 2 ou 3 rodas, com ou sem carro lateral.",
                "Veículos motorizados, cuja unidade tratora se enquadre nas categorias.",
                "Veículos motorizados, para transporte de carga, que exceda a 3.500 quilogramas de peso bruto total (PTB).",
                2);
        adicionarQuestoesNaTabela(questao22);

        Questao questao23 = new Questao("Para habilitar-se na categoria “E”, o condutor deverá possuir no mínimo:",
                "3 anos na categoria \"B\" ou 2 anos na categoria \"C\".",
                "2 anos na categoria \"C\".",
                "1 ano na categoria \"C\" ou 1 ano na categoria \"D\".",
                "2 anos na categoria \"D\".",
                3);
        adicionarQuestoesNaTabela(questao23);

        Questao questao24 = new Questao( "Em caso de morte, o seguro DPVAT cobre o valor de:",
                "R$2.500,00.",
                "R$11.500,00.",
                "R$13.500,00.",
                "R$5.000,00.",
                3);
        adicionarQuestoesNaTabela(questao24);

        Questao questao25 = new Questao( "É competência da JARI:",
                "Cumprir e fazer cumprir a legislação de trânsito e a execução das normas e diretrizes estabelecidas pelo CONTRAN, no âmbito de suas atribuições.",
                "Julgar os recursos interpostos pelos infratores.",
                "Administrar fundo de âmbito Nacional destinado à segurança e educação de trânsito.",
                "Coletar dados, elaborar estudos sobre acidentes de trânsito e suas causas.",
                2);
        adicionarQuestoesNaTabela(questao25);

        Questao questao26 = new Questao( "Deixar de guardar distância de segurança lateral e frontal entre o seu veículo e os demais, bem como em relação ao bordo da pista, considerando-se, no momento, a velocidade, as condições climáticas do local da circulação e do veículo é infração:",
                "Gravíssima.",
                "Grave.",
                "Média.",
                "Leve.",
                2);
        adicionarQuestoesNaTabela(questao26);

        Questao questao27 = new Questao( "O condutor que trafegar pela contramão em via de sentido único, comete uma infração:",
                "Leve.",
                "Média.",
                "Grave.",
                "Gravíssima.",
                4);
        adicionarQuestoesNaTabela(questao27);

        Questao questao28 = new Questao( "Deixar o condutor, envolvido em acidente sem vítima, de adotar providências para remover o veículo do local, quando necessária tal medida para assegurar a segurança e a fluidez do trânsito:",
                "É infração de trânsito de natureza leve com remoção do veículo.",
                "É falta de bom senso.",
                "É infração de trânsito de natureza média.",
                "É necessário até a chegada de perícia.",
                3);
        adicionarQuestoesNaTabela(questao28);

        Questao questao29 = new Questao( "Qual das alternativas corresponde a uma infração de natureza LEVE?",
                "Dirigir sem atenção ou sem os cuidados indispensáveis à segurança.",
                "Veículo que não estiver devidamente licenciado ou registrado.",
                "Transportar carga, arrastando-a.",
                "Tiver falsificado os selos da placa.",
                1);
        adicionarQuestoesNaTabela(questao29);

        Questao questao30 = new Questao( "Um condutor de ônibus foi flagrado trafegando em uma rodovia não sinalizada a 136 km/h. Qual a punição será aplicada?",
                "Infração grave e suspensão do direito de dirigir.",
                "Infração gravíssima com multa agravada (3x) e suspensão.",
                "Infração grave e apreensão do veículo.",
                "Infração gravíssima e cassação da CNH.",
                2);
        adicionarQuestoesNaTabela(questao30);

        Questao questao31 = new Questao( "Dispositivo de reflexão e refração da luz utilizado na sinalização de vias e veículos denomina-se: ",
                "Indicadores luminosos.",
                "Tachão de asfalto.",
                "Catadióptrico.",
                "Tartaruga.",
                3);
        adicionarQuestoesNaTabela(questao31);

        Questao questao32 = new Questao( "A sinalização através de inscrições no solo serve para:",
                "Regulamentar as vias preferenciais.",
                "Reduzir os perigos existentes na via.",
                "Indicar cruzamento com vias locais.",
                "Melhorar a percepção do condutor quanto às condições de operação da via.",
                4);
        adicionarQuestoesNaTabela(questao32);

        Questao questao33 = new Questao( "Dirigir veículos sem usar lentes corretoras de visão, impostas por ocasião da concessão ou da renovação da licença para conduzir veículos, constitui uma infração de natureza:",
                "Leve.",
                "Média.",
                "Grave.",
                "Gravíssima.",
                4);
        adicionarQuestoesNaTabela(questao33);

        Questao questao34 = new Questao( "O órgão máximo executivo do SNT é o:",
                "DETRAN.",
                "CIRETRAN.",
                "DENATRAN.",
                "CONTRAN.",
                3);
        adicionarQuestoesNaTabela(questao34);

        Questao questao35 = new Questao( "Um silvo longo significa:",
                "Pare.",
                "Diminua a marcha.",
                "Acenda as lanternas.",
                "Trânsito impedido em todas as direções.",
                2);
        adicionarQuestoesNaTabela(questao35);

        Questao questao36 = new Questao( "A permissão para dirigir tem validade de:",
                "1 ano.",
                "2 anos.",
                "5 anos.",
                "10 anos.",
                1);
        adicionarQuestoesNaTabela(questao36);

        Questao questao37 = new Questao( "Que peça é responsável pela pressão na linha de alimentação?",
                "Bomba de combustível.",
                "Radiador.",
                "Central eletrônica.",
                "Câmbio.",
                1);
        adicionarQuestoesNaTabela(questao37);

        Questao questao38 = new Questao( "São atitudes seguras de um condutor de motocicleta e que cumprem o que determina o Código de Trânsito Brasileiro (CTB), EXCETO:",
                "Respeitar os limites de velocidade fixados para a via.",
                "Realizar ultrapassagens tanto pela esquerda quanto pela direita.",
                "Não transportar criança menor de 7 anos de idade.",
                "Manter o farol aceso quando em circulação, indepentemente, se for dia ou noite.",
                2);
        adicionarQuestoesNaTabela(questao38);

        Questao questao39 = new Questao( "O Código de Trânsito Brasileiro - CTB, rege:",
                "O trânsito de qualquer natureza nas vias terrestres do território nacional, abertas ou não à circulação.",
                "O trânsito de qualquer meio de transporte terrestre ou aquaviário.",
                "O trânsito de qualquer natureza nas vias terrestres do território nacional, abertas à circulação.",
                "O trânsito de pessoas e veículos nas vias terrestres do território nacional, abertas ou não à circulação.",
                3);
        adicionarQuestoesNaTabela(questao39);

        Questao questao40 = new Questao( "Nas rodovias, excetuando-se automóveis, caminhonetas, ônibus e micro-ônibus, a velocidade máxima permitida para dos demais veículos é de:",
                "120 Km/h.",
                "100 Km/h.",
                "90 Km/h.",
                "80 Km/h.",
                4);
        adicionarQuestoesNaTabela(questao40);

        Questao questao41 = new Questao( "O condutor envolvido em acidente com vítima que deixar de prestar socorro ou providenciar socorro, podendo fazê-lo, estará incorrendo em uma infração gravíssima e será punido com a seguinte medida administrativa:",
                "Recolhimento do documento de habilitação.",
                "Retenção do veículo.",
                "Recolhimento do certificado de registro.",
                "Remoção do veículo.",
                1);
        adicionarQuestoesNaTabela(questao41);
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
