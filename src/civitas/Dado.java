/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;

/**
 *
 * @author sergio
 */
public class Dado {
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    static final private Dado instance = new Dado();
    private int SalidaCarcel = 5;
    
    private Dado(){
        //próximamente
    }
    
    static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        int resultado = 1;
        
        if (!debug)
            resultado = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        
        
        ultimoResultado = resultado;
        return ultimoResultado;
    }
    
    boolean salgoDeLaCarcel(){
        boolean sale = false;
        
        if (tirar() >= 5)
            sale = true;
                    
        return sale;
    }
    
    
    int quienEmpieza(int n){
        return (int)(Math.random() * n) ;
    }
    
    void setDebug(boolean d){
        debug = d;
        
        if (debug)
            Diario.getInstance().ocurreEvento("Modo debug Dado activado.");
                    
        else
            Diario.getInstance().ocurreEvento("Modo debug Dado desactivado.");
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
