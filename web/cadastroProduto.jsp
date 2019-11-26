<%-- 
    Document   : cadastroProduto
    Created on : 20/11/2019, 20:03:20
    Author     : Everymind
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pedido</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script src = "//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js" ></script>
    </head>
    <body>
        <form method="GET" action="InserirProduto">
            <select name="produto" class="form-control custom-select-sm">
    <option selected>Selecione seu produto</option>
    <c:forEach items="${produtos}" var="produto">
        <option value="${produto.idProduto}">${produto.descricao}</option>
    </c:forEach>
        <input type="number" name="quantidade" class="form-control">
                <input type="submit" class="btn btn-primary" value="Inserir produto">

  </select>
        </form>
    </body>
</html>
