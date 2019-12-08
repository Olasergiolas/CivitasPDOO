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
public class CasillaSorpresa extends Casilla {
    private MazoSorpresas mazo;
    
    CasillaSorpresa(MazoSorpresas mazo, String nombre)
    {
        super(nombre);
        this.mazo = mazo;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(iactual, todos))
        {
            informe(iactual, todos);
            mazo.siguiente().aplicarAJugador(iactual, todos);
        }
    }
    
    @Override
    public String toString()
    {
        String salida = new String();
        salida = "Sorpresa";
        return salida;
    }
}
