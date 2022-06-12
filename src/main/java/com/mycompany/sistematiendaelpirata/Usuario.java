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
public class Usuario {
    
    //atributos
    
    private String idUsuario;
    private String usuario;
    private String nombre;
    private String telefono;
    
    //constructor
    public Usuario(String idUsuario, String usuario, String nombre, String telefono){
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    //getters
    
     public String getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    //setters
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    
    //toString

    @Override
    public String toString() {
        return "\nUsuario: "+
                "\nId Usuario: "+idUsuario+
                "\nUsuario: "+usuario+
                "\nNombre: "+nombre+
                "\nTelefono: "+telefono;
    }

    //equals
    
   /*@Override
    public boolean equals(Object object){
         Usuario usuario = (Usuario)object;
         
         if(idUsuario != usuario.idUsuario){
             
             return false;
         }
         else{
             return true;
         }}*/

    

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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.idUsuario, other.idUsuario);
    }
        
        
        
    
    

   
    
}
