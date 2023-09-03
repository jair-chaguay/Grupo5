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

/**
 *
 * @author alexc
 */
public class Querys {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public DefaultTableModel Consulta() {
        DefaultTableModel modelo;
        String[] titulos = {"ID_USUARIO", "USUARIO", "NOMBRE", "APELLIDO", "CORREO", "CONTRASEÑA", "ID_ESTUDIANTE", "MATRICULA", "ID_USUARIO", "ID_CURSO", "ID_IDIOMA"};
        String[] registros = new String[11];
        modelo = new DefaultTableModel(null, titulos);
        String sql = "select * from usuario u Inner join (estudiante e , curso c) on (u.id_Usuario=e.id_Estudiante and e.id_Estudiante=c.id_Curso)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("id_Usuario");
                registros[1] = rs.getString("Usuario");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("apellido");
                registros[4] = rs.getString("correo");
                registros[5] = rs.getString("contraseña");
                registros[6] = rs.getString("id_Estudiante");
                registros[7] = rs.getString("matricula");
                registros[8] = rs.getString("id_Usuario");
                registros[9] = rs.getString("id_Curso");
                registros[10] = rs.getString("idioma");

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
}
