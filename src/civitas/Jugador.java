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
public class Jugador {
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
        throw new UnsupportedOperationException("No implementado");
    }
    
    protected Jugador(Jugador otro){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean cancelarHipoteca(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    int cantidadCasasHoteles(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public int compareTo(Jugador otro){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean comprar(TituloPropiedad titulo){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean construirCasa(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean construirHotel(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    protected boolean debeSerEncarcelado(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean enBancarrota(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean encarcelar(int numCasillaCarcel){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private boolean existeLaPropiedad(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private int getCasasMax(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    int getCasasPorHotel(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private int getHotelesMax(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    protected String getNombre(){
        return nombre;
    }
    
    int getNumCasillaActual(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private float getPrecioLibertad(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private float getPremioPasoSalida(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    protected TituloPropiedad[] getPropiedades(){   
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean getPuedeComprar(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    protected float getSaldo(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean hipotecar(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public boolean isEncarcelado(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean modificarSaldo(float cantidad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean moverACasilla(int numCasilla){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean obtenerSalvoconducto(Sorpresa sorpresa){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean paga(float cantidad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean pagaAlquiler(float cantidad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean pagaImpuesto(float cantidad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean pasaPorSalida(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void perderSalvoconducto(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean puedeComprarCasilla(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private boolean puedeSalirCarcelPagando(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private boolean puedoEdificarCasa(TituloPropiedad propiedad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private boolean puedoEdificarHotel(TituloPropiedad propiedad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    private boolean puedoGastar(float precio){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean recibe(float cantidad){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean salirCarcelPagando(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean salirCarcelTirando(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean tieneAlgoQueGestionar(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean tieneSalvoconducto(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    public String toString(){
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean vender(int ip){
        throw new UnsupportedOperationException("No implementado");
    }
}
