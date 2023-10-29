package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.RegistrarUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrarUsuarioTest {

    private RegistrarUsuario registrarUsuario;
    private UsuarioRepositorio usuarioRepositorio;

    @BeforeEach
    void setUp() {
        usuarioRepositorio = new UsuarioRepositorioEnMemoria();
        registrarUsuario = new RegistrarUsuario(usuarioRepositorio);
    }

    @Test
    void registrarUsuario() {
        // Arrange
        Usuario usuario = new Usuario("10734894389", "usuario1@javeriana.edu.co", new Credenciales("user1", "contrasenia1"));
        registrarUsuario.registrarUsuario(usuario);
        List<Usuario> usuarios = ((UsuarioRepositorioEnMemoria) usuarioRepositorio).getUsuarios();
        // Act and Assert
        assertEquals(1, usuarios.size());
        assertEquals(usuario, usuarios.get(0));
    }

    // Clase de repositorio de usuario en memoria para pruebas
    private static class UsuarioRepositorioEnMemoria implements UsuarioRepositorio {
        private List<Usuario> usuarios = new ArrayList<>();

        @Override
        public void guardarUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        @Override
        public List<Usuario> consultarListaUsuarios() {
            return new ArrayList<>(usuarios);
        }

        @Override
        public Usuario consultarUsuarioPorUserName(String userName) {
            return usuarios.stream()
                    .filter(usuario -> usuario.getCredenciales().getNombreUsuario().equals(userName))
                    .findFirst()
                    .orElse(null);
        }

        List<Usuario> getUsuarios() {
            return usuarios;
        }
    }
}
