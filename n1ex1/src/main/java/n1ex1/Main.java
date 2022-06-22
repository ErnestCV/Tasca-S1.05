package n1ex1;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //"C:\Users\ecv-s\IdeaProjects\Tasca-S1.05\n1ex1\src\main\java\n1ex1\Main.java"

        GestioDirectori gestioDirectori = new GestioDirectori();

        List<File> directorisListJava = gestioDirectori.mostraDirectoriAlfabeticJava("C:\\Users\\ecv-s\\IdeaProjects");
        directorisListJava.forEach(System.out::println);
        List<File> directorisListApache = gestioDirectori.mostraDirectoriAlfabeticApache("C:\\Users\\ecv-s\\IdeaProjects");
        directorisListApache.forEach(System.out::println);

    }

}
