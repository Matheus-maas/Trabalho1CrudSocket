package control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import model.Pessoa;

public class Cliente {

    static String opcao=null;
    static Scanner entrada = new Scanner(System.in);
    
    public static void Insert(){
        Pessoa p= new Pessoa();
        
                    System.out.println("Digite o CPF:");
                    p.setCpf(entrada.next());
                    System.out.println("Digite o Nome:");
                    p.setNome(entrada.nextLine());
                    p.setNome(entrada.nextLine());
                    System.out.println("Digite o Endereço:");
                    p.setEndereco(entrada.nextLine());
                    System.out.println(p.toString());
    }
    
    public static void exibirMenu() throws IOException {
        Conexao c= new Conexao();

        String aux = "";
        while (!aux.equalsIgnoreCase("sair")) {
            System.out.println("\n\n");
            System.out.println("+-------------------------------------------+");
            System.out.println("|        Menu de Operações                  |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| INSERT                                    |");
            System.out.println("| UPDATE                                    |");
            System.out.println("| GET                                       |");
            System.out.println("| DELETE                                    |");
            System.out.println("| LIST                                      |");
            System.out.println("| SAIR                                      |");
            System.out.println("+-------------------------------------------+");
            System.out.print("Opção escolhida: ");
            opcao = entrada.next();
            aux = opcao;
            switch (opcao) {
                case "sair":
                case "SAIR":
                    break;
                case "insert":
                case "INSERT":
                    Insert();
                    c.mandarMensagem();
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
                    System.out.println("vamos buscar uma pessoa");
                    break;
                default:
                    System.out.println("+-------------------------------------------+");
                    System.out.println("|        Operação inválida                  |");
                    System.out.println("+-------------------------------------------+");
                    
            }

        }

        System.out.println("Programa Finalizado...");
    }
    

    public static void main(String[] args) throws IOException {

        exibirMenu();
        
        
    }

}
