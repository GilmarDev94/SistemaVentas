package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();

    int ide;
    int idc;
    int idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();

    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

//    Vamos a instanciar la clase venta DAO
    String numeroserie = "";
    VentaDAO vdao = new VentaDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Home")) {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String password = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    em.setPassword(password);
                    em.setNom(nom);
                    em.setTlf(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String password1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    em.setPassword(password1);
                    em.setNom(nom1);
                    em.setTlf(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String direc = request.getParameter("txtDireccion");
                    String est = request.getParameter("txtEstado");
                    c.setDni(dni);
                    c.setNom(nom);
                    c.setDireccion(direc);
                    c.setEstado(est);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = cdao.listarId(idc);
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
//                    int id = Integer.parseInt(request.getParameter("txtId"));
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String direc1 = request.getParameter("txtDireccion");
                    String est1 = request.getParameter("txtEstado");
                    c.setDni(dni1);
                    c.setNom(nom1);
                    c.setDireccion(direc1);
                    c.setEstado(est1);
                    c.setId(idc);
                    cdao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc= Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    
            }
//            List <Cliente> lista= cdao.listar();
//                    request.setAttribute("listacliente", lista);
//            System.out.println("guardando venta");
//                    List<Cliente> lista=cdao.listar();

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
             switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String prec = request.getParameter("txtPrecio");
                    String stoc = request.getParameter("txtStock");
                    String est = request.getParameter("txtEstado");
                    p.setNom(nom);
                    p.setPre(prec);
                    p.setStock(stoc);
                    p.setEstado(est);
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pr = pdao.listarId(idp);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1 = request.getParameter("txtNombres");
                    String prec1 = request.getParameter("txtPrecio");
                    String stoc1 = request.getParameter("txtStock");
                    String est1 = request.getParameter("txtEstado");
                    p.setNom(nom1);
                    p.setPre(prec1);
                    p.setStock(stoc1);
                    p.setEstado(est1);
                    p.setId(idp);
                    pdao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp= Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

//        System.out.println("menu:"+menu);
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    c.setDni(dni);
                    c = cdao.buscar(dni);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarId(id);
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    int stock = Integer.parseInt(request.getParameter("stock"));
                    
                    if (cant <= stock)
                    {
                        subtotal = precio * cant;
                        v = new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar = totalPagar + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                    }else{
                        System.out.println("La cantidad supera al stock disponible");
                    }

                    break;

                case "GenerarVenta":
                    //ACTUALIZAR STOCK
//                    for (int i = 0; i < lista.size(); i++) {
//                        Producto pr = new Producto();
//                        int cantidad = lista.get(i).getCantidad();
//                        int idproducto= lista.get(i).getIdproducto();
//                        ProductoDAO aO=new ProductoDAO();
//                        pr=aO.buscar(idproducto);
//                        int sac=pr.getStock()- cantidad;
//                        aO.actualizarstock(idproducto, sac);
//                    }

                    //GUARDAR VENTA
                    System.out.println("genereando numero de serie");
                    System.out.println("numero de serie:" + numeroserie);
                    numeroserie = vdao.GenerarSerie();
                    System.out.println("numero de serie:" + numeroserie);
                    HttpSession session = request.getSession();
                    Empleado empleado = (Empleado)session.getAttribute("usuario");
                    v.setIdcliente(c.getId());
//                    v.setIdempleado(2);
                    v.setIdempleado(empleado.getId());
                    v.setNumserie(numeroserie);
                    LocalDate fecha = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String fechaFormaro = fecha.format(formatter);
//                    v.setFecha("26-06-2023");
                    v.setFecha(fechaFormaro);
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    System.out.println("guardando venta");
                    vdao.guardarVenta(v);
                    //GUARDAR DETALLE VENTA
                    
                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                        System.out.println("cantidad:"+lista.get(i).getCantidad());

//                        pdao.actualizarstock(lista.get(i).getIdproducto(), lista.get(i).getCantidad());
                        
                    }
                    break;
                default:
                    
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
//              Vamos almacenar el maximo numero de serie que existe
                    numeroserie = vdao.GenerarSerie();
                     request.setAttribute("nserie", numeroserie);
//                    if (numeroserie == null) {
//                        numeroserie = "00000001";
//                        request.setAttribute("nserie", numeroserie);
//                    } else {
////                        
//                        request.setAttribute("nserie", numeroserie);
//                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
//            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

//        System.out.println("terminado");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
