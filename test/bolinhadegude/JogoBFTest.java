package bolinhadegude;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes sobre o jogo da bolinha em brute force
 *
 * @author Maurício El Uri
 */
public class JogoBFTest {

    ArrayList<Integer> consultas;
    ArrayList<Integer> bolinhas;
    JogoBF jogo;

    public JogoBFTest() {
        jogo = new JogoBF();
        jogo.setBolinha(1);
        jogo.setBolinha(2);
        jogo.setBolinha(3);
        jogo.setBolinha(4);
        jogo.setBolinha(5);
    }

    @Test
    public void test1Entrada() {
        jogo.setConsulta(2);
        jogo.executa();
        int[] resultado1 = new int[]{2, 1};
        assertArrayEquals(resultado1, jogo.getResultados().get(0));
    }

    @Test
    public void test2Entradas() {
        jogo.setConsulta(6);
        jogo.setConsulta(1);
        jogo.executa();
        int[] resultado1 = new int[]{6, -1};
        int[] resultado2 = new int[]{1, 0};
        assertArrayEquals(resultado1, jogo.getResultados().get(0));
        assertArrayEquals(resultado2, jogo.getResultados().get(1));
    }

    @Test
    public void testRetornoTextual() {
        jogo.setConsulta(2);
        jogo.executa();
        String resultado = "2 encontrado em 2\n";
        assertEquals(resultado, jogo.getResultadosTxt());
    }

    @Test
    public void testRetornoTextual2() {
        jogo.setConsulta(6);
        jogo.setConsulta(1);
        jogo.executa();
        String resultado = "6 não encontrado\n1 encontrado em 1\n";
        assertEquals(resultado, jogo.getResultadosTxt());
    }
}
