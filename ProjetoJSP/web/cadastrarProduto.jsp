<%-- 
    Document   : cadastrarProduto
    Created on : 12/09/2017, 11:41:35
    Author     : u14189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <jsp:useBean id="daoP" scope="page" class="projjsp.Produtos" />
        
        <div>
            <content>
                <form action="cadastrarProduto.jsp">
                    Código:<br>
                    <input type="text" name="cod" required="required" value=""><br>
                    Nome: <br>
                    <input type="text" name="nome" required="required" value=""><br><br>
                <!-- Imagem: <br>
                    <input type="file" name="imagem" onchange="previewFile()"><br<br>
                    <img src="" height="200" alt="Image preview..."><br<br><p> -->
                    Imagem: <br>
                    <input type="text" name="imagem" required="required" value=""><br><br>
                    Preço <br>
                    <input type="text" name="preco" required="required" value=""><br><br>
                    Estoque: <br>
                    <input type="text" name="estoque" required="required" value=""><br><br>
                    <input type="submit" value="Submit" name="status">
                    </form>
            </content>
        </div>
        
        
        <c:if test="${param.status == 'Submit'}">
            <c:set var="cadastrou" scope="page" value="${daoP.incluir(param.cod, param.nome, param.imagem, param.preco, param.estoque)}" />
            <script>alert('Livro cadastrado com sucesso!');</script>
            
        </c:if>
        
<!--        <script>
            function previewFile(){
                var preview = document.querySelector('img'); //selects the query named img
                var file    = document.querySelector('input[type=file]').files[0]; //sames as here
                var reader  = new FileReader();

                reader.onloadend = function () {
                    preview.src = reader.result;
                }

                if (file) {
                    reader.readAsDataURL(file); //reads the data as a URL
                } else {
                    preview.src = "";
                }
            }

  previewFile();  //calls the function named previewFile()
  </script> -->
  
    </body>
</html>
