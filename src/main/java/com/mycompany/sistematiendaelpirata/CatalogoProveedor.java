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
public class CatalogoProveedor implements Iterable<Proveedor> {
    
    //Atributos
    
    private ArrayList<Proveedor> proveedores;
    
    //Constructor

    public CatalogoProveedor() {
        proveedores = new ArrayList<Proveedor>();
    }
    
    //Métodos
    
    public void addProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }
    
    public Proveedor getProveedor(String idProveedor){
        for (Iterator<Proveedor> listProveedor = proveedores.iterator(); listProveedor.hasNext();){
            Proveedor proveedor = listProveedor.next();
            if (proveedor.getIdProvedor().equals(idProveedor)) {
                return proveedor;
            }
        }
        return null;
    }
    
    //Getters
    
    public ArrayList<Proveedor> getListaProveedores() {
        return proveedores;
    }
    
    //Sobreescritura
    //iterator
    
    @Override
    public Iterator<Proveedor> iterator() {
        return proveedores.iterator();
    }
}
