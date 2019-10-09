/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author sergio
 */
public class Sorpresa {
    private String texto;
    private int valor;
    private Tablero tablero;
    private TipoSorpresa tipo;
    private MazoSorpresas mazo;
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero){
        throw new UnsupportedOperationException("No implementado");
    }
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero, int valor, String texto){
        throw new UnsupportedOperationException("No implementado");
    }
    
    Sorpresa(TipoSorpresa tipo, MazoSorpresas mazo){
        throw new UnsupportedOperationException("No implementado");
    }
    
    void aplicarAJugador(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void aplicarAJugador_irACasilla(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void aplicarAJugador_irCarcel(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void aplicarAJugador_porJugador(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void aplicarAJugador_salirCarcel(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void informe(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void init(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean jugadorCorrecto(int actual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    void salirDelMazo(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public String toString(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    void usada(){
        throw new UnsupportedOperationException("No implementado");
    }    
}
