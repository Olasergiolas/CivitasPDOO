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
        
        public Tablero(int i){
            
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
        
        public boolean correcto(){
            boolean correcto = false;

            if (casillas.size() > numCasillaCarcel)
                correcto = true;
            
            return correcto;
        }
        
        public boolean correcto(int n){
            boolean b = false;
            
            if (correcto() && n <= casillas.size())
                b = true;
            
            return b;
        }
        
        public int getCarcel(){
            return numCasillaCarcel;
        }
       
        
    }
    
    class Casilla{
        private String nombre;
        
        public Casilla (String n){
            nombre = n;
        }
        
        public String getNombre(){
            return nombre;
        }
    }
    
}
