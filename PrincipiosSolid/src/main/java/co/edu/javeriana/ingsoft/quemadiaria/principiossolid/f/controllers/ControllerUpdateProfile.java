package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.ActualizarPerfil;
import com.google.gson.Gson;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
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
    private TextField textPeso;
    @FXML
    private TextField textAltura;
    @FXML
    private ChoiceBox<String> textComplexion;
    @FXML
    private ChoiceBox<String> textObjetivo;
    @FXML
    private Text textNombre;
    @FXML
    private Text textApellido;
    @FXML
    private Text textNumIdentidad;
    @FXML
    private Text textCorreo;


    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("Initialize method is called.");
            loadUserData();
            setUpAccount.setTranslateX(171);
            cuenta1.setVisible(true);
            cuenta2.setVisible(false);
            ObservableList<String> opcionesComplexion = FXCollections.observableArrayList("Delgada", "Normal", "Robusta");
            ObservableList<String> opcionesObjetivo = FXCollections.observableArrayList("Llegar al peso ideal de acuerdo a mi altura", "Adelgazar y tonificar mi cuerpo", "Ganar masa muscular");
            // Asignar la lista de elementos al ChoiceBox
            textComplexion.setItems(opcionesComplexion);
            textObjetivo.setItems(opcionesObjetivo);
        } catch (Exception e) {
            e.printStackTrace();
        };
    }

    private void loadUserData() {
        try (FileReader reader = new FileReader("Usuarios.json")) {
            Gson gson = new Gson();
            Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);

            // Ahora, tienes un array de objetos Usuario que puedes procesar según tus necesidades.

            // Por ejemplo, puedes recorrer los usuarios:
            for (Usuario usuario : usuarios) {
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellido: " + usuario.getApellido());
                // Resto de los campos
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void onClickUpdate(ActionEvent event) {
        try {
            this.mainApp.showUpdateProfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickSave(ActionEvent event) {

        String peso = textPeso.getText();
        String altura = textAltura.getText();
        String complexion = textComplexion.getValue();
        String objetivo = textObjetivo.getValue();

        // Muestra una alerta de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Actualizar datos");
        alert.setHeaderText("Datos actualizados correctamente");

        ButtonType confirmButton = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == confirmButton) {
            try {
                this.mainApp.showHomeScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.mainApp.showUpdateProfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
