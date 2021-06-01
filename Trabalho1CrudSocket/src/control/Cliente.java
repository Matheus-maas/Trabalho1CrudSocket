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

    public static void exibirMenu() {
        String cpf = null;
        String nome = null;
        String endereco = null;

        Scanner entrada = new Scanner(System.in);
        String aux = "";
        String opcao = null;
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
            opcao = entrada.nextLine();
            aux = opcao;
            switch (opcao) {
                case "sair":
                case "SAIR":
                    break;
                case "insert":
                case "INSERT":
                    System.out.println("Digite o CPF:");
                    cpf = entrada.next();
                    System.out.println("Digite o Nome:");
                    nome = entrada.next();
                    System.out.println("Digite o Endereço:");
                    endereco = entrada.next();
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
                    System.out.println(cpf + "\n" + nome + "\n" + endereco);
                    break;
                default:
                    System.out.println("Operação inválida");
            }

        }

        System.out.println("Programa Finalizado...");
    }

    public static void main(String[] args) throws IOException {

        exibirMenu();

        ServerSocket server = new ServerSocket(90);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("Aguardando a conexão...");
            try (Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                Pessoa p = new Pessoa();
                p.getNome();
                p.getCpf();
                p.getEndereco();

                String msg = p.getNome() + ";" + p.getCpf() + ";" + p.getEndereco();
                out.write(msg.getBytes());

            }
        }

    }

}
