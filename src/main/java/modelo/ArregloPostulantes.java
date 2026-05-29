/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class ArregloPostulantes {
    private Postulante[] postulantes;
    private int indice;

    public ArregloPostulantes() {
        postulantes = new Postulante[500];
        indice = 0;
    }

    public boolean agregar(Postulante postulante) {
        if (indice < postulantes.length) {
            postulantes[indice] = postulante;
            indice++;
            return true;
        }
        return false;
    }

    public Postulante buscarPorEmail(String email) {
        for (int i = 0; i < indice; i++) {
            if (postulantes[i].getEmail().equals(email)) {
                return postulantes[i];
            }
        }
        return null;
    }
}