package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.d.infraestructure.persistencia.archivos;

import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.CifrarTexto;
import co.edu.javeriana.ingsoft.quemadiaria.principiossolid.b.usecases.persistencia.UsuarioRepositorio;
import com.google.gson.*;

import java.io.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UsuarioArchivosRepositorio es una clase que implementa la interfaz UsuarioRepositorio para gestionar un usuario
 * en un archivo json
 */
public class UsuarioArchivosRepositorio implements UsuarioRepositorio {

    @Override
    public void guardarUsuario(Usuario usuario) {

        try {

            List<Usuario> usuarioList = consultarListaUsuarios();
            System.out.println("Registrando usuario: " + usuario);
            usuarioList.add(usuario);
            FileWriter fileWriter = new FileWriter("PrincipiosSolid/Usuarios.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(usuarioList, fileWriter);
            fileWriter.close();
            System.out.println("Informacion guardada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }

    }

    @Override
    public List<Usuario> consultarListaUsuarios() {


        Gson gson = new Gson();
        try {
            Path filePath = Path.of("PrincipiosSolid/Usuarios.json");
            String content = Files.readString(filePath);
            List<Usuario> usersList = new ArrayList<>();
            try {
                Usuario[] users = gson.fromJson(content, Usuario[].class);
                if(users == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(users));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Usuario user = gson.fromJson(jsonArray.get(i), Usuario.class);
                        usersList.add(user);
                    }
                    return usersList;
                } else {
                    // Handle other JSON parsing errors
                    e.printStackTrace();
                    throw new RuntimeException("Error al gestionar el archivo", e);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }

    }

    @Override
    public Usuario consultarUsuarioPorUserName(String userName) {

        return consultarListaUsuarios().
                stream().
                filter(usuario -> usuario.getCredenciales().getNombreUsuario().equals(userName)).
                findFirst().
                orElseThrow(()->new QuemaDiariaException(QuemaDiariaException.ERROR_USUARIO_NO_ENCONTRADO, "Usuario no encontrado: " + userName));
    }

    @Override
    public void actualizarPerfil(Perfil perfil, Usuario usuario) {
        try {
            List<Usuario> usuarioList = consultarListaUsuarios();

            // Buscar el usuario que coincida con el usuario proporcionado
            Optional<Usuario> usuarioExistente = usuarioList.stream()
                    .filter(u -> u.getCredenciales().getNombreUsuario().equals(usuario.getCredenciales().getNombreUsuario()))
                    .findFirst();

            if (((Optional<?>) usuarioExistente).isPresent()) {
                // Actualizar el perfil del usuario existente
                usuarioExistente.get().setPerfil(perfil);

                // Guardar los cambios en el archivo JSON
                FileWriter fileWriter = new FileWriter("PrincipiosSolid/Usuarios.json");
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                gson.toJson(usuarioList, fileWriter);
                fileWriter.close();

                System.out.println("Información actualizada correctamente");
            } else {
                System.out.println("Usuario no encontrado. No se pudo actualizar el perfil.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }
    }
}
