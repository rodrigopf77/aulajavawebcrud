package principal.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import principal.Cliente;

public class ClienteCrud {
    
    public void criarCliente(Cliente c) throws ClassNotFoundException{
        
        //Criando a conexão com o banco, através da classes ConexaoBD
        ConexaoBD conexao = new ConexaoBD();
        Connection conex = conexao.conexao();
        PreparedStatement insereBD = null;
        
        //Criando a String de conexao com o banco
        String sql = "INSERT INTO cliente(nome, email, cpf) values(?, ?, ?)";

        try {
            insereBD = conex.prepareStatement(sql);
            insereBD.setString(1, c.getNome());
            insereBD.setString(2, c.getEmail());
            insereBD.setString(3, c.getCpf());
            
            //Persistendo os valores no banco
            insereBD.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente. Mensagem: " + e.getMessage());
        } finally {
            try {
                insereBD.close();
                conex.close();
                System.out.println("Conexão encerrada com sucesso!");
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operações de inserção. Mensagem: "
                        + e.getMessage());
            }
        }
        
    }
    
}
