/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.ArleyIsabel;

import javax.swing.*;
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
        // Crear el marco principal
        JFrame frame = new JFrame("Aplicacion Arley_Isabel_Aprendis Sena");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Ajustar el tamaño para que sea más visible
        frame.setLocationRelativeTo(null);  // Centramos la ventana en la pantalla

        // Crear botones
        JButton btnInsertar = new JButton("Insertar Usuario");
        JButton btnConsultar = new JButton("Consultar Usuarios");
        JButton btnActualizar = new JButton("Actualizar Usuario");
        JButton btnEliminar = new JButton("Eliminar Usuario");

        // Añadir acción a los botones
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para insertar un usuario
                Usuario usuario = new Usuario(0, "Arley_Torres_isabel", "arleyIsabel@correo.com");
                usuarioDAO.insertarUsuario(usuario);
                JOptionPane.showMessageDialog(frame, "Usuario insertado.");
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para consultar usuarios
                String usuarios = usuarioDAO.consultarUsuarios();
                JOptionPane.showMessageDialog(frame, usuarios);
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para actualizar un usuario
                Usuario usuario = new Usuario(1, "ArleyIsabel Actualizado", "arleyIsabel@hotmail.com.com");
                usuarioDAO.actualizarUsuario(usuario);
                JOptionPane.showMessageDialog(frame, "Usuario actualizado.");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para eliminar un usuario
                usuarioDAO.eliminarUsuario(1);
                JOptionPane.showMessageDialog(frame, "Usuario eliminado.");
            }
        });

        // Crear un panel y agregar los botones
        JPanel panel = new JPanel();
        panel.add(btnInsertar);
        panel.add(btnConsultar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        // Agregar el panel al contenido del frame
        frame.getContentPane().add(panel);

        // Asegurarse de que la interfaz gráfica se actualice correctamente
        frame.revalidate();
        frame.repaint();

        // Hacer visible la ventana
        frame.setVisible(true);
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
