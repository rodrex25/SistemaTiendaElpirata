/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/**
 *
 * @author gabre
 */
public class FacturaCompras  extends Factura implements Iterable <Item>{
    
    
    private ArrayList<Item> items;
    private double total;
    
    private Proveedor proveedor;
    private Date ingresoAlmacen;
    private String formaDePago;

    public FacturaCompras(String idFactura, Date fechaEmision, Proveedor proveedor, Date ingresoAlmacen, String formaDePago) {
        
        super(idFactura, fechaEmision);
        idFactura = super.getIdFactura();
        
        this.proveedor = proveedor;
        this.ingresoAlmacen = ingresoAlmacen;
        this.formaDePago = formaDePago;
    }
    
    public String getData(){
            String resul = super.getIdFactura()+","+super.getFechaEmision()+","+ proveedor.getIdProvedor()+","+ingresoAlmacen+","+formaDePago+","+total;
            
        for(Iterator<Item> listaItems = items.iterator(); listaItems.hasNext();){
            
            resul = resul+","+listaItems.next().getProducto().getIdProducto()+","+listaItems.next().getCantidad();
        }
        return resul;
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    //getters

    public String getIdFactura() {
        return super.getIdFactura();
    }
    
    public Date getfechaEmision(){
        return super.getFechaEmision();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTotal() {
        for(Iterator<Item> listaItems = items.iterator(); listaItems.hasNext();){
            total=total+listaItems.next().getProducto().getPrecioUnitario();
            
        }
        return total;
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
        super.setIdFactura(idFactura);
        
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
    
    public void setfechaEmision(Date FechaEmision){
        super.setFechaEmision(FechaEmision);
    }

    @Override
    public String toString() {
        
        String resu = 
                "\nFactura de compra" +
                "\nId Factura: "+super.getIdFactura()+
                "\nFecha de Emision: "+super.getFechaEmision()+
                "\nId Proveedor: "+proveedor.getIdProvedor()+
                "\nNombre Proveedor: "+proveedor.getNombreContactoProveedor()+
                "\nFecha de ingreso al Almacen: "+ingresoAlmacen+
                "\nForma de pago: "+formaDePago+
                "\nProductos Comprados: \n";
        
         for(Iterator<Item> listaItems = items.iterator(); listaItems.hasNext();){
            resu = resu + listaItems.next().getProducto().getIdProducto()+" "+listaItems.next().getProducto().getNombre()+" "+listaItems.next().getCantidad()+"\n";
            
        }
        
        return  resu;
    }
    
    
    
    

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
    
    
}
