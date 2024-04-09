/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pul;

/**
 *
 * @author Usuario
 */
import java.util.TreeSet;

/**
 * Esta es la clase donde se representa un curso donde se matriculan las personas
 * @author flavich16
 * version 1.0
 */
public class Curso {

    private String nombre;
    private TreeSet<Persona> listaAlumnos;
    /*
    
    Metodo getter para poder obetner el nombre del curso
    *@return El nombre del curso
    */

    protected String getNombre() {
        return nombre;
    }
    /*Constructorque tiene que crear un instancia de curso con un nombre dado*
    @param nombre Este es el nombre que se asignara al curso*/
    public Curso(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new TreeSet<>();
    }
     /**
     * Genera una representación en forma de cadena del objeto Curso.
     * @return Una representación en cadena del curso y sus alumnos.
     */
    @Override
    public String toString() {
        String s = "--------------------" + nombre + "-----------------\n";
        s += "NumExp\tNIF\t\tNombre\t\tApellidos\n";
        s += "-------------------------------------------------\n";
        for (Persona listaAlumno : listaAlumnos) {
            s += listaAlumno + "\n";
        }
        return s;
    }
    /**
     * Añade un nuevo alumno al curso.
     * @param p El alumno que se va a añadir.
     */
    public void aniadirAlumno(Persona p) {
        listaAlumnos.add(p);
    }
}
