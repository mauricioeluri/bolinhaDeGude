package bolinhadegude;

import java.util.ArrayList;

/**
 * Extensão do jogo da bolinha, utilizando o paradigma divisão e conquista.
 *
 * @author Maurício El Uri
 */
public class JogoDC extends JogoBolinha {

    public void executa() {
        ArrayList<Integer> listaOrdenada = ordenaBolinhas();
        for (int consulta : consultas) {
            int resultado = buscaBinaria(listaOrdenada, 0,
                    listaOrdenada.size() - 1, consulta);
            setaResultado(consulta, resultado);
        }
    }

    public int buscaBinaria(ArrayList<Integer> bolinhas,
            int minimo, int maximo, int consulta) {
        int meio = ((maximo + minimo) / 2);
        if (bolinhas.get(meio) == consulta) {
            return this.bolinhas.indexOf(
                    bolinhas.get(meio));
        }
        if (minimo >= maximo) {
            return -1;
        } else if (bolinhas.get(meio) < consulta) {
            return buscaBinaria(bolinhas, meio + 1, maximo, consulta);
        } else {
            return buscaBinaria(bolinhas, minimo, meio - 1, consulta);
        }
    }

    public ArrayList<Integer> ordenaBolinhas() {
        BubbleSort bs = new BubbleSort((ArrayList<Integer>) bolinhas.clone());
        bs.sort();
        return bs.getList();
    }

    private void setaResultado(int consulta, int result) {
        int[] resultado = new int[2];
        resultado[0] = consulta;
        resultado[1] = result;
        resultados.add(resultado);
    }
}
