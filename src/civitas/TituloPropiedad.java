/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author rullow
 */
public class TituloPropiedad {
    private float alquilerBase;
    private float factorInteresesHipoteca = 1.1f;
    private float factorRevalorizacion;
    private float hipotecaBase;
    private boolean hipotecado;
    private String nombre;
    private int numCasas;
    private int numHoteles;
    private float precioCompra;
    private float precioEdificar;
    
 
    TituloPropiedad(String nom, float ab, float fr, float hb, float pc, float pe)
    {
        nombre = nom;
        alquilerBase = ab;
        factorRevalorizacion = fr;
        hipotecaBase = hb;
        precioCompra = pc;
        precioEdificar = pe;
        numCasas = 0;
        numHoteles = 0;
        hipotecado = false;
    }
    
    public String toString()
    {
        return (nombre + " aB" + alquilerBase + " fI" + factorInteresesHipoteca + " fR" + factorRevalorizacion + 
                " hB" + hipotecaBase + " h" + " " + hipotecado + " nC" + numCasas + " nH" + numHoteles + " pC" + precioCompra
                + " pE" + precioEdificar);
    }
    
    private float getPrecioAlquiler()
    {
        float precio = alquilerBase*(1+numCasas*0.5f+numHoteles*2.5f);
        if (hipotecado || propietarioEncarcelado())
            precio = 0;
        return precio;
    }
    
    private boolean propietarioEncarcelado()
    {
        return false;
    }
}