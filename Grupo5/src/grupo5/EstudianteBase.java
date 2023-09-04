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
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;

/**
 *
 * @author alexc
 */
public class EstudianteBase {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Estudiante est) {
        String sql = "INSERT INTO estudiante (matricula, id_Usuario) values (?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getMatricula());
            ps.setInt(2, est.getId_Usuario());
            int n = ps.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            return false;
        }
    }

    public DefaultTableModel listar() {
        DefaultTableModel modelo;

        String[] titulos = {"ID_ESTUDIANTE", "MATRICULA", "ID_USUARIO"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT e.id_Estudiante, e.matricula, e.id_Usuario from estudiante e INNER JOIN usuario u ON e.id_Usuario=u.id_Usuario";

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("id_Estudiante");
                registros[1] = rs.getString("matricula");
                registros[2] = rs.getString("id_Usuario");
                modelo.addRow(registros);

            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            return null;
        }
    }
    
    public boolean ModificarEstudiante(Estudiante es) {
        String sql = "UPDATE estudiante SET matricula=?, id_Usuario=? WHERE id_Estudiante=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, es.getMatricula());
            ps.setInt(2, es.getId_Usuario());
            ps.setInt(3, es.getId_Estudiante());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } 
    }
    
    public boolean buscar(Estudiante es) {
        String sql = "SELECT * FROM estudiante WHERE id_Estudiante=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, es.getId_Estudiante());          
            rs=ps.executeQuery();
            if (rs.next()) {
               es.setId_Estudiante(rs.getInt(1));
               es.setMatricula(rs.getString(2));  
               es.setId_Usuario(rs.getInt(3)); 
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
