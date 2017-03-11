<%-- 
    Document   : principal
    Created on : Mar 5, 2017, 7:18:22 PM
    Author     : vitor
--%>

<%@page import="com.grupotcc.sgv.model.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
        <%
            Paciente paciente = (Paciente) session.getAttribute("pacienteAutenticado");
            
            if(paciente != null){
                %>
        <h1>Bem Vindo, <%= paciente.getNome() %> !</h1>
        <%}%>
        <a href="admin/cadastro_usuario.jsp">Area Restrita</a><br/>
        <a href="ControleAcesso?acao=Sair">Logout</a>
    </body>
</html>
