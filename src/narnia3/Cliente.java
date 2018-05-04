package narnia3;

import java.util.Scanner;

/**
 *
 * @author Ricardo Villeda
 */
public class Cliente {
    String Dui, infoCliente, nombre, apellido, tarjetaCredito, telefono;
    int TotalHabitaciones;

    public Cliente() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre: ");
        this.nombre = leer.nextLine();
        System.out.println("Apellido: ");
        this.apellido = leer.nextLine();
        System.out.println("Telefono: ");
        this.telefono = leer.nextLine();
        System.out.println("Tarjeta de credito o debito: ");
        this.tarjetaCredito = leer.nextLine();
        System.out.println("DUI: ");
        this.Dui = leer.nextLine();
        this.infoCliente = "Nombre: " + this.nombre + " Apellido: " + this.apellido + " DUI: " + this.Dui + " Telefono: " + this.telefono + " Tarjeta de credito: " + this.tarjetaCredito;
    }

    public Cliente(String Dui, String infoCliente, String nombre, String apellido, String tarjetaCredito, String telefono) {
        this.Dui = Dui;
        this.infoCliente = infoCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjetaCredito = tarjetaCredito;
        this.telefono = telefono;
    }

    public String getDui() {
        return Dui;
    }

    public void setDui(String Dui) {
        this.Dui = Dui;
    }

    public String getInfoCliente() {
        return infoCliente;
    }

    public void setInfoCliente(String infoCliente) {
        this.infoCliente = "Nombre: " + this.nombre + " Apellido: " + this.apellido + " DUI: " + this.Dui + " Telefono: " + this.telefono + " Tarjeta de credito: " + this.tarjetaCredito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTotalHabitaciones() {
        return TotalHabitaciones;
    }

    public void setTotalHabitaciones(int TotalHabitaciones) {
        this.TotalHabitaciones = TotalHabitaciones;
    }
}
