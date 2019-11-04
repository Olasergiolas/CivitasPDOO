/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoTexto;

import civitas.CivitasJuego;
import civitas.OperacionesJuego;

/**
 *
 * @author sergio
 */
public class Controlador {
    private CivitasJuego juego;
    private VistaTextual vista;
    
    Controlador(CivitasJuego juego, VistaTextual vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    void juega(){
        vista.setCivitasJuego(juego);
        
        while (!juego.finalDelJuego()){
            vista.actualizarVista();
            vista.pausa();
            OperacionesJuego operacion = juego.siguientePaso();
            if (operacion != OperacionesJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }
            
            if (!juego.finalDelJuego()){
                if (operacion == OperacionesJuego.COMPRAR){
                    if (vista.comprar() == Respuestas.SI){
                        juego.comprar();
                    }
                    
                    juego.siguientePasoCompletado(operacion);
                }
            }
        }
    }
}
