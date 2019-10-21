/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import java.util.ArrayList;
import java.util.Collections;

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
        for (int i = 0; i < nombres.length; i++)
            jugadores.add(i, new Jugador(nombres[i]));
        
        tablero = new Tablero(5);
        mazo = new MazoSorpresas();
        inicializarTablero(mazo);
        inicializarMazoSorpresas(tablero);
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
    
    private void inicializarMazoSorpresas(Tablero tablero){                 
        mazo.alMazo(new Sorpresa(TipoSorpresa.IRCARCEL, tablero));
        mazo.alMazo(new Sorpresa(TipoSorpresa.IRCASILLA, tablero, 200, "sorpresa IRCARCEL"));
        mazo.alMazo(new Sorpresa(TipoSorpresa.SALIRCARCEL, mazo));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, 200, "sorpresa PAGARCOBRAR"));
    }
    
    private void inicializarTablero(MazoSorpresas mazo){                                            
        ArrayList<Casilla> c = new ArrayList<Casilla>();
        c.add(new Casilla(200, "Impuesto"));
        c.add(new Casilla(5, "Cárcel"));
        c.add(new Casilla(new TituloPropiedad()));
        c.add(new Casilla(mazo, "Sorpresa"));
        c.add(new Casilla("Descanso"));
    }
    
    private void pasarTurno(){
        if (indiceJugadorActual < jugadores.size())
            indiceJugadorActual++;
        else
            indiceJugadorActual = 0;
    }
    
    private ArrayList<Jugador> ranking(){
        Collections.sort(jugadores);
        return jugadores;
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
