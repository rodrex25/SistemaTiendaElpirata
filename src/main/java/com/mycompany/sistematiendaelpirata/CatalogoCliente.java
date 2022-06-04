/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.Iterator;
import java.util.ArrayList;



/**
 *
 * @author gabre
 */
public class CatalogoCliente implements Iterable<Cliente> {
    
    
    //attributos
    private ArrayList <Cliente> clientes = new ArrayList <Cliente>();
    private Iterator<Cliente> iterator = clientes.iterator();
    
    
    //constructor
    public CatalogoCliente(){
    }
    
    //metodos
    
    public void addCliente(Cliente cliente){
        clientes.add( cliente );
    }
    
    public Cliente getCliente(String idCliente){
        
        for(Iterator<Cliente> listaClientes = clientes.iterator(); listaClientes.hasNext();){
            
            Cliente cliente = listaClientes.next();
            
            if(cliente.getIdCliente().equals(idCliente)){
                return cliente;
            }
            
        }
        
        return null;
    }
    
    //getters
    public ArrayList<Cliente> getListaClientes() {
        return clientes;
    }
    
    
     
    //sobreescritos
    @Override
    public Iterator<Cliente> iterator() {
        return clientes.iterator();
    }
    
    
    
}
