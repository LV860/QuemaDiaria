package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;


public class RegistrarUsuario {
    private UsuarioRepositorio usuarioRepositorio;

    public RegistrarUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.guardarUsuario(usuario);
    }
}
