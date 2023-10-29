package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;

public class ConsultarUsuario {
    UsuarioRepositorio usuarioRepositorio;

    public ConsultarUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

}
