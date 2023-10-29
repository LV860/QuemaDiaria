package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioArchivosRepositorioTest {

    private UsuarioRepositorio repositorio;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp() {
        repositorio = new UsuarioArchivosRepositorio();

        // Crea usuarios de prueba
        usuario1 = new Usuario("10734894389", "usuario1@javeriana.edu.co", new Credenciales("user1", "contrasenia1"));
        usuario2 = new Usuario("73298932893", "usuario2@javeriana.edu.co", new Credenciales("user2", "contrasenia2"));
    }

    @Test
    void guardarUsuarioYConsultarListaUsuarios() {
        // Arrange
        repositorio.guardarUsuario(usuario1);
        List<Usuario> usuarios = repositorio.consultarListaUsuarios();
        // Act and Assert
        assertFalse(usuarios.isEmpty());
        assertTrue(usuarios.contains(usuario1));
    }

    @Test
    void consultarUsuarioPorUserName() {
        // Arrange
        repositorio.guardarUsuario(usuario1);
        repositorio.guardarUsuario(usuario2);

        // Act
        Usuario usuarioEncontrado = repositorio.consultarUsuarioPorUserName("usuario1");

        // Assert
        assertEquals(usuario1, usuarioEncontrado);
    }

    @Test
    void consultarUsuarioPorUserNameUsuarioNoEncontrado() {
        // Act
        repositorio.guardarUsuario(usuario1);

        // Assert
        assertThrows(QuemaDiariaException.class, () -> {
            repositorio.consultarUsuarioPorUserName("usuario3");
        });
    }
}
