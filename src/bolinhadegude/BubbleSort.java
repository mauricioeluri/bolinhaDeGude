package bolinhadegude;

import java.util.ArrayList;

/**
 * Algorítmo de busca Bubble Sort, este algoritmo ordena listas de inteiros
 *
 * @author Maurício El Uri
 */
public class BubbleSort {

    ArrayList<Integer> list = new ArrayList<>();

    public BubbleSort(ArrayList<Integer> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        this.list = list;
    }

    protected void trocaValoresList(int index1, int index2) {
        int temporario = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temporario);
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void sort() {
        for (int count = list.size(); count > 1; count--) {
            moveMaiorValorParaOFinal(count);
        }
    }

    private void moveMaiorValorParaOFinal(int tamFinal) {
        for (int index = 1; index < tamFinal; index++) {
            if (list.get(index) < list.get(index - 1)) {
                trocaValoresList(index, index - 1);
            }
        }
    }
}
