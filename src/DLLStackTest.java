import org.junit.*;
import static org.junit.Assert.*;

public class DLLStackTest {
    private DLLStack <Integer> test ;
    private DLLStack <String> test_1;

    @Before
    public void setUp(){
        test = new DLLStack <Integer>();
        test_1 = new DLLStack <String>();
    }

    @Test
    public void STACK_1(){
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        assertEquals(4,test.size());
    }

    @Test
    public void STACK_2(){
        test_1.push("new");
        test_1.push("last");
        test_1.push("nothing");
        assertEquals(3,test_1.size());
        assertEquals("nothing", test_1.peek());
    }

    @Test
    public void STACK_3(){
        test.push(1);
        test.push(2);
        assertEquals(Integer.valueOf(2),test.peek());
    }

    @Test
    public void size_test_1(){
        test.push(1);
        test.push(2);
        test.push(3);
        assertEquals(3,test.size());
    }

    @Test
    public void size_test_2(){
        test_1.push("new");
        test_1.push("last");

        assertEquals(2,test_1.size());
    }

    @Test
    public void size_test_3(){
        test_1.push("new");

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
        test_1.push("String");
        test.push(12);
        assertFalse(test_1.isEmpty());
        assertFalse(test.isEmpty());
    }

    @Test
    public void push_1(){
        test.push(1);
        test.push(2);
        test.push(3);
        assertEquals(3,test.size());
        assertEquals(Integer.valueOf(3),test.peek());
    }

    @Test
    public void push_2(){
        test_1.push("nothing");
        test_1.push("thanks");
        test_1.push("last");
        assertEquals(3,test_1.size());
        assertEquals("last", test_1.peek());
    }

    @Test
    public void push_3(){
        test_1.push("great");
        assertEquals(1,test_1.size());
        assertEquals("great", test_1.peek());
    }

    @Test
    public void pop_1(){
        test.push(1);
        test.pop();
        test.push(2);
        test.pop();
        test.push(3);
        assertEquals(1,test.size());
        assertEquals(Integer.valueOf(3),test.peek());
    }

    @Test
    public void pop_2(){
        test_1.push("nothing");
        assertEquals("nothing",test_1.pop());
        test_1.push("thanks");
        assertEquals("thanks",test_1.pop());
        test_1.push("last");
        assertEquals(1,test_1.size());
        assertEquals("last",test_1.peek());
    }

    @Test
    public void pop_3(){
        test_1.push("nothing");
        test_1.push("thanks");
        test_1.push("last");
        assertEquals("last",test_1.pop());
        assertEquals("thanks",test_1.pop());
        assertEquals("nothing",test_1.pop());
    }

    @Test
    public void pop_4(){
        assertNull(test_1.pop());
    }

    @Test
    public void peek_1(){
        test_1.push("nothing");
        test_1.push("thanks");
        test_1.push("last");
        assertEquals("last",test_1.peek());
    }

    @Test
    public void peek_2(){
        test.push(1);
        test.push(2);
        test.push(3);
        assertEquals(Integer.valueOf(3),test.peek());
    }

    @Test
    public void peek_3(){

        assertNull(test.peek());
    }

    @Test (expected = IllegalArgumentException.class)
    public void exception_1(){
        test.push(null);
    }

}
