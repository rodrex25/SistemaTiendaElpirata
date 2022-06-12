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
public class CatalogoProducto implements Iterable<Producto> {

    //Atributos
    
    private ArrayList<Producto> productos;
    
    //Metodos

    public CatalogoProducto() {
        productos = new ArrayList<Producto>();
    }

    public void addProducto(Producto product) {
        productos.add(product);
    }
    
    public ArrayList<Producto> getListaProductos(){
        return productos;
    }

    public Producto getProducto(String idProducto) {
        for (Iterator<Producto> listProduct = productos.iterator(); listProduct.hasNext();){
            Producto producto = listProduct.next();
            if (producto.getIdProducto().equals(idProducto)) {
                return producto;
            }
        }
        return null;
    }

    //iterador

    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
}