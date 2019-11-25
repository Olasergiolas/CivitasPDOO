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
public class CasillaJuez extends Casilla {
    private static int carcel;
    
    CasillaJuez(int numCasillaCarcel, String nombre)
    {
        super(nombre);
        carcel = numCasillaCarcel;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(iactual, todos))
        {
            informe(iactual, todos);
            todos.get(iactual).encarcelar(carcel);
        }
    }
    
    @Override
    public String toString()
    {
        String salida = new String();
        salida = "Juez";
        return salida;
    }
}
