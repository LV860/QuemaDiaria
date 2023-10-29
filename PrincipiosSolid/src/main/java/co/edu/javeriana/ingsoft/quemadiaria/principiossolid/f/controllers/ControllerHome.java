package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerHome implements Initializable {
    private MenuLogin mainApp;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private Button setUpProfile;
    @FXML
    private Button logOut;

    public void setMainApp(MenuLogin mainApp) {this.mainApp = mainApp;}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpAccount.setTranslateX(171);
        cuenta1.setVisible(true);
        cuenta2.setVisible(false);
    }

    private void animateAndSetVisible(TranslateTransition slide, double toX, Group groupToShow, Group groupToHide) {
        slide.setToX(toX);
        slide.play();

        slide.setOnFinished((ActionEvent e) -> {
            groupToShow.setVisible(true);
            groupToHide.setVisible(false);
        });
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
    public void onClickLogOut() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Estás seguro de que deseas cerrar la sesión?");

        ButtonType confirmButton = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == confirmButton) {
            try {
                this.mainApp.showLoginScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //validación de credenciales o problemas para cerrar sesión
        }
    }
    @FXML
    public void onClickUpdateProfile() {
        try {
            this.mainApp.showUpdateProfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
