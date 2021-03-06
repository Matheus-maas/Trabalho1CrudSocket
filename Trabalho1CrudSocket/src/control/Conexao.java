package control;

import static control.Cliente.opcao;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import model.Pessoa;

public class Conexao {

    public void mandarMensagem(Pessoa p) throws IOException {

        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        if (true) {
            System.out.println("Aguardando a conexão...");
            try ( Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                String tipo = opcao;
                String nome = p.getNome();
                String cpf = p.getCpf();
                String endereco = p.getEndereco();

                int tipoTamanho = 6 - tipo.length();
                int cpfTamanho = 11 - cpf.length();
                int nomeTamanho = 100 - nome.length();
                int enderecoTamanho = 100 - endereco.length();

                for (int i = 0; i < tipoTamanho; i++) {
                    tipo += " ";
                }

                for (int i = 0; i < cpfTamanho; i++) {
                    cpf += " ";
                }
                for (int i = 0; i < nomeTamanho; i++) {
                    nome += " ";
                }

                for (int i = 0; i < enderecoTamanho; i++) {
                    endereco += " ";
                }

                String msg = opcao + cpf + nome + endereco;
                out.write(msg.getBytes());

            }
        }
    }

    public void mandarMensagemString(String s) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        if (true) {
            System.out.println("Aguardando a conexão...");
            try ( Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                String msg = s;
                out.write(msg.getBytes());
            }
        }
    }

    public void enviaRetornoCliente(String dados) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("Aguardando a conexão...");
            try ( Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                String msg = dados;
                out.write(msg.getBytes());
            }
        }
    }
    public void enviaGetCliente(String dados) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("Aguardando a conexão...");
            try ( Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                String msg = dados;
                out.write(msg.getBytes());
            }
        }
    }
    public void enviaListCliente(String dados) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("Aguardando a conexão...");
            try ( Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                String msg = dados;
                out.write(msg.getBytes());
            }
        }
    }
}
