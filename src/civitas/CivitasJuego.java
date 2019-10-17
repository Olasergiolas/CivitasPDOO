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
        throw new UnsupportedOperationException("No implementado");             //no sé hacerlo
    }
    
    private void avanzaJugador (){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean cancelarHipoteca(int ip){
        return jugadores.get(indiceJugadorActual).cancelarHipoteca(ip);
    }
    
    public boolean comprar(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean construirCasa(int ip){
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        while (tablero.getPorSalida() > 0)
            jugadorActual.pasaPorSalida();
    }
    
    public boolean finalDelJuego(){
        boolean retorno = false;
        for (int i = 0; i < jugadores.size() && jugadores.get(i).enBancarrota(); i++)
            retorno = jugadores.get(i).enBancarrota();
        return retorno;
    }
    
    public Casilla getCasillaActual(){
        return tablero.getCasilla(jugadores.get(indiceJugadorActual).getNumCasillaActual());
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public boolean hipotecar(int ip){
        return jugadores.get(indiceJugadorActual).hipotecar(ip);
    }
    
    public String infoJugadorTexto(){
        return jugadores.get(indiceJugadorActual).toString();
    }
    
    private void inicializarMazoSorpresas(Tablero tablero){                     //no sé hacerlo
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void inicializarTablero(MazoSorpresas mazo){                        //no sé hacerlo                       
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void pasarTurno(){
        if (indiceJugadorActual < jugadores.size())
            indiceJugadorActual++;
        else
            indiceJugadorActual = 0;
    }
    
    private Jugador[] ranking(){
        throw new UnsupportedOperationException("No implementado");             //no sé hacerlo
    }
    
    public boolean salirCarcelPagando(){
        return jugadores.get(indiceJugadorActual).salirCarcelPagando();
    }
    
    public boolean salirCarcelTirando(){
        return jugadores.get(indiceJugadorActual).salirCarcelTirando();
    }
    
    public OperacionesJuego siguientePaso(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        estado = gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    public boolean vender(int ip){
        return jugadores.get(indiceJugadorActual).vender(ip);
    }   
}
