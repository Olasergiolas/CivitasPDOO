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
    public static void main(String[] args)
    {
        int jugador0 = 0, jugador1 = 0, jugador2 = 0, jugador3 = 0, indice;
        Dado D = Dado.getInstance();
        for (int i = 0; i < 100; i++)
        {
            indice = D.quienEmpieza(4);
            switch (indice) {
                case 0:
                    jugador0++;
                    break;
                case 1:
                    jugador1++;
                    break;
                case 2:
                    jugador2++;
                    break;
                case 3:
                    jugador3++;
                    break;
            }
        }
        System.out.println(jugador0 + " " + jugador1 + " " + jugador2 + " " + jugador3 + "\n\n");
        
        D.setDebug(true);
        for (int i = 0; i < 3; i++)
            System.out.println(D.tirar() + " tirada debug.");
        
        D.setDebug(false);
        D.tirar();
        System.out.println("\n" + D.getUltimoResultado() + " - Tirada para salir de la cárcel");
        if (D.salgoDeLaCarcel())
            System.out.println("Yoshi paga la fianza y sale de la cárcel.");
        else
            System.out.println("A Yoshi se le deniega la fianza y se queda en prisión.");
        
        MazoSorpresas mazoPrueba = new MazoSorpresas();
        Sorpresa uno = new Sorpresa();
        Sorpresa dos = new Sorpresa();
        mazoPrueba.alMazo(uno);
        mazoPrueba.alMazo(dos);
        mazoPrueba.inhabilitarCartaEspecial(dos);
        mazoPrueba.habilitarCartaEspecial(dos);
        
        Diario Di = Diario.getInstance();
        System.out.println("\n" + Di.eventosPendientes() + "\n");
        System.out.println(Di.leerEvento());
        System.out.println(Di.leerEvento());
        System.out.println(Di.leerEvento());
        System.out.println(Di.leerEvento());
        System.out.println(Di.leerEvento());
        System.out.println(Di.eventosPendientes() + "\n");
        
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
}

//isadiasidakjtoi
