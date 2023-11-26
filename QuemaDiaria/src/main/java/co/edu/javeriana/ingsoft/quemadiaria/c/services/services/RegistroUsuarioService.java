package co.edu.javeriana.ingsoft.quemadiaria.c.services.services;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.RegistrarUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;

public class RegistroUsuarioService {

    private static int cantUsuarios;
    public ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        if (registroUsuarioDTO == null ) {
            throw new IllegalArgumentException("Invalido registroUsuarioDTO");
        }
        try {

            UsuarioArchivosRepositorio usuarioArchivosRepositorio = new UsuarioArchivosRepositorio();
            RegistrarUsuario registrarUsuario = new RegistrarUsuario(usuarioArchivosRepositorio);
            /*
            CifrarTexto cifrado = new CifrarTexto();
            String contraCifrada = cifrado.encodeToBase64URLSafe(registroUsuarioDTO.getLogin().getPassword());
             */
            Credenciales credenciales = new Credenciales(registroUsuarioDTO.getLogin().getUsername(), registroUsuarioDTO.getLogin().getPassword());
            Usuario usuario = new Usuario(registroUsuarioDTO.getNumeroDocumento(), registroUsuarioDTO.getCorreo(), credenciales);
            usuario.setNombre(registroUsuarioDTO.getNombre());
            usuario.setApellido(registroUsuarioDTO.getApellido());
            registrarUsuario.registrarUsuario(usuario);

            cantUsuarios +=1;

            String res = usuario.getNombre() + "se ha agregado al repositorio al usuario " + Integer.toString(cantUsuarios);
            ResponseDTO<String> responseDTO= new ResponseDTO(200,"Registro Exitoso", res);

            return responseDTO;
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al hacer el registro");
        }

    }
}
