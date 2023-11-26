package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;

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
