package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;


import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.RegistroFacade;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.facade.SeguridadFacade;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    @FXML
    private TextField userBox;
    @FXML
    private TextField passwordBox;
    @FXML
    private Label lblInicioRechazado;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        txtRegistrar.setOnMouseClicked(this::onclickRegistrar);
    }

    @FXML
    public Credenciales onclickIngresar(ActionEvent actionEvent) {
        UsuarioArchivosRepositorio usuarioArchivosRepositorio = new UsuarioArchivosRepositorio();
        List<Usuario> listaUsuarios = usuarioArchivosRepositorio.consultarListaUsuarios();

        Credenciales credencialesUsuarioActivo = null;
        for (Usuario u : listaUsuarios) {
            if (u.getCredenciales().validarCredenciales(userBox.getText(), passwordBox.getText())) {
                credencialesUsuarioActivo = new Credenciales(userBox.getText(), passwordBox.getText());
                break;
            }
        }

        if (credencialesUsuarioActivo != null) {
            // Llama al método para establecer las credenciales del usuario activo
            mainApp.setCredencialesUsuarioActivo(credencialesUsuarioActivo);

            Platform.runLater(() -> {
                try {
                    this.mainApp.showHomeScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            Platform.runLater(() -> {
                lblInicioRechazado.setText("Credenciales inválidas");
                lblInicioRechazado.setStyle("-fx-text-fill: red;");
            });
        }
        return credencialesUsuarioActivo;
    }

    @FXML
    public void onclickRegistrar(MouseEvent mouseEvent) {
        try {
            this.mainApp.showRegister1Screen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}