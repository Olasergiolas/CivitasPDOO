package civitas;
import java.util.ArrayList;
        
        
public class Casilla {
    private String nombre;
    private static int carcel;
    private float importe;
    
    //Falta un atributo de tipo TipoCasilla llamado tipo
    //Falta un atributo de tipo MazoSorpresas llamado mazo
    //Falta un atributo de tipo Sorpresa llamado sorpresa
    //Falta un atributo de tipo TituloPropiedad llamado tituloPropiedad
        
    Casilla (String n){
        nombre = n;
    }
    
    Casilla(TituloPropiedad titulo){
        throw new UnsupportedOperationException("No implementado");
    }
    
    Casilla(float cantidad, String nombre){
        throw new UnsupportedOperationException("No implementado");
    }
    
    Casilla(int numCasillaCarcel, String nombre){
        throw new UnsupportedOperationException("No implementado");
    }
    
    Casilla(MazoSorpresas mazo, String nombre){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public String getNombre(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    TituloPropiedad getTituloPropiedad(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void informe(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void init(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean jugadorCorrecto(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    void recibeJugador(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void recibeJugador_calle(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void recibeJugador_impuesto(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void recibeJugador_juez(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void recibeJugador_sorpresa(int iactual, Jugador[] todos){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public String toString(){
        throw new UnsupportedOperationException("No implementado");
    }
}
