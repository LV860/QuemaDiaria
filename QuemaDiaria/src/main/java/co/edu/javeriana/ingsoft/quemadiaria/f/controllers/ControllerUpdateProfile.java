package co.edu.javeriana.ingsoft.quemadiaria.f.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.ActualizarPerfil;
import co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files.UsuarioArchivosRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;
import co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command.*;
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
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class ControllerUpdateProfile implements Initializable {
    private MenuLogin mainApp;
    private Command helpCommand;
    private Command homeCommand;
    private Command settingsCommand;
    private Command logOutCommand;
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
    private TextField textPeso;
    @FXML
    private TextField textAltura;
    @FXML
    private ChoiceBox<String> textComplexion;
    @FXML
    private ChoiceBox<String> textObjetivo;
    @FXML
    private Text textNombreNEW;
    @FXML
    private Text textApellidoNEW;
    @FXML
    private Text textNumIdentidadNEW;
    @FXML
    private Text textCorreoNEW;
    private Credenciales usuarioActivo;
    private List<Usuario> usuarios;
    private ActualizarPerfil actualizarPerfil;

    public ControllerUpdateProfile() {
        actualizarPerfil = new ActualizarPerfil(new UsuarioArchivosRepositorio());
    }


    public void setMainApp(MenuLogin mainApp) {
        this.mainApp = mainApp;
        this.helpCommand = new HelpCommand(mainApp);
        this.homeCommand = new HomeCommand(mainApp);
        this.settingsCommand = new SettingsCommand(mainApp);
        this.logOutCommand = new LogOutCommand(mainApp);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Inicializa la lista de usuarios desde el archivo JSON
            usuarios = loadUsuariosFromJson();

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
        }
    }

    public void setUsuarioActivo(Credenciales usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public void loadUserData(Credenciales credencialesUsuarioActivo) {
        try (FileReader reader = new FileReader("Usuarios.json")) {
            Gson gson = new Gson();
            Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);

            // Busca al usuario activo en el array de usuarios
            Usuario usuarioEnSesion = null;
            for (Usuario usuario : usuarios) {
                if (usuario.getCredenciales().getNombreUsuario().equals(credencialesUsuarioActivo.getNombreUsuario())) {
                    usuarioEnSesion = usuario;
                    break;
                }
            }
            if (usuarioEnSesion != null) {
                // Actualiza los campos con los datos del usuario en sesión
                textNombreNEW.setText(usuarioEnSesion.getNombre());
                textApellidoNEW.setText(usuarioEnSesion.getApellido());
                textNumIdentidadNEW.setText(usuarioEnSesion.getNumeroDocumento());
                textCorreoNEW.setText(usuarioEnSesion.getCorreo());
                textPeso.setText(String.valueOf(usuarioEnSesion.getPerfil().getPeso()));
                textAltura.setText(String.valueOf(usuarioEnSesion.getPerfil().getAltura()));
                textComplexion.setValue(usuarioEnSesion.getPerfil().getComplexion());
                textObjetivo.setValue(usuarioEnSesion.getPerfil().getObjetivo());

            } else {
                System.out.println("Usuario activo no encontrado en el archivo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void onClickSave(ActionEvent event) throws IOException {
        // Obtener los valores de los campos de texto
        String peso = textPeso.getText();
        String altura = textAltura.getText();
        String complexion = textComplexion.getValue();
        String objetivo = textObjetivo.getValue();

        // Obtener el usuario activo
        Usuario usuarioEnSesion = findUsuarioActivo(mainApp.getCredencialesUsuarioActivo());

        // Actualizar los datos del usuario con los nuevos valores
        if (usuarioEnSesion != null) {
            actualizarPerfil.updatePerfil(Integer.parseInt(peso), Integer.parseInt(altura), complexion, objetivo, usuarioEnSesion);

            // Muestra una alerta de confirmación
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Actualizar datos");
            alert.setHeaderText("Datos actualizados correctamente");

            ButtonType confirmButton = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);

            Optional<ButtonType> result = alert.showAndWait();
            this.mainApp.showHomeScreen();
        }
    }

    // Método para buscar al usuario activo en el array de usuarios
    private Usuario findUsuarioActivo(Credenciales credencialesUsuarioActivo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCredenciales().getNombreUsuario().equals(credencialesUsuarioActivo.getNombreUsuario())) {
                return usuario;
            }
        }
        return null;
    }

    private List<Usuario> loadUsuariosFromJson() {
        List<Usuario> usuarios = new ArrayList<>();

        try (FileReader reader = new FileReader("Usuarios.json")) {
            Gson gson = new Gson();
            Usuario[] usuariosArray = gson.fromJson(reader, Usuario[].class);

            // Convierte el array de usuarios a una lista
            usuarios = Arrays.asList(usuariosArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(usuarios);
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
    public void onClickLogOut(ActionEvent event) { logOutCommand.execute(); }
    @FXML
    public void onclickGoBack(ActionEvent actionEvent) { homeCommand.execute(); }

    @FXML
    public void onClickSettings() { settingsCommand.execute(); }

    @FXML
    public void onClickHelp() { helpCommand.execute(); }
}
