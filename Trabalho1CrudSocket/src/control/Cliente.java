package control;

import java.io.IOException;
import java.util.Scanner;
import model.Pessoa;

public class Cliente {

    static String opcao = null;
    static Scanner entrada = new Scanner(System.in);
    
    public static void insert(Pessoa p){
         System.out.println("Vamos inserir uma pessoa");
         System.out.println("Digite o CPF:");
         p.setCpf(entrada.next());
         System.out.println("Digite o Nome:");
         p.setNome(entrada.next());
         System.out.println("Digite o Endereço:");
         p.setEndereco(entrada.next());
    }
    
    public static String update(){
        System.out.println("Qual o CPF da Pessoa?");
        String cpf=entrada.next();
        System.out.println("Digite o novo Nome: ");
        String nome=entrada.next();
        System.out.println("Digite o novo Endereço: ");
        String endereco=entrada.next();
        return cpf+nome+endereco;
    }
    
    public static String get(){
        System.out.println("Vamos buscar uma Pessoa pelo CPF: ");
        String cpf=entrada.next();
        return cpf;
    }
    
    public static void List(Pessoa p) {
        
        p.setCpf(null);
        p.setNome(null);
        p.setEndereco(null);
        
    }

    public static void exibirMenu() throws IOException {
       
        Conexao c = new Conexao();
        Pessoa p = new Pessoa();
        
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
                    insert(p);
                    c.mandarMensagem(p);
                    break;
                case "update":
                case "UPDATE":
                    System.out.println("Vamos atualizar uma pessoa");
                    c.mandarMensagemString(update());
                    break;
                case "get":
                case "GET":
                    c.mandarMensagemString(get());
                    break;
                case "delete":
                case "DELETE":
                    System.out.println("vamos deletar uma pessoa");
                    break;
                case "list":
                case "LIST":
                 c.mandarMensagem(p);
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
