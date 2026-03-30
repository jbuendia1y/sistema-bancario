/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

public class Cliente {
    //Atributos
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    
    //Constructor
    public Cliente(String id, String nombre, String email, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    //Metodos
    public void actualizarContacto (String email, String direccion){
        this.email = email;
        this.direccion = direccion;
    }
    
    public String obtenerInfoCompleta (){
        String informacion = String.format("""
                                           %-15S %S
                                           %-15S %S
                                           %-15S %S
                                           %-15S %S
                                           %-15S %S
                                           ""","ID:",getId(),"Nombre:",getNombre(),"Email:",getEmail(),"Telefono:",
                                           getTelefono(),"Direccion:",getDireccion());
        return informacion;
    }
    
    //Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
