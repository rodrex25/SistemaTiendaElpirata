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
 * @author JuanA
 */
public class RegistroFacturas implements Iterable<Factura> {
    
    //Atributos
    
    private ArrayList<Factura> facturas;
    
    //Metodos
    public ArrayList<Factura> getFacturasCompra() {

        ArrayList<Factura> facturasCompra = new ArrayList<Factura>(); 

        for(Iterator<Factura> listFactura = facturas.iterator(); listFactura.hasNext();){

            Factura factura = listFactura.next(); 

            if(factura.getIdFactura().startsWith("c")){

                facturasCompra.add(factura);

            }

        }
        return facturasCompra;

        
    }
    //CREATE TABLE TABLA1 {FECHA DATE, NOMBRE VARCHAR(30)}

    public ArrayList<Factura> getFacturasCompraPeriodo(Date fechaInicial, Date fechaFinal) {
        
        ArrayList<Factura> facturasCompra = new ArrayList<Factura>(); 
        for(Iterator<Factura> listFactura = facturas.iterator(); listFactura.hasNext();) {
            
            Factura factura = listFactura.next();
               if ((factura.getFechaEmision().before(fechaFinal)&&(factura.getFechaEmision().after(fechaInicial)))) {
                     facturasCompra.add(factura);
                }
            }
        
        return null;
    }

    public Factura getFacturasVenta() {
        for(Iterator<Factura> listFactura = facturas.iterator(); listFactura.hasNext();){
            Factura factura = listFactura.next();
            if(factura.getIdFactura().startsWith("v")){
                return factura;
            }
        }
        return null;

    }
    
    public RegistroFacturas() {
        facturas = new ArrayList<Factura>();
    }
    
    public void addFactura(Factura factura) {
        facturas.add(factura);
    }
    
    public void deleteFactura(Factura factura) {
        facturas.remove(factura);
    }
    
    public Factura getFactura (String id) {
        for (Iterator<Factura> listFactura = facturas.iterator(); listFactura.hasNext();){
            Factura factura = listFactura.next();
            if (factura.getIdFactura().equals(id)) {
                return factura;
            }
        }
        return null;

    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    @Override
    public Iterator<Factura> iterator() {
        return facturas.iterator();
    }
}
