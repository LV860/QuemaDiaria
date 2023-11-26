package co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;

import java.util.List;

public interface UsuarioRepositorio {


    void guardarUsuario(Usuario listaUsuarios);

    List<Usuario> consultarListaUsuarios();

    Usuario consultarUsuarioPorUserName(String username);

    Usuario consultarUsuarioPorUserName2(String userName);

    void actualizarContrasennaUsuario(String nombreUsuario, String nuevaContrasenna);

    void actualizarPerfil(Perfil usuarioPerfil, Usuario usuarioActual);

}
