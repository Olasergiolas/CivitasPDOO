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
    
    private void informe(int iactual, Jugador[] todos){
        Diario.getInstance().ocurreEvento("El jugador " + iactual + "ha caído en la casilla " + nombre);
    }
    
    private void init(){
        nombre = " ";
        importe = 0;
        tipo = null;
        tituloPropiedad = null;
        sorpresa = null;
        mazo = null;
    }
    
    public boolean jugadorCorrecto(int iactual, Jugador[] todos){
        boolean retorno = false;
        if (iactual > 0 && iactual < todos.length)
            retorno = true;
        return retorno;
    }
    
    void recibeJugador(int iactual, Jugador[] todos){
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
    
    private void recibeJugador_calle(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void recibeJugador_impuesto(int iactual, Jugador[] todos){
        todos[iactual].pagaImpuesto(importe);
    }
    
    private void recibeJugador_juez(int iactual, Jugador[] todos){
        todos[iactual].encarcelar(carcel);
    }
    
    private void recibeJugador_sorpresa(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public String toString(){
        return (nombre + " carcel-" + carcel + " importe-" + importe + " sorpresa-" + sorpresa.toString() + " titulo-" + tituloPropiedad.toString());
    }
}
