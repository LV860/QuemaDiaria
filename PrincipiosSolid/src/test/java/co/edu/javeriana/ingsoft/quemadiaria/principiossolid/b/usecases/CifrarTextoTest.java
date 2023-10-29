package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CifrarTextoTest {

    @Test
    void testEncodeToBase64URLSafeAndDecodeFromBase64URLSafe() {
        // Arrange
        CifrarTexto cifrador = new CifrarTexto();

        String textoOriginal = "Este es un texto de prueba.";

        String textoCifrado = cifrador.encodeToBase64URLSafe(textoOriginal);

        String textoDescifrado = cifrador.decodeFromBase64URLSafe(textoCifrado);
        // Act and Assert
        assertEquals(textoOriginal, textoDescifrado);
    }
}
