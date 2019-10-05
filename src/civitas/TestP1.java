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
public class TestP1 {
    
    void test(){
        int[] jugador = new int[4];
        Dado D = Dado.getInstance();
        for (int i = 0; i < 100; i++)
        {
            jugador[D.quienEmpieza(4)]++;
        }
        for (int i = 0; i < 4; i++)
            System.out.println(jugador[i] + " jugador " + i);
        System.out.println("\n\n");
        
        D.setDebug(true);
        for (int i = 0; i < 3; i++)
            System.out.println(D.tirar() + " tirada debug.");
        
        D.setDebug(false);
        D.tirar();
        if (D.salgoDeLaCarcel())
        {
            System.out.println("\n" + D.getUltimoResultado() + " - Tirada para salir de la cárcel");
            System.out.println("Yoshi paga la fianza y sale de la cárcel.");
        }
        else
        {
            System.out.println("\n" + D.getUltimoResultado() + " - Tirada para salir de la cárcel");
            System.out.println("A Yoshi se le deniega la fianza y se queda en prisión.");
        }
        
        MazoSorpresas mazoPrueba = new MazoSorpresas();
        Sorpresa uno = new Sorpresa();
        Sorpresa dos = new Sorpresa();
        mazoPrueba.alMazo(uno);
        mazoPrueba.alMazo(dos);
        mazoPrueba.inhabilitarCartaEspecial(dos);
        mazoPrueba.habilitarCartaEspecial(dos);
        
        Diario Di = Diario.getInstance();
        System.out.println("\n");
        while(Di.eventosPendientes())
            System.out.println(Di.leerEvento());
        System.out.println("\n");
        
        Tablero tableroPrueba = new Tablero(4);
        Casilla Recogidas = new Casilla("Recogidas");
        Casilla Pedro = new Casilla("Pedro Antonio");
        Casilla Ness = new Casilla("Ness");
        tableroPrueba.aniadeCasilla(Pedro);
        tableroPrueba.aniadeCasilla(Recogidas);
        tableroPrueba.aniadeJuez();
        tableroPrueba.aniadeCasilla(Ness);
        int anterior = 0, tiradat;
        for (int i = 0; i < 2; i++)
        {
            tiradat = D.tirar();
            System.out.println(tiradat + " tirada nº" + i);
            anterior = tableroPrueba.NuevaPosicion(anterior,tiradat);
            System.out.println(anterior + " nueva posicion nº" + i);
        }
    }
    
    public static void main(String[] args)
    {
        TestP1 Jugador = new TestP1();
        
        Jugador.test();
    }
}
