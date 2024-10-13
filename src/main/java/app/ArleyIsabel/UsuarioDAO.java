package app.ArleyIsabel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
    }

    public void insertarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public String consultarUsuarios() {
        StringBuilder resultado = new StringBuilder();
        for (Usuario u : usuarios) {
            resultado.append("ID: ").append(u.getId()).append(", Nombre: ").append(u.getNombre())
                    .append(", Correo: ").append(u.getCorreo()).append("\n");
        }
        return resultado.toString();
    }

    public void actualizarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                u.setNombre(usuario.getNombre());
                u.setCorreo(usuario.getCorreo());
                break;
            }
        }
    }

    public void eliminarUsuario(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }
}
