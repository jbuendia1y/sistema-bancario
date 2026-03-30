/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

public abstract class Retiro {
    private Cuenta cuentaOrigen;
    private double monto;

    public Retiro() {}

    public Retiro(Cuenta cuentaOrigen, double monto) {
        this.cuentaOrigen = cuentaOrigen;
        this.monto = monto;
    }

    public abstract void procesar();
}
