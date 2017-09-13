<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>e-commerce</title>
</head>
<body>
    <jsp:useBean id="daoP" scope="page" class="projjsp.Produtos" />
   
    <c:if test="${param.status == 'Buscar'}">
        <script>alert(${param.busca});</script> <%-- Não ta pegando o login --%>
    </c:if> 
    <script>alert(${param.busca});</script>

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
                <c:set var="strBusca"  scope="page" value="${daoP.getProduto(param.busca)}" /> 
                <c:set var="sproduto"  scope="page" value="${strBusca.toString()}" /> 
                <script>alert(sproduto);</script>               
                <script>${pageScope.strBusca}</script>
                <script>alert(pageScope.strBusca);</script>
     
                <c:choose>        
                    <c:when test = "${pageScope.strBusca != null}">
                        <script>alert("not null");</script>
                    </c:when>
                    <c:otherwise>
                      <c:out value="<script>alert('Houve uma falha');</script>"/>
                    </c:otherwise>
                </c:choose>
      
            </c:if> 
        </content> 
    </div>

</body>
</html>