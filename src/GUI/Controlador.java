/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.CivitasJuego;
import civitas.GestionesInmobiliarias;
import civitas.OperacionInmobiliaria;
import civitas.OperacionesJuego;
import civitas.SalidasCarcel;
import java.util.ArrayList;
import civitas.Jugador;

/**
 *
 * @author sergio
 */
public class Controlador {
    private CivitasJuego juego;
    private CivitasView vista;
    
    public Controlador(CivitasJuego juego, CivitasView vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    /*void juega(){
        vista.setCivitasJuego(juego);
        
        while (!juego.finalDelJuego()){
            vista.actualizarVista();
            vista.pausa();
            OperacionesJuego operacion = juego.siguientePaso();
            if (operacion != OperacionesJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }
            
            if (!juego.finalDelJuego()){
                if (operacion == OperacionesJuego.COMPRAR){
                    if (vista.comprar() == Respuestas.SI){
                        juego.comprar();
                    }
                    
                    juego.siguientePasoCompletado(operacion);
                }
                
                else if(operacion == OperacionesJuego.GESTIONAR){
                    vista.gestionar();
                    GestionesInmobiliarias gestion = GestionesInmobiliarias.values()[vista.getGestion()];
                    int indice = vista.getPropiedad();
                    OperacionInmobiliaria opIn = new OperacionInmobiliaria(gestion, indice);
                    
                    if (gestion == GestionesInmobiliarias.CANCELAR_HIPOTECA)
                        juego.cancelarHipoteca(indice);
                    
                    else if (gestion == GestionesInmobiliarias.CONSTRUIR_CASA)
                        juego.construirCasa(indice);
                    
                    else if (gestion == GestionesInmobiliarias.CONSTRUIR_HOTEL)
                        juego.construirHotel(indice);
                    
                    else if (gestion == GestionesInmobiliarias.HIPOTECAR)
                        juego.hipotecar(indice);
                    
                    else if (gestion == GestionesInmobiliarias.VENDER)
                        juego.vender(indice);
                    
                    else
                        juego.siguientePasoCompletado(operacion);
                }
                
                else if (operacion == OperacionesJuego.SALIR_CARCEL){
                    SalidasCarcel eleccion = vista.salirCarcel();
                    
                    if (eleccion == SalidasCarcel.PAGANDO)
                        juego.salirCarcelPagando();
                    
                    else
                        juego.salirCarcelTirando();
                    
                    juego.siguientePasoCompletado(operacion);
                }
            }
        }
        
        ArrayList<Jugador> ranking = juego.ranking();
        
        for (int i = 0; i < ranking.size(); i++){
            ranking.get(i).toString();
        }
    }*/
}
