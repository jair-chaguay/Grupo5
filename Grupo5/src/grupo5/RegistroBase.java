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
import modelo.Registro;

public class RegistroBase {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Registro reg) {
        String sql = "INSERT INTO registro (fecha_inicio, fecha_Final, id_Estudiante, id_Curso) values (?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(reg.getFecha_inicio().getTime()));
            ps.setDate(2, new java.sql.Date(reg.getFecha_final().getTime()));
            ps.setInt(3, reg.getId_Estudiante());
            ps.setInt(4, reg.getId_Curso());

            int n = ps.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public DefaultTableModel listar() {
        DefaultTableModel modelo;

        String[] titulos = {"ID_REGISTRO", "FECHA_INICIO", "FECHA_FINAL", "ID_ESTUDIANTE", "ID_CURSO"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT r.id_Registro, r.fecha_inicio, r.fecha_Final, r.id_Estudiante, r.id_Curso from registro r INNER JOIN estudiante e ON r.id_Estudiante=e.id_Estudiante INNER JOIN curso c ON r.id_Curso=c.id_Curso";

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("id_Registro");
                registros[1] = rs.getString("fecha_inicio");
                registros[2] = rs.getString("fecha_Final");
                registros[3] = rs.getString("id_Estudiante");
                registros[4] = rs.getString("id_Curso");
                modelo.addRow(registros);

            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean ModificarRegistro(Registro reg) {
        String sql = "UPDATE estudiante SET fecha_inicio=?, fecha_Final=?, id_Estudiante=?, id_Curso=? WHERE id_Registro=?";
        try {
            ps.setDate(1, new java.sql.Date(reg.getFecha_inicio().getTime()));
            ps.setDate(2, new java.sql.Date(reg.getFecha_final().getTime()));
            ps.setInt(3, reg.getId_Estudiante());
            ps.setInt(4, reg.getId_Curso());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean buscar(Registro reg) {
        String sql = "SELECT * FROM registro WHERE id_Registro=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, reg.getId_Registro());
            rs = ps.executeQuery();
            if (rs.next()) {
                reg.setId_Registro(rs.getInt(1));
                reg.setFecha_inicio(rs.getDate(2));
                reg.setFecha_final(rs.getDate(3));
                reg.setId_Estudiante(rs.getInt(4));
                reg.setId_Curso(rs.getInt(5));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
