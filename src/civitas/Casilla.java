package civitas;
import java.util.ArrayList;
        
        
public class Casilla {
    private String nombre;
    private static int carcel;
    private float importe;
    private TipoCasilla tipo;
    private TituloPropiedad tituloPropiedad;
    private Sorpresa sorpresa;
    private MazoSorpresas mazo;
        
    Casilla (String n){
        init();
        tipo = TipoCasilla.DESCANSO;
        nombre = n;
    }
    
    Casilla(TituloPropiedad titulo){
        init();
        tipo = TipoCasilla.CALLE;
        nombre = titulo.getNombre();
        tituloPropiedad = titulo;
    }
    
    Casilla(float cantidad, String nombre){
        init();
        tipo = TipoCasilla.IMPUESTO;
        importe = cantidad;
        this.nombre = nombre;
    }
    
    Casilla(int numCasillaCarcel, String nombre){
        init();
        tipo = TipoCasilla.JUEZ;
        carcel = numCasillaCarcel;
        this.nombre = nombre;
    }
    
    Casilla(MazoSorpresas mazo, String nombre){
        init();
        tipo = TipoCasilla.SORPRESA;
        this.mazo = mazo;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    TituloPropiedad getTituloPropiedad(){
        return tituloPropiedad;
    }
    
    private void informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + iactual + " ha caído en una casilla " + toString());
    }
    
    private void init(){
        nombre = " ";
        importe = 0;
        tipo = null;
        tituloPropiedad = null;
        sorpresa = null;
        mazo = null;
    }
    
    public boolean jugadorCorrecto(int iactual, ArrayList<Jugador> todos){
        boolean retorno = false;
        if (iactual >= 0 && iactual < todos.size())
            retorno = true;
        return retorno;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        boolean correcto = jugadorCorrecto(iactual, todos);
        if (correcto)
            informe(iactual, todos);
        if (tipo == TipoCasilla.CALLE && correcto)
            recibeJugador_calle(iactual, todos);
        else if (tipo == TipoCasilla.IMPUESTO && correcto)
            recibeJugador_impuesto(iactual, todos);
        else if (tipo == TipoCasilla.JUEZ && correcto)
            recibeJugador_juez(iactual, todos);
        else if (tipo == TipoCasilla.SORPRESA && correcto)
            recibeJugador_sorpresa(iactual, todos);
    }
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){
        Jugador jugador = todos.get(iactual);
            
        if (!tituloPropiedad.tienePropietario())
            jugador.puedeComprarCasilla();                                      //Para qué llama a esto?
    
        else
            tituloPropiedad.tramitarAlquiler(jugador);
    }
    
    private void recibeJugador_impuesto(int iactual, ArrayList<Jugador> todos){
        todos.get(iactual).pagaImpuesto(importe);
    }
    
    private void recibeJugador_juez(int iactual, ArrayList<Jugador> todos){
        todos.get(iactual).encarcelar(carcel);
    }
    
    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){
        /*if (jugadorCorrecto(iactual, todos)){
            Sorpresa sorpresa = mazo.siguiente();
            informe(iactual, todos);
            sorpresa.aplicarAJugador(iactual, todos);
        }*/
        
        mazo.siguiente().aplicarAJugador(iactual, todos);
    }
    
    public String toString(){
        String salida = new String();
        
        if (tipo == TipoCasilla.CALLE)
            salida = "Casilla " + tituloPropiedad.getNombre() + " con importe " + tituloPropiedad.getPrecioCompra() + " de tipo " + tipo;
        
        else
            salida = "Casilla " + nombre + " con importe " + importe + " de tipo " + tipo;
        return salida;
    }
}
