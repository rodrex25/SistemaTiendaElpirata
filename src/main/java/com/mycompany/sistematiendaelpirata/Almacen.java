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
public class Almacen implements Iterable<Item> {

    //Atributos
    
    private ArrayList<Item> items;
    
    //Metodos

    public Almacen() {
        items = new ArrayList<Item>();
    }
    
    public void addItem(Item item) {
        Item itemTmp = getItem(item.getProducto());
        if (itemTmp != null) {
            itemTmp.setCantidad(item.getCantidad());
        } else {
            items.add(item);
        }
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }
    
    public Item getItem(Producto producto) {
        for (Item item : items) {
            if (item.getProducto().equals(producto)) {
                return item;
            }
        }
        return null;
    }

    //Getters
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    //equals
    
    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
    
}
