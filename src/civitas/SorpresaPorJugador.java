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
public class SorpresaPorJugador extends Sorpresa {
    private int valor;
    
    SorpresaPorJugador(int valor, String texto)
    {
        super(texto);
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos))
        {
            informe(actual, todos);
            SorpresaPagarCobrar Dar = new SorpresaPagarCobrar(valor*-1, "Dar Dinero");
            SorpresaPagarCobrar Recibir = new SorpresaPagarCobrar(valor*(todos.size()-1), "Recibir Dinero");
            for (int i = 0; i < todos.size(); i++)
            {
                if (i != actual)
                    Dar.aplicarAJugador(i, todos);
            }
            Recibir.aplicarAJugador(actual, todos);
        }
    }
    
    @Override
    public String toString()
    {
        return ("Por Jugador");
    }
}