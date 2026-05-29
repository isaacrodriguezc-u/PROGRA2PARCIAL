/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorPrincipal {

    // Modelos (Arreglos)
    private ArregloClientes modeloClientes;
    private ArregloPostulantes modeloPostulantes;

    // Vistas
    private FrmPrincipalCod vistaPrincipal;
    private FrmRegistroEmpresa vistaEmpresa;
    private FrmRegistroCandidato vistaCandidato;

    public ControladorPrincipal(FrmPrincipalCod vistaPrincipal, FrmRegistroEmpresa vistaEmpresa, 
                                FrmRegistroCandidato vistaCandidato, ArregloClientes modeloClientes, 
                                ArregloPostulantes modeloPostulantes) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaEmpresa = vistaEmpresa;
        this.vistaCandidato = vistaCandidato;
        this.modeloClientes = modeloClientes;
        this.modeloPostulantes = modeloPostulantes;

        // Inicializar los "escuchadores" de clics
        iniciarEventos();
    }

    private void iniciarEventos() {
        // --- EVENTOS DE LA VENTANA PRINCIPAL ---
        vistaPrincipal.getBtnRegistrarEmpresa().addActionListener(e -> {
            vistaEmpresa.setVisible(true); // Abre la ventana de empresa
        });

        vistaPrincipal.getBtnRegistrarCandidato().addActionListener(e -> {
            vistaCandidato.setVisible(true); // Abre la ventana de candidato
        });

        vistaPrincipal.getBtnLogin().addActionListener(e -> {
            JOptionPane.showMessageDialog(vistaPrincipal, "Módulo de Login en construcción...");
        });

        // --- EVENTOS DE REGISTRO DE EMPRESA ---
        vistaEmpresa.getBtnRegistrar().addActionListener(e -> registrarEmpresa());
        vistaEmpresa.getBtnCancelar().addActionListener(e -> vistaEmpresa.dispose());

        // --- EVENTOS DE REGISTRO DE CANDIDATO ---
        vistaCandidato.getBtnRegistrar().addActionListener(e -> registrarCandidato());
        vistaCandidato.getBtnCancelar().addActionListener(e -> vistaCandidato.dispose());
    }

    // Lógica para guardar la empresa
    private void registrarEmpresa() {
        try {
            String ruc = vistaEmpresa.getRuc();
            String razon = vistaEmpresa.getRazonSocial();
            String correo = vistaEmpresa.getCorreo();
            String contacto = vistaEmpresa.getContacto();
            String nombreRubro = vistaEmpresa.getRubro();
            
            // El diagrama pide contraseña autogenerada
            String claveGenerada = "EMP-" + ruc.substring(0, 3) + "2026"; 

            Rubro rubro = new Rubro(nombreRubro, true);
            Cliente nuevaEmpresa = new Cliente(ruc, razon, correo, contacto, "000000", claveGenerada, rubro);

            if (modeloClientes.agregar(nuevaEmpresa)) {
                JOptionPane.showMessageDialog(vistaEmpresa, "Empresa registrada con éxito.\nTu clave es: " + claveGenerada);
                vistaEmpresa.dispose(); // Cierra la ventana tras éxito
            } else {
                JOptionPane.showMessageDialog(vistaEmpresa, "Error: No hay espacio en el sistema.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaEmpresa, "Por favor, llene todos los campos correctamente.");
        }
    }

    // Lógica para guardar el candidato
    private void registrarCandidato() {
        try {
            String email = vistaCandidato.getEmail();
            String nombres = vistaCandidato.getNombres();
            String apellidos = vistaCandidato.getApellidos();
            String telefono = vistaCandidato.getTelefono();
            String direccion = vistaCandidato.getDireccion();
            String fechaTexto = vistaCandidato.getFechaNac();
            
            // Convertir texto a Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNac = sdf.parse(fechaTexto);

            // Clave autogenerada al email (según el requerimiento)
            String claveGenerada = "CAN-" + nombres.substring(0, 2).toUpperCase() + "2026";

            Postulante nuevoCandidato = new Postulante(email, nombres, apellidos, direccion, fechaNac, claveGenerada);
            
            // Asignar grado de estudios
            GradoEstudio grado = new GradoEstudio(vistaCandidato.getGradoEstudio());
            nuevoCandidato.asignarGradoEstudio(grado);

            if (modeloPostulantes.agregar(nuevoCandidato)) {
                JOptionPane.showMessageDialog(vistaCandidato, "Candidato registrado con éxito.\nSe envió la clave a: " + email + "\nClave: " + claveGenerada);
                vistaCandidato.dispose();
            } else {
                JOptionPane.showMessageDialog(vistaCandidato, "Error: No hay espacio en el sistema.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaCandidato, "Error en los datos. Revisa la fecha (dd/mm/aaaa).");
        }
    }
}