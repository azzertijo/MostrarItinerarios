/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.fachada;

import ObjNegocio.Itinerario;
import vistaItinerario.VisorItinerario;

/**
 *
 * @author JORGE
 */
public class MostrarItineariosFachada implements IMostrarItinerarios{
VisorItinerario visor;
    
    @Override
    public void reporteItinerario(Itinerario itinerario) {
        visor.reporteItinerario(itinerario);
    }
    
}
