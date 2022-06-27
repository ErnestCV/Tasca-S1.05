import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.n1ex5.GestioDirectoris;
import org.n1ex5.Persona;

public class SerialitzaTest {

    @Test
    void checkSerializedObject() {

        Persona persona = new Persona("Ernest", 30);

        GestioDirectoris gestioDirectoris = new GestioDirectoris();
        gestioDirectoris.serialitzaObjecte(persona, "test.ser");
        Persona persona1 = gestioDirectoris.deserialitzaObjectePersona("test.ser");

        assertThat(persona.getEdat()).isEqualTo(persona1.getEdat());
        assertThat(persona.getNom()).isEqualTo(persona1.getNom());

    }
}
