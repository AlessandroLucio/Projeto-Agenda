<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img/phone.png">
    <title>Editar de contato</title>
<body>
	<div class="container cont-novo">
        <h1>Editar contato</h1>
	<form name="formContato" action="update" >
		<div>
			<input type="text" name="id" class="form-control" readonly value="<%out.print(request.getAttribute("idcon"));%>">
            <input type="text" name="nome" class="form-control" value="<%out.print(request.getAttribute("nome"));%>">
            <input type="text" name="fone" class="form-control" value="<%out.print(request.getAttribute("fone"));%>">
            <input type="text" name="email" class="form-control" value="<%out.print(request.getAttribute("email"));%>">
        </div>
    	
		<input type="button" value="Salvar" class="btn btn-primary" onclick="validar()">
	
	</form>
	
    </div>
    
    <script src="scripts/validador.js"></script>
</body>
</html>