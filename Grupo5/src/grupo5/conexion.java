/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class conexion {
    Connection con;
    String bd="grupo5";
    String url="jdbc:mysql://localhost:3306/"+bd;
    String user="root";
    String pass="Alex@1903";
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return con;
    }
}
