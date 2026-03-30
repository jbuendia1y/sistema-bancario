/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

/**
 *
 * @author UsuarioChris
 */
public class Deposito {
    private Cuenta cuentaDestino;
    private double monto;

    public Deposito() {}

    public Deposito(Cuenta cuentaDestino, double monto) {
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public void procesar() {
        cuentaDestino.depositar(monto);
    }
}

