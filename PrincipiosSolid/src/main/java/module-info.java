module co.edu.javeriana.ingsoft.quemadiaria.principiossolid {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.google.gson;
    requires java.sql;

    opens co.edu.javeriana.ingsoft.quemadiaria.principiossolid to javafx.fxml;
    opens co.edu.javeriana.ingsoft.quemadiaria.principiossolid.e.interfaces.main to javafx.fxml;
    exports co.edu.javeriana.ingsoft.quemadiaria.principiossolid.e.interfaces.main;
    opens co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers to javafx.fxml;
    exports co.edu.javeriana.ingsoft.quemadiaria.principiossolid.f.controllers;
    opens co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades to com.google.gson;
    exports co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades;
    exports co.edu.javeriana.ingsoft.quemadiaria.principiossolid;
}
