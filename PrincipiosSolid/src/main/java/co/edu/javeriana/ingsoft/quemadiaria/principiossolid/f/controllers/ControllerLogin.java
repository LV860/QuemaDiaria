package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;


import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.RegistroFacade;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.SeguridadFacade;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class ControllerLogin {

    public Text txtRegistrar;
    private MenuLogin mainApp;
    RegistroFacade seguridadFacade = new SeguridadFacade();
    @javafx.fxml.FXML
    private TextField userBox;
    @javafx.fxml.FXML
    private TextField passwordBox;
    @javafx.fxml.FXML
    private Label lblInicioRechazado;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @javafx.fxml.FXML
    public void initialize() {
        txtRegistrar.setOnMouseClicked(this::onclickRegistrar);
    }

    @javafx.fxml.FXML
    public void onclickIngresar(ActionEvent actionEvent) {
        UsuarioArchivosRepositorio usuarioArchivosRepositorio = new UsuarioArchivosRepositorio();
        List<Usuario> listaUsuarios = usuarioArchivosRepositorio.consultarListaUsuarios();

        boolean credencialesValidas = false;
        for (Usuario u : listaUsuarios) {
            if (u.getCredenciales().validarCredenciales(userBox.getText(), passwordBox.getText())) {
                credencialesValidas = true;
                break;
            }
        }

        if (credencialesValidas) {
            Platform.runLater(() -> {
                lblInicioRechazado.setText("Credenciales válidas");
            });
        } else {
            Platform.runLater(() -> {
                lblInicioRechazado.setText("Credenciales inválidas");
            });
        }
    }

    @javafx.fxml.FXML
    public void onclickRegistrar(MouseEvent mouseEvent) {
        try {
            this.mainApp.mostrarPantallaRegistro1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
