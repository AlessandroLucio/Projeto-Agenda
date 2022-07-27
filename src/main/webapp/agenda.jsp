
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
    <title>Agenda de contatos</title>
</head>
<body>
    <div class="container cont-agenda">
        <a href="novo.html" class="btn-tp btn btn-primary btn-lg">Novo contato</a>
	    <a href="report" class="btn-tp btn btn-info btn-lg">Relatorio pdf</a>
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover align-text-center">
                <thead class="table-dark">
                    <tr>
                        <th width=40px>Id</th>
                        <th width=250px>Nome</th>
                        <th width=150px>Fone</th>
                        <th width=150px>Email</th>
                        <th width=250px>Opções</th>
                    </tr>
                </thead>    
                <tbody>
                	<%for(int i=0; i<lista.size(); i++){%>
	                    <tr>
	                        <td><%=lista.get(i).getIdcon()%></td>                        
	                        <td><%=lista.get(i).getNome()%></td>
	                        <td><%=lista.get(i).getFone()%></td>
	                        <td><%=lista.get(i).getEmail()%></td>
	                        <td>
								<a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="btn btn-primary btn-sm">Editar</a>
	                           	<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class="btn btn-danger btn-sm">Deletar</a>
	                        </td>                        
	                    </tr>
                   	<%}%>
                </tbody>
            </table>  
        </div>    
    </div>
    <script src="scripts/confirmar.js"></script>
</body>
</html>