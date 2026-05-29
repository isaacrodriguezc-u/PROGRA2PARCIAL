/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;

public class FrmRegistroCandidato extends JFrame {

    private JTextField txtEmail, txtNombres, txtApellidos, txtTelefono, txtDireccion, txtFechaNac;
    private JComboBox<String> cbxGradoEstudios;
    private JButton btnRegistrar, btnCancelar;

    public FrmRegistroCandidato() {
        setTitle("Registro de Candidato");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 10, 10));

        add(new JLabel("  Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("  Nombres:"));
        txtNombres = new JTextField();
        add(txtNombres);

        add(new JLabel("  Apellidos:"));
        txtApellidos = new JTextField();
        add(txtApellidos);

        add(new JLabel("  Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        add(new JLabel("  Dirección Completa:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("  Fec. Nacimiento (dd/mm/aaaa):"));
        txtFechaNac = new JTextField();
        add(txtFechaNac);

        add(new JLabel("  Grado de Estudios:"));
        cbxGradoEstudios = new JComboBox<>(new String[]{"Bachiller", "Titulado", "Magister", "Doctor", "Técnico"});
        add(cbxGradoEstudios);

        add(new JLabel("")); 
        add(new JLabel(""));

        btnRegistrar = new JButton("Registrar Candidato");
        btnCancelar = new JButton("Cancelar");
        add(btnRegistrar);
        add(btnCancelar);
    }

    // Getters para el controlador
    public String getEmail() { return txtEmail.getText(); }
    public String getNombres() { return txtNombres.getText(); }
    public String getApellidos() { return txtApellidos.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getDireccion() { return txtDireccion.getText(); }
    public String getFechaNac() { return txtFechaNac.getText(); }
    public String getGradoEstudio() { return cbxGradoEstudios.getSelectedItem().toString(); }

    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    // Prueba rápida
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmRegistroCandidato().setVisible(true));
    }
}