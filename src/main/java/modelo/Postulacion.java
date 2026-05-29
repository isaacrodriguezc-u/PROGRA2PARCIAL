/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;

public class Postulacion {
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;
    
    // Enlaces de la relación
    private Oferta oferta;

    public Postulacion(Date fecha, Oferta oferta) {
        this.fecha = fecha;
        this.oferta = oferta;
        this.anulado = false;
    }

    public void anular() {
        this.anulado = true;
        this.fechaAnulacion = new Date();
    }

    // Getters
    public Date getFecha() { return fecha; }
    public boolean isAnulado() { return anulado; }
    public Oferta getOferta() { return oferta; }
}