/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sistematiendaelpirata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner; 
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 *
 * @author gabre
 */
public class SistemaTiendaElpirata {

    //Atributos
    private static Scanner stdIn = new Scanner(System.in);

    private Cliente cliente;
    private Item item;
    private static CatalogoProducto catalogoProducto;
    private static ListaUsuarios listaDeUsuarios;
    private static CatalogoCliente catalogoClientes;
    private static CatalogoProveedor catalogoProveedor;
    private static ListaDeReportes listaDeReportes;
    private static Almacen almacen;
    private static RegistroFacturas registroDeFacturas;
    private static SistemaTiendaElpirata sistemaTiendaElpirata = new SistemaTiendaElpirata();
    
    //Metodos
    
    public SistemaTiendaElpirata() {
        listaDeUsuarios = new ListaUsuarios();
        catalogoClientes = new CatalogoCliente();
        catalogoProveedor = new CatalogoProveedor();
        listaDeReportes = new ListaDeReportes();
        almacen = new Almacen();
        registroDeFacturas = new RegistroFacturas();
        catalogoProducto = new CatalogoProducto();
        
    }

    public static void main(String[] args) {

        sistemaTiendaElpirata.cargarDatos();

        System.out.println("""
                *********************************************************************
                *                     Sistema Tienda El Pirata                      *
                *********************************************************************
                """);

        System.out.println(sistemaTiendaElpirata.menu());
        sistemaTiendaElpirata.principal();
        
        
        
        /*
        1.	Reporte de Clientes.
        2.	Reporte de Proveedores.
        3.	Reporte de Inventarios.
        4.	Reporte de Compras.
        5.	Reporte de Ventas.
        6.	Nota de Venta
        7.	Factura.
        8.	Reporte de Ganancias por periodo.
        */
        
    }
//////////////////menu///////////////////////////////////////////////////////////////
    public void principal() {
        cargarDatos();
        while (true) {
            int op = opcion();
            switch (op) {
                case 0 -> {
                    return;
                }
                case 1 -> DisplayClientes();
                case 2 -> DisplayProveedores();
                case 3 -> DisplayAlmacen();
                case 4 -> DisplayCompras();
            }
        }
    }

