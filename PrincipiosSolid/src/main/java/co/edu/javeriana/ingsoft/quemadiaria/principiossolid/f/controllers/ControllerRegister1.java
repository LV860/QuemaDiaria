package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

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
        try {
            this.mainApp.mostrarPantallaRegistro2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onclickCancelar(ActionEvent actionEvent) {
        try {
            this.mainApp.mostrarPantallaLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
