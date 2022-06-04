/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

/**
 *
 * @author gabre
 */
public class Cliente {
    
    
    //atributos
    private String idCliente;
    private String razonSocial;
    private String rfc;
    private String direccionFiscal;
    private String nombreContactoCliente;
    private String telefonoContactoCliente;
    
    //cosntructor

    public Cliente(String idCliente, String razonSocial, String rfc, String direccionFiscal, String nombreContactoCliente, String telefonoContactoCliente) {
        this.idCliente = idCliente;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.direccionFiscal = direccionFiscal;
        this.nombreContactoCliente = nombreContactoCliente;
        this.telefonoContactoCliente = telefonoContactoCliente;
    }
    //metodos
    
    public String getData(){
        return idCliente+"/"+razonSocial+"/"+rfc+"/"+direccionFiscal+"/"+ nombreContactoCliente+"/"+ telefonoContactoCliente+"\n";
        }
    
    //getters
    
    public String getIdCliente() {
        return idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public String getNombreContactoCliente() {
        return nombreContactoCliente;
    }

    public String getTelefonoContactoCliente() {
        return telefonoContactoCliente;
    }
    
    //setters

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public void setNombreContactoCliente(String nombreContactoCliente) {
        this.nombreContactoCliente = nombreContactoCliente;
    }

    public void setTelefonoContactoCliente(String telefonoContactoCliente) {
        this.telefonoContactoCliente = telefonoContactoCliente;
    }
    
    
    //sobre escritos
    //toString

    @Override
    public String toString() {
        return  "\nCliente: "+
                "\nID: "+idCliente+
                "\nNombre: "+nombreContactoCliente+
                "\nRazon social: "+razonSocial+
                "\nRFC: "+rfc+
                "\nDireccion Fiscal: "+direccionFiscal+
                "\nTelefono "+telefonoContactoCliente;
    }
    
    //equals
    @Override
    public boolean equals(Object object){
         Cliente cliente = (Cliente)object;
         
         if(idCliente != cliente.idCliente){
             
             return false;
         }
         else{
             return true;
         }
        
        
        
    }
    
    

    
}
