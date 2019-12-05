package bolinhadegude;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Algoritmo de busca MergeSort. Este algoritmo ordena listas de números
 * inteiros de maneira crescente.
 *
 * @author Maurício El Uri
 */
public class MergeSort {

    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * Construtor da classe MergeSort
     *
     * @param list Recebe a lista que será ordenada. Caso receba uma lista nula
     * retorna um NullPointerException.
     */
    public MergeSort(ArrayList<Integer> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        this.list = list;
    }

    /**
     * Método utilizado para trocar dois valores de lugar na lista
     *
     * @param index1
     * @param index2 Recebe os indentificadores dos dois valores da lista
     */
    private void trocaValoresList(int index1, int index2) {
        int temporario = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temporario);
    }

    /**
     * Método utilizado para retornar a lista
     *
     * @return list
     */
    public ArrayList<Integer> getList() {
        return list;
    }

    /**
     * Método principal da classe, ele que confere se a lista está vazia e é
     * responsável por fazer a primeira chamada ao mergeSort
     */
    public void sort() {
        if (!list.isEmpty()) {
            list = mergeSort(0, list.size() - 1);
        }
    }

    /**
     * MergeSort - este método recebe dois valores inteiros, o valor do extremo
     * esquerdo da lista e o valor do extremo direito da lista. Ele vai fazendo
     * chamadas recursivas dele mesmo, dividindo a lista em 2, até que receba um
     * valor de esquerda e direita igual. Ou seja, apenas um elemento - e quando
     * isto acontece, esta função devolve uma lista contendo o elemento
     * selecionado. Depois de fazer duas chamadas recursivas dele mesmo,
     * dividindo a lista entre estas chamadas, ele chama o método merge,
     * passando estas duas listas como parâmetro, o qual devolve uma lista que é
     * a junção destas duas listas e de forma ordenada.
     *
     * @param esq
     * @param dir
     * @return
     */
    private ArrayList<Integer> mergeSort(int esq, int dir) {
        if (esq != dir) {
            int meio = ((esq + dir) / 2);
            ArrayList<Integer> listEsq;
            ArrayList<Integer> listDir;
            listEsq = mergeSort(esq, meio);
            listDir = mergeSort(meio + 1, dir);
            return merge(listEsq, listDir);
        }
        ArrayList<Integer> listOrdenada = new ArrayList<>();
        listOrdenada.add(list.get(esq));
        return listOrdenada;
    }

    /**
     * O método merge Em resumo, este método recebe duas listas e é responsável
     * por devolver uma lista que é a junção destas duas listas, porém de forma
     * ordenada.
     *
     * Foi utilizada a interface ListIterator do java, para facilitar o trabalho
     * e obtermos um código mais limpo, pois através dela podemos verificar se
     * existe um próximo elemento em cada lista e podemos navegar de maneira
     * mais clara.
     *
     * Primeiro, enquanto tivermos elementos em AMBAS as listas, comparamos os
     * dois elementos e vamos o inserindo na lista. É importante ressaltar que
     * voltamos o elemento que não foi alterado 1 posição no iterator. Após
     * alguma das listas estar sem elementos, inserimos todos os itens que
     * restam da outra lista, levando em consideração que as sub-listas já vem
     * ordenadas.
     *
     * Por fim, retornamos a lista ordenada.
     *
     * @param listEsq
     * @param listDir
     * @return listaOrdenada
     */
    private ArrayList<Integer> merge(ArrayList<Integer> listEsq,
            ArrayList<Integer> listDir) {

        ArrayList<Integer> listOrdenada = new ArrayList<>();
        ListIterator itrEsq = listEsq.listIterator();
        ListIterator itrDir = listDir.listIterator();

        while (itrEsq.hasNext() && itrDir.hasNext()) {
            int itemEsq = (int) itrEsq.next();
            int itemDir = (int) itrDir.next();
            if (itemEsq > itemDir) {
                listOrdenada.add(itemDir);
                itrEsq.previous();
            } else {
                listOrdenada.add(itemEsq);
                itrDir.previous();
            }
        }
        while (itrEsq.hasNext()) {
            listOrdenada.add((int) itrEsq.next());
        }
        while (itrDir.hasNext()) {
            listOrdenada.add((int) itrDir.next());
        }
        return listOrdenada;
    }
}
