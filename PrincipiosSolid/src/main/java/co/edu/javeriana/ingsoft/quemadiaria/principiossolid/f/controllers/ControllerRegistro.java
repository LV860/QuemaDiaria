package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.CifrarTexto;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControllerRegistro {

    private MenuLogin mainApp;
    @javafx.fxml.FXML
    private TextField nameUserBox;
    @javafx.fxml.FXML
    private Button btnConfirmar;
    @javafx.fxml.FXML
    private Button btnCancelar;
    @javafx.fxml.FXML
    private TextField passwordBox;
    @javafx.fxml.FXML
    private TextField nameBox;
    @javafx.fxml.FXML
    private TextField apellidoBox;
    @javafx.fxml.FXML
    private TextField correoBox;
    @javafx.fxml.FXML
    private Label txtConfirmacion;
    @javafx.fxml.FXML
    private TextField documentoBox;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @javafx.fxml.FXML
    public void onclickConfirmar(ActionEvent actionEvent) throws IOException {
        UsuarioRepositorio usuarioRepositorio = new UsuarioArchivosRepositorio();
        Usuario usuarioNuevo = new Usuario(documentoBox.getText(), correoBox.getText(), new Credenciales(nameUserBox.getText(), passwordBox.getText()));
        usuarioNuevo.setNombre(nameBox.getText());
        usuarioNuevo.setApellido(apellidoBox.getText());
        usuarioRepositorio.guardarUsuario(usuarioNuevo);
        this.mainApp.mostrarPantallaLogin();
    }

    @javafx.fxml.FXML
    public void onclickCancelar(ActionEvent actionEvent) throws IOException {
        this.mainApp.mostrarPantallaLogin();
    }
}
