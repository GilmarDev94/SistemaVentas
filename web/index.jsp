<%-- 
    Document   : Principal.jsp
    Created on : 17 abr. 2023, 13:19:44
    Author     : Rober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action= "Validar" method="POST">
                        <div class="form-group text-center">
                            <h3>INICIAR SESION</h3> 
                            <img src="img/login.png" alt="150" width="150"/>
                            <label><h2>Bienvenidos al Sistema</h2></label>
                        </div>
                        <div class = "form-group">
                            <label>Usuario:</label>
                            <input type="text" name= "txtuser" class="form-control">
                        </div>
                        
                        <div class = "form-group">
                            <label>Contraseña:</label>
                            <input type = "password" name="txtpass" class="form-control">
                        </div>
                        <div class= "form-group text-center">
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-blo">
                        </div>
                    </form>
                </div>
            </div>
        </div>    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
