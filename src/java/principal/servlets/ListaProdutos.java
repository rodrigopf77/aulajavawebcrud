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

@WebServlet(name = "ListaProdutos", urlPatterns = {"/ListaProdutos"})
public class ListaProdutos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        try{
            Class.forName("org.postgresql.Driver");
            String SQL = "SELECT * FROM produto;";
            try{
                
                Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aulajavaweb", "postgres", "root");
                
                //Deleta o registro
                //Quandp existir uma QUERY String ID
                if (request.getParameter("id") != null) {
                    int ID = Integer.parseInt(request.getParameter("id"));
                    String SQLDelete = "DELETE FROM produto WHERE idproduto = ?";
                    PreparedStatement deleteBD = conex.prepareStatement(SQLDelete);
                    deleteBD.setInt(1, ID);
                    deleteBD.execute();
                }
                
                Statement stm = conex.createStatement();
                ResultSet rs = stm.executeQuery(SQL);
                
                out.println("<table width = '50%'>");
                out.println("<tr bgcolor = 'blue'style='text-align:center'\">");
                out.println("<td><font color='white'>ID</font></td>");
                out.println("<td><font color='white'>Título</font></td>");
                out.println("<td><font color='white'>Descrição</font></td>");
                out.println("<td colspan='2'><font color='white'>AÇÕES</font></td>");
//                out.println("<td>APAGAR</td>");
                
                out.println("<tr>");
                while(rs.next()){
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
