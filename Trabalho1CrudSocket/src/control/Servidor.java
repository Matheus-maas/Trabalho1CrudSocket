
package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Servidor {
   
    static String dadosStr=null; 
    static ArrayList<String> dadosPessoas = new ArrayList<>();
    
    public static void inserir(String dados){
        dadosPessoas.add(dados);
    
    }
    
    public static void mostrarDados() throws IOException{
        Conexao c=new Conexao();
        String auxiliar=null;
        for(int i =0; i< dadosPessoas.size(); i++){
        auxiliar=auxiliar+dadosPessoas.get(i);
        System.out.println(auxiliar);
        c.enviarDados(auxiliar);
         }
            
    }

    public static void main(String[] args) throws IOException{
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
                inserir(dadosStr);
            }

        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
    }
}
