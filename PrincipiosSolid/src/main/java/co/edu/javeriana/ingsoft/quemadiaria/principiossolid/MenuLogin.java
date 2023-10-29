package co.edu.javeriana.ingsoft.quemadiaria.principiossolid;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers.ControllerLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers.ControllerRegister1;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers.ControllerRegister2;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers.ControllerRegistro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MenuLogin extends Application {

    private Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        mostrarPantallaLogin();
    }

    public void mostrarPantallaLogin() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            ControllerLogin inicioSesionController = loader.getController();
            inicioSesionController.setMainApp(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaRegistro1() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register1.fxml"));
            Parent root = loader.load();
            ControllerRegister1 controllerRegistro1 = loader.getController();
            controllerRegistro1.setMainApp(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaRegistro2() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register2.fxml"));
            Parent root = loader.load();
            ControllerRegister2 controllerRegistro2 = loader.getController();
            controllerRegistro2.setMainApp(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*public void login() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("a.barrera");
        loginDTO.setPassword("123456789");

        ResponseDTO<String> respuesta = seguridadFacade.login(loginDTO);
        System.out.println(respuesta.getCodigo() == ResponseDTO.OK ? "Login exitoso" : "Login fallido");
    }*/

}
