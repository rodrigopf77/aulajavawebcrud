package principal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import principal.Produto;

/**
 *
 * @author rodri
 */
@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = null;

        try {
            out = response.getWriter();
            out.println("Produto cadastrado com sucesso!");
            String p = request.getParameter("txtProduto");
            String d = request.getParameter("txtDescricao");

            Produto produto = new Produto(p, d);

        } catch (IOException ex) {
            out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }
        response.sendRedirect("http://localhost:8080/AtividadeCrudWeb/ListaProdutos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
