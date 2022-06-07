/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JuanA
 */
public class RegistroFacturas implements Iterable<Factura> {
    
    //Atributos
    
    private ArrayList<Factura> facturas;
    
    //Metodos
    
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
