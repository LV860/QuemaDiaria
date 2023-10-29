package co.edu.javeriana.ingsoft.quemadiaria.principiossolid;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class MenuLogin extends Application {

    private Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println("leo 2");
        this.primaryStage = primaryStage;
        showLoginScreen();

    }

    public void showLoginScreen() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        ControllerLogin inicioSesionController = loader.getController();
        inicioSesionController.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRegister1Screen() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register1.fxml"));
        Parent root = loader.load();
        ControllerRegister1 controllerRegistro1 = loader.getController();
        controllerRegistro1.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRegister2Screen() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register2.fxml"));
        Parent root = loader.load();
        ControllerRegister2 controllerRegistro2 = loader.getController();
        controllerRegistro2.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showHomeScreen() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        ControllerHome controllerHome = loader.getController();
        controllerHome.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showUpdateProfile() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/javeriana/ingsoft/quemadiaria/principiossolid/UpdateProfile.fxml"));
        Parent root = loader.load();
        ControllerUpdateProfile controllerUpdateProfile = loader.getController();
        controllerUpdateProfile.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
