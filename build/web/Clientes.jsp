<%-- 
    Document   : Clientes
    Created on : 18 abr. 2023, 14:49:37
    Author     : Rober
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
                      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" 
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex" >
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action = "Controlador?menu=Clientes" method="POST">
                        <div class = "form-group">
                            <label>Dni</label>
                            <input type = "text" value="${cliente.getDni()}" name="txtDni" class="form-control" minlength="8" maxlength="8" required pattern="^[0-9]+" title="Este campo sólo acepta valores numericos">
                        </div>

                        <div class= "form-group">
                            <label>Nombres</label>
                            <input type = "text" value="${cliente.getNom()}" name="txtNombres" class="form-control" required pattern="^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$" title="Este campo sólo acepta caracteres">
                        </div>

                        <div class="form-group">
                            <label>Direccion</label>
                            <input type = "text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control" required>
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <input type = "number" value="${cliente.getEstado()}" min="1" max="2" maxlength="1" name="txtEstado" class="form-control" required>
                        </div>

                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class= "col-sm-6">
                <table class = "table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>ESTADO</th>
                            <th>OPERACIONES</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${clientes}">
                            <tr>
                                <td>${c.getId()}</td>
                                <td>${c.getDni()}</td>
                                <td>${c.getNom()}</td>
                                <td>${c.getDireccion()}</td>
                                <td>${c.getEstado()}</td>
                                <td>
                                    <a class="fa fa-pencil"  href="Controlador?menu=Clientes&accion=Editar&id=${c.getId()}"></a>  
                                    <a class="fa fa-trash" href="Controlador?menu=Clientes&accion=Delete&id=${c.getId()}"></a> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
                <div>
                    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                </div>
            </div>
        </div>
    </body>
</html>
