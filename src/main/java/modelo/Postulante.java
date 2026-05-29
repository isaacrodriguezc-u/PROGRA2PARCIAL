/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;

public class Postulante {
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;
    
    private GradoEstudio grado;
    private Postulacion[] postulaciones;
    private int numPostulaciones;

    public Postulante(String email, String nombres, String apellidos, String direccion, Date nacimiento, String clave) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = clave;
        this.postulaciones = new Postulacion[100]; // Límite de postulaciones
        this.numPostulaciones = 0;
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {
        this.grado = grado;
        return true;
    }

    public boolean postular(Oferta oferta) {
        if (numPostulaciones < postulaciones.length) {
            Postulacion nuevaPostulacion = new Postulacion(new Date(), oferta);
            postulaciones[numPostulaciones] = nuevaPostulacion;
            numPostulaciones++;
            return true;
        }
        return false;
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        for (int i = 0; i < numPostulaciones; i++) {
            if (postulaciones[i] == postulacion && !postulaciones[i].isAnulado()) {
                postulaciones[i].anular();
                return true;
            }
        }
        return false;
    }

    public Postulacion[] getPostulaciones() {
        Postulacion[] act = new Postulacion[numPostulaciones];
        for (int i = 0; i < numPostulaciones; i++) {
            act[i] = postulaciones[i];
        }
        return act;
    }

    // Getters
    public String getEmail() { return email; }
    public String getClave() { return clave; }
}