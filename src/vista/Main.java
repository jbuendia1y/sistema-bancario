/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import servicios.ServicioTransaccion;
import sistemabancario.Cliente;
import sistemabancario.Cuenta;
import sistemabancario.Deposito;
import sistemabancario.Retiro;
import sistemabancario.Transferencia;

/**
 *
 * @author Joaquín Buendía
 */

public class Main {
    static Scanner sc = new Scanner(System.in);

    static List<Cliente> clientes = new ArrayList<>();
    static HashMap<String, List<Cuenta>> cuentas = new HashMap();

    static ServicioTransaccion servicio = new ServicioTransaccion();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n=== BANCA DIGITAL ===");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Ver clientes");
            System.out.println("4. Depositar");
            System.out.println("5. Transferir");
            System.out.println("6. Retirar");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> crearCuenta();
                case 3 -> listarClientes();
                case 4 -> depositar();
                case 5 -> transferir();
                case 6 -> retirar();
            }

        } while (opcion != 0);
    }

    // ========================
    // CLIENTES
    // ========================

    static void crearCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        Cliente c = new Cliente(UUID.randomUUID().toString(), nombre, "", "", "");
        clientes.add(c);

        System.out.println("|== Cliente creado. ==|");
    }

    static Cliente buscarCliente() {
        listarClientes();
        System.out.print("Seleccione cliente (índice): ");
        int index = sc.nextInt();
        return clientes.get(index);
    }

    static void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNombre());
        }
    }

    // ========================
    // CUENTAS
    // ========================

    static void crearCuenta() {
        Cliente cliente = buscarCliente();

        System.out.print("Tipo (ahorro/corriente): ");
        String tipo = sc.next();

        Cuenta cuenta = new Cuenta(
                UUID.randomUUID().toString(),
                tipo,
                0.0,
                "ACTIVA"
        );
        
        List<Cuenta> cuentasDeCliente = cuentas.getOrDefault(cliente.getId(), new ArrayList());
        cuentasDeCliente.add(cuenta);
        cuentas.put(cliente.getId(), cuentasDeCliente);

        System.out.println("|== Cuenta creada. ==|");
    }

    static List<Cuenta> obtenerCuentasPorCliente(String clienteId) {
        List<Cuenta> resultado = cuentas.getOrDefault(clienteId, new ArrayList());

        return resultado;
    }

    static Cuenta seleccionarCuenta(Cliente cliente) {
        List<Cuenta> cuentasCliente = obtenerCuentasPorCliente(cliente.getId());

        for (int i = 0; i < cuentasCliente.size(); i++) {
            Cuenta c = cuentasCliente.get(i);
            System.out.println(i + " - " + c.getIdCuenta() + " | Saldo: " + c.getSaldo());
        }

        System.out.print("Seleccione cuenta: ");
        int index = sc.nextInt();

        return cuentasCliente.get(index);
    }

    // ========================
    // TRANSACCIONES
    // ========================

    static void depositar() {
        Cliente cliente = buscarCliente();
        Cuenta cuenta = seleccionarCuenta(cliente);

        System.out.print("Monto: ");
        double monto = sc.nextDouble();

        Deposito deposito = new Deposito(cuenta, monto);
        servicio.ejecutarTransaccion(deposito);
    }

    static void transferir() {
        System.out.println("Cuenta ORIGEN:");
        Cliente c1 = buscarCliente();
        Cuenta origen = seleccionarCuenta(c1);

        System.out.println("Cuenta DESTINO:");
        Cliente c2 = buscarCliente();
        Cuenta destino = seleccionarCuenta(c2);

        System.out.print("Monto: ");
        double monto = sc.nextDouble();

        Transferencia t = new Transferencia(origen, destino, monto);
        servicio.ejecutarTransaccion(t);
    }

    static void retirar() {
        Cliente cliente = buscarCliente();
        Cuenta cuenta = seleccionarCuenta(cliente);

        System.out.print("Monto: ");
        double monto = sc.nextDouble();

        Retiro retiro = new Retiro(cuenta, monto);
        servicio.ejecutarTransaccion(retiro);
    }
}
