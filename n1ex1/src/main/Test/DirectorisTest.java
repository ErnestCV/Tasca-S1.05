import static org.assertj.core.api.Assertions.*;

import n1ex1.GestioDirectori;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class DirectorisTest {

    @Test
    void compareDirectoryList() {

        GestioDirectori gestioDirectori = new GestioDirectori();

        List<File> directorisListJava = gestioDirectori.mostraDirectoriAlfabeticJava("C:\\Users\\ecv-s\\IdeaProjects");
        List<File> directorisListApache = gestioDirectori.mostraDirectoriAlfabeticApache("C:\\Users\\ecv-s\\IdeaProjects");
        directorisListApache.remove(0); //Hem d'eliminar el primer element, el directori parent

        assertThat(directorisListJava.equals(directorisListApache)).isTrue();

    }

}
