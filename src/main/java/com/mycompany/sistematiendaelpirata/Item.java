/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.Objects;

/**
 *
 * @author gabre
 */
public class Item {
    //atributos
    
    private int cantidad;
    private Producto producto;
    private double total;

    //constructor
    public Item(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        total = 0;
        
    }

    //getters
    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }
    
    public double getTotal() {
        total = producto.getPrecioUnitario()*cantidad; 
        return total;
    }
    
    //seters
    public void setCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        
        return  "\nProducto: " +
                "\nNombre: " + producto.getNombre()+
                "\nCantidad: " + cantidad;
    }
    
    //equals

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        
        return Objects.equals(this.producto, other.producto);
    }   
    
    
}
