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

//https://dev.mysql.com/downloads/connector/j/
//https://toedter.com/jcalendar/
//https://www.mediafire.com/file/c8e9i5t0epz1jfs/flatlaf-intellij-themes-3.1.1.jar/file
//https://www.mediafire.com/file/b58esnqyc599wf1/flatlaf-3.1.1.jar/file

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
