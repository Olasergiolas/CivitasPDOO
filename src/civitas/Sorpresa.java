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
class Sorpresa {
    private String texto;
    private int valor;
    private Tablero tablero;
    private TipoSorpresa tipo;
    private MazoSorpresas mazo;
    
    Sorpresa(String texto)
    {
        this.texto = texto;
    }
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero){               //Mandar a cárcel
        init();
        this.tipo = tipo;
        this.tablero = tablero;
    }
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero, int valor, String texto){      //Mandar a otra casilla
        init();
        this.tipo = tipo;
        this.tablero = tablero;
        this.valor = valor;
        this.texto = texto;
    }
    
    Sorpresa(TipoSorpresa tipo, int valor, String texto)          //resto de sorpresas
    {
        init();
        this.tipo = tipo;
        this.valor = valor;
        this.texto = texto;
    }
    
    Sorpresa(TipoSorpresa tipo, MazoSorpresas mazo){            //evitar cárcel
        init();
        this.tipo = tipo;
        this.mazo = mazo;
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        boolean correcto = jugadorCorrecto(actual, todos);
        if (correcto)
            informe(actual, todos);
        if (tipo == TipoSorpresa.IRCARCEL && correcto)
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
    
    private void aplicarAJugador_irACasilla(int actual, ArrayList<Jugador> todos){
        int casillaActual,  nueva_posicion;
        casillaActual = todos.get(actual).getNumCasillaActual();
        nueva_posicion = tablero.NuevaPosicion(casillaActual, tablero.calcularTirada(casillaActual, valor));
        todos.get(actual).moverACasilla(nueva_posicion);
        tablero.getCasilla(valor).recibeJugador(actual, todos);

    }
    
    private void aplicarAJugador_irCarcel(int actual, ArrayList<Jugador> todos){
        todos.get(actual).encarcelar(tablero.getCarcel());
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        todos.get(actual).modificarSaldo(valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        todos.get(actual).modificarSaldo(valor*todos.get(actual).getNumPropiedades());
    }
    
    private void aplicarAJugador_porJugador(int actual, ArrayList<Jugador> todos){
        Sorpresa Dar = new Sorpresa(TipoSorpresa.PAGARCOBRAR, valor*-1, "Dar Dinero");
        Sorpresa Recibir = new Sorpresa(TipoSorpresa.PAGARCOBRAR, valor*(todos.size()-1), "Recibir Dinero");
        for (int i = 0; i < todos.size(); i++)
        {
            if (i != actual)
                Dar.aplicarAJugador(i, todos);
        }
        Recibir.aplicarAJugador(actual, todos);
        
    }
    
    private void aplicarAJugador_salirCarcel(int actual, ArrayList<Jugador> todos){
        boolean alguien_tiene = false;
        for (int i = 0; i < todos.size(); i++)
            alguien_tiene = todos.get(i).tieneSalvoconducto();
        
        if (!alguien_tiene)
        {
            todos.get(actual).obtenerSalvoconducto(this);
            salirDelMazo();
        }
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Al jugador " + todos.get(actual).getNombre() + " se le aplica una sorpresa " + toString());
    }
    
    private void init(){
        valor = -1;
        mazo = null;
        tablero = null;
    }
    
    public boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos){
        boolean retorno = false;
        if (actual >= 0 && actual < todos.size())
            retorno = true;
        return retorno;
    }
    
    void salirDelMazo(){
        if (tipo == TipoSorpresa.SALIRCARCEL)
            mazo.inhabilitarCartaEspecial(this);
    }
    
    public String toString(){
        return ("tipo- " + tipo + "texto-" + texto + " valor-" + valor);
    }
    
    void usada(){
        if (tipo == TipoSorpresa.SALIRCARCEL)
            mazo.habilitarCartaEspecial(this);
    }    
}