    private String menu(){
        String res = "[0] Quit";
        res += "\n[1] Reporte de Clientes";
        res += "\n[2] Reporte de Proveedores";
        res += "\n[3] Reporte de Inventarios";
        res += "\n[4] Reporte de Compras";
        res += "\n[5] Reporte de Ventas";
        res += "\n[6] Register sale of current order";
        res += "\n[7] Display sales";
        res += "\n[8] Display number of orders with a specific product";
        res += "\n[9] Display the total quantity sold for each product";
        res += "\nchoice";
        return res;
    }

    
    public int opcion(){
        while (true){
            try{
                int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
                if (op > -1 && op < 10){
                    return op;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Se espera un número del 0 al 9");
            }
        }
    }

    
    
    //Reporte de Clientes
    public void DisplayClientes(){
        System.out.println(catalogoClientes.getListaClientes());
    }

    //Reporte de Proveedores
    public void DisplayProveedores(){
        System.out.println(catalogoProveedor.getListaProveedores());
    }

    //display Reporte de Inventarios.
    public void DisplayAlmacen(){
        System.out.println(almacen.getItems());
    }

    //Reporte de Compras
    public void DisplayCompras(){

        System.out.println("1.General\n2.Periodo");
        int i=Integer.parseInt(stdIn.nextLine());

        switch(i){
            case 1:{

                    System.out.println(registroDeFacturas.getFacturasCompra());
                
                
                
                
            }
            case 2: {
                while(true){
                try {
                    System.out.println("Ingrese la fecha inicial del periodo (dd/MM/aaaa)");
                    Date fechaInicial = new SimpleDateFormat("dd/MM/yyyy").parse(stdIn.nextLine());
                    System.out.println("Ingrese la fecha final del periodo (dd/MM/aaaa)");
                    Date fechaFinal = new SimpleDateFormat("dd/MM/yyyy").parse(stdIn.nextLine());
                    
                    System.out.println(registroDeFacturas.getFacturasCompraPeriodo(fechaInicial, fechaFinal));

                    if(fechaInicial!=null && fechaFinal != null){break;}
                    
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Se esperan valores numericos");
                    }catch (ParseException nfe) {
                        JOptionPane.showMessageDialog(null, "Ingrese el valor de fecha correctamente");
                    }
                }
            }
        }
        

    }
///////////////////cargar datos///////////////////////////////////////////////////////////////
    private static void cargarDatos() {
        BufferedReader fileIn;
        
        try {
            String dato;
            
            fileIn = new BufferedReader(new FileReader("Almacen.txt"));
            dato = fileIn.readLine();

            while (dato!= null) {
                almacen.addItem(iniciarAlmacen(dato));
                dato = fileIn.readLine();
            }
            ////////////////////////////////////////////////////////////////////////////
            fileIn = new BufferedReader(new FileReader("CatalogoCliente.txt"));
            dato = fileIn.readLine();

            while (dato!= null) {
                catalogoClientes.addCliente(iniciarCatalogoCliente(dato));
                dato = fileIn.readLine();
            }
            ////////////////////////////////////////////////////////////////////////////

            fileIn = new BufferedReader(new FileReader("CatalogoProveedor.txt"));
            dato = fileIn.readLine();

            while (dato!= null) {
                catalogoProveedor.addProveedor(iniciarCatalogoProveedor(dato));
                dato = fileIn.readLine();
            }
            ////////////////////////////////////////////////////////////////////////////

            fileIn = new BufferedReader(new FileReader("ListaReportes.txt"));
            dato = fileIn.readLine();

            while (dato!= null) {
                listaDeReportes.addReporte(iniciarListaDeReportes(dato));
                dato = fileIn.readLine();
            }
            ////////////////////////////////////////////////////////////////////////////

            fileIn = new BufferedReader(new FileReader("ListaUsuarios.txt"));
            dato = fileIn.readLine();

            while (dato!= null) {
                listaDeUsuarios.addUsuario(iniciarListaUsuarios(dato));
                dato = fileIn.readLine();
            }
            ////////////////////////////////////////////////////////////////////////////

            fileIn = new BufferedReader(new FileReader("RegistroFacturas.txt"));
            dato = fileIn.readLine();

            while (dato!= null) {
                registroDeFacturas.addFactura(iniciarRegistroFactura(dato));
                dato = fileIn.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    /*private Product crearCoffee(String dato) {
        String [] valores = dato.split("_");
        return new Coffee(valores[1], valores[2], Double.parseDouble(valores[3]), valores[4], valores[5], valores[6], valores[7], valores[8], valores[9]);
    } */
    private  static Item iniciarAlmacen(String dato){
        String [] valores = dato.split(",");
        Producto producto = catalogoProducto.getProducto(valores[1]);
        return new Item(Integer.parseInt(valores[0]), producto);

    }


    private  static Cliente iniciarCatalogoCliente(String dato){
        String [] valores = dato.split(",");

        return new Cliente(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]);
    }


    private  static Proveedor iniciarCatalogoProveedor(String dato){
        String [] valores = dato.split(",");
        return new Proveedor(valores[0],valores[1],valores[2],valores[3],valores[4],valores[5],valores[6],valores[7],valores[8]);
    }


    private static Reporte iniciarListaDeReportes(String dato){
        String [] valores = dato.split(",");

        return new Reporte(valores[0],listaDeUsuarios.getUsuario(valores[1]),valores[2]);
    }


    private  static Usuario iniciarListaUsuarios(String dato){
        String [] valores = dato.split(",");
        return new Usuario(valores[0], valores[1], valores[2], valores[3]);
        
    }

    private  static Factura iniciarRegistroFactura(String dato) {
        String [] valores = dato.split(",");
        try{
            if(dato.startsWith("c")){
                //                        String idFactura, Date fechaEmision, Proveedor proveedor, Date ingresoAlmacen, String formaDePago, double total
                return new FacturaCompras(valores[0], new SimpleDateFormat("dd/MM/yyyy").parse(valores[1]), catalogoProveedor.getProveedor(valores[2]), new SimpleDateFormat("dd/MM/yyyy").parse(valores[3]), valores[4], Double.parseDouble(valores[5]));
            } else {
                if(dato.startsWith("v")){
                    return new FacturaVentas(valores[0], new SimpleDateFormat("dd/MM/yyyy").parse(valores[1]), catalogoClientes.getCliente(valores[2]), valores[3]);
                }
        }
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Se espera un valor numerico");
        }catch (ParseException nfe) {
            JOptionPane.showMessageDialog(null, "Se bugio el programa llamen a la policia weoo weoo weoo");
        }

        //throws NumberFormatException, ParseException

        return null;
        
    }

    

    
}
