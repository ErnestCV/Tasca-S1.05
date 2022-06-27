import static org.assertj.core.api.Assertions.*;

import n1ex1.GestioDirectori;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class DirectorisTest {

    @Test
    void compareDirectoryList() {

        String dirName = "C:\\Users\\formacio\\IdeaProjects";
        GestioDirectori gestioDirectori = new GestioDirectori();

        List<File> directorisListJava = gestioDirectori.mostraDirectoriAlfabeticJava(dirName);
        List<File> directorisListApache = gestioDirectori.mostraDirectoriAlfabeticApache(dirName);
        directorisListApache.remove(0); //Hem d'eliminar el primer element, el directori parent

        assertThat(directorisListJava.equals(directorisListApache)).isTrue();

    }
}
