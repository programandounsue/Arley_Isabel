package app.ArleyIsabel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
    }

    private int idCounter = 1; // Comenzar desde 1

    public void insertarUsuario(Usuario usuario) {
        usuario.setId(idCounter++);
        usuarios.add(usuario);
    }
    


    public String consultarUsuarios() {
        if (usuarios.isEmpty()) {
            return "No hay usuarios registrados.";
        }
        StringBuilder resultado = new StringBuilder();
        for (Usuario u : usuarios) {
            resultado.append("ID: ").append(u.getId())
                    .append(", Nombre: ").append(u.getNombre())
                    .append(", Correo: ").append(u.getCorreo())
                    .append("\n");
        }
        return resultado.toString();
    }
    

    public void actualizarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                u.setNombre(usuario.getNombre());
                u.setCorreo(usuario.getCorreo());
                return; // Salir una vez actualizado
            }
        }
        throw new IllegalArgumentException("Usuario no encontrado para actualizar.");
    }
    
    public void eliminarUsuario(int id) {
        boolean removed = usuarios.removeIf(u -> u.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Usuario no encontrado para eliminar.");
        }
    }
}     

