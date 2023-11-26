package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
import com.google.gson.Gson;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerRemoveAccount implements Initializable {
    private MenuLogin mainApp;
    private Command helpCommand;
    private Command homeCommand;
    private Command settingsCommand;
    private Command updateProfileCommand;
    private Command logOutCommand;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private Text textUser;
    @FXML
    private Text textMail;


    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
        this.helpCommand = new HelpCommand(mainApp);
        this.homeCommand = new HomeCommand(mainApp);
        this.settingsCommand = new SettingsCommand(mainApp);
        this.updateProfileCommand = new UpdateProfileCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpAccount.setTranslateX(171);
        cuenta1.setVisible(true);
        cuenta2.setVisible(false);
    }

    public void loadUserData(Credenciales credencialesUsuarioActivo) {
        try (FileReader reader = new FileReader("Usuarios.json")) {
            Gson gson = new Gson();
            Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);

            Usuario usuarioEnSesion = null;
            for (Usuario usuario : usuarios) {
                if (usuario.getCredenciales().getNombreUsuario().equals(credencialesUsuarioActivo.getNombreUsuario())) {
                    usuarioEnSesion = usuario;
                    break;
                }
            }
            if (usuarioEnSesion != null) {
                textUser.setText(usuarioEnSesion.getCredenciales().getNombreUsuario());
                textMail.setText(usuarioEnSesion.getCorreo());
            } else {
                System.out.println("Usuario activo no encontrado en el archivo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void animateAndSetVisible(TranslateTransition slide, double toX, Group groupToShow, Group groupToHide) {
        Command Animationcommand = new AnimationVisibilityCommand(slide, toX, groupToShow, groupToHide);
        Animationcommand.execute();
    }

    @FXML
    public void onclickCuenta2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), setUpAccount);
        animateAndSetVisible(slide, 342, cuenta1, cuenta2);
    }

    @FXML
    public void onclickCuenta1(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), setUpAccount);
        animateAndSetVisible(slide, 0, cuenta2, cuenta1);
    }

    @FXML
    public void onMouseEntered(MouseEvent event) {
        Button boton = (Button) event.getSource();
        boton.setStyle("-fx-font-weight: bold; -fx-background-color: transparent;");
    }

    @FXML
    public void onMouseExited(MouseEvent event) {
        Button boton = (Button) event.getSource();
        boton.setStyle("-fx-font-weight: normal; -fx-background-color: transparent;");
    }

    @FXML
    public void onClickHome(ActionEvent event) { homeCommand.execute(); }

    @FXML
    public void onClickLogOut() { logOutCommand.execute(); }

    @FXML
    public void onClickUpdateProfile() { updateProfileCommand.execute(); }

    @FXML
    public void onClickSettings() { settingsCommand.execute(); }

    @FXML
    public void onClickHelp() { helpCommand.execute(); }

}
