
package narnia3;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author thesecond
 */
public class Habitacion {
    //creando todos los atributos del objeto
    private String piso;
    private int numero;
    private double precioHabitacion;
    private String idHabitacion;
    boolean disponible;
    //creando constructor vacio
    public Habitacion(){
        disponible=true;
    }
    //creando constructor lleno
    public Habitacion(String Piso, int Numero, double PrecioHab){
    this.piso=Piso;
    this.numero=Numero;
    this.precioHabitacion=PrecioHab;
    this.disponible=true;
    }
    //creando los GETTERS 
    public String getPiso(){
        return piso;
    }
    public int getNumHab(){
        return numero;
    }
    public double getPrecioHab(){
        return precioHabitacion;
    }
    public String getIDhabitacion(){
        return piso+String.valueOf(numero);
    }
    public boolean getEstado() {
        return disponible;
    }
    
    //CREANDO LOS SETTERS
    public void setPiso(String Piso){
        this.piso=Piso;
    }
    public void setNumHab(int Numero){
        this.numero=Numero;
    }
    public void setPrecioHab(double PrecioHab){
        this.precioHabitacion=PrecioHab;
    }
    public void setIDhabitacion(String idHab){
        this.idHabitacion=idHab;
    }
    public void setEstado(boolean estado) {
        this.disponible = estado;
    }

}
