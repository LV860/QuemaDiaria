package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades;

import java.io.Serializable;

public class Credenciales implements Serializable {

    private final String nombreUsuario;

    private final String contrasenna;

    public Credenciales(String nombreUsuario, String contrasenna) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public boolean validarCredenciales(String nombreUsuario, String contrasenna) {
        return this.contrasenna.equals(contrasenna) && this.nombreUsuario.equals(nombreUsuario);
    }

    @Override
    public String toString() {
        return "Credenciales {" + "nombreUsuario=" + nombreUsuario + ", contrasenna=" + contrasenna + '}';
    }
}
