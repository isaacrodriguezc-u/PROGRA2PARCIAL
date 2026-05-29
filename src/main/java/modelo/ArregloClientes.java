/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class ArregloClientes {
    private Cliente[] clientes;
    private int indice;

    public ArregloClientes() {
        clientes = new Cliente[100];
        indice = 0;
    }

    public boolean agregar(Cliente cliente) {
        if (indice < clientes.length) {
            clientes[indice] = cliente;
            indice++;
            return true;
        }
        return false;
    }

    public Cliente buscarPorRUC(String ruc) {
        for (int i = 0; i < indice; i++) {
            if (clientes[i].getRUC().equals(ruc)) {
                return clientes[i];
            }
        }
        return null;
    }
}
