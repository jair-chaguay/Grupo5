/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.usuarios;
/**
 *
 * @author alexc
 */
public class ConeUsuario {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion cn=new conexion();
    
    
    public usuarios login(String user, String pass){
        usuarios us=new usuarios();
        String sql="SELECT * FROM usuario WHERE Usuario = ? AND contraseña = ?";
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next()){
                us.setIdUser(rs.getInt("id_Usuario"));
                us.setUsuarios(rs.getString("Usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setCorreo(rs.getString("correo"));
                us.setContraseña(rs.getString("contraseña"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return us;
    }
}
