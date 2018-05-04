/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia3;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author javie
 */
public class Reservacion {
    ArrayList<Paquete> paquetes = new ArrayList<>();
    public String infoHuesped;

    public String getPisoHabitacion() {
        return pisoHabitacion;
    }

    public void setPisoHabitacion(String pisoHabitacion) {
        this.pisoHabitacion = pisoHabitacion;
    }
    public String pisoHabitacion;
    public int numeroHabitacion;
    public int diasReservacion;
    public double costoNoche;
    public double costoTotal;
    public String nombrePaquete;

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
    
    public String getInfoHuesped() {
        return infoHuesped;
    }

    public void setInfoHuesped(String infoHuesped) {
        this.infoHuesped = infoHuesped;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getDiasReservacion() {
        return diasReservacion;
    }

    public void setDiasReservacion(int diasReservacion) {
        this.diasReservacion = diasReservacion;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Reservacion() {
    }

    public Reservacion(String infoHuesped, int numeroHabitacion, int diasReservacion, double costoNoche, double costoTotal, String nombrePaquete) {
        this.infoHuesped = infoHuesped;
        this.numeroHabitacion = numeroHabitacion;
        this.diasReservacion = diasReservacion;
        this.costoNoche = costoNoche;
        this.costoTotal = costoTotal;
        this.nombrePaquete = nombrePaquete;
    }
    
    public void CambiarPrecioPaquete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que paquete desea cambiar? ");
        String n = sc.nextLine();
        paquetes.forEach((Paquete paque) -> {
            if(paque.nombrePaquete.equals(n)){
                System.out.println("Nuevo precio del paquete: ");
                double precioNuevo = sc.nextDouble();
                paque.precioPaquete = precioNuevo;
            }
            else{
                System.out.println("El paquete que desea no existe o ya no esta disponible");
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
            }
            else{
                System.out.println("El paquete que desea no existe o ya no esta disponible");
            }
        });
    }
    
    public void mostrarPaquete(){
        paquetes.forEach((Paquete paque) -> {
            System.out.println(paque.nombrePaquete+" "+paque.contenidoPaquete+" "+paque.precioPaquete);
        });
    }
    
    public void CrearPaquete(){  
        Scanner sc = new Scanner(System.in);
        String nuevoNombrePaquete,contenidoPaquete;
        double precioPaquete;
        //Como en el hotel ya se encuentran 2 paquetes predeterminados, si estos no estan todavia se agregan
        if(paquetes == null || paquetes.isEmpty()){
            Paquete paqueteBasico = new Paquete("Basico","Acceso a la pisina y acceso a internet ilimitado",10);
            paquetes.add(paqueteBasico);
            Paquete paquetePremium = new Paquete("Premium","acceso al buffet de desayuno, acceso ilimitado a la pisina, servicio a la habitacion,"
                    + "acceso ilimitado al minibar y acceso a internet ilimitado",150);
            paquetes.add(paquetePremium);
        }
        else{
            System.out.println("Introduzca el nombre del paquete: ");
            nuevoNombrePaquete = sc.nextLine();

            System.out.println("Introduzca el contenido del paquete: ");
            contenidoPaquete = sc.nextLine();

            System.out.println("Introduzca el precio del paquete: ");
            precioPaquete = sc.nextDouble();

            Paquete nuevoPaquete = new Paquete(nuevoNombrePaquete,contenidoPaquete,precioPaquete);

            paquetes.add(nuevoPaquete);
        }
    }
    
    private double SeleccionarPaquete(){
        Scanner sc = new Scanner(System.in);
        String Pack;
        System.out.println("¿Que paquete desea?");
        Pack = sc.nextLine();
        double precio = -1;
        for (Paquete paques : paquetes){
            if(paques.nombrePaquete.equals(Pack)){
                precio = paques.precioPaquete; 
            }
        }
        return precio;
    }
    
    public double PrecioPaquete(){
        double precio = SeleccionarPaquete();
        if(precio == -1){
            System.out.println("Su paquete no fue encontrado");
            return 0;
        }
        else{
            return precio;
        }
    }
}
