/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;

public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;
    
    // Relación de composición con Requisito (Arreglo interno)
    private Requisito[] requisitos;
    private int numRequisitos;

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.requisitos = new Requisito[20]; // Capacidad máxima por defecto
        this.numRequisitos = 0;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        if (numRequisitos < requisitos.length) {
            requisitos[numRequisitos] = new Requisito(orden, descripcion, true);
            numRequisitos++;
            return true;
        }
        return false;
    }

    public Requisito[] getRequisitos() {
        // Retornar solo los elementos activos
        Requisito[] reqsActivos = new Requisito[numRequisitos];
        for (int i = 0; i < numRequisitos; i++) {
            reqsActivos[i] = requisitos[i];
        }
        return reqsActivos;
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < numRequisitos; i++) {
            if (requisitos[i].getOrden() == orden) {
                requisitos[i].deshabilitar();
                return true;
            }
        }
        return false;
    }

    // Getters
    public String getPuesto() { return puesto; }
    public String getArea() { return area; }
}
