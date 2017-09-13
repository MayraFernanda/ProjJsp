<%-- 
    Document   : excluirCliente
    Created on : 12/09/2017, 20:29:58
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Cliente </title>
    </head>
    <body>
        <jsp:useBean id="daoC" scope="page" class="projjsp.Clientes" />
        <div>
            <header> 
                <form action="excluirCliente.jsp">
                    <input type="text" name="busca" value="" id="txtBusca" placeholder="Cliente...">
                    <input type="submit" value="Buscar" name="status">
                </form>    
            </header>
        </div>
        
        <div>
            <form action="excluirCliente.jsp">
                Código:<br>
                <input type="text" name="cod" required="required" value=""><br>
                <input type="submit" value="Submit" name="status">
            </form>
        </div>
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="excluiu" scope="page" value="${daoC.excluir(param.cod)}" />
            <c:if test="${pageScope.excluiu}"
                <script>alert('Cliente excluído com sucesso!');</script>
            </c:if>            
        </c:if>
    </body>
</html>
