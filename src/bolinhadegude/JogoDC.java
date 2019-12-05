package bolinhadegude;

import java.util.ArrayList;

/**
 * Extensão do jogo da bolinha, utilizando o paradigma divisão e conquista.
 *
 * @author Maurício El Uri
 */
public class JogoDC extends JogoBolinha {

    /**
     * Função que executa a busca utilizando o método divisão e conquista
     * Primeiramente, criamos uma cópia da lista de bolinhas, e 
     * então, a ordenamos.
     * Logo, para cada consulta, fazemos uma busca binária
     * na lista.
     */
    public void executa() {
        ArrayList<Integer> listaOrdenada = ordenaBolinhas();
        for (int consulta : getConsultas()) {
            int resultado = buscaBinaria(listaOrdenada, 0,
                    listaOrdenada.size() - 1, consulta);
            setaResultado(consulta, resultado);
        }
    }
    
    /**
     * Função que ordena a lista de bolinhas, utiliza o paradigma BubbleSort 
     * para efetuar a ordenação.
     * @return bolinhasOrdenado
     */
    private ArrayList<Integer> ordenaBolinhas() {
        MergeSort ms = new MergeSort((ArrayList<Integer>) getBolinhas().clone());
        ms.sort();
        return ms.getList();
    }

    /**
     * A função buscaBinária é uma função recursiva, a qual recebe como
     * parâmetros uma lista ordenada, o valor mínimo máximo da lista, e o
     * valor que está sendo consultado.
     * Esta função verifica se o valor selecionado está no meio da lista,
     * caso não esteja, ela quebra a lista em 2, chamando novamente esta
     * função.
     * Caso o valor selecionado não seja encontrado, é retornado o valor -1
     * @param bolinhas
     * @param minimo
     * @param maximo
     * @param consulta
     * @return resultado
     */
    private int buscaBinaria(ArrayList<Integer> bolinhas,
            int minimo, int maximo, int consulta) {
        int meio = ((maximo + minimo) / 2);
        if (bolinhas.get(meio) == consulta) {
            return getBolinhas().indexOf(
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
}
