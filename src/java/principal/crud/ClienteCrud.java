package principal.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.Cliente;

public class ClienteCrud {

    public void criarCliente(Cliente c) throws ClassNotFoundException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("yyyy-MMM-dd")).toFormatter();

        //Criando a conexão com o banco, através da classes ConexaoBD
        ConexaoBD conexao = new ConexaoBD();
        Connection conex = conexao.conexao();
        PreparedStatement insereBD = null;

        //Criando a String de conexao com o banco
        String sql = "INSERT INTO cliente(nome, email, cpf, datanascimento) values(?, ?, ?, ?)";

        try {

            java.util.Date d = new java.util.Date(sdf.parse(c.getDataNascimento()).getTime());
            java.sql.Date dt = new java.sql.Date(d.getTime());

            System.out.println(c.getDataNascimento2());

            insereBD = conex.prepareStatement(sql);
            insereBD.setString(1, c.getNome());
            insereBD.setString(2, c.getEmail());
            insereBD.setString(3, c.getCpf());
            insereBD.setDate(4, dt);
//            insereBD.setObject(4, LocalDate.parse(c.getDataNascimento(), f));

            //LocalDate datetime = LocalDate.parse("2019-DeC-22", f);
            //Persistendo os valores no banco
            insereBD.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente. Mensagem: " + e.getMessage());
        } catch (DateTimeParseException p) {
            System.out.println("Erro na conversão da data: " + p.getMessage());
        } catch (ParseException ex) {
            System.out.println("Erro na conversão do Date: " + ex.getMessage());
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
