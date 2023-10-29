package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.e.interfaces.main;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.LoginDTO;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.AdministradorFacade;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.SeguridadFacade;

public class MenuAdministrador {

    AdministradorFacade seguridadFacade = new SeguridadFacade();

    public void registrarUsuario() {
        RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
        registroUsuarioDTO.setNumeroDocumento("123456789");

        seguridadFacade.registrarUsuario(registroUsuarioDTO);
    }

    public void login() {
        LoginDTO loginDTO = new LoginDTO();
        //loginDTO.setUsuario("123456789");
        //loginDTO.setContrasenna("123456789");

        seguridadFacade.login(loginDTO);
        //seguridadFacade
    }

    public static void main(String[] args) {
        System.out.println("Menu Administrador");

    }

}
