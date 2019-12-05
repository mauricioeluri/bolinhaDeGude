package bolinhadegude;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes sobre o algorítmo de ordenação Merge Sort.
 *
 * @author Maurício El Uri
 */
public class MergeSortTest {

    MergeSort ms;
    ArrayList<Integer> list = new ArrayList<>();

    public MergeSortTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testaListNull() {
        ms = new MergeSort(null);
    }
    
//    TESTES DO MÉTODO PRIVATO MERGE
//    PARA TESTAR, MUDAR PARA PÚBLICO OU UTILIZAR REFLECTION
//
//    @Test
//    public void testMerge() {
//        list.add(10);
//        list.add(20);
//        ms = new MergeSort(list);
//        assertEquals(list, ms.merge(0, 1));
//    }
//    
//    
//    @Test
//    public void testMerge() {
//        ArrayList<Integer> listEsq = new ArrayList<>();
//        ArrayList<Integer> listDir = new ArrayList<>();
//        listEsq.add(1);
//        listEsq.add(4);
//        listDir.add(2);
//        listDir.add(3);
//        listDir.add(5);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        ms = new MergeSort(list);
//        assertEquals(list, ms.merge(listEsq, listDir));
//    }
//    
//    @Test
//    public void testMerge2Elem() {
//        ArrayList<Integer> listEsq = new ArrayList<>();
//        ArrayList<Integer> listDir = new ArrayList<>();
//        listEsq.add(1);
//        listDir.add(2);
//        list.add(1);
//        list.add(2);
//        ms = new MergeSort(list);
//        assertEquals(list, ms.merge(listEsq, listDir));
//    }
//    
//    @Test
//    public void testMerge2ElemDes() {
//        ArrayList<Integer> listEsq = new ArrayList<>();
//        ArrayList<Integer> listDir = new ArrayList<>();
//        listEsq.add(2);
//        listDir.add(1);
//        list.add(1);
//        list.add(2);
//        ms = new MergeSort(list);
//        ArrayList<Integer> resultado = ms.merge(listEsq, listDir);
//        assertEquals(list, resultado);
//    }

    @Test
    public void ListVazio() {
        ms = new MergeSort(new ArrayList<>());
        ms.sort();
        assertEquals(new ArrayList<>(), ms.getList());
    }

    @Test
    public void list1Elemento() {
        list.add(10);
        ms = new MergeSort(list);
        ms.sort();
        assertEquals(list, ms.getList());
    }

    @Test
    public void listJaOrdenado() {
        list.add(10);
        list.add(100);
        ms = new MergeSort(list);
        ms.sort();
        assertEquals(list, ms.getList());
    }

    @Test
    public void array2ElemDesordenado() {
        list.add(10);
        list.add(100);
        ms = new MergeSort(list);
        ms.sort();
        assertEquals(10, ms.getList().get(0).intValue());
        assertEquals(100, ms.getList().get(1).intValue());
    }

    @Test
    public void testaMaiorNoFinal() {
        list.add(100);
        list.add(10);
        list.add(200);
        list.add(30);
        list.add(50);
        ms = new MergeSort(list);
        ms.sort();
        assertEquals(200, ms.getList().get(4).intValue());
    }

    @Test
    public void testOrdenacao() {
        list.add(100);
        list.add(10);
        list.add(200);
        list.add(30);
        list.add(50);
        ArrayList<Integer> listFinal = new ArrayList<>();
        listFinal.add(10);
        listFinal.add(30);
        listFinal.add(50);
        listFinal.add(100);
        listFinal.add(200);
        ms = new MergeSort(list);
        ms.sort();
        assertEquals(listFinal, ms.getList());
    }

    @Test
    public void testOrdenacao2() {
        list.add(10);
        list.add(200);
        list.add(30);
        list.add(25);
        list.add(70);
        list.add(30);
        list.add(7);
        list.add(27);
        ArrayList<Integer> listFinal = new ArrayList<>();
        listFinal.add(7);
        listFinal.add(10);
        listFinal.add(25);
        listFinal.add(27);
        listFinal.add(30);
        listFinal.add(30);
        listFinal.add(70);
        listFinal.add(200);
        ms = new MergeSort(list);
        ms.sort();
        assertEquals(listFinal, ms.getList());
    }

    @Test
    public void mantemListaOriginal() {
        list.add(10);
        list.add(30);
        list.add(20);
        ms = new MergeSort((ArrayList<Integer>) list.clone());
        ms.sort();
        assertEquals(10, list.get(0).intValue());
        assertEquals(30, list.get(1).intValue());
        assertEquals(20, list.get(2).intValue());
    }
}
