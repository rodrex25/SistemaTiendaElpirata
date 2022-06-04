/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gabre
 */
public class ListaUsuarios implements Iterable<Usuario>{
   
    //atributos
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Iterator<Usuario> iterator = usuarios.iterator();
    
    //metodos
    
    public void addUsuario(Usuario usuario){
        
        usuarios.add(usuario);
    }
    
    
    public void deleteUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }
    
    
    public Usuario getUsuario(String idUsuario){
        
        for(Iterator<Usuario> listaUsuarios = usuarios.iterator(); listaUsuarios.hasNext();){
            
            Usuario usuario = listaUsuarios.next();
            
            if(idUsuario.equals(usuario.getIdUsuario())){
                
                return usuario;
                
            }
            
        }
        
    return null;
    
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    
    @Override
    public Iterator<Usuario> iterator() {
        return usuarios.iterator();
    }
    
}
