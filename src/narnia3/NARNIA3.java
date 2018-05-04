/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia3;
import java.util.Scanner;


/**
 *
 * @author thesecond
 */
public class NARNIA3 {

    public static void main(String[] args) {
        AdminHotel AD = new AdminHotel();
    }
    public void menu(){
        //se crea objeto de la clase AdminHotel
        AdminHotel Admin = new AdminHotel();
        //se crea objeto de la clase CLiente
        Cliente CLIENTE = new Cliente();
        //se crea objeto de la clase Reservacion
        Reservacion RES = new Reservacion();
        String opcion;
        Scanner input= new Scanner(System.in);
        //SE IMPRIME EL MENU
        System.out.println("***************MENU***************");
        System.out.println("1.Ver reservaciones de la semana");
        System.out.println("2.Habilitar habitaciones");
        System.out.println("3.Habilitar piso");
        System.out.println("4.Modificar habitacion");
        System.out.println("5.Agregar cliente");
        System.out.println("6.Mostrar habitaciones disponibles");
        System.out.println("7.Hacer reservacion");
        System.out.println("8.Cancelar reservacion");
        System.out.println("9.Modificar reservacion");
        //la variable opcion es transformada de String a Int para poder usarla en el switch
        opcion=input.next();
        /*con un Switch mandamos a llamar a todos los metodos dandole uso a los 
        objetos de las clases creados aneriormente*/
        int OP=Integer.parseInt(opcion);
        switch(OP){
            case 1:
            case 2:
                Admin.HabilitarHabitacion();
                break;
            case 3:
                Admin.HabilitarPiso();
                break;
            case 4:
                Admin.ModificarHabitacion();
                break;
            case 5:
                Admin.AgregarCliente();
                break;
            case 6:
                Admin.MostrarHabitacionesDisponibles();
                break;
            case 7:
                CLIENTE.HacerReservacion();
                //RES.PrecioPaquete();
                break;
            case 8:
                CLIENTE.CancelarReservacion();
                break;
            case 9:
                CLIENTE.ModificarReservacion();
                break;
            default:
                System.out.println("Ha ingresado una opcion invalida");
             
            }
    }
    
}
