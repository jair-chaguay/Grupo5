/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alexc
 */
public class Registro {
    int id_Registro;
    Date fecha_inicio;
    Date fecha_final;
    int id_Estudiante;
    int id_Curso;

    public Registro() {
    }

    public Registro(int id_Registro, Date fecha_inicio, Date fecha_final, int id_Estudiante, int id_Curso) {
        this.id_Registro = id_Registro;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.id_Estudiante = id_Estudiante;
        this.id_Curso = id_Curso;
    }

    public int getId_Registro() {
        return id_Registro;
    }

    public void setId_Registro(int id_Registro) {
        this.id_Registro = id_Registro;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public int getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(int id_Curso) {
        this.id_Curso = id_Curso;
    }
    
    
}
