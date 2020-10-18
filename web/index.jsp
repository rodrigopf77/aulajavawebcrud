<%-- 
    Document   : index
    Created on : 02/10/2020, 00:06:37
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Produtos</title>
    </head>
    <body>
        
        <h1>CADASTRO DE PRODUTO</h1>
        <hr>
        

        <form method="POST" action="ServletProduto">
            Produto:<br>
            <input type="text" name="txtProduto"> <br>
            Descrição: <br>
            <input type="text" name="txtDescricao"> <br>
            
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
