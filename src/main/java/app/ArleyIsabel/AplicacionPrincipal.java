/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.ArleyIsabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arley
 */
public class AplicacionPrincipal {

    private UsuarioDAO usuarioDAO;

    public AplicacionPrincipal() {
        usuarioDAO = new UsuarioDAO();
        initializeUI();
    }

    private void initializeUI() {
        // marco principal
        JFrame frame = new JFrame("Aplicacion Arley_Isabel_Aprendis Sena");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Ajustar el tamaño 
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

        // Crear botones
        JButton btnInsertar = new JButton("Insertar Usuario");
        JButton btnConsultar = new JButton("Consultar Usuarios");
        JButton btnActualizar = new JButton("Actualizar Usuario");
        JButton btnEliminar = new JButton("Eliminar Usuario");

        // Añadir acción a los botones
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioInsertar(frame);
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //consultar usuarios
                String usuarios = usuarioDAO.consultarUsuarios();
                JOptionPane.showMessageDialog(frame, usuarios);
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioActualizar(frame);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "¿Está seguro que desea eliminar este usuario?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    //eliminar un usuario
                    usuarioDAO.eliminarUsuario(1); // Aquí puedes ajustar el ID del usuario a eliminar
                    JOptionPane.showMessageDialog(frame, "Usuario eliminado.");
                }
            }
        });

        // Crear un panel
        JPanel panel = new JPanel();
        panel.add(btnInsertar);
        panel.add(btnConsultar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        // panel al contenido del frame
        frame.getContentPane().add(panel);

        // interfaz gráfica 
        frame.revalidate();
        frame.repaint();

        //ventana
        frame.setVisible(true);
    }

    private void mostrarFormularioInsertar(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Insertar Usuario", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(frame);

        // Crear campos de entrada
        JTextField txtNombre = new JTextField(20);
        JTextField txtEmail = new JTextField(20);
        JButton btnGuardar = new JButton("Guardar");

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario(0, txtNombre.getText(), txtEmail.getText());
                usuarioDAO.insertarUsuario(usuario);
                JOptionPane.showMessageDialog(dialog, "Usuario insertado.");
                dialog.dispose(); // Cerrar el dialogo
            }
        });

        // Panel para los campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(btnGuardar);

        dialog.getContentPane().add(panel);
        dialog.setVisible(true);
    }

    private void mostrarFormularioActualizar(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Actualizar Usuario", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(frame);

        // Crear campos de entrada
        JTextField txtId = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JTextField txtEmail = new JTextField(20);
        JButton btnActualizar = new JButton("Actualizar");

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                Usuario usuario = new Usuario(id, txtNombre.getText(), txtEmail.getText());
                usuarioDAO.actualizarUsuario(usuario);
                JOptionPane.showMessageDialog(dialog, "Usuario actualizado.");
                dialog.dispose(); // Cerrar el dialogo
            }
        });

        // Panel para  campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(btnActualizar);

        dialog.getContentPane().add(panel);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        // Usar SwingUtilities para ejecutar en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplicacionPrincipal();
            }
        });
    }
}
