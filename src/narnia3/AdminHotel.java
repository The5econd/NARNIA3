package narnia3;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author feranstirman1
 */
public class AdminHotel {
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Habitacion> habitaciones;
    private int numeroPisos=6;
    private int numeroHabitaciones=10;
    private double precioHabitacion=500;
    Scanner input= new Scanner(System.in);
    
    public AdminHotel(){
        clientes= new ArrayList<Cliente>();
        habitaciones= new ArrayList<Habitacion>();
        CrearHabitaciones();
    }

//EL MENU PRINCIPAL
    public void menu(){
        int opcion;
        boolean corriendo=true;
//SE IMPRIME EL MENU
        System.out.println("***************MENU***************");
        System.out.println("1.Agregar Cliente");
        System.out.println("2.Habilitar habitaciones");
        System.out.println("3.Habilitar piso");
        System.out.println("4.Modificar habitacion");
        System.out.println("5.Mostrar reservaciones de la semana");
        System.out.println("6.Mostrar habitaciones disponibles");
        System.out.println("7.Hacer reservacion");
        System.out.println("8.Cancelar reservacion");
        System.out.println("9.Modificar reservacion");
        System.out.println("10.Modificar todas las habitaciones");
        System.out.println("11.Salir");
        while(corriendo){
            opcion=input.nextInt();
            switch(opcion){
                case 1:
                    AgregarCliente();
                case 2:
                    HabilitarHabitacion();
                    break;
                case 3:
                    HabilitarPiso();
                    break;
                case 4:
                    ModificarHabitacion();
                    break;
                case 5:
                    //LO DE LAS SEMANAS
                    break;
                case 6:
                    MostrarHabitacionesDisponibles();
                    break;
                case 7:
                    HacerReservacion();
                    //RES.PrecioPaquete();
                    break;
                case 8:
                    CancelarReservacion();
                    break;
                case 9:
                    ModificarReservacion();
                    break;
                case 10:
                    ModificarHabitaciones();
                    break;
                case 11:
                    corriendo=false;
                default:
                    System.out.println("Ha ingresado una opcion invalida");
                }
        }
    }    

//GETTERS Y SETTERS
    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }
    
    //FUNCIONES
    
    /**
     * Crea todas las habitaciones del hotel y la guarda en el ArrayList habitaciones
     */
    public void CrearHabitaciones(){
        for(int i=1;i<=numeroPisos;i+=1){
            for(int j=1;j<=numeroHabitaciones;j+=1){
                Habitacion nuevaHabitacion= new Habitacion();
                nuevaHabitacion.setNumHab(j);
                nuevaHabitacion.setPrecioHab(this.precioHabitacion);
                switch(i){
                    case 1:
                        nuevaHabitacion.setPiso("A");
                        break;
                    case 2:
                        nuevaHabitacion.setPiso("B");
                        break;
                    case 3:
                        nuevaHabitacion.setPiso("C");
                        break;
                    case 4:
                        nuevaHabitacion.setPiso("D");
                        break;
                    case 5:
                        nuevaHabitacion.setPiso("E");
                        break;
                    case 6:
                        nuevaHabitacion.setPiso("F");
                        break;
                    default:
                        System.out.println("Ha habido un error creando las habitaciones");
                }
                habitaciones.add(nuevaHabitacion);
            }
        }
        System.out.println("Se han creado todas las habitaciones con exito!");
    }
    /**
     * Se modifica el precio de un cuarto de acuerdo al ID del cuarto proporcionado
     */
    public void ModificarHabitacion(){
        String habitacion="";
        int opcion=0;
        System.out.println("Que cuarto desea modificar: ");
        habitacion= input.next();
        for(Habitacion h:habitaciones){
            if(h.getIDhabitacion().equals(habitacion)){
                System.out.println("1.Modificar Precio" );
                switch(opcion){
                    case 1:
                        double nuevoPrecio;
                        System.out.println("Ingrese el nuevo precio de la habitacion:");
                        nuevoPrecio=input.nextInt();
                        h.setPrecioHab(nuevoPrecio);
                        break;
                }
            }
        }
    }
    /**
     * Modifica el precio de todas las habitaciones
     */
    public void ModificarHabitaciones(){
        double nuevoPrecio;
        System.out.println("Ingrese el nuevo precio para todas las habitaciones");
        nuevoPrecio=input.nextDouble();
        for(Habitacion h:habitaciones){
            h.setPrecioHab(nuevoPrecio);
        }
    }
    /**
     * Cambia la disponibilidad de cierta habitacion
     */
    public void HabilitarHabitacion(){
        String idHabitacion;
        int opcion=0;
        boolean habilitado;
        System.out.println("1.Habilitar Habitacion 2.Deshabilitar Habitacion");
        opcion=input.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Ingrese el codigo de la habitacion a habiliar:");
                idHabitacion=input.next();
                for(Habitacion h:habitaciones){
                    if(idHabitacion.equals(h.getIDhabitacion())){
                        h.setEstado(true);
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese el codigo de la habitacion a deshabilitar:");
                idHabitacion=input.next();
                for(Habitacion h:habitaciones){ 
                    if(idHabitacion.equals(h.getIDhabitacion())){
                        h.setEstado(false);
                        System.out.println(h.getIDhabitacion()+" ha sido deshabilitada");
                    }
                }
                break;
            default:
                System.out.println("Ha ingresado una opcion no valida");
        }
    }
    
    /**
     * Cambia la disponibilidad de Cierto Piso
     */
    public void HabilitarPiso(){
        String piso;
        System.out.println("Ingrese el piso a modificar:");
        piso=input.next();
        int opcion=0;
        System.out.println("1.Habilitar Piso 2.Deshabilitar Piso");
        opcion=input.nextInt();
        for(Habitacion h:habitaciones){
            if(piso.equals(h.getPiso())){
                switch(opcion){
                    case 1:
                        h.setEstado(true);
                        break;
                    case 2:
                        h.setEstado(false);
                        break;
                    default:
                        System.out.println("Ingreso una opcion no valida");
                }
            }
        }
    }
    
    /*
    Devuelve el precio de la habiacion elegida por el cliente
    */
    
    public double CalcularPrecioHabitacion(int numHabitacion  , String piso){ 
        for(Habitacion e : habitaciones){
            if(e.getNumHab()==numHabitacion && e.getPiso().equals(piso))
                return e.getPrecioHab();
        }
        return 0;
    }
    
    /**
     * Muestra cuales habitaciones del hotel estan disponibles
     */
    public void MostrarHabitacionesDisponibles(){
        for(Habitacion h:habitaciones){
            if(h.getEstado()){
                System.out.println(h.getIDhabitacion()+" esta disponible");
            }
        }
    }
    
    /**
     * Agrega a un nuevo cliente al hotel y verifica si esta cliente ya exisitia
     */
    public void AgregarCliente(){
        boolean existeCliente=false;
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.getInfoCliente();
        for(Cliente c:clientes){
            if(c.getDui().equals(nuevoCliente.getDui())){
                existeCliente=true;
            }
        }
        if(existeCliente){
            System.out.println("Este cliente ya existia en los registros del hotel");
        }else{
            clientes.add(nuevoCliente);
        }
    }
    
    public void HacerReservacion(){
        String duiCliente;
        System.out.println("Ingrese el dui del cliente que quiera hacer la reservacion: ");
        duiCliente=input.nextLine();
        for(Cliente c:clientes){
            if(duiCliente.equals(c.getDui())){
                c.HacerReservacion();
            }
        }
    }
    
    public void ModificarReservacion(){
        String duiCliente;
        System.out.println("Ingrese el dui del cliente que quiera modificar la reservacion: ");
        duiCliente=input.nextLine();
        for(Cliente c:clientes){
            if(duiCliente.equals(c.getDui())){
                c.ModificarReservacion();
            }
        }
    }
    
    public void CancelarReservacion(){
        String duiCliente;
        System.out.println("Ingrese el dui del cliente que quiera cancelar la reservacion: ");
        duiCliente=input.nextLine();
        for(Cliente c:clientes){
            if(duiCliente.equals(c.getDui())){
                c.CancelarReservacion();
            }
        }
    }
}
