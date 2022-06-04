/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sistematiendaelpirata;

import javax.swing.JOptionPane;

/**
 *
 * @author gabre
 */
public class SistemaTiendaElpirata {

    public static void main(String[] args) {
        
        Cliente [] cliente = new Cliente[3];
        cliente[0]=new Cliente("1","a","a","a","a","a");
        cliente[1]=new Cliente("2","b","b","b","b","b");
        cliente[2]=new Cliente("3","c","c","c","c","c");
        CatalogoCliente catalogoCliente = new CatalogoCliente( );
        
        for(int i=0;i<cliente.length;i++){
            catalogoCliente.addCliente(cliente[i]);
        
        }
        JOptionPane.showMessageDialog(null, catalogoCliente.getListaClientes());
        
        catalogoCliente.deleteCliente(catalogoCliente.getCliente("2"));
        
        JOptionPane.showMessageDialog(null, catalogoCliente.getListaClientes());
        
        /*
        JOptionPane.showMessageDialog(null, catalogoCliente.getListaClientes());
        if(catalogoCliente.getCliente("2") != null){
            JOptionPane.showMessageDialog(null, catalogoCliente.getCliente("2").toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "no se encontro el cliente");
        }*/
        
        
    }
}
