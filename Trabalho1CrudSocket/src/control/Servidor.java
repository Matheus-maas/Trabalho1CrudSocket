package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {

    static String dadosStr = null;

    public static void insertCliente() {

    }
    public static void updateCliente() {

    }
    public static void getCliente() {

    }
    public static void deleteCliente() {

    }
    public static void listCliente() {

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Criando Conexão....");
        try {
            Socket conn = new Socket("127.0.0.1", 80);
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();

            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = in.read(dadosBrutos);
            while (qtdBytesLidos >= 0) {
                dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                System.out.println(dadosStr);
                qtdBytesLidos = in.read(dadosBrutos);
            }

            String tipo1 = "insert";
            String tipo2 = "update";
            String tipo3 = "get";
            String tipo4 = "delete";
            String tipo5 = "list";

            if (dadosStr.toLowerCase().contains(tipo1.toLowerCase())) {
                insertCliente();
            }
            if (dadosStr.toLowerCase().contains(tipo2.toLowerCase())) {
                updateCliente();
            }
            if (dadosStr.toLowerCase().contains(tipo3.toLowerCase())) {
                getCliente();
            }
            if (dadosStr.toLowerCase().contains(tipo4.toLowerCase())) {
                deleteCliente();
            }
            if (dadosStr.toLowerCase().contains(tipo5.toLowerCase())) {
                listCliente();
            }

        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
    }
}
