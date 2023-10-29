package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.e.interfaces.main;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.RegistroFacade;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.SeguridadFacade;

public class MenuRegistro {

    RegistroFacade seguridadFacade = new SeguridadFacade();

    public void registrarUsuario() {
        //registroUsuarioDTO.setNumeroDocumento("123456789");

        RegistroUsuarioDTO registroUsuarioDTO = null;
        seguridadFacade.registrarUsuario(registroUsuarioDTO);
        //seguridadFacade.
    }

    public static void main(String[] args) {
        System.out.println("Menu Registro");
    }
}
