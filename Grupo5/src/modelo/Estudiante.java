/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alexc
 */
public class Estudiante {
    int id_Estudiante;
    String matricula;
    int id_Usuario;
    
    public Estudiante(){
        
    }
    
    public Estudiante(int id_Estudiante, String matricula, int id_Usuario){
        this.id_Estudiante=id_Estudiante;
        this.matricula=matricula;
        this.id_Usuario=id_Usuario;
    }

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
    
    
}
