package org.n1ex5;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Ernest", 30);

        GestioDirectoris gestioDirectoris = new GestioDirectoris();

        gestioDirectoris.serialitzaObjecte(persona, "prova.ser");
        Persona persona1 = gestioDirectoris.deserialitzaObjectePersona("prova.ser");

    }
}