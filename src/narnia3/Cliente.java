package narnia3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ricardo Villeda
 */
public class Cliente {

    Reservacion reservacion = new Reservacion();
    ArrayList<Reservacion> reservaciones = new ArrayList<>();

    ArrayList<Habitacion> habitaciones = new ArrayList<>();

    Scanner leer = new Scanner(System.in);
    AdminHotel admin = new AdminHotel();
    Paquete paquete = new Paquete();

    public Cliente() {
    }

    public Cliente(String Dui, String infoCliente, String nombre, String apellido, String tarjetaCredito, String telefono, int TotalHabitaciones) {
        this.Dui = Dui;
        this.infoCliente = infoCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjetaCredito = tarjetaCredito;
        this.telefono = telefono;
        this.TotalHabitaciones = TotalHabitaciones;
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
        this.infoCliente = infoCliente;
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

    String Dui, infoCliente, nombre, apellido, tarjetaCredito, telefono;
    int TotalHabitaciones;

    
    //Hace una reservacion
    public void HacerReservacion() {
        int numHabitacion, opc, diasReservacion;
        double costoTotal, precioPaquete;
        String piso;
        String nombrePaquete;

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
        reservacion.setInfoHuesped(infoCliente);

        System.out.println("Seleccione 1 para ver los paquetes disponibles o 2 si prefiere otro servicio: ");
        opc = leer.nextInt();
        if (opc == 1) {
            reservacion.mostrarPaquete();
            System.out.println("Que paquete desea?");
            nombrePaquete = leer.nextLine();
            precioPaquete = reservacion.PrecioPaquete(nombrePaquete);
            admin.CrearHabitaciones();
            System.out.println("En que piso le gustaria la habitacion(A,B,C,D,E,F): ");
            piso = leer.nextLine();
            System.out.println("Que numero de habitacion deseraia(recuerde las pares son dobles y las impares sencillas): ");
            numHabitacion = leer.nextInt();
            System.out.println("Por cuantos dias desea resrvar la habitacion: ");
            diasReservacion = leer.nextInt();
            costoTotal = (admin.CalcularPrecioHabitacion(numHabitacion, piso) * diasReservacion) + precioPaquete;
            System.out.println("Su costo total sera de: " + "$" + costoTotal);   
            reservacion.setCostoNoche(admin.CalcularPrecioHabitacion(numHabitacion, piso));
            reservacion.setCostoTotal(costoTotal);
            reservacion.setNumeroHabitacion(numHabitacion);
            reservacion.setDiasReservacion(diasReservacion);
            reservacion.setPisoHabitacion(piso);
            reservacion.setNombrePaquete(nombrePaquete);
            reservaciones.add(reservacion);
            
        } else {
            admin.CrearHabitaciones();
            System.out.println("En que piso le gustaria la habitacion(A,B,C,D,E,F): ");
            piso = leer.nextLine();
            System.out.println("Que numero de habitacion deseraia(recuerde las pares son dobles y las impares sencillas): ");
            numHabitacion = leer.nextInt();
            System.out.println("Por cuantos dias desea reservar la habitacion: ");
            diasReservacion = leer.nextInt();
            costoTotal = (admin.CalcularPrecioHabitacion(numHabitacion, piso) * diasReservacion);
            System.out.println("Su costo total sera de: " + "$" + costoTotal);
            reservacion.setCostoTotal(costoTotal);
            reservacion.setNumeroHabitacion(numHabitacion);
            reservacion.setDiasReservacion(diasReservacion);
            reservacion.setPisoHabitacion(piso);
            reservacion.setCostoNoche(admin.CalcularPrecioHabitacion(numHabitacion, piso));
            reservacion.setNombrePaquete(null);
            reservaciones.add(reservacion);
        }

    }

    //Modifica la reservacion, con o sin paquete.
    public void ModificarReservacion() {
        String piso;
        int numHabitacion, opc, dias;
        double costoTotal, precioPaquete;

        System.out.println("En que piso se encuentra en ese momento: ");
        piso = leer.nextLine();
        System.out.println("En que numero de habitacion se encuentra: ");
        numHabitacion = leer.nextInt();

        for (Reservacion r : reservaciones) {
            if (r.getNumeroHabitacion() == numHabitacion && r.getPisoHabitacion().equals(piso)) {
                System.out.println("Como le gustaria su servicio ahora: ");
                System.out.println("1-Para seleccionar paquete y habitacion");
                System.out.println("2-Para solo seleccionar habitacion");
                opc=leer.nextInt();
                if (opc == 1) {
                    reservacion.mostrarPaquete();
                    precioPaquete = reservacion.PrecioPaquete(reservacion.Paquete);
                    admin.MostrarHabitacionesDisponibles();
                    System.out.println("Que piso prefiere: ");
                    piso = leer.nextLine();
                    System.out.println("Que numero de habitacion prefiere: ");
                    numHabitacion = leer.nextInt();
                    System.out.println("Cuantos dias se hospedara: ");
                    dias = leer.nextInt();
                    r.setNumeroHabitacion(numHabitacion);
                    r.setPisoHabitacion(piso);
                    costoTotal = (admin.CalcularPrecioHabitacion(numHabitacion, piso) * dias) + precioPaquete;
                    r.setCostoTotal(costoTotal);
                    r.setCostoNoche(admin.CalcularPrecioHabitacion(numHabitacion, piso));
                    r.setDiasReservacion(dias);
                    
                }   
                else{
                    admin.MostrarHabitacionesDisponibles();
                    System.out.println("Que piso prefiere: ");
                    piso = leer.nextLine();
                    System.out.println("Que numero de habitacion prefiere: ");
                    numHabitacion = leer.nextInt();
                    System.out.println("Cuantos dias se hospedara: ");
                    dias = leer.nextInt();
                    r.setNumeroHabitacion(numHabitacion);
                    r.setPisoHabitacion(piso);
                    costoTotal = (admin.CalcularPrecioHabitacion(numHabitacion, piso) * dias);
                    r.setCostoTotal(costoTotal);   
                    r.setCostoNoche(admin.CalcularPrecioHabitacion(numHabitacion, piso));
                    r.setDiasReservacion(dias);
                }   
            }

        }

    }
    
    //Cancela por completo la reservacion
    public void CancelarReservacion() {
        String piso;
        int numHabitacion, opc, dias;
        double costoP;

        System.out.println("En que piso se encuentra en ese momento: ");
        piso = leer.nextLine();
        System.out.println("En que numero de habitacion se encuentra: ");
        numHabitacion = leer.nextInt();
        System.out.println("Cuantos dias ha estado en el hotel");
        dias = leer.nextInt();

        for (Reservacion r : reservaciones) {
            if (r.getNumeroHabitacion() == numHabitacion && r.getPisoHabitacion().equals(piso)) {
                costoP = r.getCostoTotal() - (r.getCostoNoche() * dias);
                System.out.println("Su total a pagar es: $" + costoP);
                System.out.println("Gracias por estar con nosotros");
                reservaciones.remove(r);

            }

        }

    }
}
