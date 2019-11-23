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
    
    public CivitasJuego(ArrayList<String> nombres){
        jugadores = new ArrayList<Jugador>();
        
        for (int i = 0; i < nombres.size(); i++)
            jugadores.add(i, new Jugador(nombres.get(i)));
        
        tablero = new Tablero(5);
        mazo = new MazoSorpresas();
        estado = EstadosJuego.INICIO_TURNO;
        gestorEstados = new GestorEstados();
        inicializarTablero(mazo);
        inicializarMazoSorpresas(tablero);
    }
    
    private void avanzaJugador (){
        Jugador jugadorActual;
        int posicionActual, posicionNueva;
        int tirada;
        Casilla c;
        
        jugadorActual = jugadores.get(indiceJugadorActual);
        posicionActual = jugadorActual.getNumCasillaActual();
        tirada = Dado.getInstance().tirar();
        posicionNueva = tablero.NuevaPosicion(posicionActual, tirada);
        c = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida(jugadorActual);
        jugadorActual.moverACasilla(posicionNueva);
        c.recibeJugador(indiceJugadorActual, jugadores);
        contabilizarPasosPorSalida(jugadorActual);
        
    }
    
    public boolean cancelarHipoteca(int ip){
        return jugadores.get(indiceJugadorActual).cancelarHipoteca(ip);
    }
    
    public boolean comprar(){
        boolean resultado = false;
        
        Jugador jugadorActual = jugadores.get(indiceJugadorActual);
        int numCasillaActual = jugadorActual.getNumCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        TituloPropiedad titulo = casilla.getTituloPropiedad();
        resultado = jugadorActual.comprar(titulo);
        
        return resultado;
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
        Casilla aux = tablero.getCasilla(jugadores.get(indiceJugadorActual).getNumCasillaActual());
        return aux;
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
        //mazo.alMazo(new Sorpresa(TipoSorpresa.IRCARCEL, tablero));       
        //mazo.alMazo(new Sorpresa(TipoSorpresa.SALIRCARCEL, mazo));
        //mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, 200, "sorpresa PAGARCOBRAR"));
        //mazo.alMazo(new Sorpresa(TipoSorpresa.IRCASILLA, tablero, 0, "sorpresa IRCASILLA"));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORJUGADOR, 200, "sorpresa PORJUGADOR"));
    }
    
    private void inicializarTablero(MazoSorpresas mazo){
        Casilla casSorp = new Casilla(mazo, "Sorpresa");
        ArrayList<Casilla> c = new ArrayList<Casilla>();
        c.add(casSorp);
        c.add(new Casilla(200f, "Impuesto"));
        c.add(new Casilla(new TituloPropiedad("Calle Albaricoque", 0, 0, 0, 0, 0)));
        c.add(new Casilla(mazo, "Sorpresa"));
        c.add(new Casilla("Descanso"));
        c.add(new Casilla(new TituloPropiedad("Calle ESPAÑA", 0, 0, 0, 0, 0)));
        
        
        for (int i = 0; i < c.size(); i++){
            tablero.aniadeCasilla(c.get(i));
        }
        
        tablero.aniadeJuez();
        
    }
    
    private void pasarTurno(){
        if (indiceJugadorActual < jugadores.size()-1)
            indiceJugadorActual++;
        else
            indiceJugadorActual = 0;
    }
    
    public ArrayList<Jugador> ranking(){
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
        Jugador jugadorActual = jugadores.get(indiceJugadorActual);
        OperacionesJuego operacion = gestorEstados.operacionesPermitidas(jugadorActual, estado);
        
        if (operacion == OperacionesJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        
        else if(operacion == OperacionesJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        estado = gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    public boolean vender(int ip){
        return jugadores.get(indiceJugadorActual).vender(ip);
    }   
}
