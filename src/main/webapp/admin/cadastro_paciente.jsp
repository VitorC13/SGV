<%-- 
    Document   : cadastro_paciente
    Created on : Mar 22, 2017, 7:37:34 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Paciente</title>
    </head>
    <body>
        <h1>Area de Acesso restrito aos funcionários</h1>
        <h2>Cadastro de novos paciente</h2>
        
        <% 
          String msg = (String) request.getAttribute("msg");
          if(msg != null){
        %>
        <font color="blue"><%=msg %></font>
        <%}%>
        <form action="PacientesController" method="POST">
            Login: <input type="text" name="txtLogin"></br>
            Senha: <input type="password" name="txtSenha"></br>
            Perfil: <select name="optPerfil">
                <option>COMUM </option>
                <option>ADMINISTRADOR</option>
            </select><br/>
            <input type="submit" value="Cadastrar" name="acao">
        </form>
        <a href="../principal.jsp">Página Principal</a>
    </body>
</html>
