
package control;

import static control.Cliente.opcao;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import model.Pessoa;


public class Conexao {
    
    public void mandarMensagem() throws IOException{
        
     ServerSocket server = new ServerSocket(80);
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

                String msg = opcao+";"+p.getNome() + ";" + p.getCpf() + ";" + p.getEndereco();
                out.write(msg.getBytes());

            }
        }
        
    }

}
