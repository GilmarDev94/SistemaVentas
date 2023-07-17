/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author will
 */
public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

//    public String GenerarSerie() {
//        String numeroserie = "";
//        String sql = "select max(NumeroSerie) from ventas";
//        try {
//            con = cn.Conexion();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                numeroserie = rs.getString(1);
//
//            }
//        } catch (Exception e) {
//        }
//        return numeroserie;
//    }
    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(IFNULL(NumeroSerie,0))+1 from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("valor retornado:"+rs.getInt(1)); 
                int valor=0;
                if (rs.getInt(1)==0) {
                    valor=1;
                } else{
                    valor=rs.getInt(1);
                }
                
                numeroserie ="00000"+ valor; 
                
            }
        } catch (Exception e) {
//            System.out.println("mi error"); 
            e.printStackTrace();
        }
        return numeroserie;
    }

    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    public int guardarVenta(Venta ve){
//        System.out.println("guardsndo ventas");
        String sql="insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) value(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getPrecio());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
//            System.out.println("mi error");
            e.printStackTrace();
        }
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql="insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) value(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
}
