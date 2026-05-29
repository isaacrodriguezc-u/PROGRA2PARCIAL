/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Cliente {
    private String RUC;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;
    
    // Relación con Rubro y Ofertas
    private Rubro rubro;
    private Oferta[] ofertas;
    private int numOfertas;

    public Cliente(String RUC, String razonSocial, String email, String contacto, String telefono, String clave, Rubro rubro) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.clave = clave;
        this.rubro = rubro;
        this.ofertas = new Oferta[50]; // Capacidad máxima
        this.numOfertas = 0;
    }

    public boolean agregarOferta(Oferta oferta) {
        if (numOfertas < ofertas.length) {
            ofertas[numOfertas] = oferta;
            numOfertas++;
            return true;
        }
        return false;
    }

    public boolean eliminarOferta(Oferta oferta) {
        for (int i = 0; i < numOfertas; i++) {
            if (ofertas[i] == oferta) {
                // Desplazar elementos para "eliminar"
                for(int j = i; j < numOfertas - 1; j++){
                    ofertas[j] = ofertas[j+1];
                }
                ofertas[numOfertas - 1] = null;
                numOfertas--;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        Oferta[] ofertasActivas = new Oferta[numOfertas];
        for (int i = 0; i < numOfertas; i++) {
            ofertasActivas[i] = ofertas[i];
        }
        return ofertasActivas;
    }

    // Getters
    public String getRUC() { return RUC; }
    public String getClave() { return clave; }
}