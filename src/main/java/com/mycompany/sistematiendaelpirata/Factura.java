/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.Date;

/**
 *
 * @author gabre
 */
public class Factura {
    
    //atributos
    private String idFactura;
    //private ArrayList<Item> items = new ArrayList<Item>();
    private Date fechaEmision;
    //private double total;

    public Factura(String idFactura, Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    
    //getters
    public String getIdFactura() {
        return idFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    
    //setters

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    
//////////////////////////////////////////////////////////////////////////////////////    
    
}