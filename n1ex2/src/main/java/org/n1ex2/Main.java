package org.n1ex2;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //String dirName = "C:\\Users\\ecv-s\\IdeaProjects\\Tasca-S1.05";

        GestioDirectoris gestioDirectoris = new GestioDirectoris();

        //Amb Java pur
        gestioDirectoris.mostraDirectorisRecursiuAlfabeticJava(args[0]);

        System.out.println();

        //Amb llibreria apache commons io
        gestioDirectoris.mostraDirectorisRecursiuAlfabeticApache(args[0]);

    }
}