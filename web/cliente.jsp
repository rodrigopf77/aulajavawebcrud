<%-- 
    Document   : cliente
    Created on : 02/10/2020, 19:53:25
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
    </head>
    <body>
        <h1>CADASTRO DE CLIENTES</h1>
        <hr>
        
        <form method="POST" action="ClienteServlet">
            Nome:<br>
            <input type="text" name="txtNome"> <br>
            E-mail: <br>
            <input type="text" name="txtEmail"> <br>
            CPF: <br>
            <input type="text" name="txtCpf"> <br>
            
            <input type="submit" value="Cadastrar">
        </form>
        
    </body>
</html>
