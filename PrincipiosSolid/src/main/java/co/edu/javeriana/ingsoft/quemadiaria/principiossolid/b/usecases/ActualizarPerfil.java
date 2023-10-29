package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;

import java.io.IOException;

public class ActualizarPerfil {
    private UsuarioRepositorio usuarioRepositorio;

    public ActualizarPerfil(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void updatePerfil(int altura, int peso, String complexion, String objetivo, Usuario usuarioActual) {
        Perfil usuarioPerfil = new Perfil(altura, peso, complexion, objetivo);

        usuarioRepositorio.actualizarPerfil(usuarioPerfil, usuarioActual);
        System.out.println("Perfil del usuario actualizado correctamente.");
    }
}
