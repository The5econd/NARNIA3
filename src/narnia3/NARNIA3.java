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
 * @author thesecond
 */
public class NARNIA3 {

    public static void main(String[] args) {
        AdminHotel ADMIN = new AdminHotel();
    }
    public void menu(){
        AdminHotel Admin = new AdminHotel();
        Cliente CLIENTE = new Cliente();
        String opcion;
        Scanner input= new Scanner(System.in);
        System.out.println("***************MENU***************");
        System.out.println("1.Ver reservaciones de la semana");
        System.out.println("2.Habilitar habitaciones");
        System.out.println("3.Habilitar piso");
        System.out.println("4.Modificar habitacion");
        System.out.println("5.Agregar cliente");
        System.out.println("6.Mostrar habitaciones disponibles");
        System.out.println("7.Hacer reservacion");
        System.out.println("8.Cancelar reservacion");
        System.out.println("9.MOdificar reservacion");
        opcion=input.next();
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
            case 6:
                Admin.MostrarHabitacionesDisponibles();
                break;
            case 7:
                CLIENTE.HacerReservacion();
                break;
            case 8:
            case 9:
             
            }
    }
    
}
