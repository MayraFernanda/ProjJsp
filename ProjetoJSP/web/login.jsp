<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>login</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <jsp:useBean id="daoA" scope="page" class="projjsp.Administradores" />
    <jsp:useBean id="daoC" scope="page" class="projjsp.Clientes" />
    
<c:if test="${param.status == 'Submit'}">   
    <script>alert('vou testar');</script>
    <c:set var="existeAdm" scope="page" value="${daoA.getAdministrador(param.login)}" /> 
    <script>${pageScope.existeAdm}</script>
    <script>alert(pageScope.existeAdm);</script> 
    
    <script>alert('vou testar');</script>
    <c:set var="existeCliente" scope="page" value="${daoC.getCliente(param.login)}" />    
    <script>${pageScope.existeCliente}</script>
    <script>alert(pageScope.existeCliente);</script>
    
    <c:set var="senhaCorretaAdm" scope="page" value="${daoA.senhaCorreta(param.login, param.senha)}" />
    <script>${pageScope.senhaCorretaAdm}</script>
    <script>alert(pageScope.senhaCorretaAdm);</script>
    
    <c:set var="senhaCorretaCliente" scope="page" value="${daoC.senhaCorreta(param.login, param.senha)}" /> 
    <script>${pageScope.senhaCorretaCliente}</script>
    <script>alert(pageScope.senhaCorretaCliente);</script>
   
     <c:choose>        
         <c:when test = "${pageScope.existeAdm != null}">
            <c:choose> 
                <c:when test = "${pageScope.senhaCorretaAdm}">
                    <script>alert('login e senha corretos!');</script>
                </c:when>
            </c:choose>
                    <c:otherwise><script>alert("chegou");</script></c:otherwise>
         </c:when>
         
         <c:when test = "${pageScope.existeCliente != null}">
            <c:choose> 
                <c:when test = "${pageScope.senhaCorretaCliente}">
                    <script>alert('login e senha corretos!');</script>
                </c:when>
            </c:choose>
         </c:when>
         
         <c:otherwise>
            <script>alert('Insira dados corretos');</script>
         </c:otherwise>
      </c:choose> 
      
</c:if> 
    
    <form action="login.jsp">
      Login:<br>
      <input type="text" name="login" value=""><br>
      Senha<br>
      <input type="text" name="senha" value=""><br><br>
      <input type="submit" value="Submit" name="status">
    </form>
</body>
</html>