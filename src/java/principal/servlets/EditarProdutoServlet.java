package principal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import principal.Produto;

@WebServlet(name = "EditarProdutoServlet", urlPatterns = {"/EditarProdutoServlet"})
public class EditarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/aulajavaweb", "postgres", "root");

            String SQL = "SELECT * FROM produto WHERE idproduto = ?";

            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, Integer.parseInt(request.getParameter("id")));

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Editar Produto</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Preencha as Informações do Produto</h1>");
                out.println("<hr/>");
                out.println("<form method='POST'>");
                out.println("Código Produto:<br> <input type='text' name='txtID' readonly='readonly' value='" + rs.getInt("idproduto") + "'>");
                out.println("<br>");
                out.println("Produto:<br> <input type='text' name='txtNome' value='" + rs.getString("nome") + "'>");
                out.println("<br>");
                out.println("Descrição:<br> <textarea name='txtDescricao' rows='10' cols='40'>" + rs.getString("descricao") + "</textarea>");
                out.println("<br>");
                out.println("<input type='submit' value='Atualizar Produto'>");
                out.println("</form>");
                out.println("<br>");
                out.println("<a href='http://localhost:8080/AtividadeCrudWeb/ListaProdutos'>Listar Produtos</a>");
                out.println("<br>");
                out.println("<a href='http://localhost:8080/AtividadeCrudWeb/Logoff'>Sair</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("Este produto não existe!");
            }

            pstm.close();
            conn.close();

        } catch (SQLException e) {
            out.println("Problema no banco de dados: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            out.println("Problema ao carregar o driver de conexão!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         PrintWriter out = response.getWriter();

            int id = Integer.parseInt(request.getParameter("txtID"));
            String nome = request.getParameter("txtNome");
            String descricao = request.getParameter("txtDescricao");

            if (nome.trim().length() < 4) {
                out.println("Preencha o campo nome");
            } else if (descricao.trim().length() < 4) {
                out.println("Preencha o campo descricao");
            } else {
                try {
                    Class.forName("org.postgresql.Driver");

                    String SQL = "UPDATE produto SET nome = ?, descricao = ? WHERE idproduto = ?";

                    try {
                        Connection conn = DriverManager.getConnection(
                                "jdbc:postgresql://localhost:5432/aulajavaweb", "postgres", "root");

                        PreparedStatement pstm = conn.prepareStatement(SQL);

                        pstm.setString(1, nome);
                        pstm.setString(2, descricao);
                        pstm.setInt(3, id);

                        pstm.execute();

                        pstm.close();

                        conn.close();

                        response.sendRedirect("http://localhost:8080/AtividadeCrudWeb/ListaProdutos");

                    } catch (SQLException e) {
                        out.println("Problema no banco de dados: " + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    out.println("Problema ao carregar o driver de conexão!");
                }
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
