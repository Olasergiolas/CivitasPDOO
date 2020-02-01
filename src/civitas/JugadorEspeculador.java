/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author ggarr
 */
public class JugadorEspeculador extends Jugador {
    private static int FactorEspeculador = 2;
    private static int CasasMax = Jugador.CasasMax*FactorEspeculador;
    private static int HotelesMax = Jugador.HotelesMax*FactorEspeculador;
    private int fianza;
    
    JugadorEspeculador(Jugador jugador, int fianza)
    {
        super(jugador);
        this.fianza = fianza;
        for (int i = 0; i < jugador.getNumPropiedades(); i++)
            jugador.getPropiedades().get(i).actualizaPropietarioPorConversion(this);
    }
    
    @Override
    public String toString(){
        String retorno = "Jugador Especulador " + getNombre() + " ¿Encarcelado?-" + encarcelado + " con saldo  " + getSaldo() + ", en la casilla " + getNumCasillaActual() + ", salvoconducto? " + tieneSalvoconducto();
        for (int i = 0; i < getPropiedades().size(); i++)
            retorno += "titulo" + i + getPropiedades().get(i).toString();
        
        return retorno;
    }
    
    @Override
    boolean pagaImpuesto(float cantidad){
        boolean retorno = false;
        if (!encarcelado)
            retorno = paga(cantidad/2f);
        return retorno;
    }
    
    @Override
    protected boolean debeSerEncarcelado(){
        boolean res = true;
        
        if (super.debeSerEncarcelado() == true){
            if (getSaldo() > fianza){
                paga(fianza);
                Diario.getInstance().ocurreEvento("El jugador especulador paga la fianza y se libra de la cárcel");
                res = false;
            }
        }
        
        else
            res = false;
        
        return res;
    }
    
    @Override
    int getCasasMax(){
        return CasasMax;
    }
    
    @Override
    int getHotelesMax(){
        return HotelesMax;
    }
}
