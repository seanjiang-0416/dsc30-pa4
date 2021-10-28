/*
 * NAME: Zhixing Jiang
 * PID: A16400450
 */

/**
 * Queue that is implemented with the DoublyLinkedList
 * @param <T> generic container
 * @author Zhixing Jiang
 * @since October 26, 2021
 */
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;
    /**
     * Construct a new DLLQueue with DoublyLinkedList
     * @return boolean if the stack is empty
     *
     */
    public DLLQueue() {
        /* TODO */
        queue = new DoublyLinkedList<T>();
    }
    /**
     * Return the size of the queue
     * @return int the size of the queue
     */
    public int size() {
        /* TODO */
        return queue.size();
    }
    /**
     * Check if the queue is empty
     * @return boolean if the queue is empty
     *
     */
    public boolean isEmpty() {
        /* TODO */
        return queue.isEmpty();
    }
    /**
     * Add the element to the rear of the queue
     * @param data the input element
     *
     */
    public void enqueue(T data) {
        /* TODO */
        if (data == null){
            throw new IllegalArgumentException();
        }
        queue.add(data);
    }
    /**
     * Remove the element of the front of the queue
     * @return the element that is removed
     *
     */
    public T dequeue() {
        /* TODO */
        if (queue.isEmpty()) {
            return null;
        } else {
            T output = queue.remove(0);
            return (T) output;
        }
    }
    /**
     * Return the front element of the queue
     * @return the front element of the queue
     *
     */
    public T peek() {
        /* TODO */
        if (queue.isEmpty()){
            return null;
        }else{
            return queue.get(0);
        }
    }

}
