/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

public class SorpresaConversion extends Sorpresa {
    private int valor;
    JugadorEspeculador especulador;
    
    SorpresaConversion(int valor, String texto)
    {
        super(texto);
        this.valor = valor;
    }
  
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos))
        {
            informe(actual, todos);
            especulador = new JugadorEspeculador(todos.get(actual), valor);
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
