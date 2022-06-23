package org.n1ex2;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String dirName = "C:\\Users\\formacio\\IdeaProjects\\Tasca-S1.05";

        GestioDirectoris gestioDirectoris = new GestioDirectoris();

        gestioDirectoris.mostraDirectorisRecursiuAlfabeticJava(dirName);

    }
}