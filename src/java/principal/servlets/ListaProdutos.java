package principal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaProdutos", urlPatterns = {"/ListaProdutos"})
public class ListaProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
            String SQL = "SELECT * FROM produto;";
            try {

                Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aulajavaweb", "postgres", "root");

                //Deleta o registro
                //Quando existir uma QUERY String ID
                if (request.getParameter("id") != null) {
                    int ID = Integer.parseInt(request.getParameter("id"));
                    String SQLDelete = "DELETE FROM produto WHERE idproduto = ?";
                    PreparedStatement deleteBD = conex.prepareStatement(SQLDelete);
                    deleteBD.setInt(1, ID);
                    deleteBD.execute();
                }

                Statement stm = conex.createStatement();
                ResultSet rs = stm.executeQuery(SQL);

                out.println("<title>Lista Produtos</title>");
                out.println("<table width = '50%'>");
                out.println("<tr bgcolor = 'blue'style='text-align:center'\">");
                out.println("<td><font color='white'>ID</font></td>");
                out.println("<td><font color='white'>Título</font></td>");
                out.println("<td><font color='white'>Descrição</font></td>");
                out.println("<td colspan='2'><font color='white'>AÇÕES</font></td>");
//                out.println("<td>APAGAR</td>");

                out.println("<tr>");
                while (rs.next()) {
                    out.println("<td>" + rs.getInt("idproduto") + "</td>");
                    out.println("<td>" + rs.getString("nome") + "</td>");
                    out.println("<td>" + rs.getString("descricao") + "</td>");
                    out.println("<td><a href='http://localhost:8080/AtividadeCrudWeb/EditarProdutoServlet?id="
                            + rs.getInt("idproduto") + "'>  [EDITAR]</td>");
                    out.println("<td><a href='http://localhost:8080/AtividadeCrudWeb/ListaProdutos?id="
                            + rs.getInt("idproduto") + "'>  [APAGAR]</td>");

                    out.println("</tr>");
                }
                out.println("</table>");

            } catch (SQLException ex) {
                out.println("Erro de SQL: " + ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            out.println("Driver do Banco não encontrado: " + ex.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
