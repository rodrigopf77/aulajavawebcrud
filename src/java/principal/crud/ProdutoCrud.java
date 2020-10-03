package principal.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import principal.Produto;

public class ProdutoCrud {
    private String nome;
    private String descricao;
    private double preco;
    
    Scanner sc = new Scanner(System.in);
    
    public void criarProduto(Produto p) throws ClassNotFoundException, SQLException{
       
        ConexaoBD conexao = new ConexaoBD();
        Connection conex = conexao.conexao();
        PreparedStatement insereBD = null;
        String sql = "INSERT INTO produto(nome, descricao) values(?, ?)";

        try {
            insereBD = conex.prepareStatement(sql);
            insereBD.setString(1, p.getNome());
            insereBD.setString(2, p.getDescricao());

            insereBD.executeUpdate();
            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto. Mensagem: " + e.getMessage());
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
