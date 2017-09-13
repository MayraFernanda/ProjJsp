<%-- 
    Document   : produtos
    Created on : 05/09/2017, 13:54:40
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        
        <div>
            <header> 
                <form action="Index.jsp">
                    <input type="text" name="busca" value="" id="txtBusca" placeholder="Produto...">
                    <input type="submit" value="Buscar" name="status">
                </form>
            
                <a href="login.jsp">Login</a> 
            </header>
        </div>
        
        <div name='content'>
            <a href="cadastrarProduto.jsp"> Cadastrar</a> <p>
            <a href="excluirProduto.jsp"> Excluir</a> <p>
            <a href="alterarProduto.jsp"> Alterar</a> 
        </div>
        
    </body>
</html>
