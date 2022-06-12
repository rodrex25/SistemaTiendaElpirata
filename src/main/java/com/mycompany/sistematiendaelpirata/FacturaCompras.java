/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
/**
 *
 * @author gabre
 */
public class FacturaCompras implements Iterable<Item>{
    
    private ArrayList<Item> items= new ArrayList<Item>();
    
    private String idFactura;
    private Date fechaEmision;
    private Proveedor proveedor;
    private Date ingresoAlmacen;
    private String formaDePago;
    private double total;

    
    public FacturaCompras(String idFactura, Date fechaEmision, Proveedor proveedor, Date ingresoAlmacen, String formaDePago, double total) {
        this.idFactura = idFactura;
        this.fechaEmision = fechaEmision;
        this.proveedor = proveedor;
        this.ingresoAlmacen = ingresoAlmacen;
        this.formaDePago = formaDePago;
        this.total = total;

    }
    
    public String getDateEmision(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fechaEmision);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String date1 = day+"-"+month+"-"+year;

       
        return date1;
    }
    
    public String getDateingresoAlmacen(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(ingresoAlmacen);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String date1 = day+"-"+month+"-"+year;

       
        return date1;
    }
    /*v023,25/03/2020,24547,26/03/2020,tarjeta,4500,12554,50,233246,50

     * for(mientras haya un next line)    
     * additem(new Item(get.product(12554),10))
    */
    
    public void addItem(Item item){
        items.add(item);
    }
    
    //getters

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTotal() {
        total = 0.0;
        for(Iterator<Item> listaItems = items.iterator(); listaItems.hasNext();){
            total = total + (listaItems.next().getProducto().getPrecioUnitario() * listaItems.next().getCantidad());
            
        }
        return total;
    }

    public String getIdFactura() {
        return idFactura;
    }
    
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Date getIngresoAlmacen() {
        return ingresoAlmacen;
    }

    public String getFormaDePago() {
        return formaDePago;
    }
    
    //setters

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setIngresoAlmacen(Date ingresoAlmacen) {
        this.ingresoAlmacen = ingresoAlmacen;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    @Override
    public String toString() {
        
        String resu = 
                "\nFactura de compra" +
                "\nId Factura: "+idFactura+
                "\nFecha de Emision: "+fechaEmision+
                "\nId Proveedor: "+proveedor.getIdProvedor()+
                "\nNombre Proveedor: "+proveedor.getNombreContactoProveedor()+
                "\nFecha de ingreso al Almacen: "+ingresoAlmacen+
                "\nForma de pago: "+formaDePago+
                "\nProductos Comprados: \n";
        
                resu = resu + items;
        
        return  resu;
    }
    
    
    
    

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
    
    
}
