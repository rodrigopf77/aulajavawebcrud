<%-- 
    Document   : lista_produto
    Created on : 02/10/2020, 02:16:17
    Author     : rodri
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <h1>Produtos</h1>
        <hr>
        <table>

            <tr>
                <td>ID</td>
                <td>Login</td>
            </tr>
            <%

                Class.forName("org.postgresql.Driver");

                String SQL = "SELECT * FROM produto";

                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/aulajavaweb",
                        "postgres", "root");

                Statement stm = conn.prepareStatement(SQL);

                ResultSet rs = stm.executeQuery(SQL);
                while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString("nome")%></td>
                <td><%=rs.getString("descricao")%></td>
            </tr>
            <%
                }
            %>
        </table>
        
    </body>
</html>
