package principal.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import principal.Livro;

public class LivroCrud {

    public void criarLivro(Livro l) throws ClassNotFoundException, SQLException {

        ConexaoBD conexao = new ConexaoBD();
        Connection conex = conexao.conexao();
        PreparedStatement insereBD = null;
        String sql = "INSERT INTO livro(titulo, autor, genero) values(?, ?, ?)";

        try {
            insereBD = conex.prepareStatement(sql);
            insereBD.setString(1, l.getTitulo());
            insereBD.setString(2, l.getAutor());
            insereBD.setString(3, l.getGenero());

            insereBD.executeUpdate();
            System.out.println("Livro inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Livro. Mensagem: " + e.getMessage());
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
