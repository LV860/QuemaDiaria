package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerRegister2 {
    public TextField nameUserBox;
    public PasswordField passwordBox;
    public Text txtIniciarSesion;
    private MenuLogin mainApp;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        txtIniciarSesion.setOnMouseClicked(this::onclickIniciarSesion);
    }

    public void onclickRegistrarse(ActionEvent actionEvent) {
        System.out.println("hola");
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onclickIniciarSesion(MouseEvent mouseEvent) {
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
