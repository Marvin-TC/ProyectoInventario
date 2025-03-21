package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> listaProducto =new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        poblarListadoProducto();
        int opcion = 0;
        do{
            mostrarMenu();
            opcion = sc.nextInt();

            if (opcion==1)
            {

            } else if (opcion==2) {
                //mostar lista de operacion
                mostarListaDeProducto();
            }else if (opcion==3) {

            }else if (opcion==4) {

            }
        }while (opcion!=5);{
            if (sc!=null){sc.close();}
            System.out.println("saliendo del programa");}


    }
    public static void mostrarMenu()
    {
        System.out.println("***************** MENU ****************");
        System.out.println("* 1) Agregar Producto                 *");
        System.out.println("* 2) Mostrar Producto                 *");
        System.out.println("* 3) Actualizar Cantidad de producto  *");
        System.out.println("* 4) eliminar Producto                *");
        System.out.println("* 5) salir                            *");
        System.out.println("***************************************");
        System.out.print("Ingrese una opcion del menu: ");
    }

    public static void poblarListadoProducto()
    {
        listaProducto.add("1020,Dorito rojo,10,4.00");
        listaProducto.add("1021,Jugo del frutal,5,5.00");
        listaProducto.add("1022,Sopa Instantanea,8,5.00");
        listaProducto.add("1023,Pepsi 3L,1,18.00");
    }

    public static void mostarListaDeProducto(){
        if (listaProducto.isEmpty())
        {System.out.println("lista de productos vacios");}
        else {
            for (String productoTemp: listaProducto){
                String[] atributos = productoTemp.split(",");
                System.out.println("Codigo:    "+atributos[0]);
                System.out.println("Nombre:    "+atributos[1]);
                System.out.println("Stock:     "+atributos[2]);
                System.out.println("Precio:     Q "+atributos[3]);
                System.out.println("");
            }
            System.out.println("-------- fin de operacion -----------");
        }

    }
}