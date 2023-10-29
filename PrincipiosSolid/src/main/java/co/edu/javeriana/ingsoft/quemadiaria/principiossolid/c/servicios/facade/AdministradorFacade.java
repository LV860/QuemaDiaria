package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.LoginDTO;

public interface AdministradorFacade {

    ResponseDTO<String> login(LoginDTO loginDTO);
    ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna);

    ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO);

    public ResponseDTO<String> cancelarRegistro(String email, String motivo);
}
