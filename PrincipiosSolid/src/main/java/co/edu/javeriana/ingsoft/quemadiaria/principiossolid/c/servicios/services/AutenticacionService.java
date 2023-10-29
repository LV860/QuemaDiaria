package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.services;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.LoginDTO;

public class AutenticacionService {


    RealizarLogin realizarLogin;

    public AutenticacionService() {
        this.realizarLogin = new RealizarLogin(new UsuarioArchivosRepositorio());
    }
    public ResponseDTO<String> autenticarUsuario(LoginDTO loginDTO) {
        try {
            realizarLogin.login(loginDTO.getUsername(), loginDTO.getPassword());
            return new ResponseDTO<>(ResponseDTO.OK, "Login exitoso", "Login exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al hacer el login");
        }

    }
}
