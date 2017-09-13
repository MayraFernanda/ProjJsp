<%-- 
    Document   : alterarSenhaAdm
    Created on : 12/09/2017, 11:08:40
    Author     : u14189
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar sua Senha</title>
    </head>
    <body>
        <jsp:useBean id="daoA" scope="page" class="projjsp.Administradores" />
        
        <div>
            <content>
                <form action="alterarSenhaAdm.jsp">
                    Login:<br>
                    <input type="text" name="login" required="required" value=""><br>
                    Nova senha:<br>
                    <input type="text" name="novaSenha" required="required" value=""><br><br>          
                    <input type="submit" value="Submit" name="status">
                </form>
            </content>
            
        </div>

        <a href="AdmLogado.jsp"> Voltar </a>
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="alterouSenha" scope="page" value="${daoA.alterarSenha(param.login, param.novaSenha)}" />
            <script>alert('Senha Alterada com Sucesso!');</script>
            
        </c:if>
     
    </body>
    
    
</html>
