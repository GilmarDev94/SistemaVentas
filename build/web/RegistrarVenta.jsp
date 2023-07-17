<%-- 
    Document   : RegistrarVenta
    Created on : 18 abr. 2023, 14:50:03
    Author     : Rober
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Ventas</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="DNI" minlength="8" maxlength="8" required pattern="^[0-9]+" title="Este campo sólo acepta valores numericos"> 
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info"> 
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNom()}" class="form-control" >
                                </div> 
                            </div>
                                
                            <div class="form-group">
                                <!--DATOS DEL PRODUCTO-->
                                <label>Datos Productos</label>
                            </div>
                                
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo" required pattern="^[0-9]+" title="Este campo sólo acepta valores numericos"> 
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control" >
                                </div> 
                            </div>
                                
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPre()}" class="form-control"  placeholder="S/0.00" > 
                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="number" name="cant" value="1" class="form-control" placeholder="" > 
                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="" > 
                                </div>
                            </div>
                                
                                <!--REGISTAR VENTAS-->
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                            </div>
                        </div>
                    </form>
                </div> 
            </div>
                                
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Nro.Serie</label>
                            <input type="text" name="NroSerie:" value="${nserie}" class="form-control">
                            
                        </div>
                        <br>
                        <table class="table table-secondary">
                                <thead>
                                    <tr>
                                        <th>Nro</th>  
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Subtotal</th>
                                        <th class="accion">Accion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="lista" items="${lista}">
                                    <tr>
                                        <td>${lista.getItem()}</td>
                                        <td>${lista.getIdproducto()}</td>
                                        <td>${lista.getDescripcionP()}</td>
                                        <td>${lista.getPrecio()}</td>
                                        <td>${lista.getCantidad()}</td>
                                        <td>${lista.getSubtotal()}</td>
                                        <td class="d-flex">
<!--                                            <a href="#" class="btn btn-warning">Editar</a>-->
                                            <a href="#" class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                    </div>
                    <div class="card-footer">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-6 ml-auto d-flex">
                            <label class="col-sm-6 text-right mt-2">Total a Pagar</label>
                            <input type="text" name="textTotal" value="s/.${totalpagar}0" class="form-control" >
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" 
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" 
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
 