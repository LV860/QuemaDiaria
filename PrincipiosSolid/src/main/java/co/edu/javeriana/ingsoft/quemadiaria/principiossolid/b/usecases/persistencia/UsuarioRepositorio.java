package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;

import java.util.List;

public interface UsuarioRepositorio {


    void guardarUsuario(Usuario listaUsuarios);

    List<Usuario> consultarListaUsuarios();

    Usuario consultarUsuarioPorUserName(String username);

    void actualizarPerfil(Perfil usuarioPerfil, Usuario usuarioActual);
}
