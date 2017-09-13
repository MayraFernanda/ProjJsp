<%-- 
    Document   : incluirCliente
    Created on : 12/09/2017, 20:29:44
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Cliente</title>
    </head>
    <body>
        <jsp:useBean id="daoC" scope="page" class="projjsp.Clientes" />
        
        <div>
           <content>
                <form action="cadastrarCliente.jsp">
                    Id:<br>
                    <input type="text" name="id" required="required" value=""><br>
                    Nome: <br>
                    <input type="text" name="nome" required="required" value=""><br><br>              
                    Endereço: <br>
                    <input type="text" name="endereco" required="required" value=""><br><br>
                    Telefone: <br>
                    <input type="text" name="telefone" required="required" value=""><br><br>
                    E-mail: <br>
                    <input type="text" name="email" required="required" value=""><br><br>
                    Senha: <br>
                    <input type="text" name="senha" required="required" value=""><br><br>                   
                    <input type="submit" value="Submit" name="status">
                    </form>
            </content> 
        </div>
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="cadastrou" scope="page" value="${daoC.incluir(param.id, param.nome, param.endereco, param.telefone, param.email, param.senha)}" />
            
            <c:choose> 
                <c:when test = "${pageScope.cadastrou}">
                    <script>alert('Cliente Cadastrado!');</script>
                </c:when>
            </c:choose>     
        </c:if>
    
    </body>
</html>
