/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematiendaelpirata;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JuanA
 */
public class ListaDeReportes implements Iterable<Reporte> {

    //Atributos
    
    private ArrayList<Reporte> reportes;
    
    //Métodos
    
    public ListaDeReportes() {
        reportes = new ArrayList<Reporte>();
    }
    
    public void addReporte(Reporte reporte) {
        reportes.add(reporte);
    }
    
    public void deleteReporte(Reporte reporte) {
        reportes.remove(reporte);
    }
    
    public Reporte getReporte(String idReporte) {
        for (Iterator<Reporte> listReporte = reportes.iterator(); listReporte.hasNext();){
            Reporte reporte = listReporte.next();
            if (reporte.getIdReporte().equals(idReporte)) {
                return reporte;
            }
        }
        return null;
    }
    
    //Getters
    
    public ArrayList<Reporte> getListaReportes() {
        return reportes;
    }
    
    //Sobreescritura
    //iterator
    
    @Override
    public Iterator<Reporte> iterator() {
        return reportes.iterator();
    }
}
