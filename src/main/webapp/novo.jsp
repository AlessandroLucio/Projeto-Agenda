
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("contatos");%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img/phone.png">
    <title>Novo Contato</title>
</head>
<body>
    <div class="container cont-novo">
        <h1>Criar novo contato</h1>
	<form name="formContato" action="insert" >
		<div>
            <input type="text" name="nome" class="form-control" placeholder="Nome">
            <input type="text" name="fone" class="form-control" placeholder="Fone">
            <input type="text" name="email" class="form-control" placeholder="Email">
        </div>
    	
		<input type="button" value="Adicionar" class="btn btn-primary" onclick="validar()">
	
	</form>
	
	<script src="scripts/validador.js"></script>
    </div>
</body>
</html>