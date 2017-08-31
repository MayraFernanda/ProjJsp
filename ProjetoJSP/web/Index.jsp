<!DOCTYPE html>
<html>
<head>
	<title>e-commerce</title>
</head>
<body>
    <jsp:useBean id="daoP" scope="page" class="projjsp.Produtos" />
    
    <c:if test="${param.status == 'Buscar'}">
        <script>alert(param.busca);</script> <%-- Não ta pegando o login --%>
    </c:if>  

    <div>
        <header> 
        <form action="Index.jsp">
        <input type="text" name="busca" value="" id="txtBusca" placeholder="Produto...">
        <input type="submit" value="Buscar" name="status">
        </form>
            
        <a href="login.jsp">Login</a> 
        </header>
    </div>

    <div>
        <content>
            <c:if test="${param.status == 'Buscar'}"> 
                <script>alert('vou testar');</script>
                <c:set var="strBusca" scope="page" value="${daoP.getProduto(param.busca)}" /> 
                <script>${pageScope.strBusca}</script>
                <script>alert(pageScope.strBusca);</script> 
     
                <c:choose>        
                    <c:when test = "${pageScope.strBusca != null}">
                        <script>alert("not null");</script>
                    </c:when>
         
            
                    <c:otherwise>
                        <script>alert('Deu ruim');</script>
                    </c:otherwise>
                </c:choose> 
      
            </c:if> 
        </content> 
    </div>

</body>
</html>