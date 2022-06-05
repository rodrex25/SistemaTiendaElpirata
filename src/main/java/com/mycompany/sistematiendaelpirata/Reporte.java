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
public class Reporte {
    
    //Atributos
    
    private String idReporte;
    private Usuario usuario;
    private String descripcion;
    
    //Métodos

    public Reporte(String idReporte, Usuario usuario, String descripcion) {
        this.idReporte = idReporte;
        this.usuario = usuario;
        this.descripcion = descripcion;
    }

    //Getters
    
    public String getIdReporte() {
        return idReporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    //Setters

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //toString

    @Override
    public String toString() {
        return "Reporte:" +
                "\nID de reporte: " + idReporte +
                "\nDatos del modificador:" +
                "\nID de usuario: " + usuario.getIdUsuario() +
                "\nNombre de usuario: " + usuario.getNombre() +
                "\nDescripción del reporte: " + descripcion;
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
        final Reporte other = (Reporte) obj;
        
        return Objects.equals(this.idReporte, other.idReporte);
    }   
}
