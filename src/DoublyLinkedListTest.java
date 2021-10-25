import org.junit.*;

import static org.junit.Assert.*;


public class DoublyLinkedListTest {
    private DoublyLinkedList <Integer> empty ;
    private DoublyLinkedList<Integer> one ;
    private DoublyLinkedList<Integer> several ;
    private DoublyLinkedList<String>  slist ;
    static final int DIM = 5;
    static final int FIBMAX = 30;
    @Before
    public void setUp(){
        empty = new DoublyLinkedList<Integer>();
        one = new DoublyLinkedList<Integer>();
        one.add(Integer.valueOf(0));
        several = new DoublyLinkedList<Integer>() ;
        // List: 1,2,3,...,Dim
        for (int i = DIM; i > 0; i--) {
            several.add(0, Integer.valueOf(i));
        }
        // List: "First","Last"
        //slist = new DoublyLinkedList<String>();
        //slist.add(0,"First");
        //slist.add(1,"Last");

    }

    @Test
    public void doubleLinkedList_test_1(){
        assertEquals(0,empty.size());
    }

    @Test
    public void doubleLinkedList_test_2(){
        assertEquals(1,one.size());
        assertEquals(Integer.valueOf(0),one.get(0));
    }

    @Test
    public void doubleLinkedList_test_3(){
        assertEquals(5,several.size());
        assertEquals(Integer.valueOf(1),several.get(0));
        assertEquals(Integer.valueOf(2),several.get(1));
        assertEquals(Integer.valueOf(3),several.get(2));
        assertEquals(Integer.valueOf(4),several.get(3));
        assertEquals(Integer.valueOf(5),several.get(4));
    }

    


}
