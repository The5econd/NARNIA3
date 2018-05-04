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
    private ArrayList<Reservacion> reservaciones;
    private ArrayList<Paquete> paquetes;
    private int numeroPisos=6;
    private int numeroHabitaciones=10;
    private double precioHabitacion=500;
    Scanner input= new Scanner(System.in);
    
    public AdminHotel(){
        clientes= new ArrayList<Cliente>();
        habitaciones= new ArrayList<Habitacion>();
        reservaciones = new ArrayList<Reservacion>();
        paquetes = new ArrayList<Paquete>();
        CrearHabitaciones();
        if(paquetes == null || paquetes.isEmpty()){
            Paquete paqueteBasico = new Paquete("Basico","Acceso a la pisina y acceso a internet ilimitado",10);
            paquetes.add(paqueteBasico);
            Paquete paquetePremium = new Paquete("Premium","acceso al buffet de desayuno, acceso ilimitado a la pisina, servicio a la habitacion,"
                    + "acceso ilimitado al minibar y acceso a internet ilimitado",150);
            paquetes.add(paquetePremium);
        }
    }

//EL MENU PRINCIPAL
    public void menu(){
        int opcion;
        boolean corriendo=true;

        while(corriendo){
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
            System.out.println("11.Modificar paquetes");
            System.out.println("12.Salir");
            opcion=input.nextInt();
            switch(opcion){
                case 1:
                    AgregarCliente();
                    break;
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
                    MostrarReservacion();
                    break;
                case 6:
                    MostrarHabitacionesDisponibles();
                    break;
                case 7:
                    HacerReservacion();
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
                    ModificarPaquete();
                    break;
                case 12:
                    corriendo=false;
                    break;
                default:
                    System.out.println("Ha ingresado una opcion invalida");
                    break;
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
        System.out.println("*****BIENVENIDO AL HOTEL VIÑA RAFINHA***********");
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
                opcion=input.nextInt();
                switch(opcion){
                    case 1:
                        double nuevoPrecio;
                        System.out.println("Ingrese el nuevo precio de la habitacion:");
                        nuevoPrecio=input.nextInt();
                        h.setPrecioHab(nuevoPrecio);
                        System.out.println("El precio de la habitacion "+h.getIDhabitacion()+" ha sido actualizado con exito!");
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
        System.out.println("El precio de todas las Habitaciones ha sido actualizado con exito!");
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
                        System.out.println(h.getIDhabitacion()+" ha sido habilitada");
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
    
    //Reservacion
    public void HacerReservacion() {
        Reservacion reservacion = new Reservacion();
        Scanner leer = new Scanner(System.in);
        int numHabitacion = 0, opc, diasReservacion = 0;
        double costoTotal, precioPaquete;
        String piso = "";
        boolean cumple = true;
        String nombrePaquete;
        System.out.println("Ingrese el dui del cliente que quiera cancelar la reservacion");
        String Dui = leer.nextLine();
        for(Cliente reser: clientes){
            if(reser.Dui.equals(Dui)){
                System.out.println("Seleccione 1 para ver los paquetes disponibles o 2 si prefiere otro servicio: ");
                opc = leer.nextInt();
                switch (opc) {
                    case 1:
                    {
                            Scanner n = new Scanner(System.in);
                            mostrarPaquete();
                            System.out.println("Que paquete desea?");
                            nombrePaquete = n.nextLine();
                            precioPaquete = PrecioPaquete(nombrePaquete);
                            if(precioPaquete == 0){
                                nombrePaquete = null;
                            }
                            while(cumple){
                                System.out.println("En que piso le gustaria la habitacion(A,B,C,D,E,F): ");
                                piso = n.nextLine();
                                switch(piso){
                                    case "A":
                                    case "B":
                                    case "C":
                                    case "D":
                                    case "E":
                                    case "F":
                                        cumple = false;
                                        break;
                                    default:
                                        System.out.println("La letra que digito no corresponde con ninguno de los pisos.");
                                        break;
                                }
                            }
                            cumple = true;
                            while(cumple){
                                System.out.println("Que numero de habitacion desea(recuerde las pares son dobles y las impares sencillas): ");
                                numHabitacion = n.nextInt();
                                if(numHabitacion >=0 && numHabitacion <=10){
                                    cumple = false;
                                }
                                else{
                                    System.out.println("Solo son 10 habitaciones por piso");
                                }
                            }
                            cumple = true;
                            while(cumple){
                                System.out.println("Por cuantos dias desea reservar la habitacion: ");
                                diasReservacion = n.nextInt();
                                if(diasReservacion > 0 && diasReservacion <= 7){
                                    cumple = false;
                                }
                                else{
                                    System.out.println("Lo maximo de dias que se pueden reservar son 7");
                                }
                            }
                            String idHabitacion = piso + numHabitacion;
                            for(Habitacion h:habitaciones){ 
                                if(idHabitacion.equals(h.getIDhabitacion())){
                                    h.setEstado(false);
                                }
                            }
                            costoTotal = (CalcularPrecioHabitacion(numHabitacion, piso) * diasReservacion) + precioPaquete;
                            System.out.println("Su costo total sera de: " + "$" + costoTotal);
                            reservacion.setCostoNoche(CalcularPrecioHabitacion(numHabitacion, piso));
                            reservacion.setCostoTotal(costoTotal);
                            reservacion.setInfoHuesped(Dui);
                            reservacion.setNumeroHabitacion(numHabitacion);
                            reservacion.setDiasReservacion(diasReservacion);
                            reservacion.setPisoHabitacion(piso);
                            reservacion.setPaquete(nombrePaquete);
                            reservaciones.add(reservacion);
                            break;
                        }
                    case 2:
                        {
                            Scanner n = new Scanner(System.in);
                            while(cumple){
                                System.out.println("En que piso le gustaria la habitacion(A,B,C,D,E,F): ");
                                piso = n.nextLine();
                                switch(piso){
                                    case "A":
                                    case "B":
                                    case "C":
                                    case "D":
                                    case "E":
                                    case "F":
                                        break;
                                    default:
                                        System.out.println("La letra que digito no corresponde con ninguno de los pisos.");
                                        cumple = false;
                                        break;
                                }
                            }
                            cumple = true;
                            while(cumple){
                                System.out.println("Que numero de habitacion desea(recuerde las pares son dobles y las impares sencillas): ");
                                numHabitacion = n.nextInt();
                                if(numHabitacion >0 && numHabitacion <=10){
                                    cumple = false;
                                }
                                else{
                                    System.out.println("Solo son 10 habitaciones por piso");
                                }
                            }
                            cumple = true;
                            while(cumple){
                                System.out.println("Por cuantos dias desea reservar la habitacion: ");
                                diasReservacion = n.nextInt();
                                if(diasReservacion > 0 && diasReservacion <= 7){
                                    cumple = false;
                                }
                                else{
                                    System.out.println("Lo maximo de días que se puede reservar son 7");
                                }
                            }
                            String idHabitacion = piso + numHabitacion;
                            for(Habitacion h:habitaciones){ 
                                if(idHabitacion.equals(h.getIDhabitacion())){
                                    h.setEstado(false);
                                }
                            }
                            costoTotal = (CalcularPrecioHabitacion(numHabitacion, piso) * diasReservacion);
                            System.out.println("Su costo total sera de: " + "$" + costoTotal);
                            reservacion.setCostoTotal(costoTotal);
                            reservacion.setNumeroHabitacion(numHabitacion);
                            reservacion.setDiasReservacion(diasReservacion);
                            reservacion.setPisoHabitacion(piso);
                            reservacion.setInfoHuesped(Dui);
                            reservacion.setCostoNoche(CalcularPrecioHabitacion(numHabitacion, piso));
                            reservacion.setPaquete(null);
                            reservaciones.add(reservacion);
                            break;
                        }
                    default:
                        System.out.println("no selecciono 1 o 2");
                        break;
                }
            }
        }
    }
    public void MostrarReservacion(){
        reservaciones.forEach((re) -> {
            System.out.println("Dui: "+re.infoHuesped+" Piso: "+re.pisoHabitacion+" #habitacion: "+re.numeroHabitacion+" Dias:"+re.diasReservacion
                    +" Costo total: $"+re.costoTotal+" Paquete: "+re.Paquete);
        });
    }
    public void CancelarReservacion() {
        Scanner leer = new Scanner(System.in);
        int cont= 0,eliminar = 0;
        boolean VF =false;
        int numHabitacion = 0;
        String piso = "";
        System.out.println("Ingrese el dui del cliente que quiera cancelar la reservacion");
        String Dui = leer.nextLine();
        for(Reservacion reser: reservaciones){
            if(reser.infoHuesped.equals(Dui)){
                eliminar = cont;
                piso = reser.pisoHabitacion;
                numHabitacion = reser.numeroHabitacion;
                VF = true;
            }
            cont++;
        }
        if(VF){
            reservaciones.remove(eliminar);
            String idHabitacion = piso + numHabitacion;
                for(Habitacion h:habitaciones){ 
                    if(idHabitacion.equals(h.getIDhabitacion())){
                        h.setEstado(true);
                    }
                }
            System.out.println("La reservacion fue eliminada.");
        }
        else{
            System.out.println("No se encontro la reservacion.");
        }
    }
    //Modifica la reservacion, con o sin paquete.
    public void ModificarReservacion() {
        Scanner leer = new Scanner(System.in);
        String piso ="";
        boolean cumple = true;
        int numHabitacion, dias=0;
        double costoTotal;
        System.out.println("Ingrese el dui del cliente que quiera cancelar la reservacion");
        String Dui = leer.nextLine();
        for(Cliente reser: clientes){
            if(reser.Dui.equals(Dui)){
                System.out.println("En que piso se encuentra en ese momento: ");
                piso = leer.nextLine();
                System.out.println("En que numero de habitacion se encuentra: ");
                numHabitacion = leer.nextInt();
                Scanner n = new Scanner(System.in);
                for (Reservacion r : reservaciones) {
                    if (r.getNumeroHabitacion() == numHabitacion && r.getPisoHabitacion().equals(piso)) {
                        System.out.println("Para solo seleccionar habitacion");
                        MostrarHabitacionesDisponibles();
                        while(cumple){
                                System.out.println("En que piso le gustaria la habitacion(A,B,C,D,E,F): ");
                                piso = n.nextLine();
                                switch(piso){
                                    case "A":
                                    case "B":
                                    case "C":
                                    case "D":
                                    case "E":
                                    case "F":
                                        break;
                                    default:
                                        System.out.println("La letra que digito no corresponde con ninguno de los pisos.");
                                        cumple = false;
                                        break;
                                }
                            }
                        cumple = true;
                        while(cumple){
                                System.out.println("Que numero de habitacion desea(recuerde las pares son dobles y las impares sencillas): ");
                                numHabitacion = n.nextInt();
                                if(numHabitacion >0 && numHabitacion <=10){
                                    cumple = false;
                                }
                                else{
                                    System.out.println("Solo son 10 habitaciones por piso");
                                }
                            }

                        cumple = true;
                        while(cumple){
                            System.out.println("Cuantos dias se hospedara: ");
                            dias= n.nextInt();
                            if(dias> 0 && dias <= 7){
                                cumple = false;
                            }
                            else{
                                System.out.println("Lo maximo de días que se puede reservar son 7");
                            }
                        }
                        r.setNumeroHabitacion(numHabitacion);
                        r.setPisoHabitacion(piso);
                        costoTotal = (CalcularPrecioHabitacion(numHabitacion, piso) * dias+ PrecioPaquete(r.Paquete));
                        r.setCostoTotal(costoTotal);
                        r.setCostoNoche(CalcularPrecioHabitacion(numHabitacion, piso)+ PrecioPaquete(r.Paquete));
                        r.setDiasReservacion(dias);
                    }
                }
            }
        }
    }

    //Paquete
    public void CambiarPrecioPaquete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que paquete desea cambiar? ");
        String n = sc.nextLine();
        paquetes.forEach((Paquete paque) -> {
            if(paque.nombrePaquete.equals(n)){
                System.out.println("Nuevo precio del paquete: ");
                double precioNuevo = sc.nextDouble();
                paque.precioPaquete = precioNuevo;
                System.out.println("Se realizo el cambio de precio");
            }
        });
    }
    public void CambiarContenidoPaquete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que paquete desea cambiar? ");
        String n = sc.nextLine();
        paquetes.forEach((Paquete paque) -> {
            if(paque.nombrePaquete.equals(n)){
                System.out.println("Nuevo contenido del paquete: ");
                String precioNuevo = sc.nextLine();
                paque.contenidoPaquete = precioNuevo;
                System.out.println("Se realizo el cambio de contenido");
            }
        });
    }
    
    public void mostrarPaquete(){
        paquetes.forEach((Paquete paque) -> {
            System.out.println(paque.nombrePaquete+" "+paque.contenidoPaquete+"  $"+paque.precioPaquete);
        });
    }
    
    public void CrearPaquete(){  
        Scanner sc = new Scanner(System.in);
        String nuevoNombrePaquete,contenidoPaquete;
        double precioPaquete;
        System.out.println("Introduzca el nombre del paquete: ");
        nuevoNombrePaquete = sc.nextLine();
        System.out.println("Introduzca el contenido del paquete: ");
        contenidoPaquete = sc.nextLine();
        System.out.println("Introduzca el precio del paquete: ");
        precioPaquete = sc.nextDouble();
        Paquete nuevoPaquete = new Paquete(nuevoNombrePaquete,contenidoPaquete,precioPaquete);
        paquetes.add(nuevoPaquete);
    }
    
    private double SeleccionarPaquete(String Nombre){
        Scanner sc = new Scanner(System.in);
        double precio = -1;
        for (Paquete paques : paquetes){
            if(paques.nombrePaquete.equals(Nombre)){
                precio = paques.precioPaquete;
            }
        }
        return precio;
    }
    
    public double PrecioPaquete(String Nombre){
        double precio = SeleccionarPaquete(Nombre);
        if(precio == -1){
            System.out.println("Su paquete no fue encontrado");
            return 0;
        }
        else{
            return precio;
        }
    }
    public void ModificarPaquete(){
        Scanner n= new Scanner(System.in);
        System.out.println("1.Crear un nuevo paquete");
        System.out.println("2.Modificar el precio");
        System.out.println("3.Modificar el contenido");
        int opcion = n.nextInt();
        switch(opcion){
            case 1:
                CrearPaquete();
                break;
            case 2:
                CambiarPrecioPaquete();
                break;
            case 3:
                CambiarContenidoPaquete();
                break;
            default:
                System.out.println("No ingreso ninguna de las tres opciones");
                break;
        }
    }
}
