package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade;


import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.ResponseDTO;

public interface RegistroFacade {

    ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO);

    public ResponseDTO<String> cancelarRegistro(String email, String motivo);
}
