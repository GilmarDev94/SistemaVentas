
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex" >
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action = "Controlador?menu=Empleado" method="POST">

                        <div class= "form-group">
                            <label>Nombres</label>
                            <input type = "text" value="${empleado.getNom()}" name="txtNombres" class="form-control" required pattern="^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$" title="Este campo sólo acepta caracteres">
                        </div>

                        <div class="form-group">
                            <label>Telefono</label>
                            <input type = "text" value="${empleado.getTlf()}" name="txtTel" class="form-control" minlength="9" maxlength="9" required pattern="^[0-9]+" title="Este campo sólo acepta valores numericos">
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <input type = "number" value="${empleado.getEstado()}" name="txtEstado" class="form-control" min="1" max="2" maxlength="1" required>
                        </div>
                          
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type = "text" value="${empleado.getUser()}" name="txtUsuario" class="form-control" required maxlength="11">
                        </div>
                        <div class = "form-group">
                            <label>Password</label>
                            <input type = "text" value="${empleado.getPassword()}" name="txtDni" class="form-control" required>
                        </div>

                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class= "col-sm-6">
                <table class = " table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRES</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>USUARIO</th>
                            <th>PASSWORD</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">

                            <tr>
                                <td>${em.getId()}</td>
                                
                                <td>${em.getNom()}</td>
                                <td>${em.getTlf()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUser()}</td>
                                <td>${em.getPassword()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>  
                                    <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Delete</a> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div>




                </div>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                </body>
                </html>