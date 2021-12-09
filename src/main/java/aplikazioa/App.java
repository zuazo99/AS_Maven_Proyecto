package aplikazioa;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw;

    static {
        try {

            FileWriter file = new FileWriter("./app/data/Resultados.txt",true);
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        System.out.println("Introduce el primer valor ");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo valor:");
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
                int resultado = 0;
                select = sc.nextInt();

                //Ejemplo de switch case en Java
                switch(select){
                    case 1:
                        pideNumeros();
                        resultado = suma(num1,num2);
                        System.out.println(num1+" + "+num2+" = "+resultado);

                        break;
                    case 2:
                        pideNumeros();
                        resultado = resta(num1,num2);
                        System.out.println(num1+" - "+num2+" = "+resultado);
                        break;
                    case 3:
                        pideNumeros();
                        resultado = multiplicacion(num1,num2);
                        System.out.println(num1+" * "+num2+" = "+resultado);
                        break;
                    case 4:
                        pideNumeros();
                        resultado = division(num1,num2);
                        System.out.println(num1+" / "+num2+" = "+resultado);
                        break;
                    case 0:
                        salir=true;
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Número no reconocido");break;
                }

                if (select>0 && select<=4){
                    pw.println(resultado);
                }

                System.out.println("\n"); //Mostrar un salto de línea en Java

            }catch(InputMismatchException e){
                System.out.println("Uoop! Error!");
                System.out.println("No se ingreso un entero");
                sc.nextInt();
            }
        }
        sc.close();
        pw.close();


    }
}
