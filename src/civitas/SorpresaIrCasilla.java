/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author ggarr
 */
public class SorpresaIrCasilla extends Sorpresa{
    private int numCasilla;
    private Tablero tablero;
    
    SorpresaIrCasilla(Tablero tablero, int valor, String texto)
    {
        super(texto);
        this.tablero = tablero;
        numCasilla = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos))
        {
            informe(actual, todos);
            int casillaActual,  nueva_posicion;
            casillaActual = todos.get(actual).getNumCasillaActual();
            nueva_posicion = tablero.NuevaPosicion(casillaActual, tablero.calcularTirada(casillaActual, numCasilla));
            todos.get(actual).moverACasilla(nueva_posicion);
            tablero.getCasilla(numCasilla).recibeJugador(actual, todos);
        }
    }
    
    @Override
    public String toString()
    {
        String salida = new String();
        salida = "IRCASILLA";
        return salida;
    }
}
