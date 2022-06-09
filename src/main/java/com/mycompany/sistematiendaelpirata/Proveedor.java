/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.Objects;

/**
 *
 * @author JuanA
 */
public class Proveedor {
    
    //Atributos
    
    private String idProvedor;
    private String razonSocial;
    private String rfc;
    private String direccion;
    private String tel;
    private String fax;
    private String nombreContactoProveedor;
    private String emailContactoProveedor;
    private String telContactoProveedor;
    
    //Metodos

    public Proveedor(String idProvedor, String razonSocial, String rfc, String direccion, String tel, String fax, String nombreContactoProveedor, String emailContactoProveedor, String telContactoProveedor) {
        this.idProvedor = idProvedor;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.direccion = direccion;
        this.tel = tel;
        this.fax = fax;
        this.nombreContactoProveedor = nombreContactoProveedor;
        this.emailContactoProveedor = emailContactoProveedor;
        this.telContactoProveedor = telContactoProveedor;
    }

    public String getData(){
        return idProvedor+","+razonSocial+","+rfc+","+direccion+","+tel+","+fax+","+nombreContactoProveedor+","+emailContactoProveedor+","+telContactoProveedor+"\n";
    }
    
    //Getters

    public String getIdProvedor() {
        return idProvedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTel() {
        return tel;
    }

    public String getFax() {
        return fax;
    }

    public String getNombreContactoProveedor() {
        return nombreContactoProveedor;
    }

    public String getEmailContactoProveedor() {
        return emailContactoProveedor;
    }

    public String getTelContactoProveedor() {
        return telContactoProveedor;
    }
    
    //Setters

    public void setIdProvedor(String idProvedor) {
        this.idProvedor = idProvedor;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setNombreContactoProveedor(String nombreContactoProveedor) {
        this.nombreContactoProveedor = nombreContactoProveedor;
    }

    public void setEmailContactoProveedor(String emailContactoProveedor) {
        this.emailContactoProveedor = emailContactoProveedor;
    }

    public void setTelContactoProveedor(String telContactoProveedor) {
        this.telContactoProveedor = telContactoProveedor;
    }
    
    //Sobreescritura
    //toString

    @Override
    public String toString() {
        return "Proveedor:" +
                "\nID: " + idProvedor +
                "\nRazon social: " + razonSocial +
                "\nRFC: " + rfc +
                "\nDirección: " + direccion +
                "\nTeléfono: " + tel +
                "\nFax: " + fax +
                "\nNombre de contacto: " + nombreContactoProveedor +
                "\nEmail de contacto: " + emailContactoProveedor +
                "\nTeléfono de contacto: " + telContactoProveedor;
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
        final Proveedor other = (Proveedor) obj;
        return Objects.equals(this.idProvedor, other.idProvedor);
    }
}
