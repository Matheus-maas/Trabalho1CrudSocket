package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import model.Pessoa;

public class Servidor {

    static String dadosStr = null;
    static String tipo1 = "insert";
    static String tipo2 = "update";
    static String tipo3 = "get";
    static String tipo4 = "delete";
    static String tipo5 = "list";

    static ArrayList<Pessoa> pessoasServidor = new ArrayList<>();
    static Conexao c = new Conexao();
    static Pessoa p = new Pessoa();

    public static void inserir(String dados) {
        p.setCpf((String) dados.subSequence(6, 17));
        p.setNome((String) dados.subSequence(17, 116));
        p.setEndereco((String) dados.subSequence(117, 215));
        pessoasServidor.add(p);
    }

    public static void update(String dados) {
        String cpf = ((String) dados.subSequence(6, 17));
        for (int i = 0; i < pessoasServidor.size(); i++) {
            if (pessoasServidor.get(i).getCpf().equalsIgnoreCase(cpf)) {
                pessoasServidor.get(i).setCpf(cpf);
                pessoasServidor.get(i).setNome(((String) dados.subSequence(17, 116)));
                pessoasServidor.get(i).setEndereco(((String) dados.subSequence(117, 215)));
                System.out.println("Pessoa alterada com sucesso.");
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        }
    }

    public static void get(String dados) {
        String cpf = ((String) dados.subSequence(6, 17));

        for (int i = 0; i < pessoasServidor.size(); i++) {
            if (pessoasServidor.get(i).getCpf().equalsIgnoreCase(cpf)) {
                System.out.println(pessoasServidor.get(i).getNome() + ";" + pessoasServidor.get(i).getEndereco());
            }
        }
    }

    public static void delete(String dados) {
        String cpf = ((String) dados.subSequence(6, 17));

        for (int i = 0; i < pessoasServidor.size(); i++) {
            if (pessoasServidor.get(i).getCpf().equalsIgnoreCase(cpf)) {
                pessoasServidor.remove(pessoasServidor.get(i));
                System.out.println("Pessoa excluída com sucesso.");
            } else {
                System.out.println("Pessoa não encontrada.");
            }
        }
    }

    public static void list(String dados) {

        for (int i = 0; i < pessoasServidor.size(); i++) {
            Pessoa auxiliar = pessoasServidor.get(i);
            System.out.println("CPF: " + auxiliar.getCpf() + ";" + "NOME: " + auxiliar.getNome() + ";" + "ENDEREÇO: " + auxiliar.getEndereco());
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
                    for (int i = 0; i < pessoasServidor.size(); i++) {
                        Pessoa auxiliar = pessoasServidor.get(i);
                        System.out.println("CPF: " + auxiliar.getCpf() + "\n" + "NOME: " + auxiliar.getNome() + "\n" + "ENDEREÇO: " + auxiliar.getEndereco());
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
