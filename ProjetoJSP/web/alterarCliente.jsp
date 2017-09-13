<%-- 
    Document   : alterarCliente
    Created on : 12/09/2017, 20:30:13
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body>
        <jsp:useBean id="daoC" scope="page" class="projjsp.Clientes" />
        <div>
            <header> 
                <form action="index.jsp">
                    <input type="text" name="busca" required="required" value="" id="txtBusca" placeholder="Produto...">
                    <input type="submit" value="Buscar" name="status">
                </form>           
            </header>
        </div>
        
        <div>
            <content>
                <form action="excluirCliente.jsp">
                    Código:<br>
                    <input type="text" name="cod" value=""><br>
                    <input type="submit" value="Submit" name="status">
                </form>
            </content>    
        </div>
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="cliente" scope="page" value="${daoC.getCliente(param.cod)}" />
            <c:set var="strCliente"  scope="page" value="${produto.toString()}" />
                <script>alert(pageScope.strProduto);</script>            
        </c:if>
    </body>
</html>
