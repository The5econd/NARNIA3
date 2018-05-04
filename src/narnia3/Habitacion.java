
package narnia3;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author thesecond
 */
public class Habitacion {
    private String piso;
    private int numero;
    private double precioHabitacion;
    private String idHabitacion;
    boolean disponible;
    
    public boolean getEstado() {
        return disponible;
    }

    public void setEstado(boolean estado) {
        this.disponible = estado;
    }
    
    public Habitacion(){
        disponible=true;
    }
    
    public Habitacion(String Piso, int Numero, double PrecioHab){
    this.piso=Piso;
    this.numero=Numero;
    this.precioHabitacion=PrecioHab;
    this.disponible=true;
    }
    
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
        return idHabitacion + numero;
    }
    
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

}
