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
    public int numeroHabitacion;
    public int diasReservacion;
    public double costoNoche;
    public double costoTotal;

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

    public Reservacion(String infoHuesped, int numeroHabitacion, int diasReservacion, double costoNoche, double costoTotal) {
        this.infoHuesped = infoHuesped;
        this.numeroHabitacion = numeroHabitacion;
        this.diasReservacion = diasReservacion;
        this.costoNoche = costoNoche;
        this.costoTotal = costoTotal;
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
        });
    }
    
    public void mostrarPaquete(){
        paquetes.forEach((Paquete paque) -> {
            System.out.println(paque.nombrePaquete+" "+paque.contenidoPaquete+" "+paque.precioPaquete);
        });
    }
    
    public void CrearPaquete(){  
        Scanner sc = new Scanner(System.in);
        String nombrePaquete,contenidoPaquete;
        double precioPaquete;
        
        System.out.println("Introduzca el nombre del paquete: ");
        nombrePaquete = sc.nextLine();
        
        System.out.println("Introduzca el contenido del paquete: ");
        contenidoPaquete = sc.nextLine();
        
        System.out.println("Introduzca el precio del paquete: ");
        precioPaquete = sc.nextDouble();
        
        Paquete nuevoPaquete = new Paquete(nombrePaquete,contenidoPaquete,precioPaquete);
        
        paquetes.add(nuevoPaquete);
    }
    
    public double SeleccionarPaquete(){
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
}
