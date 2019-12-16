/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import java.util.ArrayList;

public abstract class Sorpresa {
    private String texto;
    
    Sorpresa(String texto)
    {
        this.texto = texto;
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos))
            informe(actual, todos);
    }
     
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Al jugador " + todos.get(actual).getNombre() + " se le aplica una sorpresa " + toString());
    }
    
    public boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos){
        boolean retorno = false;
        if (actual >= 0 && actual < todos.size())
            retorno = true;
        return retorno;
    }
    
    public String toString(){
        return (" ");
    } 
}
