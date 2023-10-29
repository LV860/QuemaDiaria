package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.ActualizarPerfil;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUpdateProfile implements Initializable {
    private MenuLogin mainApp;
    @FXML
    private ImageView profilePicture;
    @FXML
    private AnchorPane anchorPaneProfile;
    @FXML
    private Group cuenta1;
    @FXML
    private Group cuenta2;
    @FXML
    private AnchorPane setUpAccount;
    @FXML
    private Button setUpProfile;
    @FXML
    private TextField textAltura;
    @FXML
    private TextField textPeso;
    @FXML
    private ChoiceBox<String> textComplexion;
    @FXML
    private ChoiceBox<String> textObjetivo;

    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpAccount.setTranslateX(171);
        cuenta1.setVisible(true);
        cuenta2.setVisible(false);
        ObservableList<String> opcionesComplexion = FXCollections.observableArrayList("Delgada", "Normal", "Robusta");
        ObservableList<String> opcionesObjetivo = FXCollections.observableArrayList("Llegar al peso ideal de acuerdo a mi altura", "Adelgazar y tonificar mi cuerpo", "Ganar masa muscular");
        // Asignar la lista de elementos al ChoiceBox
        textComplexion.setItems(opcionesComplexion);
        textObjetivo.setItems(opcionesObjetivo);
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
    public void onMouseEnteredImageView(MouseEvent event) {
        this.anchorPaneProfile.setVisible(true);
    }
    @FXML
    public void onMouseExitedImageView(MouseEvent event) {
        this.anchorPaneProfile.setVisible(false);
    }
    @FXML
    public void changeProfilePhoto(MouseEvent event) throws MalformedURLException {
        // Realizar la acción de cambio de imagen aquí

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Mostrar el cuadro de diálogo para seleccionar una imagen
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            // Cargar la imagen seleccionada
            Image image = new Image(selectedFile.toURI().toURL().toExternalForm());

            // Asignar la imagen al ImageView
            profilePicture.setImage(image);

            // Establecer el tamaño fijo de 120x120
            profilePicture.setFitWidth(120);
            profilePicture.setFitHeight(120);
        }
    }

    @FXML
    public void onClickHome(ActionEvent event) {
        try {
            this.mainApp.showHomeScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickLogOut(ActionEvent event) {
        try {
            this.mainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickUpdateAccount(ActionEvent event) {
        try {
            this.mainApp.showUpdateProfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
