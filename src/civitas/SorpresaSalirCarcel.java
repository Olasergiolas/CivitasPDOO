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
public class SorpresaSalirCarcel extends Sorpresa {
    private MazoSorpresas mazo;
    
    SorpresaSalirCarcel(MazoSorpresas mazo, String texto)
    {
        super(texto);
        this.mazo = mazo;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos))
        {
            informe(actual, todos);
            boolean alguien_tiene = false;
            for (int i = 0; i < todos.size() && !alguien_tiene; i++)
                alguien_tiene = todos.get(i).tieneSalvoconducto();

            if (!alguien_tiene)
            {
                todos.get(actual).obtenerSalvoconducto(this);
                salirDelMazo();
            }
        }
    }
    
    @Override
    public String toString()
    {
        return ("Salir Cárcel");
    }
    
    void usada()
    {
        mazo.habilitarCartaEspecial(this);
    }
    
    void salirDelMazo()
    {
        mazo.inhabilitarCartaEspecial(this);
    }
}
