package civitas;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rullow
 */
public class Diario
{
    static final private Diario instance = new Diario();
    private ArrayList<String> eventos;
        
    private Diario()
    {
        eventos = new ArrayList<>();
    }
        
    static public Diario getInstance()
    {
        return instance;
    }
}
