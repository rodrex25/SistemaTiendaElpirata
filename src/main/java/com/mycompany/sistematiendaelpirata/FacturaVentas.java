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
 * @author JuanA
 */
public class FacturaVentas implements Iterable<Item>{

    //Atributos
    private ArrayList<Item> items = new ArrayList<Item>();
    
    private String idFactura;
    private Date fechaEmision;
    private Cliente cliente;
    private String direccionEnvio;
    private Double total;
    
    //Metodos

    public FacturaVentas(String idFactura, Date fechaEmision, Cliente cliente, String direccionEnvio, Double total) {
        this.idFactura = idFactura;
        this.fechaEmision = fechaEmision;
        this.cliente = cliente;
        this.direccionEnvio = direccionEnvio;
        this.total = total;

    }
    
    public void addItem(Item item){
        items.add(item);
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
    
    //Getters

    public String getIdFactura() {
        return idFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public Double getTotal() {
        total = 0.0;
        for(Iterator<Item> listaItems = items.iterator(); listaItems.hasNext();){
            total = total + (listaItems.next().getProducto().getPrecioUnitarioVenta() * listaItems.next().getCantidad());
            
        }
        return total;
    }
    
    public Item getItem(Producto producto) {
        for (Item item : items) {
            if (item.getProducto().equals(producto)) {
                return item;
            }
        }
        return null;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    //Setters

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setfechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    //toString
    
    @Override
    public String toString() {
        
        String resu =  "\nFactura de venta: " +
                "\nID: " + idFactura +
                
                "\nFecha de emision: " + fechaEmision +
                "\nID del cliente: " + cliente.getIdCliente() +
                "\nNombre del cliente: " + cliente.getNombreContactoCliente() +
                "\nDireccion de envio: " + direccionEnvio+
                "\nTotal: "+ total;

                
                    resu = resu + items;
                
        
        return resu;
    }

    //iterator

	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}
}
