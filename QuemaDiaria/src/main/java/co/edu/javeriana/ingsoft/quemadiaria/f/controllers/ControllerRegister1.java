package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.RegistroUsuarioDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;

import java.io.IOException;

public class ControllerRegister1 {
    public TextField nameBox;
    public TextField lastNameBox;
    public TextField documentBox;
    public TextField mailBox;
    private MenuLogin mainApp;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    public void onclickContinuar(ActionEvent actionEvent) {
        RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
        registroUsuarioDTO.setNombre(this.nameBox.getText());
        registroUsuarioDTO.setApellido(this.lastNameBox.getText());
        registroUsuarioDTO.setCorreo(this.mailBox.getText());
        registroUsuarioDTO.setNumeroDocumento(this.documentBox.getText());

        try {
            this.mainApp.showRegister2Screen(registroUsuarioDTO );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onclickCancelar(ActionEvent actionEvent) {
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
