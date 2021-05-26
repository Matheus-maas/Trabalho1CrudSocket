
package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) throws IOException{
        //criando conexão
       System.out.println("Criando Conexão....");
        try  {
            Socket conn = new Socket("0.tcp.ngrok.io",13947);
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();
            
            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = in.read(dadosBrutos);
            while (qtdBytesLidos >= 0){
                String dadosStr = new String (dadosBrutos, 0, qtdBytesLidos);
                System.out.println(dadosStr);
                qtdBytesLidos = in.read(dadosBrutos);
            }
            
        } catch (UnknownHostException e) {
            System.out.println("Host não encotnrado");
            e.printStackTrace();
        }
    }
    
}
