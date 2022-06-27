package n1ex1;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Fem el mateix amb llibreries de Java i també d'Apache Commons IO

        GestioDirectori gestioDirectori = new GestioDirectori();

        List<File> directorisListJava = gestioDirectori.mostraDirectoriAlfabeticJava(args[0]);
        directorisListJava.forEach(System.out::println);

        System.out.println();

        List<File> directorisListApache = gestioDirectori.mostraDirectoriAlfabeticApache(args[0]);
        directorisListApache.forEach(System.out::println);

    }

}
