package bolinhadegude;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes sobre o algorítmo do jogo da bolinha Divisão e Conquista.
 *
 * @author mauricio
 */
public class JogoDCTest {

    JogoDC jogo;

    public JogoDCTest() {
        jogo = new JogoDC();
        jogo.setBolinha(3);
        jogo.setBolinha(2);
        jogo.setBolinha(4);
        jogo.setBolinha(1);
    }

    @Test
    public void testListaDesordenada() {
        jogo.executa();
        assertEquals(0, jogo.bolinhas.indexOf(3));
        assertEquals(1, jogo.bolinhas.indexOf(2));
        assertEquals(2, jogo.bolinhas.indexOf(4));
        assertEquals(3, jogo.bolinhas.indexOf(1));
    }

    @Test
    public void testResultado() {
        jogo.setConsulta(3);
        int[] resultado1 = new int[]{3, 0};
        jogo.executa();
        assertArrayEquals(resultado1, jogo.getResultados().get(0));
    }

    @Test
    public void testResultado2() {
        jogo.setConsulta(3);
        jogo.setConsulta(5);
        jogo.executa();
        int[] resultado1 = new int[]{3, 0};
        int[] resultado2 = new int[]{5, -1};
        assertArrayEquals(resultado1, jogo.getResultados().get(0));
        assertArrayEquals(resultado2, jogo.getResultados().get(1));
    }

    @Test
    public void testResultado3() {
        jogo.setBolinha(5);
        jogo.setConsulta(3);
        jogo.setConsulta(5);
        jogo.executa();
        int[] resultado1 = new int[]{3, 0};
        int[] resultado2 = new int[]{5, 4};
        assertArrayEquals(resultado1, jogo.getResultados().get(0));
        assertArrayEquals(resultado2, jogo.getResultados().get(1));

    }

    @Test
    public void testResultado4() {
        jogo.setBolinha(5);
        jogo.setBolinha(21);
        jogo.setBolinha(14);
        jogo.setBolinha(9);
        jogo.setBolinha(5);
        jogo.setConsulta(3);
        jogo.setConsulta(14);
        jogo.setConsulta(5);
        jogo.setConsulta(8);
        jogo.setConsulta(12);
        jogo.setConsulta(5);
        jogo.executa();

        int[] resultado1 = new int[]{3, 0};
        int[] resultado2 = new int[]{14, 6};
        int[] resultado3 = new int[]{5, 4};
        int[] resultado4 = new int[]{8, -1};
        int[] resultado5 = new int[]{12, -1};
        int[] resultado6 = new int[]{5, 4};

        assertArrayEquals(resultado1, jogo.getResultados().get(0));
        assertArrayEquals(resultado2, jogo.getResultados().get(1));
        assertArrayEquals(resultado3, jogo.getResultados().get(2));
        assertArrayEquals(resultado4, jogo.getResultados().get(3));
        assertArrayEquals(resultado5, jogo.getResultados().get(4));
        assertArrayEquals(resultado6, jogo.getResultados().get(5));
    }

    @Test
    public void testAleatorio() {
        ArrayList<Integer> listaOrdenada = new ArrayList<>();
        ArrayList<Integer> lista10Ordenada = new ArrayList<>();

        listaOrdenada.add(10);
        listaOrdenada.add(20);
        lista10Ordenada.add(20);
        lista10Ordenada.add(10);

        //resposta desejada 10 & 0
        assertEquals(10, lista10Ordenada.get(1).intValue());
        assertEquals(0, listaOrdenada.indexOf(lista10Ordenada.get(1)));
    }

    public void testSimples() {
        jogo.setConsulta(1);
        jogo.setConsulta(2);
        jogo.setConsulta(3);
        jogo.setConsulta(4);
        jogo.executa();
        // 3 encontrado em 0
        // 2 encontrado em 1
        // 4 encontrado em 2
        // 1 encontrado em 3
        int[] resultado1 = new int[]{3, 0};
        int[] resultado2 = new int[]{2, 1};
        int[] resultado3 = new int[]{4, 2};
        int[] resultado4 = new int[]{1, 3};
        int[] resultado5 = new int[]{5, -1};

        assertArrayEquals(resultado1, jogo.getResultados().get(0));
        assertArrayEquals(resultado2, jogo.getResultados().get(1));
        assertArrayEquals(resultado3, jogo.getResultados().get(2));
        assertArrayEquals(resultado4, jogo.getResultados().get(3));
        assertArrayEquals(resultado5, jogo.getResultados().get(4));
    }
}
