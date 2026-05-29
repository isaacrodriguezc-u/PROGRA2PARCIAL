/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;

public class FrmRegistroEmpresa extends JFrame {

    // Componentes visuales
    private JTextField txtRazonSocial, txtRuc, txtCorreo, txtContacto;
    private JComboBox<String> cbxRubro;
    private JButton btnRegistrar, btnCancelar;

    public FrmRegistroEmpresa() {
        setTitle("Registro de Empresas");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana, no todo el programa
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Etiquetas y Campos de texto
        add(new JLabel("  Razón Social:"));
        txtRazonSocial = new JTextField();
        add(txtRazonSocial);

        add(new JLabel("  RUC:"));
        txtRuc = new JTextField();
        add(txtRuc);

        add(new JLabel("  Rubro o Sector:"));
        cbxRubro = new JComboBox<>(new String[]{"Tecnología", "Finanzas", "Salud", "Educación", "Retail"});
        add(cbxRubro);

        add(new JLabel("  Correo Institucional:"));
        txtCorreo = new JTextField();
        add(txtCorreo);

        add(new JLabel("  Datos de Contacto:"));
        txtContacto = new JTextField();
        add(txtContacto);

        // Espacio vacío para alinear botones
        add(new JLabel("")); 
        add(new JLabel(""));

        // Botones
        btnRegistrar = new JButton("Registrar Empresa");
        btnCancelar = new JButton("Cancelar");
        add(btnRegistrar);
        add(btnCancelar);
    }

    // Getters para que el controlador lea los datos ingresados
    public String getRazonSocial() { return txtRazonSocial.getText(); }
    public String getRuc() { return txtRuc.getText(); }
    public String getRubro() { return cbxRubro.getSelectedItem().toString(); }
    public String getCorreo() { return txtCorreo.getText(); }
    public String getContacto() { return txtContacto.getText(); }
    
    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    // Prueba rápida
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmRegistroEmpresa().setVisible(true));
    }
}