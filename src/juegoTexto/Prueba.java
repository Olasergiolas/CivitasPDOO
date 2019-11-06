/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoTexto;

import java.util.ArrayList;
import civitas.CivitasJuego;
import civitas.Jugador;
import civitas.Dado;

/**
 *
 * @author sergio
 */
public class Prueba {
    public static void main(String[] args){
        VistaTextual vista = new VistaTextual();
        ArrayList<String> jugadores = new ArrayList<String>();

        jugadores.add("Sergio");
        jugadores.add("Inés");
        jugadores.add("Alberto");
        jugadores.add("Cuack");
        
        CivitasJuego juego = new CivitasJuego(jugadores);
        Controlador controlador = new Controlador(juego, vista);
        
        controlador.juega();      
    }
}
