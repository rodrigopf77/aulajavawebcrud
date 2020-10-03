<%-- 
    Document   : livro
    Created on : 02/10/2020, 21:02:15
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Livros</title>
    </head>
    <body>
        <h1>Cadastrar Livros</h1>
        <hr>
        
        <form method="POST" action="LivroServlet">
            Título:<br>
            <input type="text" name="txtTitulo"> <br>
            Autor: <br>
            <input type="text" name="txtAutor"> <br>
            Genero: <br>
            <input type="text" name="txtGenero"> <br>
            
            <input type="submit" value="Cadastrar">
        </form>
        
    </body>
</html>
