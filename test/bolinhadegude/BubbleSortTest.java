package bolinhadegude;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes sobre o algorítmo de ordenação Bubble Sort.
 *
 * @author Maurício El Uri
 */
public class BubbleSortTest {

    BubbleSort bs;
    ArrayList<Integer> list = new ArrayList<>();

    public BubbleSortTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testaListNull() {
        bs = new BubbleSort(null);
    }

    @Test
    public void ListVazio() {
        bs = new BubbleSort(new ArrayList<>());
        bs.sort();
        assertEquals(new ArrayList<>(), bs.getList());
    }

    @Test
    public void list1Elemento() {
        list.add(10);
        bs = new BubbleSort(list);
        bs.sort();
        assertEquals(list, bs.getList());
    }

    @Test
    public void listJaOrdenado() {
        list.add(10);
        list.add(100);
        bs = new BubbleSort(list);
        bs.sort();
        assertEquals(list, bs.getList());
    }

    @Test
    public void array2ElemDesordenado() {
        list.add(10);
        list.add(100);
        bs = new BubbleSort(list);
        bs.sort();
        assertEquals(10, bs.getList().get(0).intValue());
        assertEquals(100, bs.getList().get(1).intValue());
    }

    @Test
    public void testaMaiorNoFinal() {
        list.add(100);
        list.add(10);
        list.add(200);
        list.add(30);
        list.add(50);
        bs = new BubbleSort(list);
        bs.sort();
        assertEquals(200, bs.getList().get(4).intValue());
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
        bs = new BubbleSort(list);
        bs.sort();
        assertEquals(listFinal, bs.getList());
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
        bs = new BubbleSort(list);
        bs.sort();
        assertEquals(listFinal, bs.getList());
    }

    @Test
    public void mantemListaOriginal() {
        list.add(10);
        list.add(30);
        list.add(20);
        bs = new BubbleSort((ArrayList<Integer>) list.clone());
        bs.sort();
        assertEquals(10, list.get(0).intValue());
        assertEquals(30, list.get(1).intValue());
        assertEquals(20, list.get(2).intValue());
    }
}
