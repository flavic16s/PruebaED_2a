/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pul;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void testConstructorPredeterminado() {
        Persona persona = new Persona();
        assertEquals("", persona.getNombre());
        assertEquals(' ', persona.getGenero());
        assertNotNull(persona.getNacimiento()); // Verifica que la fecha de nacimiento no sea nula
    }

    @Test
    public void testConstructorConNif() {
        int nifValue = 123456789;
        Persona persona = new Persona(nifValue);
        assertEquals(nifValue, persona.getNif());
    }

    @Test
    public void testConstructorConAtributos() {
        int nifValue = 123456789;
        String nombre = "Juan Perez";
        char genero = 'M';
        int dia = 15;
        int mes = 6;
        int ano = 1985;

        Persona persona = new Persona(nifValue, nombre, genero, dia, mes, ano);
        assertEquals(nifValue, persona.getNif());
        assertEquals(nombre, persona.getNombre());
        assertEquals(genero, persona.getGenero());
        assertEquals(LocalDate.of(ano, mes, dia), persona.getNacimiento());
    }

    @Test
    public void testEquals() {
        int nifValue1 = 123456789;
        int nifValue2 = 987654321;
        Persona persona1 = new Persona(nifValue1);
        Persona persona2 = new Persona(nifValue2);
        assertTrue(persona1.equals(persona1)); // Compara una persona consigo misma
        assertTrue(persona1.equals(new Persona(nifValue1))); // Compara la misma persona con un objeto igual
        assertFalse(persona1.equals(persona2)); // Compara dos personas con NIFs diferentes
        assertFalse(persona1.equals(null)); // Compara una persona con null
    }

    @Test
    public void testToString() {
        int nifValue = 123456789;
        String nombre = "Juan Perez";
        char genero = 'M';
        int dia = 15;
        int mes = 6;
        int ano = 1985;

        Persona persona = new Persona(nifValue, nombre, genero, dia, mes, ano);
        String expectedToString = nifValue + "\t" + "Juan" + '\t' + "Perez" + "\t\t" + persona.getEdad();
        assertEquals(expectedToString, persona.toString());
    }

    @Test
    public void testCompareTo() {
        int nifValue1 = 123456789;
        int nifValue2 = 987654321;
        Persona persona1 = new Persona(nifValue1);
        Persona persona2 = new Persona(nifValue2);

        assertTrue(persona1.compareTo(persona2) < 0); // Compara dos personas con NIFs diferentes
        assertTrue(persona2.compareTo(persona1) > 0); // Compara dos personas con NIFs diferentes
        assertEquals(0, persona1.compareTo(new Persona(nifValue1))); // Compara una persona consigo misma
    }
}

