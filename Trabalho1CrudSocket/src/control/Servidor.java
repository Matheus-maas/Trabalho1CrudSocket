
package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import model.Pessoa;


public class Servidor {
   
    static String dadosStr=null; 
    static ArrayList<Pessoa> pessoasServidor = new ArrayList<>();
    
    public static void inserir(String dados){
        Pessoa p=new Pessoa();
        p.setCpf((String) dados.subSequence(6, 16));
        p.setNome((String) dados.subSequence(17, 116));
        p.setEndereco((String) dados.subSequence(117, 215));
        pessoasServidor.add(p);
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
                for(int i =0; i< pessoasServidor.size(); i++){
                        Pessoa auxiliar=pessoasServidor.get(i);
                        System.out.println(auxiliar.getCpf()+";\n"+auxiliar.getNome()+";\n"+auxiliar.getEndereco());
            }

        }
        }catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
    }
}
