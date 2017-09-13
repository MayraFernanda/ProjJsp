<%-- 
    Document   : alterarProduto
    Created on : 12/09/2017, 11:42:29
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
        <jsp:useBean id="daoP" scope="page" class="projjsp.Produtos" />
        <div>
            <header> 
                <form action="Index.jsp">
                    <input type="text" name="busca" required="required" value="" id="txtBusca" placeholder="Produto...">
                    <input type="submit" value="Buscar" name="status">
                </form>
            
                <a href="login.jsp">Login</a> 
            </header>
        </div>
        
        <div>
            <content>
                <form action="excluirProduto.jsp">
                    Código:<br>
                    <input type="text" name="cod" value=""><br>
                    <input type="submit" value="Submit" name="status">
                </form>
            </content>    
        </div>
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="produto" scope="page" value="${daoP.getProduto(param.cod)}" />
            <c:set var="strProduto"  scope="page" value="${produto.toString()}" />
                <script>alert(pageScope.strProduto);</script>            
        </c:if>
    </body>
</html>
