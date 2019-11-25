package civitas;
import java.util.ArrayList;
        
        
public class Casilla {
    private String nombre;
        
    Casilla (String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    void informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre() + " ha caído en una casilla " + toString());
    }
    
    public boolean jugadorCorrecto(int iactual, ArrayList<Jugador> todos){
        boolean retorno = false;
        if (iactual >= 0 && iactual < todos.size())
            retorno = true;
        return retorno;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(iactual, todos))
            informe(iactual, todos);
    }
    
    public String toString(){
        String salida = new String();
        salida = "Descanso";
        return salida;
    }
}
