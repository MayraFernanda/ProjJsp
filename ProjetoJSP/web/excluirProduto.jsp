<%-- 
    Document   : excluirProduto
    Created on : 05/09/2017, 13:55:25
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja</title>
    </head>
    <body>
        <jsp:useBean id="daoP" scope="page" class="projjsp.Produtos" />
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
            <form action="excluirProduto.jsp">
                Código:<br>
                <input type="text" name="cod" required="required" value=""><br>
                <input type="submit" value="Submit" name="status">
            </form>
        </div>
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="excluiu" scope="page" value="${daoP.excluir(param.cod)}" />
            <c:if test="${pageScope.excluiu}"
                <script>alert('Livro excluído com sucesso!');</script>
            </c:if>            
        </c:if>
        
    </body>

    
</html>
