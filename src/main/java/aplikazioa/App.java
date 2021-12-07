package aplikazioa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static int num1 = 0, num2= 0; //variables
    static int select; //Guardaremos la opcion del usuario

    public static int suma (int primerNumero, int segundoNumero){
        return primerNumero + segundoNumero;
    }

    public static int resta (int primerNumero, int segundoNumero){
        return primerNumero-segundoNumero;
    }

    public static int multiplicacion(int primerNumero, int segundoNumero){
        return primerNumero * segundoNumero;
    }

    public static int division(int primerNumero, int segundoNumero){
        return primerNumero/segundoNumero;
    }

    public static void pideNumeros(){
        System.out.println("Introduce numero 1:");
        num1 = sc.nextInt();
        System.out.println("Introduce numero 2:");
        num2 = sc.nextInt();

        System.out.println("\n");
    }





    public static void main(String[] args) {
            boolean salir = false;

        while(!salir){
            //Try catch para evitar que el programa termine si hay un error


                System.out.println("Elige opción:\n1.- Sumar" +
                        "\n2.- Restar\n" +
                        "3.- Multiplicar\n" +
                        "4.- Dividir\n" +
                        "0.- Salir");

            try{
                select = sc.nextInt();

                //Ejemplo de switch case en Java
                switch(select){
                    case 1:
                        pideNumeros();
                        System.out.println(num1+" + "+num2+" = "+suma(num1,num2));
                        break;
                    case 2:
                        pideNumeros();
                        System.out.println(num1+" - "+num2+" = "+resta(num1,num2));
                        break;
                    case 3:
                        pideNumeros();
                        System.out.println(num1+" * "+num2+" = "+multiplicacion(num1,num2));
                        break;
                    case 4:
                        pideNumeros();
                        System.out.println(num1+" / "+num2+" = "+division(num1,num2));
                        break;
                    case 0:
                        salir=true;
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Número no reconocido");break;
                }

                System.out.println("\n"); //Mostrar un salto de línea en Java

            }catch(InputMismatchException e){
                System.out.println("Uoop! Error!");
                System.out.println("No se ingreso un entero");
                sc.nextInt();
            }
        }
        sc.close();


    }
}
