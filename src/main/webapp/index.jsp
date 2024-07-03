<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String msjError = (String) request.getAttribute("msjError");
    if(msjError == null) msjError = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="p-5 bg-success-subtle">
    <div class="p-5 container col-5 border border-1 rounded bg-white">
        <h1 class="text-center">Ingresar al sistema</h1>
        <hr>
        <form action="UsuarioController" method="post">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="txtUsername" name="username" placeholder="Usuario" autocomplete="off" required>
                <label for="txtUsername">Usuario</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="txtPassword" name="password" placeholder="Contraseña" required>
                <label for="txtPassword">Contraseña</label>
            </div>
            <div class="text-center mb-3">
                <button type="submit" class="btn btn-primary">Ingresar</button>
            </div>
            <%
                if(!msjError.equals("")) {
            %>
            <div class="alert alert-danger text-center">
                <%=msjError %>
            </div>
            <%
                }
            %>
        </form>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>