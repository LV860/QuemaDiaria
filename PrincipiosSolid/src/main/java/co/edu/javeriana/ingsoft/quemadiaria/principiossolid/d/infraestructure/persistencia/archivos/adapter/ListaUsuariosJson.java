package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos.adapter;

import lombok.Data;

import java.io.Serializable;

@Data
public class ListaUsuariosJson implements Serializable {

    //private List<Usuario> listaUsuarios;

    private String nombreArchivo = "usuarios.json";

    public ListaUsuariosJson() {
        //this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ListaUsuariosJson{" +
                "nombreArchivo='" + nombreArchivo + '\'' +
                '}';
    }

}
