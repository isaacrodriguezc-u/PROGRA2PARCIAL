/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador; // o el paquete principal de tu proyecto

import modelo.*;
import vista.*;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializar los Modelos (Arreglos vacíos)
        ArregloClientes modeloClientes = new ArregloClientes();
        ArregloPostulantes modeloPostulantes = new ArregloPostulantes();

        // 2. Inicializar las Vistas
        FrmPrincipalCod vistaPrincipal = new FrmPrincipalCod();
        FrmRegistroEmpresa vistaEmpresa = new FrmRegistroEmpresa();
        FrmRegistroCandidato vistaCandidato = new FrmRegistroCandidato();

        // 3. Inicializar el Controlador (Conectando Modelos y Vistas)
        ControladorPrincipal controlador = new ControladorPrincipal(
            vistaPrincipal, vistaEmpresa, vistaCandidato, modeloClientes, modeloPostulantes
        );

        // 4. Hacer visible la pantalla principal
        vistaPrincipal.setVisible(true);
    }
}