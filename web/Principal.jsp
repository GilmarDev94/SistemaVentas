
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #8674EC; ">
            
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
            <div class="collapse navbar-collapse" id="navbarNav"></div>
    <ul class="navbar-nav  dropdown-item">
        
      <li class="nav-item ">
          <a class="nav-link" href="Controlador?menu=Home&accion=Listar" target="myFrame">Home </a> 
      </li>
      <li class="nav-item">
          <a class="nav-link" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Usuarios</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva venta</a>
      </li>
      
    </ul>
      <div class="dropdown dropdown-item ">
  <button class="dropdown text-center" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    
     ${usuario.getNom()}
  </button>
  <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton"
      <a class="dropdown-item" href="#">
          <img src="img/conectado.png" alt="70px" width="70px"/>
         
      </a>
    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
    <a class="dropdown-item" href="#">usuario@gmail.com</a>
    <div class=" dropdown-divider"></div>
    <form action="Validar" method="POST"> 
       <button name = "accion" value="salir" class="dropdown-item" href="#">Salir</button>
    </form>
    
  </div>
</div>
      
  </div>
</nav>
    
    <div class="m-4" style="height: 530px; ">
        <iframe name="myFrame" style= "height: 100% ; width: 100%; border: none "></iframe>
    </div>
       <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
