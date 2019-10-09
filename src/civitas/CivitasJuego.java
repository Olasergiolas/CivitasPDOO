/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    private MazoSorpresas mazo;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private EstadosJuego estado;
    private GestorEstados gestorEstados;
    
    public CivitasJuego(String[] nombres){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void avanzaJugador (){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean cancelarHipoteca(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean comprar(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean construirCasa(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean construirHotel(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean finalDelJuego(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public Casilla getCasillaActual(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public Jugador getJugadorActual(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean hipotecar(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public String infoJugadorTexto(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void inicializarMazoSorpresas(Tablero tablero){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void inicializarTablero(MazoSorpresas mazo){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void pasarTurno(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private Jugador[] ranking(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean salirCarcelPagando(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean salirCarcelTirando(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public OperacionesJuego siguientePaso(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean vender(int ip){
        throw new UnsupportedOperationException("No implementado");
    }   
}
