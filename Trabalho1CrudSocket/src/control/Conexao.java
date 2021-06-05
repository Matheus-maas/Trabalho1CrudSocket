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

        while (true) {
            System.out.println("Aguardando a conexão...");
            try ( Socket conn = server.accept();) {

                System.out.println("Conectado com:"
                        + conn.getInetAddress().getHostAddress());

                OutputStream out = conn.getOutputStream();
                p.getNome();
                p.getCpf();
                p.getEndereco();

//                String tipo = opcao;
//                String tipoP = tipo.substring(0, 6);
//                String cpfN = p.getCpf();
//                String cpfP = cpfN.substring(7, 17);
//                String nomeP = nome.substring(18, 116);
//                p.setNome(reverteConversao(nome));
//                String enderecoN = p.getEndereco();
//                String enderecoP = enderecoN.substring(117, 226);
//
//;;            String msg = tipoP + ";" + nomeP + ";" + cpfP + ";" + enderecoP;
                String msg = opcao + ";" + p.getNome() + ";" + p.getCpf() + ";" + p.getEndereco();
                out.write(msg.getBytes());

            }
        }

    }

}
