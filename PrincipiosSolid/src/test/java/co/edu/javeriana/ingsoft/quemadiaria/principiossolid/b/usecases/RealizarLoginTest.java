package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealizarLoginTest {

    private RealizarLogin realizarLogin;
    private UsuarioRepositorio usuarioRepositorio;

    @BeforeEach
    void setUp() {
        usuarioRepositorio = new UsuarioArchivosRepositorio(); // Usar una implementación real de UsuarioRepositorio
        realizarLogin = new RealizarLogin(usuarioRepositorio);
    }

    @Test
    void testLoginWithValidCredentials(){
        // Agregar un usuario con credenciales válidas al repositorio
        Usuario usuario = new Usuario("12345678", "a.barrera@javeriana.edu.co", new Credenciales("a.barrera", "123456789"));
        usuario.setNombre("andres");
        usuario.setApellido("barrera");

        // Act & Assert
        assertDoesNotThrow(() -> realizarLogin.login(usuario.getCredenciales().getNombreUsuario(), usuario.getCredenciales().getContrasenna()));
    }

    @Test
    void testLoginWithInvalidCredentials() {
        // Arrange
        Usuario usuario = new Usuario("102012", "andres@javeriana.edu.co", new Credenciales("andresa.20", "12345"));
        usuario.setNombre("andres");
        usuario.setApellido("barrera");
        // Act & Assert
        QuemaDiariaException exception = assertThrows(QuemaDiariaException.class,
                () -> realizarLogin.login(usuario.getCredenciales().getNombreUsuario(), usuario.getCredenciales().getContrasenna()));

        // Assert the specific exception message
        assertFalse(exception.getMessage().contains("Credenciales invalidas"));
        assertEquals(QuemaDiariaException.ERROR_USUARIO_NO_ENCONTRADO, exception.getCodigo());
    }
}
