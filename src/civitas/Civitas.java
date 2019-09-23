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
public class Civitas {

    enum TipoCasilla{
        CALLE, SORPRESA, JUEZ, IMPUESTO, DESCANSO
    }
    
    enum TipoSorpresa{
        IRCARCEL, IRCASILLA, PAGARCOBRAR, PORCASAHOTEL, PORJUGADOR, SALIRCARCEL
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    class Tablero{
        
        private int numCasillaCarcel;
        private int porSalida;
        private boolean tieneJuez;
        private ArrayList<Casilla> casillas;
        private Casilla tempcas = new Casilla("Salida");
        
        Tablero(int i){
            
            if (i >= 1){
                numCasillaCarcel = i;
            }
            
            else{
                numCasillaCarcel = 1;
            }
            
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
        
        void añadeCasilla (Casilla casilla)
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
    
    class Casilla{
        private String nombre;
        
        Casilla (String n){
            nombre = n;
        }
        
        String getNombre(){
            return nombre;
        }
    }
}
//this is the pilot speaking
//we seem to be in the middle of a bruh moment right now