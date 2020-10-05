<%-- 
    Document   : editarproduto
    Created on : 04/10/2020, 14:38:12
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR PRODUTO</title>
    </head>
    <body>
        <h1>EDITAR PRODUTO</h1>
        <form method="POST" action="EditarProdutoServlet">
            Código Produto:<br>
            <input type="text" name="txtIdProduto" value="" ><br>
            Produto:<br>
            <input type="text" name="txtProduto"> <br>
            Descrição: <br>
            <input type="text" name="txtDescricao"> <br> <input
                type="submit" value="Cadastrar">
        </form>
    </body>
</html>
