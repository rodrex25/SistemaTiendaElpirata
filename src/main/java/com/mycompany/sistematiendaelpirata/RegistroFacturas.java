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
public class RegistroFacturas implements Iterable <Factura>{
    
    //Atributos
    
    private ArrayList<FacturaVentas> facturasVentas;
    private ArrayList<FacturaCompras> facturasCompras;

    //constuctor

    public RegistroFacturas(){

        facturasVentas = new ArrayList<FacturaVentas>();
        facturasCompras = new  ArrayList<FacturaCompras>();

    }

    //metodos

    public void addFacturaVenta(FacturaVentas facturaVenta){
        facturasVentas.add(facturaVenta);
    }

    public void addFacturaCompras(FacturaCompras facturasCompra){
        facturasCompras.add(facturasCompra);
    }
    
    public  ArrayList<FacturaVentas> getListaFacturaVentas(){
        return facturasVentas;
    }
    
    public ArrayList<FacturaCompras> getListaFacturaCompras(){
        return facturasCompras;
    }
    
    public FacturaCompras getFacturaCompra(String idFacturaCompra){
        for (Iterator<FacturaCompras> listcompras = facturasCompras.iterator(); listcompras.hasNext();){
            
        FacturaCompras facturaCompra = listcompras.next();
            
            if (facturaCompra.getIdFactura().equals(idFacturaCompra)) {
                
                return facturaCompra;
                
            }
        }
        return null;
    }
    
    public ArrayList<FacturaCompras> getFacturasCompraPeriodo(Date fechaInicial, Date fechaFinal) {
        
        ArrayList<FacturaCompras> facturasCompra = new ArrayList<FacturaCompras>(); 
        for(Iterator<FacturaCompras> listcompras = facturasCompras.iterator(); listcompras.hasNext();) {   

            FacturaCompras facturaCompra = listcompras.next();
               if ((facturaCompra.getFechaEmision().before(fechaFinal)&&(facturaCompra.getFechaEmision().after(fechaInicial)))) {
                    facturasCompra.add(facturaCompra);
                }

            }
        
        return facturasCompra;

    }

    public FacturaVentas getFacturaVentas(String idFacturaVenta){
    
        for (Iterator<FacturaVentas> listVentas = facturasVentas.iterator(); listVentas.hasNext();){
            
        FacturaVentas facturaVenta = listVentas.next();
            
            if (facturaVenta.getIdFactura().equals(idFacturaVenta)) {
                
                return facturaVenta;
                
            }
        }
        return null;
    
    }

    public ArrayList<FacturaVentas> getFacturasVentaPeriodo(Date fechaInicial, Date fechaFinal) {
        
        ArrayList<FacturaVentas> facturasVenta = new ArrayList<FacturaVentas>(); 
        for(Iterator<FacturaVentas> listVentas = facturasVenta.iterator(); listVentas.hasNext();) {   

            FacturaVentas facturaVenta = listVentas.next();
               if ((facturaVenta.getFechaEmision().before(fechaFinal)&&(facturaVenta.getFechaEmision().after(fechaInicial)))) {
                    facturasVenta.add(facturaVenta);
                }

            }
        
        return facturasVenta;

    }

    @Override
    public Iterator<Factura> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
