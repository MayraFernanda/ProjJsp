<%-- 
    Document   : clientes
    Created on : 12/09/2017, 11:10:19
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <div>
            <header> 
                <form action="Index.jsp">
                    <input type="text" name="busca" value="" id="txtBusca" placeholder="Cliente...">
                    <input type="submit" value="Buscar" name="status">
                </form>
            </header>
        </div>
        <div>
            <content>
                <p><a href="cadastrarCliente.jsp"> Incluir Cliente</a> <p>
                <a href="excluirCliente.jsp"> Excluir Cliente</a> <p>
                <a href="alterarCliente.jsp"> Alterar Cliente</a>
            </content>
        </div>
       
    </body>
</html>
