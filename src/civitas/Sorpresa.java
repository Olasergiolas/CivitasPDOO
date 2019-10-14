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
        init();
        this.tipo = tipo;
        this.tablero = tablero;
    }
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero, int valor, String texto){
        init();
        this.tipo = tipo;
        this.tablero = tablero;
        this.valor = valor;
        this.texto = texto;
    }
    
    Sorpresa(TipoSorpresa tipo, int valor, String texto)
    {
        init();
        this.tipo = tipo;
        this.valor = valor;
        this.texto = texto;
    }
    
    Sorpresa(TipoSorpresa tipo, MazoSorpresas mazo){
        init();
        this.tipo = tipo;
        this.mazo = mazo;
    }
    
    void aplicarAJugador(int actual, Jugador[] todos){
        boolean correcto = jugadorCorrecto(actual, todos);
        if (correcto)
            informe(actual, todos);
        if (tipo == TipoSorpresa.SALIRCARCEL && correcto)
            aplicarAJugador_irCarcel(actual, todos);
        else if (tipo == TipoSorpresa.IRCASILLA && correcto)
            aplicarAJugador_irACasilla(actual, todos);
        else if (tipo == TipoSorpresa.PAGARCOBRAR && correcto)
            aplicarAJugador_pagarCobrar(actual, todos);
        else if (tipo == TipoSorpresa.PORCASAHOTEL && correcto)
            aplicarAJugador_porCasaHotel(actual, todos);
        else if (tipo == TipoSorpresa.PORJUGADOR && correcto)
            aplicarAJugador_porJugador(actual, todos);
        else if (tipo == TipoSorpresa.SALIRCARCEL && correcto)
            aplicarAJugador_salirCarcel(actual, todos);
    }
    
    private void aplicarAJugador_irACasilla(int actual, Jugador[] todos){
        int casillaActual,  nueva_posicion;
        casillaActual = todos[actual].getNumCasillaActual();
        nueva_posicion = tablero.NuevaPosicion(casillaActual, tablero.calcularTirada(casillaActual, valor));
        todos[actual].moverACasilla(nueva_posicion);
        tablero.getCasilla(valor).recibeJugador(actual, todos);

    }
    
    private void aplicarAJugador_irCarcel(int actual, Jugador[] todos){
        todos[actual].encarcelar(tablero.getCarcel());
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, Jugador[] todos){
        todos[actual].modificarSaldo(valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, Jugador[] todos){
        todos[actual].modificarSaldo(valor*todos[actual].getCasasPorHotel());
    }
    
    private void aplicarAJugador_porJugador(int actual, Jugador[] todos){
        Sorpresa Dar = new Sorpresa(TipoSorpresa.PAGARCOBRAR, valor*-1, "Dar Dinero");
        Sorpresa Recibir = new Sorpresa(TipoSorpresa.PAGARCOBRAR, valor*(todos.length-1), "Recibir Dinero");
        for (int i = 0; i < todos.length; i++)
        {
            if (i != actual)
                Dar.aplicarAJugador(i, todos);
        }
        Recibir.aplicarAJugador(actual, todos);
        
    }
    
    private void aplicarAJugador_salirCarcel(int actual, Jugador[] todos){
        boolean alguien_tiene = false;
        for (int i = 0; i < todos.length; i++)
            alguien_tiene = todos[i].tieneSalvoconducto();
        
        if (!alguien_tiene)
        {
            todos[actual].obtenerSalvoconducto(this);
            salirDelMazo();
        }
    }
    
    private void informe(int actual, Jugador[] todos){
        Diario.getInstance().ocurreEvento("Se le aplica la sorpresa" + texto + " a " + todos[actual].getNombre());
    }
    
    private void init(){
        valor = -1;
        mazo = null;
        tablero = null;
    }
    
    public boolean jugadorCorrecto(int actual, Jugador[] todos){
        boolean retorno = false;
        if (actual > 0 && actual < todos.length)
            retorno = true;
        return retorno;
    }
    
    void salirDelMazo(){
        if (tipo == TipoSorpresa.SALIRCARCEL)
            mazo.inhabilitarCartaEspecial(this);
    }
    
    public String toString(){
        return ("texto-" + texto + " valor-" + valor);
    }
    
    void usada(){
        if (tipo == TipoSorpresa.SALIRCARCEL)
            mazo.habilitarCartaEspecial(this);
    }    
}
