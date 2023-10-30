package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;

public class RealizarLogin {

    private UsuarioRepositorio usuarioRepositorio;

    public RealizarLogin(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario login(String nombreUsuario, String contrasenna) {
        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(nombreUsuario);
        if (usuario.getCredenciales().validarCredenciales(nombreUsuario, contrasenna)) {
            return usuario;
        } else {
            throw new QuemaDiariaException(QuemaDiariaException.ERROR_CREDENCIALES_INVALIDAS, "Credenciales inválidas");
        }
    }
}
