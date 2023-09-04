/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.usuarios;

/**
 *
 * @author alexc
 */
public class CursoBase {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarCurso(Curso c) {
        String sql = "INSERT INTO curso (idioma) VALUES (?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getIdioma());           
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } 
    }
    
    public List ListarCurso() {
        List<Curso> ListaCurso = new ArrayList();
        String sql = "SELECT * FROM curso";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso cur = new Curso();
                cur.setId_Curso(rs.getInt("id_Curso"));
                cur.setIdioma(rs.getString("idioma"));
                
                ListaCurso.add(cur);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCurso;
    }
    
    public boolean ModificarCurso(Curso cu) {
        String sql = "UPDATE curso SET idioma=? WHERE id_Curso=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(2, cu.getId_Curso());
            ps.setString(1, cu.getIdioma());            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } 
    }
    
    public boolean buscar(Curso cu) {
        String sql = "SELECT * FROM curso WHERE id_Curso=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cu.getId_Curso());          
            rs=ps.executeQuery();
            if (rs.next()) {
               cu.setId_Curso(rs.getInt(1));
               cu.setIdioma(rs.getString(2));  
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
