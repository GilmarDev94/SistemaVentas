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
public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar( String dni){
        Cliente c = new Cliente();
        String sql="SELECT * FROM cliente WHERE Dni="+dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
            
        }
        return c;
    }
    
    public Cliente validar(String user, String dni) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE User=? AND  Dni=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("IdCliente"));
                c.setDni(rs.getString("Dni"));
                c.setNom(rs.getString("Nombres"));
                c.setDireccion(rs.getString("Direccion")); 
                c.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return c;
    }
//    throws SQLException se elimina
    public List listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
            }
        } catch (Exception e) {
           
        }
        
        return lista;
    }
    
    public Cliente listarId(int id) {
        Cliente cli = new Cliente();

        String sql = "SELECT * FROM cliente WHERE IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return cli;
    }

    public int actualizar(Cliente cl) {
        String sql = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getEstado());
            ps.setInt(5, cl.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    public int agregar(Cliente cli) {
        String sql = "INSERT INTO cliente(Dni, Nombres, Direccion, Estado) VALUES(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Eliminando.....");
            e.printStackTrace();
        }

    }
}
