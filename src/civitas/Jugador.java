/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import java.util.ArrayList;

/**
 *
 * @author rullow
 */
public class Jugador implements Comparable<Jugador>{
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected boolean encarcelado;
    protected static int HotelesMax = 4;
    private String nombre;
    private int numCasillaActual;
    protected static float PasoPorSalida = 1000f;
    protected static float PrecioLibertad = 200f;
    private boolean puedeComprar;
    private float saldo;
    private float saldoInicial = 7500f;
    private ArrayList<TituloPropiedad> propiedades;
    private Sorpresa salvoconducto;
    
    Jugador(String nombre){
        propiedades = new ArrayList<TituloPropiedad>();
        this.nombre = nombre;
        encarcelado = false;
        puedeComprar = true;
        saldo = saldoInicial;
        salvoconducto = null;
    }
    
    protected Jugador(Jugador otro){
        encarcelado = otro.encarcelado;
        nombre = otro.nombre;
        numCasillaActual = otro.numCasillaActual;
        puedeComprar = otro.puedeComprar;
        saldo = otro.saldo;
        propiedades = otro.propiedades;
        salvoconducto = otro.salvoconducto;
    }
    
    boolean cancelarHipoteca(int ip){                                   //Preguntar por esto
        boolean resultado = false;
        
        if (!encarcelado && existeLaPropiedad(ip)){
            TituloPropiedad propiedad = propiedades.get(ip);
            float cantidad = propiedad.getImporteCancelarHipoteca();
            
            if (puedoGastar(cantidad))
                resultado = propiedad.cancelarHipoteca(this);        
        }
        
        if (resultado){
            Diario.getInstance().ocurreEvento("El jugador " + nombre + "cancela la hipoteca de la propiedad " + ip);
        }
        
        return resultado;
    }
    
    int cantidadCasasHoteles(){
        int suma = 0;
        for (int i = 0; i < propiedades.size(); i++)
            suma += propiedades.get(i).cantidadCasasHoteles();
        return suma;
    }
    
    public int compareTo(Jugador otro){
        int retorno = 0;
        if (saldo > otro.saldo)
            retorno = 1;
        else if (saldo < otro.saldo)
            retorno = -1;
        return retorno;
    }
    
    boolean comprar(TituloPropiedad titulo){
        boolean resultado = false;
        
        if(!encarcelado && puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if (puedoGastar(precio)){
                resultado = titulo.comprar(this);
                
                if (resultado){
                    propiedades.add(titulo);
                    Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo.toString());             
                }
                
                puedeComprar = false;
            }
        }
        
        return resultado;
    }
    
