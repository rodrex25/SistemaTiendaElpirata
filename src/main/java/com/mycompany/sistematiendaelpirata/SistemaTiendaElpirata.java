/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sistematiendaelpirata;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 *
 * @author gabre
 */
public class SistemaTiendaElpirata {
    
    //auxiliares
    private static Cliente auxCliente;
    private static Item auxItem;
    private static FacturaVentas auxFacturaVentas;
    private static FacturaCompras auxFacturaCompras;
    private static Producto auxProducto;
    private static Proveedor auxProveedor;
    
    //Atributos
    private static Scanner stdIn = new Scanner(System.in);

    private static Double totalCompras;
    private static Double totalVentas;
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
        catalogoProducto = new CatalogoProducto();
        almacen = new Almacen();
        listaDeUsuarios = new ListaUsuarios();
        catalogoClientes = new CatalogoCliente();
        catalogoProveedor = new CatalogoProveedor();
        listaDeReportes = new ListaDeReportes();
        registroDeFacturas = new RegistroFacturas();
        
    }

    public static void main(String[] args) {
        
        System.out.println("""
                *********************************************************************
                *                     Sistema Tienda El Pirata                      *
                *********************************************************************
                """);

        
       
                
        
    }
//////////////////menu///////////////////////////////////////////////////////////////
    public void principal() {
        
        cargarDatos();
        while (true) {
            int op = opcion();
            switch (op) {
                case 0 -> {
                    SubirDatos();
                    return;
                }
                case 1 -> DisplayClientes();
                case 2 -> DisplayProveedores();
                case 3 -> DisplayAlmacen();
                case 4 -> DisplayCompras();
                case 5 -> DisplayVentas();
                case 6 -> AddVenta();
                case 7 -> AddCompra();
                case 8 -> ModifyFacturaVenta();
                case 9 -> ModifyAlmacen();
                case 10 -> DisplayGananciasPeriodo();
                case 11 -> System.out.println(listaDeReportes.getListaReportes());
            }
        }
    }

    private String menu(){
        String res = "[0] Cerrar";
        res += "\n[1] Reporte de Clientes";
        res += "\n[2] Reporte de Proveedores";
        res += "\n[3] Reporte de Inventarios";
        res += "\n[4] Reporte de Compras";
        res += "\n[5] Reporte de Ventas";
        res += "\n[6] Facturar venta";
        res += "\n[7] Facturar Compra";
        res += "\n[8] Modificar factura de venta";
        res += "\n[9] Movimientos extraordinarios";
        res += "\n[10] Reporte de ganancias por periodo";
        res += "\n[11] Reportes de movimientos";
        res += "\nEscoge una opción";
        return res;
    }

    public int opcion(){
        while (true){
            try{
                System.out.println(menu());
                int op = Integer.parseInt(stdIn.nextLine());
                if (op > -1 && op < 10){
                    return op;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Se espera un número del 0 al 11");
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

        System.out.println("[1]Reporte de compras general\n[2]Reporte de compras por periodo\nEscoge una opción");
        int i = Integer.parseInt(stdIn.nextLine());

        switch(i){
            case 1:{
                System.out.println(registroDeFacturas.getListaFacturaCompras());
                break;
                
            }
            case 2: {
                while(true) {
                
                System.out.println("Ingrese la fecha inicial del periodo (dd/MM/aaaa)");
                String x = stdIn.nextLine();
                
                System.out.println("Ingrese la fecha final del periodo (dd/MM/aaaa)");
                String y = stdIn.nextLine();
                Date fechaX = null;
                Date fechaY = null;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
                try {
                    fechaX = sdf.parse(x);
                    fechaY = sdf.parse(y);
        
                } catch (ParseException nfe) {
                    System.out.println("Ingrese el valor de fecha correctamente");
                } catch (NumberFormatException nfe) {
                    System.out.println("Se esperan valores numericos");
                }
                
                System.out.println(registroDeFacturas.getFacturasCompraPeriodo(fechaX, fechaY));
                if(fechaX != null && fechaY != null){break;}
                
                } 
                
                break;
            }
        }
        
    }

    //Reporte Ventas
    public static void DisplayVentas() {

        System.out.println("[1]Reporte de ventas general\n[2]Reporte de ventas por periodo\nEscoge una opción");
        int i = Integer.parseInt(stdIn.nextLine());

        switch(i){
            case 1:{
                System.out.println(registroDeFacturas.getListaFacturaVentas());
                break;
                
            }
            case 2: {
                while(true) {
                try {
                    System.out.println("Ingrese la fecha inicial del periodo (dd/MM/aaaa)");
                    Date fechaInicial = new SimpleDateFormat("dd-MM-yyyy").parse(stdIn.nextLine());
                    System.out.println("Ingrese la fecha final del periodo (dd/MM/aaaa)");
                    Date fechaFinal = new SimpleDateFormat("dd-MM-yyyy").parse(stdIn.nextLine());
                    
                    System.out.println(registroDeFacturas.getFacturasVentaPeriodo(fechaInicial, fechaFinal));

                    if(fechaInicial != null && fechaFinal != null){break;}
                
                } catch (NumberFormatException nfe) {
                    System.out.println("Se esperan valores numericos");
                } catch (ParseException nfe) {
                    System.out.println("Ingrese el valor de fecha correctamente");
                }
                    
                } break;
            }
        }
    }
    
    //Facturar venta
    public void AddVenta() {
        double total = 0;
        int idFactura = getRandom();
        String date;
        Date fechaEmision = null;
        String direccionEnvio;
        String idProducto;
        int cantidad;
        String decision;
        
        while(true){
        System.out.println("Ingrese la fecha de venta en el formato dd/mm/aaaa");
        
        try{
            date = stdIn.nextLine();
            SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
            fechaEmision = sfm.parse(date);
            
        
        } catch (NumberFormatException nfe) {
            System.out.println("Se espera un valor numerico");
            
        } catch (ParseException nfe) {
            System.out.println("Se espera una fecha");
            
        }
        if(fechaEmision != null){break;}
        
        }
        
        while(true){
        System.out.println("Escriba la id del Cliente");
        
        auxCliente = catalogoClientes.getCliente(stdIn.nextLine());
        
        if(auxCliente != null){break;}
        else{System.out.println("No se encontro el Cliente");
        }
        }
        System.out.println("Escriba la direccion de envio");
        direccionEnvio = stdIn.nextLine();
        
        auxFacturaVentas = new FacturaVentas("v"+idFactura,fechaEmision,auxCliente,direccionEnvio,0.0 );
        
        while(true){
            System.out.println("Escriba el ID del producto a anadir");
            idProducto = stdIn.nextLine();
             
            if(catalogoProducto.getProducto(idProducto)!= null){
                 
                auxProducto=catalogoProducto.getProducto(idProducto);
                 
                System.out.println("Digite la cantidad");
                cantidad = Integer.parseInt(stdIn.nextLine());
                 
                auxItem = new Item(cantidad, auxProducto);

                if(almacen.getItem(auxProducto).getCantidad() == 0){
                    System.out.println("sin existencia en almacen");
                }

                if(almacen.getItem(auxProducto).getCantidad() >= cantidad){

                    almacen.getItem(auxProducto).setCantidad(almacen.getItem(auxProducto).getCantidad() - cantidad);
                    auxFacturaVentas.addItem(auxItem);
                    total=total+(auxItem.getCantidad()*auxItem.getProducto().getPrecioUnitarioVenta());
                    System.out.println( "Se agrego el producto");
                   
                } else {
                    System.out.println("La cantidad supera los productos disponibles");
                }
                             
                System.out.println("¿Desea agregar otro producto?\n[1]Si\n[2]No");
                decision = stdIn.nextLine();
                 
                if(decision != "1"){
                    break;
                }
                 
            } else {
                 
                System.out.println("No se encontro el Producto");
               
            }
             
        }
        
        if(auxFacturaVentas!=null){
            auxFacturaVentas.setTotal(total);
        registroDeFacturas.addFacturaVenta(auxFacturaVentas);
        System.out.println("Se concreto la factura");
        }else{
        System.out.println("Error no se lleno la factura de forma correcta");}
        
    }
    
    //Facturar compra
    public void AddCompra() {
        double total = 0;
        int decision;
        int cantidad;
        String idProveedor;
        int idFactura = getRandom();
        String date;
        Date fechaEmision = null;
        Date ingresoAlmacen = null;
        String formaDePago;
        String idProducto;

        while(true){
            System.out.println("Ingrese la fecha de emision en el formato dd/mm/aaaa :>");
            
            try{
                date = stdIn.nextLine();
                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                fechaEmision = sfm.parse(date);
                
            } catch (NumberFormatException nfe) {
                System.out.println("Se espera un valor numerico");
                
            } catch (ParseException nfe) {
                System.out.println("Se espera una fecha");
                
            }
            if(fechaEmision != null){break;}
            
        }
        
        while(true) {
            System.out.println("Ingrese el id de proveedor :>");
            idProveedor = stdIn.nextLine();
            
            if(catalogoProveedor.getProveedor(idProveedor) != null){
                auxProveedor = catalogoProveedor.getProveedor(idProveedor);
                break;
                
            } else {
                System.out.println("No se encontró el proveedor");
            }
            
        }

        while(true){
            System.out.println("Ingrese la fecha de ingreso al almacen en el formato dd/mm/aaaa :>");
            
            try{
                date = stdIn.nextLine();
                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                ingresoAlmacen = sfm.parse(date);
                
            } catch (NumberFormatException nfe) {
                System.out.println("Se espera un valor numerico");
                
            } catch (ParseException nfe) {
                System.out.println("Se espera una fecha");
                
            }
            if(ingresoAlmacen != null) {break;}
            
        }

        System.out.println("Escriba su forma de pago");
        formaDePago = stdIn.nextLine();

        auxFacturaCompras = new FacturaCompras("c"+idFactura, fechaEmision, auxProveedor, ingresoAlmacen, formaDePago, 0.0);

        while(true) {

            System.out.println("Escriba el codigo del producto");
            idProducto = stdIn.nextLine();
            
            if (catalogoProducto.getProducto(idProducto) != null) {
                auxProducto = catalogoProducto.getProducto(idProducto);
                System.out.println("Escriba la cantidad de productos adquiridos");
                cantidad = Integer.parseInt(stdIn.nextLine());
                             
                auxItem = new Item(cantidad, auxProducto);
                auxFacturaCompras.addItem(auxItem);
                almacen.addItem(auxItem);
                total += auxItem.getCantidad()*auxItem.getProducto().getPrecioUnitario();
                
            } else {
                
                System.out.println("El producto no existe ¿desea agregarlo?\n[1]Si\n[2]No");
                decision = Integer.parseInt(stdIn.nextLine()) ;
                
                if(decision == 1){
                    //String idProducto, String nombre, String descripcion, double precUnitarioSinImpuestos, double impuestoUnitarioPagado, double precioUnitarioVenta, boolean impuesto
                    auxProducto = sistemaTiendaElpirata.generarProducto();
                    catalogoProducto.addProducto(auxProducto);

                    System.out.println("Escriba la cantidad de productos adquiridos");
                    cantidad = Integer.parseInt(stdIn.nextLine());
                             
                    auxItem = new Item(cantidad, auxProducto);
                    auxFacturaCompras.addItem(auxItem);
                    almacen.addItem(auxItem);
                }
            } 

            System.out.println("¿Desea agregar otro producto?\n[0]Si\n[1]No");
            decision = Integer.parseInt(stdIn.nextLine());
            if (decision == 1) {
                break;
            }
            
        }

        if(auxFacturaCompras != null) {
            auxFacturaCompras.setTotal(total);
            registroDeFacturas.addFacturaCompras(auxFacturaCompras);
            System.out.println("Se añadió la factura correctamente :D");
            
        } else {
            System.out.println("Error, no se llenó la factura de forma correcta");
            
        }
        
    }

    //modificar factura venta
    public void ModifyFacturaVenta() {
        String idFacturaVenta;
        String idProducto;
        int cantidad;
        int diferencia=0;
        
        System.out.println("Digite el codigo de la factura a editar");
        idFacturaVenta = stdIn.nextLine();
        auxFacturaVentas = registroDeFacturas.getFacturaVentas(idFacturaVenta);

        if (registroDeFacturas.getFacturaVentas(idFacturaVenta) != null) {
            System.out.println("Digite el ID producto a editar");
            idProducto=stdIn.nextLine();

            if(catalogoProducto.getProducto(idProducto) != null) {
                
                auxProducto = catalogoProducto.getProducto(idProducto);

                if(auxFacturaVentas.getItem(auxProducto) != null){
                    System.out.println("Digite la nueva cantidad");
                    cantidad=Integer.parseInt(stdIn.nextLine());
                    diferencia = auxFacturaVentas.getItem(auxProducto).getCantidad()- cantidad;
                    
                    if (auxFacturaVentas.getItem(auxProducto).getCantidad() == cantidad) {
                        System.out.println("No modificaste nada cabeza de chorlito");

                    } else {
                        if(auxFacturaVentas.getItem(auxProducto).getCantidad() > cantidad){
                            //10 9
                            almacen.getItem(auxProducto).setCantidad(almacen.getItem(auxProducto).getCantidad() + diferencia);
                            //
                        } 
                        if(auxFacturaVentas.getItem(auxProducto).getCantidad() > 0 && auxFacturaVentas.getItem(auxProducto).getCantidad() < cantidad &&
                        (almacen.getItem(auxProducto).getCantidad() - diferencia > 0)){
                            //10 5 5 //4 15  
                            almacen.getItem(auxProducto).setCantidad(almacen.getItem(auxProducto).getCantidad() - diferencia);
                        }
                        else{

                            System.out.println("no se puede modificar");
                            
                        }
                    }

                }
            } else {
                System.out.println("El producto no existe");
            }
            
        } else {
            System.out.println("No se encontro la factura");
        }

        System.out.println("Generar reporte de movimiento");
        newReporte();
        
    }
    //Movimiento extraordinario
    public void  ModifyAlmacen(){

        
        int remover;
        String idProducto;

        System.out.println("Ingrese la id del producto a modificar");
        idProducto = stdIn.nextLine();

        auxProducto=catalogoProducto.getProducto(idProducto);

        if(almacen.getItem(auxProducto) != null){

            System.out.println("Cuantos productos va a remover?");
            remover=Integer.parseInt(stdIn.nextLine());

            if(almacen.getItem(auxProducto).getCantidad() > 0 && almacen.getItem(auxProducto).getCantidad()-remover > 0){

                sistemaTiendaElpirata.newReporte();

                almacen.getItem(auxProducto).setCantidad(almacen.getItem(auxProducto).getCantidad()-remover);

                System.out.println("Se modifico el almacen y se genero el reporte");
            }
            else{
                System.out.println("La cantidad a remover es mayor a la cantidad en almacen");

            }

        }
        else{
            System.out.println("No se encontro el producto");
        }

    }

    //Mostrar ganancias por periodo
    public void DisplayGananciasPeriodo() {

        double totalVentas = 0;
        double totalGanancias = 0;
        ArrayList<FacturaVentas> facturaVentas = new ArrayList<FacturaVentas>();
        ArrayList<Item> items = new ArrayList<Item>();
        double precioCompra;
        double precioVenta;
        Date fechaInicial;
        Date fechaFinal;

        while(true) {

            try {
            
                System.out.println("Ingrese la fecha inicial del periodo (dd/MM/aaaa)");
                fechaInicial = new SimpleDateFormat("dd-MM-yyyy").parse(stdIn.nextLine());
                System.out.println("Ingrese la fecha final del periodo (dd/MM/aaaa)");
                fechaFinal = new SimpleDateFormat("dd-MM-yyyy").parse(stdIn.nextLine());
            
                facturaVentas = registroDeFacturas.getFacturasVentaPeriodo(fechaInicial, fechaFinal);

                for (Iterator<FacturaVentas> listFacturas = facturaVentas.iterator(); listFacturas.hasNext();) { 
                    items = listFacturas.next().getItems();

                    for (Iterator<Item> listItems = items.iterator(); listItems.hasNext();) {

                        precioCompra = (listItems.next().getProducto().getPrecioUnitario()) * listItems.next().getCantidad();

                        precioVenta = (listItems.next().getProducto().getPrecioUnitarioVenta()) * listItems.next().getCantidad();

                        totalGanancias += precioVenta-precioCompra;

                    }

                }

                if(fechaInicial != null && fechaFinal != null){break;}
                
            } catch (NumberFormatException nfe) {
                System.out.println("Se esperan valores numericos");
            } catch (ParseException nfe) {
                System.out.println("Ingrese el valor de fecha correctamente");
            }
            
        }
        System.out.println("Las ganancias de "+fechaFinal + " a " + fechaFinal + " son de: " +totalGanancias);
        
    }

    //Crear Producto
    public Producto generarProducto(){

        int idProducto = getRandom();
        String nombre;
        String descripcion;
        double precUnitarioSinImpuestos;
        double impuestoUnitarioPagado;
        double precioUnitario = 0;
        double precioUnitarioVenta;
        boolean impuesto = false;
        Producto producto;
        int decision;
        
        System.out.println("Ingrese el nombre del producto");
        nombre = stdIn.nextLine();
        System.out.println("Ingrese la descripcion");
        descripcion = stdIn.nextLine();
        System.out.println("Ingrese el  precio Unitario Sin Impuestos");
        precUnitarioSinImpuestos = Double.parseDouble(stdIn.nextLine());
        System.out.println("Ingrese el  impuesto Unitario Pagado");
        impuestoUnitarioPagado = Double.parseDouble(stdIn.nextLine());
        System.out.println("¿Lleva impuesto?\n[1]Si\n[2]No");
        decision=Integer.parseInt(stdIn.nextLine());
        
        if(decision == 1){
            impuesto = true;
            precioUnitario = precUnitarioSinImpuestos + impuestoUnitarioPagado;
            precioUnitario += precioUnitario * 0.14;
            
        }
        if(decision == 2){
            impuesto = false;
            precioUnitario = precUnitarioSinImpuestos + impuestoUnitarioPagado;
            
        }

        System.out.println("el precio unitario es de: "+precioUnitario+"\nDigite el precio de venta unitario");
        precioUnitarioVenta = Double.parseDouble(stdIn.nextLine());
        producto = new Producto(""+idProducto, nombre, descripcion, precUnitarioSinImpuestos, impuestoUnitarioPagado, precioUnitarioVenta, impuesto);
        return producto;
        
    }

    //Crear Reporte
    public void newReporte() {
        int idReporte = getRandom();
        String descripcion;
        String idUsuario;
        Usuario usuario=null;
        Reporte reporte = null;
        

        while(true){
            System.out.println("Escriba su usuario");
            idUsuario = stdIn.nextLine();
            if(listaDeUsuarios.getUsuario(idUsuario) != null){

                usuario = listaDeUsuarios.getUsuario(idUsuario);
                break;
            } else {
                System.out.println("El usuario que ingresó no existe");

            }

        }
        
        System.out.println("ingrese la id de la factura, del producto y su descripcion del movimiento");
        descripcion = stdIn.nextLine();

        reporte = new Reporte(""+idReporte, usuario, descripcion);

        listaDeReportes.addReporte(reporte);

    }
    public int getRandom(){
        Random random = new Random();
        int num = random.nextInt(99999+1)+1;
        return num;      
    }

///////////////////Guardar datos///////////////////////////////////////////////////////////////
    
    public void SubirDatos() {
        
         ///////////////////productos////////////////////////////////////
        JSONArray listaProductos = new JSONArray();
        
        for(Producto product: catalogoProducto){
            JSONObject prod = new JSONObject();
            prod.put("idProducto", product.getIdProducto());
            prod.put("nombre", product.getNombre());
            prod.put("descripcion", product.getDescripcion());
            prod.put("precUnitarioSinImpuestos", product.getPrecUnitarioSinImpuestos());
            prod.put("impuestoUnitarioPagado", product.getImpuestoUnitarioPagado());
            prod.put("precioUnitarioVenta", product.getPrecioUnitarioVenta());
            prod.put("impuesto", product.isImpuesto());
            
            JSONObject datosProducto = new JSONObject();
            datosProducto.put("Producto", prod);
            listaProductos.add(datosProducto);
            
        }
        
        try(FileWriter file=new FileWriter("CatalogoProductos.json")) {
            file.write(listaProductos.toJSONString());
            file.flush();
        
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        ///////////almacen/////////////////////////////////////////////////
        JSONArray listaItems = new JSONArray();
        
        for(Item item: almacen) {
            
            JSONObject auxItem = new JSONObject();
            auxItem.put("Cantidad", item.getCantidad());
            auxItem.put("idProducto", item.getProducto().getIdProducto());
            
            JSONObject datosItem = new JSONObject();
            datosItem.put("Item", auxItem);
            listaItems.add(datosItem);
        }
        
        try(FileWriter file=new FileWriter("Almacen.json")) {
            file.write(listaItems.toJSONString());
            file.flush();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    
        ///////////Catalogo cliente/////////////////////////////////////////
        
        JSONArray listaClientes = new JSONArray();
        
        for(Cliente cliente : catalogoClientes){
            
            JSONObject auxCliente = new JSONObject();
            /*String idCliente, String razonSocial, String rfc, String direccionFiscal, String nombreContactoCliente, String telefonoContactoCliente*/
            auxCliente.put("idCliente",cliente.getIdCliente());
            auxCliente.put("razonSocial",cliente.getRazonSocial());
            auxCliente.put("rfc",cliente.getRfc());
            auxCliente.put("direccionFiscal",cliente.getDireccionFiscal());
            auxCliente.put("nombreContactoCliente",cliente.getNombreContactoCliente());
            auxCliente.put("telefonoContactoCliente",cliente.getTelefonoContactoCliente());
            
            JSONObject datosCliente = new JSONObject();
            datosCliente.put("Cliente", auxCliente);
            listaClientes.add(datosCliente);
            
        }
        
        try(FileWriter file = new FileWriter("CatalogoCliente.json")){
            file.write(listaClientes.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        ///////////proveedores/////////////////////////////////////////////////
        JSONArray listaProovedores = new JSONArray();
        
        for(Proveedor proveedor: catalogoProveedor){
            JSONObject prov = new JSONObject();
            prov.put("idProveedor", proveedor.getIdProvedor());
            prov.put("razonSocial", proveedor.getRazonSocial());
            prov.put("rfc", proveedor.getRfc());
            prov.put("direccion", proveedor.getDireccion());
            prov.put("tel", proveedor.getTel());
            prov.put("fax", proveedor.getFax());
            prov.put("nombreContactoProveedor", proveedor.getNombreContactoProveedor());
            prov.put("emailContactoProveedor", proveedor.getEmailContactoProveedor());
            prov.put("telContactoProveedor", proveedor.getTelContactoProveedor());
            
            JSONObject datosProveedor = new JSONObject();
            datosProveedor.put("Proveedor", prov);
            listaProovedores.add(datosProveedor);
            
        }
        
        try(FileWriter file = new FileWriter("CatalogoProveedor.json")) {
            file.write(listaProovedores.toJSONString());
            file.flush();
        
        } catch(IOException e) {
            e.printStackTrace();
            
        }

        ///////////usuarios/////////////////////////////////////////////////
        JSONArray listaUsuarios = new JSONArray();
        
        for(Usuario usuario: listaDeUsuarios){
            JSONObject user = new JSONObject();
            user.put("idUsuario", usuario.getIdUsuario());
            user.put("usuario", usuario.getUsuario());
            user.put("nombre", usuario.getNombre());
            user.put("telefono", usuario.getTelefono());
            
            JSONObject datosUsuario = new JSONObject();
            datosUsuario.put("Usuario", user);
            listaUsuarios.add(datosUsuario);
            
        }
        
        try(FileWriter file = new FileWriter("ListaUsuarios.json")) {
            file.write(listaUsuarios.toJSONString());
            file.flush();
        
        } catch(IOException e) {
            e.printStackTrace();
            
        }

        ///////////registraListaReportes/////////////////////////////////////////////////
        JSONArray listaReportes = new JSONArray();
        for(Reporte reporte: listaDeReportes){
            
            JSONObject auxReporte= new JSONObject();
            //String idReporte, Usuario usuario, String descripcion
            auxReporte.put("idReporte", reporte.getIdReporte());
            auxReporte.put("idUsuario", listaDeUsuarios.getUsuario(reporte.getUsuario().getIdUsuario()).getIdUsuario());
            auxReporte.put("descripcion", reporte.getDescripcion());
            
            JSONObject datosReporte= new JSONObject();
            
            datosReporte.put("Reporte",auxReporte);
            listaReportes.add(datosReporte);
            
        }
        try(FileWriter file = new FileWriter("ListaReportes.json")){
            file.write(listaReportes.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }

        ///////////facturas ventas/////////////////////////////////////////////////
        JSONArray listaFacturaVenta = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        for(FacturaVentas facturaVenta: registroDeFacturas.getListaFacturaVentas()){
            JSONObject facV = new JSONObject();
            JSONArray itemsVenta = new JSONArray();
            
            facV.put("idFactura", facturaVenta.getIdFactura());
            facV.put("fechaEmision", sdf.format(facturaVenta.getFechaEmision()));
            facV.put("cliente", facturaVenta.getCliente().getIdCliente());
            facV.put("direccionEnvio", facturaVenta.getDireccionEnvio());
            facV.put("total", facturaVenta.getTotal());
            
            for (Item item : facturaVenta.getItems()) {
                
                JSONObject itemFV = new JSONObject();
                itemFV.put("cantidad", item.getCantidad());
                itemFV.put("idItem", item.getProducto().getIdProducto());
                
                itemsVenta.add(itemFV);
                System.out.println("a");
                
            }
            
            facV.put("items", itemsVenta);
            
            JSONObject datosFacturaVenta = new JSONObject();
            datosFacturaVenta.put("FacturaVenta", facV);
            listaFacturaVenta.add(datosFacturaVenta);
            
        }
        
        try(FileWriter file = new FileWriter("RegistroFacturasVenta.json")) {
            file.write(listaFacturaVenta.toJSONString());
            file.flush();
        
        } catch(IOException e) {
            e.printStackTrace();
            
        }

        ///////////facturas compras/////////////////////////////////////////////////
        JSONArray listaFacturaCompra = new JSONArray();
        
        for(FacturaCompras facturaCompra: registroDeFacturas.getListaFacturaCompras()){
            JSONObject facC = new JSONObject();
            JSONArray itemsCompra = new JSONArray();
            
            facC.put("idFactura", facturaCompra.getIdFactura());
            facC.put("fechaEmision", sdf.format(facturaCompra.getFechaEmision()));
            facC.put("proveedor", facturaCompra.getProveedor().getIdProvedor());
            facC.put("ingresoAlmacen",sdf.format(facturaCompra.getIngresoAlmacen()));
            facC.put("formaDePago", facturaCompra.getFormaDePago());
            facC.put("total", facturaCompra.getTotal());
            
            for (Item item : facturaCompra.getItems()) {
                
                JSONObject itemFC = new JSONObject();
                itemFC.put("cantidad", item.getCantidad());
                itemFC.put("idItem", item.getProducto().getIdProducto());
                
                itemsCompra.add(itemFC);
                System.out.println("a");
                
            }
            
            facC.put("items", itemsCompra);
            
            JSONObject datosFacturaCompra = new JSONObject();
            datosFacturaCompra.put("FacturaCompra", facC);
            listaFacturaCompra.add(datosFacturaCompra);
            
        }
        
        try(FileWriter file = new FileWriter("RegistroFacturasCompra.json")) {
            file.write(listaFacturaCompra.toJSONString());
            file.flush();
        
        } catch(IOException e) {
            e.printStackTrace();
            
        }

    }

///////////////////cargar datos///////////////////////////////////////////////////////////////
    
    private void cargarDatos() {

        ///////////productos/////////////////////////////////////////////////
        JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader("CatalogoProductos.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray listaProductos = (JSONArray) obj; 
            
            for(Object producto: listaProductos){
                getProductoJSON((JSONObject) producto);
            }
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(org.json.simple.parser.ParseException e){
            e.printStackTrace();
        }
        
        ///////////almacen/////////////////////////////////////////////////
        try(FileReader reader = new FileReader("Almacen.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray listaAlmacenItems = (JSONArray) obj; 
            
            for(Object item: listaAlmacenItems){
                getAlmacenItemJSON((JSONObject) item);
            }
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(org.json.simple.parser.ParseException e){
            e.printStackTrace();
        }

        ///////////catalogo cliente/////////////////////////////////////////////////        
        try(FileReader reader = new FileReader("CatalogoCliente.json")){
            
            Object obj =jsonParser.parse(reader);
            JSONArray listaClientes=(JSONArray) obj;
            
            for(Object cliente: listaClientes){
                getClientesJSON((JSONObject) cliente);
            }
            
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(org.json.simple.parser.ParseException e){
            e.printStackTrace();
        }
        
        ///////////proveedores/////////////////////////////////////////////////
        try(FileReader reader = new FileReader("CatalogoProveedor.json")){
            Object obj = jsonParser.parse(reader);
            
            JSONArray listaProovedores = (JSONArray) obj; 
            for(Object proveedor: listaProovedores){
                getProveedorJSON((JSONObject) proveedor);
            }
        
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            
        } catch(IOException e) {
            e.printStackTrace();
            
        } catch(org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            
        }

        ///////////usuarios/////////////////////////////////////////////////
        try(FileReader reader = new FileReader("ListaUsuarios.json")){
            Object obj = jsonParser.parse(reader);
            
            JSONArray listaUsuario = (JSONArray) obj; 
            for(Object usuario: listaUsuario){
                getUsuarioJSON((JSONObject) usuario);
            }
        
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            
        } catch(IOException e) {
            e.printStackTrace();
            
        } catch(org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            
        }
        
        ///////////Lista Reportes/////////////////////////////////////////////////
        try(FileReader reader = new FileReader("ListaReportes.json")){
            
            Object obj = jsonParser.parse(reader);
            
            JSONArray listaDeReportes=(JSONArray) obj;
            
            for(Object reporte: listaDeReportes){
                
                getReporteJSON((JSONObject) reporte);
            }
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(org.json.simple.parser.ParseException e){
            e.printStackTrace();
        }

        ///////////facturaVentas/////////////////////////////////////////////////
        try(FileReader reader = new FileReader("RegistroFacturasVenta.json")){
            Object obj = jsonParser.parse(reader);
            
            JSONArray listaFacturaVenta = (JSONArray) obj; 
            for(Object facturaVenta: listaFacturaVenta){
                getFacturaVentaJSON((JSONObject) facturaVenta);
            }
        
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            
        } catch(IOException e) {
            e.printStackTrace();
            
        } catch(org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        ///////////facturaCompras/////////////////////////////////////////////////
        try(FileReader reader = new FileReader("RegistroFacturasCompra.json")){
            Object obj = jsonParser.parse(reader);
            
            JSONArray listaFacturaCompra = (JSONArray) obj; 
            for(Object facturaCompra: listaFacturaCompra){
                getFacturaCompraJSON((JSONObject) facturaCompra);
                System.out.println("a");
            }
        
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            
        } catch(IOException e) {
            e.printStackTrace();
            
        } catch(org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }

    ////////////////get Objects//////////////////////////////////////////////////////////////////////
    private static void getProductoJSON(JSONObject jsonObject) {
        
        JSONObject producto = (JSONObject) jsonObject.get("Producto");
         
        String idProducto = (String) producto.get("idProducto");
        String nombre = (String) producto.get("nombre");
        String descripcion = (String) producto.get("descripcion");
        double precUnitarioSinImpuestos = (double) producto.get("precUnitarioSinImpuestos");
        double impuestoUnitarioPagado = (double) producto.get("impuestoUnitarioPagado");
        double precioUnitarioVenta = (double) producto.get("precioUnitarioVenta");
        boolean impuesto = (boolean) producto.get("impuesto");

        Producto tempproducto = new Producto(idProducto,nombre,descripcion,precUnitarioSinImpuestos,impuestoUnitarioPagado,precioUnitarioVenta,impuesto);
        
        catalogoProducto.addProducto(tempproducto);

    }
    
    private static void getAlmacenItemJSON(JSONObject jsonObject) {
        JSONObject item = (JSONObject)jsonObject.get("Item");
        
        Producto producto = catalogoProducto.getProducto((String) item.get("idProducto"));
        Long cantidad = (Long) item.get("Cantidad");
        String cant = "" + cantidad;
        
        Item tempItem=new Item((Integer.parseInt(cant)) ,producto);
        
        almacen.addItem(tempItem);
        
    }

    private static void getClientesJSON(JSONObject jsonObject) {
        JSONObject cliente =(JSONObject)jsonObject.get("Cliente");
        
        String idCliente = (String) cliente.get("idCliente");
        String razonSocial = (String) cliente.get("razonSocial");
        String rfc = (String) cliente.get("rfc");
        String direccionFiscal = (String) cliente.get("direccionFiscal");
        String nombreContactoCliente = (String) cliente.get("nombreContactoCliente");
        String telefonoContactoCliente = (String) cliente.get("telefonoContactoCliente");
        
        Cliente clienteFinal = new Cliente(idCliente,razonSocial,rfc,direccionFiscal,nombreContactoCliente,telefonoContactoCliente);
        
        catalogoClientes.addCliente(clienteFinal);
           
    }

    private static void getProveedorJSON(JSONObject jsonObject) {
        
        JSONObject proveedor = (JSONObject) jsonObject.get("Proveedor");
        
        String idProvedor = (String) proveedor.get("idProveedor");
        String razonSocial = (String) proveedor.get("razonSocial");
        String rfc = (String) proveedor.get("rfc");
        String direccion = (String) proveedor.get("direccion");
        String tel = (String) proveedor.get("tel");
        String fax = (String) proveedor.get("fax");
        String nombreContactoProveedor = (String) proveedor.get("nombreContactoProveedor");
        String emailContactoProveedor = (String) proveedor.get("emailContactoProveedor");
        String telContactoProveedor = (String) proveedor.get("telContactoProveedor");
        
        Proveedor tmpProveedor = new Proveedor(idProvedor, razonSocial, rfc, direccion, tel, fax, nombreContactoProveedor, emailContactoProveedor, telContactoProveedor);
        
        catalogoProveedor.addProveedor(tmpProveedor);
                
    }

    private static void getUsuarioJSON(JSONObject jsonObject) {
        
        JSONObject usuario = (JSONObject) jsonObject.get("Usuario");
        
        String idUsuario = (String) usuario.get("idUsuario");
        String usuario1 = (String) usuario.get("usuario");
        String nombre = (String) usuario.get("nombre");
        String telefono = (String) usuario.get("telefono");
        
        Usuario tmpUsuario = new Usuario(idUsuario, usuario1, nombre, telefono);
        
        listaDeUsuarios.addUsuario(tmpUsuario);
        
    }

    private static void getReporteJSON(JSONObject jsonObject) {
        JSONObject reporte = (JSONObject)jsonObject.get("Reporte");
        
        String idReporte =(String) reporte.get("idReporte");
        Usuario usuario =listaDeUsuarios.getUsuario((String) reporte.get("idUsuario")); 
        String descripcion = (String) reporte.get("descripcion");
        
        Reporte reporteFinal = new Reporte(idReporte,usuario,descripcion);
        
        listaDeReportes.addReporte(reporteFinal);
        
    }

    private static void getFacturaVentaJSON(JSONObject jsonObject) {
        
        Date fechaEmisionFinal;
        Cliente clienteFinal;
        Item nuevoItem;
        
        JSONObject facturaVenta = (JSONObject) jsonObject.get("FacturaVenta");
        
        String idFactura = (String) facturaVenta.get("idFactura");
        String fechaEmision = (String) facturaVenta.get("fechaEmision");
        String cliente = (String) facturaVenta.get("cliente");
        String direccionEnvio = (String) facturaVenta.get("direccionEnvio");
        Double total = (Double) facturaVenta.get("total");
        
        // Fecha
        int Aux;
        do { 
            Aux = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            fechaEmisionFinal = null;
                
            try{
                fechaEmisionFinal = sdf.parse(fechaEmision);
                Aux = 1;
            } catch (Exception e){ 
                System.out.println("Fecha Inválida");
            }
        } while (Aux == 0);
    
        // Cliente
        clienteFinal = catalogoClientes.getCliente(cliente);
        
        // FacturaVenta
        FacturaVentas tmpFacturaVenta = new FacturaVentas(idFactura, fechaEmisionFinal, clienteFinal, direccionEnvio, total);
        
        // Items
        JSONArray itemsList = (JSONArray) facturaVenta.get("items");
        for (Object item: itemsList) {
            
            JSONObject i = (JSONObject) item;
            
            Long cantidadLong = (Long) i.get("cantidad");
            int cantidad = Math.toIntExact(cantidadLong);
            String id = (String) i.get("idItem");
            
            nuevoItem = new Item(cantidad, catalogoProducto.getProducto(id));
            tmpFacturaVenta.addItem(nuevoItem);
            
        }
        
        // Add FacturaVenta
        registroDeFacturas.addFacturaVenta(tmpFacturaVenta);
        
    }

    private static void getFacturaCompraJSON(JSONObject jsonObject) {
        
        Date fechaEmisionFinal;
        Date ingresoAlmacenFinal;
        Proveedor proveedorFinal;
        Item nuevoItem;
        
        
        JSONObject facturaCompra = (JSONObject) jsonObject.get("FacturaCompra");
        
        String idFactura = (String) facturaCompra.get("idFactura");
        String fechaEmision = (String) facturaCompra.get("fechaEmision");
        String proveedor = (String) facturaCompra.get("proveedor");
        String ingresoAlmacen = (String) facturaCompra.get("ingresoAlmacen");
        String formaDePago = (String) facturaCompra.get("formaDePago");
        Double total = (Double) facturaCompra.get("total");
        
        // Fechas
        int Aux;
        do { 
            Aux = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            fechaEmisionFinal = null;
            ingresoAlmacenFinal = null;
                
            try{
                fechaEmisionFinal = sdf.parse(fechaEmision);
                ingresoAlmacenFinal = sdf.parse(ingresoAlmacen);
                Aux = 1;
            } catch (Exception e){ 
                System.out.println("Fecha Inválida");
            }
        } while (Aux == 0);
        
        // Proveedor
        proveedorFinal = catalogoProveedor.getProveedor(proveedor);
        
        // FacturaCompras
        FacturaCompras tmpFacturaCompra = new FacturaCompras(idFactura, fechaEmisionFinal, proveedorFinal, ingresoAlmacenFinal, formaDePago, total);
        
        // Items
        JSONArray itemsList = (JSONArray) facturaCompra.get("items");
        for (Object item: itemsList) {
            
            JSONObject i = (JSONObject) item;
            
            Long cantidadLong = (Long) i.get("cantidad");
            int cantidad = Math.toIntExact(cantidadLong);
            String id = (String) i.get("idItem");
            
            nuevoItem = new Item(cantidad, catalogoProducto.getProducto(id));
            tmpFacturaCompra.addItem(nuevoItem);
            
        }
        
        // Add FacturaCompra
        registroDeFacturas.addFacturaCompras(tmpFacturaCompra);
        
    }

}
