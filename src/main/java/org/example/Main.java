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
                agregarProducto(sc);
            } else if (opcion==2) {
                mostarListaDeProducto();
            }else if (opcion==3) {
                actualizarStockProducto(sc);
            }else if (opcion==4) {
                eliminarProducto(sc);
            }else{System.out.println("opcion no valida.");}
        }while (opcion!=5);{
            if (sc!=null){sc.close();}
            System.out.println("saliendo del programa...");}
    }


    public static void mostrarMenu()
    {
        System.out.println(" ");
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
    public static void agregarProducto(Scanner sc){
        System.out.print("Ingresa el codigo del producto con este formato 0000: ");
        String codigoNuevoProducto = sc.next();
        if (existeCodigo(codigoNuevoProducto))
        {
            //si existe el codigo
            while(existeCodigo(codigoNuevoProducto))
            {
                System.out.print("Ingresa otro codigo ya existe: ");
                codigoNuevoProducto = sc.next();
            }
            System.out.print(" ");
            System.out.println("codigo libre siguiendo el registro...");
        }
        System.out.print("Ingresa el nombre del producto: ");
        String nombreProductoNuevo = sc.next();
        System.out.print("Ingresa el stock del producto:  ");
        String stockProductoNuevo = sc.next();
        System.out.print("Ingresa el precio del producto: ");
        String precioProductoNuevo = sc.next();
        String nuevoProducto = codigoNuevoProducto+","+nombreProductoNuevo+","+stockProductoNuevo+","+precioProductoNuevo;
        listaProducto.add(nuevoProducto);
        System.out.println("registro exitoso del nuevo produco: "+codigoNuevoProducto);

    }

    public static void mostarListaDeProducto(){
        if (listaProducto.isEmpty())
        {System.out.println("lista de productos vacios");}
        else {
            System.out.println(" ");
            System.out.println("cantidad de productos ("+listaProducto.size()+")");
            System.out.println("mostrando listado de productos...");
            for (String productoTemp: listaProducto){
                String[] atributos = productoTemp.split(",");
                System.out.println("Codigo: "+atributos[0]+" Nombre: "+atributos[1]+" Stock: "+atributos[2]+" Precio: Q "+atributos[3]);
            }
            System.out.println("-------- fin de operacion -----------");
        }
    }

    private static void actualizarStockProducto(Scanner sc) {
        System.out.print("Ingresa el codigo del producto con este formato 0000: ");
        String codigoProducto= sc.next();
        if (existeCodigo(codigoProducto))
        {
            System.out.println("el pruducto existe en la lista...");
            System.out.print("Ingrese la nueva cantidad de stock: ");
            String nuevoStock = sc.next();
           for (String producto:listaProducto)
           {
              String codigoTemp = producto.split(",")[0];
              String nombreTemp = producto.split(",")[1];
              String stockTemp =  producto.split(",")[2];
              String precioTemp = producto.split(",")[3];
               if (codigoTemp.equals(codigoProducto))
               {
                   String nuevaActualizacionProducto = codigoProducto+","+nombreTemp+","+nuevoStock+","+precioTemp;
                   listaProducto.set(listaProducto.indexOf(producto),nuevaActualizacionProducto);
                   System.out.println("actualización exitosa del estock de: "+stockTemp+" a: "+nuevoStock);
                   break;
               }
           }

        }else{System.out.println("no existe ningún producto con este codigo: "+codigoProducto);}
    }

    public static boolean existeCodigo(String codigo)
    {
        if(!listaProducto.isEmpty())
        {
            for(String producto: listaProducto)
            {
                String codigoTemp = producto.split(",")[0];
                if (codigoTemp.equals(codigo))
                {return true;}
            }
        }return false;
    }

    public static void eliminarProducto( Scanner sc)
    {
        System.out.print("Ingrese un codigo con este formato 0000: ");
        String codigoProdcutoAEliminar= sc.next();

        if (existeCodigo(codigoProdcutoAEliminar))
        {
            for (String producto:listaProducto)
            {
                String codigoTemp = producto.split(",")[0];
                if (codigoTemp.equals(codigoProdcutoAEliminar))
                {
                    listaProducto.remove(producto);
                    System.out.println("se elimino correctamente el producto.");
                    break;
                }
            }
        }else {
            System.out.println("no se encontro nigún producto con el codigo ingresado.");
        }
    }

}