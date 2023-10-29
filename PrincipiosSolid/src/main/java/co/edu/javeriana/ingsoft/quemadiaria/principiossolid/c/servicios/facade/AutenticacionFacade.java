package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.LoginDTO;

public interface AutenticacionFacade {

    ResponseDTO<String> login(LoginDTO loginDTO);
    ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna);
}
