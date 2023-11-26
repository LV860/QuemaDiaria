package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;

import java.io.IOException;

public class SettingsCommand implements Command {
    private MenuLogin mainApp;

    public SettingsCommand(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        try {
            mainApp.showSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
