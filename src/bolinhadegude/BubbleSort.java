package bolinhadegude;

import java.util.ArrayList;

/**
 * Algorítmo de busca Bubble Sort, este algoritmo ordena listas de inteiros
 * e ordena um ArrayList em orientação crescente.
 *
 * @author Maurício El Uri
 */
public class BubbleSort {

    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * Construtor da classe BubbleSort
     * 
     * @param list 
     * Recebe a lista que será ordenada
     */
    public BubbleSort(ArrayList<Integer> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        this.list = list;
    }

    /**
     * Método utilizado para trocar dois valores de lugar na lista
     * @param index1
     * @param index2
     * Recebe os indentificadores dos dois valores da lista
     */
    private void trocaValoresList(int index1, int index2) {
        int temporario = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temporario);
    }

    /**
     * Método utilizado para retornar a lista
     * @return list
     */
    public ArrayList<Integer> getList() {
        return list;
    }

    /**
     * Método que ordena a lista de forma crescente.
     * Vai varrendo a lista de trás pra frente, e chamando o método
     * que testa o valor até encontrar o maior e o move para o final da lista.
     */
    public void sort() {
        for (int count = list.size(); count > 1; count--) {
            moveMaiorValorParaOFinal(count);
        }
    }

    /**
     * Este método recebe o valor atual que a formatação da lista está,
     * e vai ordenando-a, encontrando o maior valor (até a posição máxima
     * recebida, e move-o para a última posição.
     * @param tamFinal 
     */
    private void moveMaiorValorParaOFinal(int tamFinal) {
        for (int index = 1; index < tamFinal; index++) {
            if (list.get(index) < list.get(index - 1)) {
                trocaValoresList(index, index - 1);
            }
        }
    }
}
