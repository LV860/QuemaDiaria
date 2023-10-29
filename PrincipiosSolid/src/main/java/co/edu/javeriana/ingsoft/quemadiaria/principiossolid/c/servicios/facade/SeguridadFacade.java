package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.services.AutenticacionService;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.services.RegistroUsuarioService;

public class SeguridadFacade implements AutenticacionFacade, RegistroFacade, AdministradorFacade {

    private RegistroUsuarioService registroUsuarioService;
    private AutenticacionService autenticacionService = new AutenticacionService();

    @Override
    public ResponseDTO<String> login(LoginDTO loginDTO) {
        return autenticacionService.autenticarUsuario(loginDTO);
    }

    @Override
    public ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        return registroUsuarioService.registrarUsuario(registroUsuarioDTO);
    }

    @Override
    public ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna) {
        return null;//autenticacionService.cambiarContrasenna(usuario, contrasenna);
    }

    @Override
    public ResponseDTO<String> cancelarRegistro(String email, String motivo) {
        return null;//autenticacionService.recuperarContrasenna(usuario);
    }


}
