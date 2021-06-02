
package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Servidor {

    public static void main(String[] args) throws IOException{
       System.out.println("Criando Conexão....");
        try {
            Socket conn = new Socket("127.0.0.1", 80);
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();

            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = in.read(dadosBrutos);
            while (qtdBytesLidos >= 0) {
                String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                System.out.println(dadosStr);
                qtdBytesLidos = in.read(dadosBrutos);
            }

        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
    }
}
