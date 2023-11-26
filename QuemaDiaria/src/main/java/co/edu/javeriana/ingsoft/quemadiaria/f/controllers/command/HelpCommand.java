package co.edu.javeriana.ingsoft.quemadiaria.f.controllers.command;

import co.edu.javeriana.ingsoft.quemadiaria.MenuLogin;
import co.edu.javeriana.ingsoft.quemadiaria.e.interfaces.Command;

import java.io.IOException;

public class HelpCommand implements Command {
    private MenuLogin mainApp;

    public HelpCommand(MenuLogin mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        try {
            mainApp.showHelp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
