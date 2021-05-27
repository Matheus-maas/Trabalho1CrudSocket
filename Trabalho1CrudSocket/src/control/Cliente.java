
package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {
    
    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("QUAL OPERAÇÃO DESEJA REALIZAR?");
        System.out.println("INSERT");
        System.out.println("UPDATE");
        System.out.println("GET");
        System.out.println("DELETE");
        System.out.println("LIST");
        String opcao= entrada.next();
        
        switch(opcao){
            case "insert":
            case "INSERT":
                System.out.println("vamos inserir uma pessoa");
                break;
            case "update":
            case "UPDATE":
                System.out.println("vamos atualizar uma pessoa");
                break;
            case "get":
            case "GET":
                System.out.println("vamos buscar uma pessoa");
                break;
            case "delete":
            case "DELETE":
                System.out.println("vamos deletar uma pessoa");
                break;
            case "list":
            case "LIST":
                System.out.println("vamos bsucar uma lista de pessoas");
                break;
            default:
                System.out.println("Opção inválida");
        }
}

    public static void main(String[] args) throws IOException{
        
        menu();
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
