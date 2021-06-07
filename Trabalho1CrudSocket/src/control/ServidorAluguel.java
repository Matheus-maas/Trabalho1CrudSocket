/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import model.AluguelCarro;

/**
 *
 * @author Dell
 */
public class ServidorAluguel {

    static String dadosStr = null;
    static String tipo1 = "insert";
    static String tipo2 = "update";
    static String tipo3 = "get";
    static String tipo4 = "delete";
    static String tipo5 = "list";

    static ArrayList<AluguelCarro> alugueisServidor = new ArrayList<>();
    static Conexao c = new Conexao();
    static AluguelCarro a = new AluguelCarro();

    public static void inserir(String dados) {
        //  a.setPreco((String) dados.subSequence(6, 17));
        a.setDataAluguel((String) dados.subSequence(17, 116));
        a.setDataVencimento((String) dados.subSequence(117, 215));
        alugueisServidor.add(a);
    }

    public static void update(String dados) {
        /*   
        String p = ((String) dados.subSequence(6, 17));
        for (int i = 0; i < alugueisServidor.size(); i++) {
            if (alugueisServidor.get(i).getP()==p)) {
                //alugueisServidor.get(i).setPreco();
                alugueisServidor.get(i).setDataAluguel(((String) dados.subSequence(17, 116)));
                alugueisServidor.get(i).setDataVencimento(((String) dados.subSequence(117, 215)));
                System.out.println("Pessoa alterada com sucesso.");
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        }
         */
    }

    public static void get(String dados) {
//        String p = ((String) dados.subSequence(6, 17));
//
//        for (int i = 0; i < alugueisServidor.size(); i++) {
//            if (alugueisServidor.get(i).getP().equalsIgnoreCase(p)) {
//                System.out.println(alugueisServidor.get(i).getP()+ ";" + alugueisServidor.get(i).getPreco()+
//                 ";" +alugueisServidor.get(i).getDataAluguel()+ ";" +alugueisServidor.get(i).getDataVencimento());
//            }
//        }
    }

    public static void delete(String dados) {
//        String p = ((String) dados.subSequence(6, 17));
//
//        for (int i = 0; i < alugueisServidor.size(); i++) {
//            if (alugueisServidor.get(i).getP().equalsIgnoreCase(p)) {
//                alugueisServidor.remove(alugueisServidor.get(i));
//                System.out.println("Aluguel excluída com sucesso.");
//            } else {
//                System.out.println("Aluguel não encontrada.");
//            }
//        }
    }

    public static void list(String dados) {
        for (int i = 0; i < alugueisServidor.size(); i++) {
            AluguelCarro auxiliar = alugueisServidor.get(i);
            System.out.println("CPF: " + auxiliar.getP() + ";" + "PREÇO: " + auxiliar.getPreco() + ";" + "ALUGUEL: " + auxiliar.getDataAluguel() + ";"
                    + "VENCIMENTO: " + auxiliar.getDataVencimento());
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Criando Conexão....");
        try {
            Socket conn = new Socket("127.0.0.1", 80);
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();

            byte[] dadosBrutos = new byte[217];
            int qtdBytesLidos = in.read(dadosBrutos);
            while (qtdBytesLidos >= 0) {
                dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                qtdBytesLidos = in.read(dadosBrutos);

                if (dadosStr.toLowerCase().contains(tipo1.toLowerCase())) {
                    inserir(dadosStr);
                    for (int i = 0; i < alugueisServidor.size(); i++) {
                        AluguelCarro auxiliar = alugueisServidor.get(i);
                        System.out.println("CPF: " + auxiliar.getP() + ";" + "PREÇO: " + auxiliar.getPreco() + ";" + "ALUGUEL: " + auxiliar.getDataAluguel() + ";"
                                + "VENCIMENTO: " + auxiliar.getDataVencimento());
                    }

                }

                if (dadosStr.toLowerCase().contains(tipo2.toLowerCase())) {
                    update(dadosStr);
                    c.enviaRetornoCliente(dadosStr);
                }
                if (dadosStr.toLowerCase().contains(tipo3.toLowerCase())) {
                    get(dadosStr);
                }
                if (dadosStr.toLowerCase().contains(tipo4.toLowerCase())) {
                    delete(dadosStr);
                    c.enviaRetornoCliente(dadosStr);
                }
                if (dadosStr.toLowerCase().contains(tipo5.toLowerCase())) {
                    list(dadosStr);
                }

            }
        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
    }
}
