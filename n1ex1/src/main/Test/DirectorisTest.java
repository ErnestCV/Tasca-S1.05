import static org.assertj.core.api.Assertions.*;

import n1ex1.GestioDirectori;
import org.junit.jupiter.api.Test;

public class DirectorisTest {

    @Test
    void compareDirectoryList() {

        GestioDirectori gestioDirectori = new GestioDirectori();

        assertThat(gestioDirectori.mostraDirectoriAlfabeticJava("C:\\Users\\ecv-s\\IdeaProjects")
                .equals(gestioDirectori.mostraDirectoriAlfabeticApache("C:\\Users\\ecv-s\\IdeaProjects")));

    }

}
