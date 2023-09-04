/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.usuarios;

/**
 *
 * @author alexc
 */
public class UsuarioBase {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrarUsuario(usuarios us) {
        String sql = "INSERT INTO usuario (Usuario, nombre, apellido, correo, contraseña) VALUES (?,?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUsuarios());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellido());
            ps.setString(4, us.getContraseña());
            ps.setString(5, us.getContraseña());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } 
    }

    public List ListarUsuario() {
        List<usuarios> ListaUsu = new ArrayList();
        String sql = "SELECT * FROM usuario";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios usu = new usuarios();
                usu.setIdUser(rs.getInt("id_Usuario"));
                usu.setUsuarios(rs.getString("Usuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setCorreo(rs.getString("correo"));
                usu.setContraseña(rs.getString("contraseña"));
                ListaUsu.add(usu);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaUsu;
    }

    public boolean ModificarUsuario(usuarios us) {
        String sql = "UPDATE usuario SET Usuario=?, nombre=?, apellido=?, correo=?, contraseña=? WHERE id_Usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUsuarios());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellido());
            ps.setString(4, us.getCorreo());
            ps.setString(5, us.getContraseña());
            ps.setInt(6, us.getIdUser());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } 
    }

    public boolean buscar(usuarios u) {
        String sql = "SELECT * FROM usuario WHERE id_Usuario=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getIdUser());          
            rs=ps.executeQuery();
            if (rs.next()) {
               u.setIdUser(rs.getInt(1));
               u.setUsuarios(rs.getString(2));
               u.setNombre(rs.getString(3));
               u.setApellido(rs.getString(4));
               u.setCorreo(rs.getString(5));
               u.setContraseña(rs.getString(6));
               return true; 
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

}