boolean construirCasa(int ip){
        boolean resultado = false;
        boolean puedoEdificarCasa = false;
        
        if (!encarcelado && existeLaPropiedad(ip)){
            TituloPropiedad propiedad = propiedades.get(ip);
            puedoEdificarCasa = puedoEdificarCasa(propiedad);
            float precio = propiedad.getPrecioEdificar();
            
            if (puedoEdificarCasa){
                resultado = propiedad.construirCasa(this);
                
                if (resultado)
                    Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye casa en la propiedad " + ip);
            }
            
            
        }
        return resultado;
    }
    
    boolean construirHotel(int ip){                                     
        boolean resultado = false;
        
        if (!encarcelado && existeLaPropiedad(ip)){
            TituloPropiedad propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            
            if (puedoEdificarHotel){
                resultado = propiedad.construirHotel(this);
                CasasPorHotel = getCasasPorHotel();
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye un hotel en la propiedad " + ip);
            }
        }
        
        return resultado;
    }
    
    protected boolean debeSerEncarcelado(){
        boolean retorno = false;
        if (!encarcelado && !tieneSalvoconducto())
            retorno = true;
        else if (!encarcelado && tieneSalvoconducto())
        {
            perderSalvoconducto();
            Diario.getInstance().ocurreEvento("El jugador " + nombre + " se libra de la cárcel.");
        }
            return retorno;
    }
    
    boolean enBancarrota(){
        boolean broke = false;
        if (saldo < 0)
            broke = true;
        return broke;
    }
    
    boolean encarcelar(int numCasillaCarcel){
        if (debeSerEncarcelado())
        {
            moverACasilla(numCasillaCarcel);
            encarcelado = true;
            Diario.getInstance().ocurreEvento("El jugador " + nombre + " es encarcelado.");
        }
        return encarcelado;
    }
    
    private boolean existeLaPropiedad(int ip){
        boolean retorno = false;
        if (ip >= 0 && ip < propiedades.size())
            retorno = true;
        return retorno;
    }
    
    private int getCasasMax(){
        return CasasMax;
    }
    
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    private int getHotelesMax(){
        return HotelesMax;
    }
    
    protected String getNombre(){
        return nombre;
    }
    
    int getNumCasillaActual(){
        return numCasillaActual;
    }
    
    private float getPrecioLibertad(){
        return PrecioLibertad;
    }
    
    private float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    protected ArrayList<TituloPropiedad> getPropiedades(){   
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    protected float getSaldo(){
        return saldo;
    }
    
    boolean hipotecar(int ip){
        boolean resultado = false;
        
        if (!encarcelado && existeLaPropiedad(ip)){
            TituloPropiedad propiedad = propiedades.get(ip);
            resultado = propiedad.hipotecar(this);
        }
        
        if (resultado)
            Diario.getInstance().ocurreEvento("El jugador " + nombre + " hipoteca la propiedad " + ip);
        
        return resultado;
    }
    
    public boolean isEncarcelado(){
        return encarcelado;
    }
    
    boolean modificarSaldo(float cantidad){
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("Se le incrementa el saldo al jugador " + nombre + " en " + cantidad + " euros.");
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        boolean retorno = false;
        if (!encarcelado)
        {
            Diario.getInstance().ocurreEvento("Se mueve al jugador " + nombre + " de la casilla " + numCasillaActual + " a la casilla " + numCasilla);
            numCasillaActual = numCasilla;
            puedeComprar = false;
            retorno = true;
        }
        return retorno;
    }
    
    boolean obtenerSalvoconducto(Sorpresa sorpresa){
        boolean retorno = false;
        if (!encarcelado)
        {
            salvoconducto = sorpresa;
            retorno = true;
        }
        return retorno;
    }
    
    boolean paga(float cantidad){
        return modificarSaldo(cantidad*-1);
    }
    
    boolean pagaAlquiler(float cantidad){
        boolean retorno = false;
        if (!encarcelado)
            retorno = paga(cantidad);
        return retorno;
    }
    
    boolean pagaImpuesto(float cantidad){
        boolean retorno = false;
        if (!encarcelado)
            retorno = paga(cantidad);
        return retorno;
    }
    
    boolean pasaPorSalida(){
        modificarSaldo(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " recibe 1000€ por pasar por salida");
        return true;
    }
    
    private void perderSalvoconducto(){
        salvoconducto.usada();
        salvoconducto = null;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        if (encarcelado)
            puedeComprar = false;
        return puedeComprar;
    }
    
    private boolean puedeSalirCarcelPagando(){
        boolean retorno = false;
        if (saldo >= PrecioLibertad)
            retorno = true;
        return retorno;
    }
    
    private boolean puedoEdificarCasa(TituloPropiedad propiedad){
        boolean retorno = false;
        float precio = propiedad.getPrecioEdificar();
        
        if (puedoGastar(precio) && propiedad.getNumCasas() < getCasasMax())
            retorno = true;
        
        return retorno;
    }
    
    private boolean puedoEdificarHotel(TituloPropiedad propiedad){
        boolean retorno = false;
        if (propiedad.getPropietario() == this && saldo >= propiedad.getPrecioEdificar() && propiedad.getNumHoteles() < 4)
            retorno = true;
        return retorno;
    }
    
    private boolean puedoGastar(float precio){
        boolean retorno = false;
        if (!encarcelado && saldo >= precio)
            retorno = true;
        return retorno;
    }
    
    boolean recibe(float cantidad){
        boolean retorno = false;
        if (!encarcelado)
        {
            modificarSaldo(cantidad);
            retorno = true;
        }
        return retorno;
    }
    
    boolean salirCarcelPagando(){
        boolean retorno = false;
        if (encarcelado && puedeSalirCarcelPagando())
        {
            paga(PrecioLibertad);
            encarcelado = false;
            Diario.getInstance().ocurreEvento("El jugador " + nombre + " sale de la cárcel pagando.");
            retorno = true;
        }
        return retorno;
    }
    
    boolean salirCarcelTirando(){
        boolean retorno = false;
        if (encarcelado && Dado.getInstance().salgoDeLaCarcel())
        {
            encarcelado = false;
            Diario.getInstance().ocurreEvento("El jugador " + nombre + " sale de la cárcel con una tirada.");
            retorno = true;
        }
        return retorno;
    }
    
    boolean tieneAlgoQueGestionar(){
        boolean retorno = false;
        if (propiedades.size() > 0)
            retorno = true;
        return retorno;
    }
    
    boolean tieneSalvoconducto(){
        boolean retorno = false;
        if (salvoconducto != null)
            retorno = true;
        return retorno;
    }
    
    public String toString(){
        String retorno = "Jugador " + nombre + " ¿Encarcelado?-" + encarcelado + " con saldo  " + saldo + ", en la casilla " + numCasillaActual;
        for (int i = 0; i < propiedades.size(); i++)
            retorno += "titulo" + i + propiedades.get(i).toString();
        
        return retorno;
    }
    
    boolean vender(int ip){
        boolean retorno = false;
        if (!encarcelado  && existeLaPropiedad(ip))
        {
            if (propiedades.get(ip).vender(this))
            {
                propiedades.remove(ip);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " vende la propiedad " + ip);
                retorno = true;
            }
        }
        return retorno;
    }
    
    public ArrayList<String> nombreToString(){
        ArrayList<String> nombres = new ArrayList<String>();
        
        for (int i = 0; i < propiedades.size(); i++){
            nombres.add(propiedades.get(i).getNombre());
        }
        
        return nombres;
    }
}
