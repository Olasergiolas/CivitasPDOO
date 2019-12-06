/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import GUI.*;

public class TestP5 {
    
    public static void test(){
        CivitasView vista = new CivitasView();
        Dado.createInstance(vista);
    }
    
    public static void main(String[] args)
    {
        TestP5 Jugador = new TestP5();
        
        Jugador.test();
    }
}
