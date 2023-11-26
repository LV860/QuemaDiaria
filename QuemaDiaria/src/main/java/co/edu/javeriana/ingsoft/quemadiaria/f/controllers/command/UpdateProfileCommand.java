package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;

import java.io.IOException;

public class UpdateProfileCommand implements Command {
    private MenuLogin mainApp;

    public UpdateProfileCommand(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        try {
            mainApp.showUpdateProfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
