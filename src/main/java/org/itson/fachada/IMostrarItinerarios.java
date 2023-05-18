/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.fachada;

import ObjNegocio.Itinerario;

/**
 * Interfaz para generar un reporte de itinerario
 * @author @author kim, marki, elmer, yorx
 */
public interface IMostrarItinerarios {
    
    /**
     * Metodo que genera un reporte de itinerario de a cuerdo al itinerario que se le envia
     * @param itinerario Itinerario a generar un reporte
     */
    public void reporteItinerario(Itinerario itinerario);
}
