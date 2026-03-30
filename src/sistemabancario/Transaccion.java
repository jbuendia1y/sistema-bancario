/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;
import java.util.Date;
/**
 *
 * @author Samuel
 */

public abstract class Transaccion {

        private String idTransaccion;
        private double monto;
        private Date fecha;
        private String estado;


        public Transaccion() {
        }

        //Constructor parametrizado con los atributos
        public Transaccion(String idTransaccion, double monto, Date fecha, String estado) {
            this.idTransaccion = idTransaccion;
            this.monto = monto;
            this.fecha = fecha;
            this.estado = estado;
        }

  
        //Getter an setter
        
        public String getIdTransaccion() {
            return idTransaccion;
        }

        public void setIdTransaccion(String idTransaccion) {
            this.idTransaccion = idTransaccion;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
        
        public abstract void procesar();

        public void marcarCompletada() {
            this.estado = "Transaccio Completada con Exito";
        }

        public void marcarFallida() {
            this.estado = "Transaccion Fallida";
        }
    }


