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
    private static float factorInteresesHipoteca = 1.1f;
    private float factorRevalorizacion;
    private float hipotecaBase;
    private boolean hipotecado;
    private String nombre;
    private int numCasas;
    private int numHoteles;
    private float precioCompra;
    private float precioEdificar;
    private Jugador propietario;
 
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
        boolean retorno = false;
        if (propietario != null)
            retorno = propietario.encarcelado;
        return retorno;
    }
    
    float getImporteCancelarHipoteca(){
        return (hipotecaBase*(1+numCasas*0.5f+numHoteles*2.5f)*factorInteresesHipoteca);
    }
    
    void actualizaPropietarioPorConversion(Jugador jugador){
        propietario = jugador; // supongo que es así ???
    }
    
    boolean cancelarHipoteca(Jugador jugador){
        boolean realizado = false;
        if (hipotecado && jugador == propietario && jugador.getSaldo() >= getImporteCancelarHipoteca())
        {
            hipotecado = false;
            realizado = true;
        }
        return realizado;
    }
    
    int cantidadCasasHoteles(){
        return (numCasas+numHoteles);
    }
    
    boolean comprar(Jugador jugador){
        boolean realizado = false;
        if (propietario == null && jugador.getSaldo() >= precioCompra)
        {
            jugador.paga(precioCompra);
            propietario = jugador;
            realizado = true;
        }
        return realizado;
    }
    
    boolean construirCasa(Jugador jugador){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean construirHotel(Jugador jugador){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean derruirCasas(int n, Jugador jugador){
        boolean retorno = false;
        if (jugador == propietario && numCasas >= n)
        {
            numCasas -= n;
            retorno = true;
        }
        return retorno;
    }
    
    private boolean esEsteElPropietario(Jugador jugador){
        boolean retorno = false;
        if (jugador == propietario)
            retorno = true;
        return retorno;
    }
    
    public boolean getHipotecado(){
        return hipotecado;
    }
    
    private float getImporteHipoteca(){
        return (hipotecaBase*(1+numCasas*0.5f+numHoteles*2.5f));
    }
    
    String getNombre(){
        return nombre;
    }
    
    int getNumCasas(){
        return numCasas;
    }
    
    int getNumHoteles(){
        return numHoteles;
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
    private float getPrecioVenta(){
        return (precioCompra+numCasas+5*numHoteles+precioEdificar*factorRevalorizacion);
    }
    
    Jugador getPropietario(){
        return propietario;
    }
    
    boolean hipotecar(Jugador jugador){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean tienePropietario(){
        boolean retorno = false;
        if (propietario != null)
            retorno = true;
        return retorno;
    }
    
    void tramitarAlquiler(Jugador jugador){
        if (propietario != null && jugador != propietario)
        {
            jugador.pagaAlquiler(getPrecioAlquiler());
            propietario.recibe(getPrecioAlquiler());
        }
    }
    
    boolean vender(Jugador jugador){
        boolean retorno = false;
        if (jugador == propietario && !hipotecado)
        {
            propietario.recibe(getPrecioVenta());
            propietario = null;
            retorno = true;
        }
        return retorno;
    }
}