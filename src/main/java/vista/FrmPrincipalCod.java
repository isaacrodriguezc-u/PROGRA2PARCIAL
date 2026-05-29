/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipalCod extends JFrame {

    private JButton btnLogin;
    private JButton btnRegistrarEmpresa;
    private JButton btnRegistrarCandidato;

    // Fíjate que dice EXACTAMENTE "public FrmPrincipalCod()" sin la palabra void
    public FrmPrincipalCod() {
        setTitle("Sistema de Reclutamiento TI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        // Título de la ventana
        JLabel lblTitulo = new JLabel("Portal de Empleos TI", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo);

        // Inicializar botones
        btnLogin = new JButton("Iniciar Sesión");
        btnRegistrarEmpresa = new JButton("Registro de Empresas");
        btnRegistrarCandidato = new JButton("Registro de Candidatos");

        // Agregar botones al Frame
        add(btnLogin);
        add(btnRegistrarEmpresa);
        add(btnRegistrarCandidato);
        
        setLocationRelativeTo(null); // Centrar en pantalla
    }

    // Getters
    public JButton getBtnLogin() { return btnLogin; }
    public JButton getBtnRegistrarEmpresa() { return btnRegistrarEmpresa; }
    public JButton getBtnRegistrarCandidato() { return btnRegistrarCandidato; }

    // Método de prueba
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmPrincipalCod().setVisible(true);
        });
    }
}