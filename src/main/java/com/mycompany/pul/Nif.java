/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pul;

/**
 * Representacion de las personas matriculadas en el curso
 * @author flavich16
 * @version 1.0
 */
public class Nif {

    private int numero;
    private char letra;

    //CONSTANTE: no accesible - compartido por todo - no modificable
    private static final char[] LETRAS
            = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                'C', 'K', 'E'};
    /*
     Funcion que determina la letra de verificacion basada en el numero del NIF
    @param numero El numero del NIF usado para el calculo
    @return La letra asociada al numero proporcionado
    */
    private static char calcularLetra(int numero) {
        return LETRAS[numero % 23];
    }
    /*Constructor de la clase NIF que inicializa el numero 0 y la letra en vacio*/
    protected Nif() {
        this.numero = 0;
        this.letra = ' ';
    }
    /**
    * Constructor que posibilita la creación de un NIF con un número específico
    * @param numero Un entero que se utiliza para calcular la letra del NIF
    */
    protected Nif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }
    /**
     * Devuelve el NIF como texto
     * @return Representación en forma de cadena de caracteres
     */
    @Override
    public String toString() {
        return numero + "-" + letra;
    }
    /**
     * Método setter que facilita la modificación del NIF existente.
     * La letra se recalcula automáticamente.
     * @param numero El nuevo número de identificación fiscal
     */
    protected void setNif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }
    /**
     * Método que compara este NIF con otro objeto.
     * @param obj El objeto con el que se compara este NIF
     * @return true si los NIF son iguales, false en caso contrario
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
        final Nif other = (Nif) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return this.letra == other.letra;
    }
}

