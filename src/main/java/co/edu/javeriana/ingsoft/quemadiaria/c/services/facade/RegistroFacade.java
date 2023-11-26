package co.edu.javeriana.ingsoft.quemadiaria.c.services.facade;


import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.ResponseDTO;

public interface RegistroFacade {

    ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO);

    public ResponseDTO<String> cancelarRegistro(String email, String motivo);
}
