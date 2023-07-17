/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author will
 */
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id) {
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getString(3));
                p.setStock(rs.getString(4));
                p.setEstado(rs.getString(5));

            }
        } catch (Exception e) {

        }
        return p;
    }

    public int actualizarstock(int id, int stock) {
//        String sql = "update producto  set Stock=? where IdProducto=?";
        String sql = "update producto  set Stock=Stock-? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }


    public int agregar(Producto p) {
        String sql = "INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPre());
            ps.setString(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    //throws SQLException
    public List listar()  {
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getString(3));
                p.setStock(rs.getString(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public Producto listarId(int id) {
        Producto pr = new Producto();

        String sql = "SELECT * FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPre(rs.getString(3));
                pr.setStock(rs.getString(4));
                pr.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pr;
    }

    public int actualizar(Producto pr) {
        String sql = "UPDATE producto SET  Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setString(2, pr.getPre());
            ps.setString(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();

        } catch (Exception e) {
             e.printStackTrace();
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
}
