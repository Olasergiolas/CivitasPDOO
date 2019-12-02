/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

public class SorpresaConversion extends Sorpresa {
    JugadorEspeculador especulador;
    
    SorpresaConversion(String texto)
    {
        super(texto);
    }
  
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos))
        {
            informe(actual, todos);
            especulador = new JugadorEspeculador(todos.get(actual), 200);
            todos.remove(actual);
            todos.add(especulador);
        }
    }
    
    @Override
    public String toString()
    {
        return ("Conversión A Especulador");
    }
}
