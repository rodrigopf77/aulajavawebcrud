package principal.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import principal.Produto;

public class ProdutoCrud {

    private String nome;
    private String descricao;
    private double preco;
    private List<Produto> produtos = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void criarProduto(Produto p) throws ClassNotFoundException{

        ConexaoBD conexao = new ConexaoBD();
        Connection conex = conexao.conexao();
        PreparedStatement insereBD = null;
        String sql = "INSERT INTO produto(nome, descricao) values(?, ?)";
        
        System.out.println("ProdutoCrud: " + p.getNome());
        System.out.println("ProdutoCrud: " + p.getDescricao());

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
            } catch (Exception e) {
                System.out.println("Erro ao fechar operações de inserção. Mensagem: "
                        + e.getMessage());
            }
        }

    }
    
    public void atualizarProduto(int id){
        
    }

    public List<Produto> listar() throws ClassNotFoundException {

        ConexaoBD conexao = new ConexaoBD();
        Connection conex = conexao.conexao();
        PreparedStatement listaBD = null;

        List<Produto> produtos = new ArrayList<>();
        Statement consulta = null;
        ResultSet resultado = null;

        Produto produto = new Produto();

        String sql = "select * from produto";
        try {
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(sql);
            while (resultado.next()) {

                produto.setNome(resultado.getString("nome"));
                produto.setDescricao(resultado.getString("descricao"));
                
                produtos.add(produto);

            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produtos. Mensagem: "
                    + e.getMessage());
        } finally {
            try {
                consulta.close();
                resultado.close();
                conex.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operações de consulta. Mensagem: " + e.getMessage());
            }
        }

        return produtos;
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
