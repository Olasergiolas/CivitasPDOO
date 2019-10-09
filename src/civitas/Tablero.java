package civitas;
import java.util.ArrayList;
/**
 *
 * @author rullow
 */
public class Tablero {
    private int numCasillaCarcel;
    private int porSalida;
    private boolean tieneJuez;
    private ArrayList<Casilla> casillas;
        
    Tablero(int i){
            
        if (i >= 1){
            numCasillaCarcel = i;
        }
            
        else{
            numCasillaCarcel = 1;
        }
        
        Casilla tempcas = new Casilla("Salida");    
        casillas = new ArrayList<Casilla>();
        casillas.add(tempcas);
            
        porSalida = 0;
        tieneJuez = false;
    }
        
    private boolean correcto(){
        boolean correcto = false;

            if (casillas.size() > numCasillaCarcel && tieneJuez)
                correcto = true;
            
            return correcto;
    }
        
    private boolean correcto(int n){
        boolean b = false;
            
        if (correcto() && n <= casillas.size())
            b = true;
            
        return b;
    }
        
    int getCarcel(){
        return numCasillaCarcel;
    }
        
    int getPorSalida()
    {
        int salida = porSalida;
        if (porSalida > 0)
        {
            porSalida--;
            salida++;
        }
        
        return salida;   
    }
        
    void aniadeCasilla (Casilla casilla)
    {
        Casilla Carcel = new Casilla("Cárcel");
        if (casillas.size() == numCasillaCarcel)
            casillas.add(Carcel);
            
        casillas.add(casilla);
            
        if (casillas.size() == numCasillaCarcel)
            casillas.add(Carcel);
    }
        
    void aniadeJuez()
    {
        Casilla Juez = new Casilla("Juez");
        if (!tieneJuez)
        {
            casillas.add(Juez);
            tieneJuez = true;
        }
    }
        
    Casilla getCasilla(int numCasilla)
    {
        Casilla auxiliar = null;
        boolean correctisimo = correcto(numCasilla);
        if (correctisimo)
            auxiliar = casillas.get(numCasilla);
        return auxiliar;
    }
        
    int NuevaPosicion(int actual, int tirada)
    {
        int desplazamiento = actual+tirada;
        if (correcto() && desplazamiento >= casillas.size())
        {
            desplazamiento %= casillas.size();
            porSalida++;
                
        }
        else if (!correcto())
            desplazamiento = -1;
        return desplazamiento;
    }
        
    int calcularTirada(int origen, int destino)
    {
        int tirada = destino - origen;
        if (tirada < 0)
            tirada += casillas.size();
            
        return tirada;
    }
}
