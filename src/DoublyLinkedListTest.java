import org.junit.*;

import static org.junit.Assert.*;

import java.util.*;
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
        slist = new DoublyLinkedList<String>();
        slist.add(0,"First");
        slist.add(1,"Last");

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

    @Test
    public void add_test_1(){
        empty.add(1);
        empty.add(2);
        empty.add(3);
        assertEquals(3, empty.size());
        assertEquals(Integer.valueOf(1),empty.get(0));
        assertEquals(Integer.valueOf(2),empty.get(1));
        assertEquals(Integer.valueOf(3),empty.get(2));
    }

    @Test
    public void add_test_2(){
        one.add(1);
        one.add(2);
        assertEquals(3, one.size());
        assertEquals(Integer.valueOf(0),one.get(0));
        assertEquals(Integer.valueOf(1),one.get(1));
        assertEquals(Integer.valueOf(2),one.get(2));
    }

    @Test
    public void add_test_3(){
        assertEquals(2, slist.size());
        assertEquals("First",slist.get(0));
        assertEquals("Last",slist.get(1));
    }

    @Test
    public void add_test_4(){
        empty.add(0,1);
        empty.add(0,2);
        empty.add(0,3);
        assertEquals(3, empty.size());
        assertEquals(Integer.valueOf(3),empty.get(0));
        assertEquals(Integer.valueOf(2),empty.get(1));
        assertEquals(Integer.valueOf(1),empty.get(2));
    }

    @Test
    public void add_test_5(){
        slist.add(0,"nothing");
        slist.add(2,"dang");
        assertEquals(4, slist.size());
        assertEquals("nothing",slist.get(0));
        assertEquals("First",slist.get(1));
        assertEquals("dang",slist.get(2));
        assertEquals("Last",slist.get(3));
    }

    @Test
    public void add_test_6(){
        one.add(1,12);
        assertEquals(2, one.size());
        assertEquals(Integer.valueOf(0),one.get(0));
        assertEquals(Integer.valueOf(12),one.get(1));
    }

    @Test
    public void clear_1(){
        one.clear();
        assertEquals(0,one.size());
    }
    @Test
    public void clear_2(){
        empty.clear();
        assertEquals(0,empty.size());
    }
    @Test
    public void clear_3(){
        slist.clear();
        assertEquals(0,slist.size());
    }

    @Test
    public void test_contains_1(){
        assertTrue(one.contains(0));
    }

    @Test
    public void test_contains_2(){
        assertTrue(slist.contains("Last"));
    }

    @Test
    public void test_contains_3(){
        assertFalse(one.contains(12));
    }

    @Test
    public void test_get_1(){
        empty.add(1);
        assertEquals(Integer.valueOf(1),empty.get(0));
    }

    @Test
    public void test_get_2(){
        assertEquals("Last",slist.get(1));
    }

    @Test
    public void test_get_3(){
        assertEquals(Integer.valueOf(1),several.get(0));
        assertEquals(Integer.valueOf(2),several.get(1));
        assertEquals(Integer.valueOf(3),several.get(2));
        assertEquals(Integer.valueOf(4),several.get(3));
        assertEquals(Integer.valueOf(5),several.get(4));
    }

    @Test
    public void is_empty_1(){
        assertTrue(empty.isEmpty());
    }

    @Test
    public void is_empty_2(){
        assertFalse(one.isEmpty());
    }

    @Test
    public void is_empty_3(){
        assertFalse(slist.isEmpty());
    }

    @Test
    public void test_remove_1(){
        assertEquals(Integer.valueOf(0),one.remove(0));
        assertEquals(0,one.size());
    }

    @Test
    public void test_remove_2(){
        assertEquals(Integer.valueOf(3),several.remove(2));
        assertEquals(4,several.size());
        assertEquals(Integer.valueOf(1),several.get(0));
        assertEquals(Integer.valueOf(2),several.get(1));
        assertEquals(Integer.valueOf(4),several.get(2));
        assertEquals(Integer.valueOf(5),several.get(3));
    }

    @Test
    public void test_remove_3(){
        assertEquals("First",slist.remove(0));
        assertEquals(1,slist.size());
        assertEquals("Last",slist.get(0));
    }

    @Test
    public void test_set_1(){
        assertEquals(5,several.size());
        several.set(2,100);
        assertEquals(Integer.valueOf(1),several.get(0));
        assertEquals(Integer.valueOf(2),several.get(1));
        assertEquals(Integer.valueOf(100),several.get(2));
        assertEquals(Integer.valueOf(4),several.get(3));
        assertEquals(Integer.valueOf(5),several.get(4));
    }

    @Test
    public void test_set_2(){
        one.set(0,100);
        assertEquals(Integer.valueOf(100),one.get(0));
    }

    @Test
    public void test_set_3(){
        String original = slist.get(1);
        slist.set(1,"dang");
        assertEquals("dang",slist.get(1));
    }

    @Test
    public void test_size_1(){
        assertEquals(1,one.size());
    }

    @Test
    public void test_size_2(){
        assertEquals(0,empty.size());
    }

    @Test
    public void test_size_3(){
        assertEquals(5,several.size());
    }
    @Test
    public void test_toString_1(){
        assertEquals("[(head) -> (tail)]", empty.toString());
    }

    @Test
    public void test_toString_2(){
        assertEquals("[(head) -> 0 -> (tail)]", one.toString());
    }

    @Test
    public void test_toString_3(){
        assertEquals("[(head) -> First -> Last -> (tail)]", slist.toString());
    }

    @Test(expected = NullPointerException.class)
    public void test_exception_1(){
        empty.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_exception_2(){
        empty.add(0,null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_exception_3(){
        empty.add(13,12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_exception_4(){
        several.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_exception_5(){
        several.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_exception_6() throws IndexOutOfBoundsException{
        several.set(-1,12);
    }

    @Test(expected = NullPointerException.class)
    public void test_exception_7(){
        several.set(0,null);
    }

    @Test
    public void test_swapSegment_1(){
        one.add(12);
        one.add(13);
        one.add(14);

        several.swapSegment(one,2);
        assertEquals(Integer.valueOf(0),several.get(0));
        assertEquals(Integer.valueOf(12),several.get(1));
        assertEquals(Integer.valueOf(13),several.get(2));
        assertEquals(Integer.valueOf(1),one.get(0));
        assertEquals(Integer.valueOf(2),one.get(1));
        assertEquals(Integer.valueOf(3),one.get(2));
    }

    @Test
    public void test_swapSegment_2(){
        one.add(12);
        several.swapSegment(one,0);
        assertEquals(Integer.valueOf(0),several.get(0));
        assertEquals(Integer.valueOf(1),one.get(0));
    }

    @Test
    public void test_swapSegment_3(){
        empty.add(12);
        one.add(1);
        empty.add(13);
        empty.swapSegment(one,1);
        assertEquals(Integer.valueOf(0),empty.get(0));
        assertEquals(Integer.valueOf(1),empty.get(1));
        assertEquals(Integer.valueOf(12),one.get(0));
        assertEquals(Integer.valueOf(13),one.get(1));
    }

    @Test
    public void test_removeMultpleOf_1(){

        several.removeMultipleOf(2);
        assertEquals(Integer.valueOf(2),several.get(0));
        assertEquals(Integer.valueOf(4),several.get(1));
    }

    @Test
    public void test_removeMultpleOf_2(){

        several.removeMultipleOf(3);
        assertEquals(Integer.valueOf(2),several.get(0));
        assertEquals(Integer.valueOf(3),several.get(1));
        assertEquals(Integer.valueOf(5),several.get(2));


    }
    @Test
    public void test_removeMultpleOf_3(){
        several.removeMultipleOf(4);
        assertEquals(Integer.valueOf(2),several.get(0));
        assertEquals(Integer.valueOf(3),several.get(1));
        assertEquals(Integer.valueOf(4),several.get(2));


    }


}


