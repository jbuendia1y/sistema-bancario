/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import sistemabancario.Transaccion;

/**
 *
 * @author Joaquín Buendía
 */
public class ServicioTransaccion {

    public void ejecutarTransaccion(Transaccion t) {
        try {
            t.procesar();
            t.marcarCompletada();
            System.out.println("|== Transacción completada correctamente. ==|");
        } catch (Exception e) {
            t.marcarFallida();
            System.out.println("X Error en la transacción: " + e.getMessage());
        }
    }
}
