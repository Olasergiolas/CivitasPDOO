/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import GUI.*;
import java.util.ArrayList;

public class TestP5 {
    
    public static void test(){
        CivitasView vista = new CivitasView();
        Dado.createInstance(vista);
        CapturaNombres captura = new CapturaNombres(vista, true);
        
        ArrayList<String> nombres = new ArrayList<String>();
        nombres = captura.getNombres();
        
        CivitasJuego juego = new CivitasJuego(nombres);
        Controlador controlador = new Controlador(juego, vista);
        
        vista.setCivitasJuego(juego);
        vista.actualizarVista();
    }
    
    public static void main(String[] args)
    {
        TestP5 Jugador = new TestP5();
        
        Jugador.test();
    }
}
