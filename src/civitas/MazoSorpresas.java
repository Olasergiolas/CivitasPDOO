/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sergio
 */
public class MazoSorpresas {
    
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    private ArrayList<Sorpresa> cartasEspeciales;
    private Sorpresa ultimaSorpresa;
    
    MazoSorpresas(boolean d){
        debug = d;
        
        init();
        if (debug)
            Diario.getInstance().ocurreEvento("Debug MazoSorpresas activado");
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    private void init(){
        sorpresas = new ArrayList<Sorpresa>();
        cartasEspeciales = new ArrayList<Sorpresa>();
        barajada = false;
        usadas = 0;
    }
    
    void alMazo(Sorpresa s){
        if (!barajada){
            sorpresas.add(s);
        }
            
    }
    
    Sorpresa siguiente(){
        
        if (!barajada || usadas == sorpresas.size()){
            if (!debug)
                Collections.shuffle(sorpresas);
            
            
            usadas = 0;
            barajada = true;
        }
        
        usadas++;
        ultimaSorpresa = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(ultimaSorpresa);
        
        return ultimaSorpresa;
    }
    
    void inhabilitarCartaEspecial(Sorpresa sorpresa){
        if (sorpresas.contains(sorpresa)){
                sorpresas.remove(sorpresa);             //Debería funcionar?¿?¿
                cartasEspeciales.add(sorpresa);
                Diario.getInstance().ocurreEvento("Carta especial en el mazo inhabilitada");
        }                  
    }
    
    void habilitarCartaEspecial(Sorpresa sorpresa){
        if (cartasEspeciales.contains(sorpresa)){
            cartasEspeciales.remove(sorpresa);
            sorpresas.add(sorpresa);
            Diario.getInstance().ocurreEvento("Carta especial habilitada");
        }
    }
    
}
