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
    
    TituloPropiedad()
    {
        propietario = null;
        alquilerBase = 0;
        factorInteresesHipoteca = 0;
        factorRevalorizacion = 0;
        hipotecaBase = 0;
        hipotecado = false;
        nombre = "";
        numCasas = 0;
        numHoteles = 0;
        precioCompra = 0;
        precioEdificar = 0;
    }
 
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
        return (nombre + " " + numCasas + " " + numHoteles + " Hipotecado: " + hipotecado);
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
        if (hipotecado && esEsteElPropietario(jugador) && jugador.getSaldo() >= getImporteCancelarHipoteca())
        {
            propietario.paga(getImporteCancelarHipoteca());
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
        if (!tienePropietario() && jugador.getSaldo() >= precioCompra)
        {
            jugador.paga(precioCompra);
            propietario = jugador;
            realizado = true;
        }
        return realizado;
    }
    
    boolean construirCasa(Jugador jugador){
        boolean resultado = false;
        
        if (esEsteElPropietario(jugador)){
            propietario.paga(precioEdificar);
            numCasas++;
            resultado = true;
        }
        
        return resultado;
    }
    
    boolean construirHotel(Jugador jugador){
        boolean resultado = false;
        
        if (esEsteElPropietario(jugador)){
            propietario.paga(precioEdificar);
            numHoteles++;
            resultado = true;
        }
        
        return resultado;
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
    
    public String getNombre(){
        return nombre;
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
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
        boolean salida = false;
        
        if (!hipotecado && esEsteElPropietario(jugador)){
            propietario.recibe(getImporteHipoteca());
            salida = true;
            hipotecado = true;
        }
        
        return salida;
    }
    
    boolean tienePropietario(){
        boolean retorno = false;
        if (propietario != null)
            retorno = true;
        return retorno;
    }
    
    void tramitarAlquiler(Jugador jugador){
        if (tienePropietario() && !esEsteElPropietario(jugador))
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