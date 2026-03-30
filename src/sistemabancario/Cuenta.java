/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

/**
 *
 * @author Aldha
 */
public class Cuenta{

    private String IdCuenta;
    private String Tipo;
    private double saldo;
    private String Estado;
    
    
    public Cuenta (String IdCuenta,String Tipo,double saldo,String Estado){
    this.IdCuenta=IdCuenta;
    this.Tipo=Tipo;
    this.saldo=saldo;
    this.Estado=Estado;
    }
    
    public String getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(String IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public void depositar(double monto){
        if(monto>0){
            saldo=saldo+monto;
            System.out.println("Deposito con exito: "+monto+"$");
            System.out.println("Saldo actualizado: "+saldo+"$");
        }else{
            System.out.println("Monto invalido");
        }
    }
    
    public void retirar(double monto){
        if(monto<=0){
            System.out.println("Monto invalido");
            
        } else if(tieneSaldoSuficiente(monto)){
                saldo=saldo-monto;
                System.out.println("Retiraste: "+monto+"$"+" saldo restante: "+saldo);
            }
           else{
                System.out.println("Saldo insuficiente para un retiro de "+monto+"$");
            }
    }
    
    public boolean tieneSaldoSuficiente(double monto){
        return saldo >= monto;
    }
    
    public double obtenerSaldo() {
       return saldo;
    }
}
