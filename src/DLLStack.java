/*
 * NAME: Zhixing Jiang
 * PID: A16400450
 */

/**
 * Stack that is implemented by DoublyLinkedList
 * @param <T> generic container
 * @author Zhixing Jiang
 * @since October 26, 2021
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    /**
     * Construct a new DLLStack Object
     *
     */
    public DLLStack() {
        /* TODO */
        stack = new DoublyLinkedList<T>();
    }
    /**
     * Return the size of the stack
     * @return int the size of the stack
     */
    public int size() {
        /* TODO */
        return stack.size();
    }
    /**
     * Check if the stack is empty
     * @return boolean if the stack is empty
     *
     */
    public boolean isEmpty() {
        /* TODO */
        return stack.isEmpty();
    }
    /**
     * Push the data into stack
     * @param data the input element
     *
     */
    public void push(T data) {
        /* TODO */
        if(data == null){
            throw new IllegalArgumentException();
        }
        stack.add(data);
    }
    /**
     * Pop the first element in the stack
     * @return the top element in the stack
     *
     */
    public T pop() {
        /* TODO */
        if (stack.isEmpty()) {
            return null;
        } else {
            T output = stack.remove(size() - 1);
            return (T) output;
        }
    }
    /**
     * Check the top element in the stack
     * @return the first element in the stack
     *
     */
    public T peek() {
        /* TODO */
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.get(size()-1);
        }
    }

}
