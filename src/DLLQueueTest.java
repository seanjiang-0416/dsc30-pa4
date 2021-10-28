import org.junit.*;
import static org.junit.Assert.*;

public class DLLQueueTest {
    private DLLQueue <Integer> test ;
    private DLLQueue <String> test_1;
    @Before
    public void setUp(){
        test = new DLLQueue <Integer>();
        test_1 = new DLLQueue <String>();
    }

    @Test
    public void DLLQUEUE_1(){
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        assertEquals(4,test.size());
    }

    @Test
    public void DLLQUEUE_2(){
        test_1.enqueue("new");
        test_1.enqueue("last");
        test_1.enqueue("nothing");
        assertEquals(3,test_1.size());
        assertEquals("new", test_1.peek());
    }

    @Test
    public void DLLQUEUE_3(){
        test.enqueue(1);
        test.enqueue(2);
        assertEquals(Integer.valueOf(1),test.peek());
    }

    @Test
    public void size_test_1(){
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        assertEquals(3,test.size());
    }

    @Test
    public void size_test_2(){
        test_1.enqueue("new");
        test_1.enqueue("last");

        assertEquals(2,test_1.size());
    }

    @Test
    public void size_test_3(){
        test_1.enqueue("new");

        assertEquals(1,test_1.size());
    }

    @Test
    public void isEmpty_test_1(){
        assertTrue(test_1.isEmpty());
    }

    @Test
    public void isEmpty_test_2(){
        assertTrue(test.isEmpty());
    }

    @Test
    public void isEmpty_test_3(){
        test_1.enqueue("String");
        test.enqueue(12);
        assertFalse(test_1.isEmpty());
        assertFalse(test.isEmpty());
    }

    @Test
    public void enqueue_1(){
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        assertEquals(3,test.size());
        assertEquals(Integer.valueOf(1),test.peek());
    }

    @Test
    public void enqueue_2(){
        test_1.enqueue("nothing");
        test_1.enqueue("thanks");
        test_1.enqueue("last");
        assertEquals(3,test_1.size());
        assertEquals("nothing", test_1.peek());
    }

    @Test
    public void enqueue_3(){
        test_1.enqueue("great");
        assertEquals(1,test_1.size());
        assertEquals("great", test_1.peek());
    }

    @Test
    public void dequeue_1(){
        test.enqueue(1);
        test.dequeue();
        test.enqueue(2);
        test.dequeue();
        test.enqueue(3);
        assertEquals(1,test.size());
        assertEquals(Integer.valueOf(3),test.peek());
    }

    @Test
    public void dequeue_2(){
        test_1.enqueue("nothing");
        assertEquals("nothing",test_1.dequeue());
        test_1.enqueue("thanks");
        assertEquals("thanks",test_1.dequeue());
        test_1.enqueue("last");
        assertEquals(1,test_1.size());
        assertEquals("last",test_1.peek());
    }

    @Test
    public void dequeue_3(){
        test_1.enqueue("nothing");
        test_1.enqueue("thanks");
        test_1.enqueue("last");
        assertEquals("nothing",test_1.dequeue());
        assertEquals("thanks",test_1.dequeue());
        assertEquals("last",test_1.dequeue());
    }

    @Test
    public void dequeue_4(){
        assertNull(test_1.dequeue());
    }

    @Test
    public void peek_1(){
        test_1.enqueue("nothing");
        test_1.enqueue("thanks");
        test_1.enqueue("last");
        assertEquals("nothing",test_1.peek());
    }

    @Test
    public void peek_2(){
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        assertEquals(Integer.valueOf(1),test.peek());
    }

    @Test
    public void peek_3(){

        assertNull(test.peek());
    }

    @Test (expected = IllegalArgumentException.class)
    public void exception_1(){
        test.enqueue(null);
    }

}
