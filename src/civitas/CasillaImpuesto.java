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
public class CasillaImpuesto extends Casilla {
    private float importe;
    
    CasillaImpuesto(float cantidad, String nombre)
    {
        super(nombre);
        importe = cantidad;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(iactual, todos))
        {
            informe(iactual, todos);
            todos.get(iactual).pagaImpuesto(importe);
        }
    }
    
    @Override
    public String toString()
    {
        String salida = new String();
        salida = "Impuesto de importe " + importe + " y de nombre " + getNombre();
        return salida;
    }
}
