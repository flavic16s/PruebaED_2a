/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pul;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * La clase Persona representa a una persona.
 * Implementa la interfaz Comparable para permitir la comparación entre personas.
 */
public class Persona implements Comparable<Persona> {

    private Nif nif;
    private String nombre;
    private char genero;
    private LocalDate nacimiento;

    /**
     * Constructor predeterminado de la clase Persona.
     * Crea una persona con valores predeterminados para el NIF, nombre, género y fecha de nacimiento.
     */
    public Persona() {
        nif = new Nif();
        nombre = "";
        genero = ' ';
        nacimiento = LocalDate.of(1990, 1, 1);
    }

    /**
     * Constructor que crea una persona utilizando el NIF.
     * @param nif El número de identificación fiscal de la persona.
     */
    public Persona(int nif) {
        this();
        this.nif = new Nif(nif);
    }

    /**
     * Constructor que crea una persona con todos los atributos especificados.
     * @param nif El número de identificación fiscal de la persona.
     * @param nombre El nombre de la persona.
     * @param genero El género de la persona.
     * @param dia El día de nacimiento de la persona.
     * @param mes El mes de nacimiento de la persona.
     * @param ano El año de nacimiento de la persona.
     */
    public Persona(int nif, String nombre, char genero, int dia, int mes, int ano) {
        this.nif = new Nif(nif);
        this.nombre = nombre;
        this.genero = genero;
        this.nacimiento = LocalDate.of(ano, mes, dia);
    }

    /**
     * Obtiene el NIF de la persona.
     * @return El NIF de la persona.
     */
    public Nif getNif() {
        return nif;
    }

    /**
     * Establece el NIF de la persona.
     * @param nif El nuevo NIF de la persona.
     */
    public void setNif(Nif nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el género de la persona.
     * @return El género de la persona.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     * @param genero El nuevo género de la persona.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * @return La fecha de nacimiento de la persona.
     */
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param nacimiento La nueva fecha de nacimiento de la persona.
     */
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Obtiene la edad de la persona.
     * @return La edad de la persona.
     */
    public int getEdad() {
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    /**
     * Devuelve una representación en forma de cadena de la persona.
     * @return La representación en forma de cadena de la persona.
     */
    @Override
    public String toString() {
        if (nombre.split(" ").length > 1) {
            return nif + "\t" + nombre.split(" ")[0] + '\t' + nombre.split(" ")[1] + "\t\t" + getEdad();
        } else {
            return nif + "\t" + nombre + "\t\t\t" + getEdad();
        }
    }

    /**
     * Compara si dos personas son iguales.
     * @param a La persona con la que se compara.
     * @return true si las personas son iguales, false en caso contrario.
     */
    public boolean equals(Persona a) {
        if (a == null) {
            return false;
        }
        return a.nif.toString().equals(this.nif.toString());
    }

    /**
     * Compara si dos personas son iguales.
     * @param obj El objeto con el que se compara.
     * @return true si las personas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.nif, other.nif);
    }

    /**
     * Compara esta persona con otra persona.
     * @param o La persona con la que se compara.
     * @return Un valor negativo si el NIF es menor, 0 si son iguales, o un valor positivo si el NIF es mayor.
     */
    @Override
    public int compareTo(Persona o) {
        return this.nif.toString().compareTo(o.nif.toString());
    }
}
