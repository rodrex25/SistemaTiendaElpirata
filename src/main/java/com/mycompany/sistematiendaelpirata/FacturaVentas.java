/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author JuanA
 */
public class FacturaVentas extends Factura {

    //Atributos
    
    private Cliente cliente;
    private String direccionEnvio;
    
    //Metodos

    public FacturaVentas(String idFactura, Date fechaEmision, Cliente cliente, String direccionEnvio) {
        super(idFactura, fechaEmision);
        this.cliente = cliente;
        this.direccionEnvio = direccionEnvio;
    }
    
    //Getters

    public Cliente getCliente() {
        return cliente;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }
    
    //Setters

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
    
    //toString
    
    @Override
    public String toString() {
        
        return  "\nFactura de venta: " +
                "\nID: " + super.getIdFactura() +
                "\nFecha de emision: " + super.getFechaEmision() +
                "\nID del cliente: " + cliente.getIdCliente() +
                "\nNombre del cliente: " + cliente.getNombreContactoCliente() +
                "\nDireccion de envio: " + super.getFechaEmision();
    }
}
