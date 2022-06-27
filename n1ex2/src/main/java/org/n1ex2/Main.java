package org.n1ex2;

public class Main {

    public static void main(String[] args) {

        GestioDirectoris gestioDirectoris = new GestioDirectoris();

        //Amb llibreria apache commons io
        gestioDirectoris.mostraDirectorisRecursiuAlfabetic(args[0]);

    }
}