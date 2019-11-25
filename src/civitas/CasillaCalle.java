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
public class CasillaCalle extends Casilla {
    private TituloPropiedad tituloPropiedad;
    
    CasillaCalle(TituloPropiedad titulo)
    {
        super(titulo.getNombre());
        tituloPropiedad = titulo;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        if(jugadorCorrecto(iactual, todos))
        {
            informe(iactual, todos);
            Jugador jugador = todos.get(iactual);

            if (!tituloPropiedad.tienePropietario())
                jugador.puedeComprarCasilla();                                      

            else
                tituloPropiedad.tramitarAlquiler(jugador);
        }
    }
    
    @Override
    public String toString()
    {
        String salida = new String();
        salida = "Calle " + tituloPropiedad.toString();
        return salida;
    }
    
    TituloPropiedad getTituloPropiedad()
    {
        return tituloPropiedad;
    }
}