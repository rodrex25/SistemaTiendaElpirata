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
public class Producto {
    
    //atributos
    private String idProducto;
    private String nombre;
    private String descripcion;
    private double precUnitarioSinImpuestos;
    private double impuestoUnitarioPagado;
    private double precioUnitario;
    private double precioUnitarioVenta;
    private boolean impuesto;
    
    //cosntructor

    public Producto(String idProducto, String nombre, String descripcion, double precUnitarioSinImpuestos, double impuestoUnitarioPagado, double precioUnitarioVenta, boolean impuesto) {
        
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precUnitarioSinImpuestos = precUnitarioSinImpuestos;
        this.impuestoUnitarioPagado = impuestoUnitarioPagado;
        this.precioUnitario = precUnitarioSinImpuestos+impuestoUnitarioPagado;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.impuesto = impuesto;
        
    }
    
    //getters

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecUnitarioSinImpuestos() {
        return precUnitarioSinImpuestos;
    }

    public double getImpuestoUnitarioPagado() {
        return impuestoUnitarioPagado;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public boolean isImpuesto() {
        return impuesto;
    }
   
    //setters

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecUnitarioSinImpuestos(double precUnitarioSinImpuestos) {
        this.precUnitarioSinImpuestos = precUnitarioSinImpuestos;
    }

    public void setImpuestoUnitarioPagado(double impuestoUnitarioPagado) {
        this.impuestoUnitarioPagado = impuestoUnitarioPagado;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPrecioUnitarioVenta(double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public void setImpuesto(boolean impuesto) {
        this.impuesto = impuesto;
    }
    
    //toString

    @Override
    public String toString() {
        return "\nProducto: "+
                "\nId: "+idProducto+
                "\nProducto Nombre: "+nombre+
                "\nPrecio Unitario Sin Impuesto: "+precUnitarioSinImpuestos+
                "\nImpuesto Unitario Pagado: "+impuestoUnitarioPagado+
                "\nPrecio Unitario: "+precioUnitario+
                "\nPrecio Unitario de Venta: "+precioUnitarioVenta+
                "\nImpuesto: "+impuesto;
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
        final Producto other = (Producto) obj;
        return Objects.equals(this.idProducto, other.idProducto);
    }
   
}
