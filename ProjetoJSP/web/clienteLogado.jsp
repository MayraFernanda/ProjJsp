<%-- 
    Document   : clienteLogado
    Created on : 05/09/2017, 13:53:46
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área Cliente</title>
    </head>
    <body>
        <jsp:useBean id="daoC" scope="page" class="projjsp.Clientes" />
        <div>
            <header> 
                <form action="Index.jsp">
                    <input type="text" name="busca" value="" id="txtBusca" placeholder="Produto...">
                    <input type="submit" value="Buscar" name="status">
                </form>
            
                <a href="login.jsp">Login</a> 
            </header>
        </div>
    </body>
</html>
    