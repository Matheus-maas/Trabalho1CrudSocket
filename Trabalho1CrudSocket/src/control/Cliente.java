package control;

import java.io.IOException;
import java.util.Scanner;
import model.AluguelCarro;
import model.Pessoa;

public class Cliente {

    static String opcao = null;
    static int opcaoMenu;
    static Scanner entrada = new Scanner(System.in);

    public static void insertPessoa(Pessoa p) {
        System.out.println("Vamos inserir uma pessoa");
        System.out.println("Digite o CPF:");
        p.setCpf(entrada.next());
        System.out.println("Digite o Nome:");
        p.setNome(entrada.next());
        System.out.println("Digite o Endereço:");
        p.setEndereco(entrada.next());
    }

    public static String updatePessoa() {
        System.out.println("Qual o CPF da Pessoa?");
        String cpf = entrada.next();
        System.out.println("Digite o novo Nome: ");
        String nome = entrada.next();
        System.out.println("Digite o novo Endereço: ");
        String endereco = entrada.next();
        return cpf + nome + endereco;
    }

    public static String getPessoa() {
        System.out.println("Vamos buscar uma Pessoa pelo CPF: ");
        String cpf = entrada.next();
        return cpf;
    }

    public static void ListPessoa(Pessoa p) {

        p.setCpf(null);
        p.setNome(null);
        p.setEndereco(null);

    }

    public static void insertAluguel(AluguelCarro a) {
        System.out.println("Vamos inserir um aluguel");
        System.out.println("Digite o Preço:");
        a.setPreco(entrada.nextDouble());
        System.out.println("Digite a Data do aluguel:");
        a.setDataAluguel(entrada.next());
        System.out.println("Digite a Data de vencimento do aluguel:");
        a.setDataVencimento(entrada.next());
    }

    public static void updateAluguel(AluguelCarro a) {
        System.out.println("Digite o Preço:");
        a.setPreco(entrada.nextDouble());
        System.out.println("Digite a Data do aluguel:");
        a.setDataAluguel(entrada.next());
        System.out.println("Digite a Data de vencimento do aluguel:");
        a.setDataVencimento(entrada.next());
    }

    public static String getAluguel() {
        System.out.println("Vamos buscar um Aluguel pelo CPF da pessoa: ");
        String cpf = entrada.next();
        return cpf;
    }

    public static void ListAluguel(AluguelCarro a) {

        a.setPreco(null);
        a.setDataVencimento(null);
        a.setDataAluguel(null);

    }

    public static void exibirMenu() throws IOException {

        Conexao c = new Conexao();
        Pessoa p = new Pessoa();
        AluguelCarro a = new AluguelCarro();

        System.out.println("+-------------------------------------------+");
        System.out.println("|        Sistema de Locação de carro        |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 1- Menu cliente                           |");
        System.out.println("| 2- Menu de aluguel de carro               |");
        System.out.println("+-------------------------------------------+");
        System.out.print("Opção escolhida: ");
        opcaoMenu = entrada.nextInt();

        if (opcaoMenu == 1) {

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
                        insertPessoa(p);
                        c.mandarMensagem(p);
                        break;
                    case "update":
                    case "UPDATE":
                        System.out.println("Vamos atualizar uma pessoa");
                       // c.mandarMensagemString(updatePessoa());
                        break;
                    case "get":
                    case "GET":
                       // getPessoa(p);
                        //c.mandarMensagemString(getPessoa());
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
        if (opcaoMenu == 2) {
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
                        insertAluguel(a);
                        c.mandarMensagem(p);
                        break;
                    case "update":
                    case "UPDATE":
                        System.out.println("Vamos atualizar uma pessoa");
                        updateAluguel(a);
                        break;
                    case "get":
                    case "GET":
                       // c.mandarMensagemString(getAluguel());
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
        } else {
            System.out.println("Valor incorreto!");
        }
    }

    public static void main(String[] args) throws IOException {

        exibirMenu();

    }

}
