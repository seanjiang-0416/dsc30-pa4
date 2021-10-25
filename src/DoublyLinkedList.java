/*
 * NAME: Zhixing Jiang
 * PID: A16400450
 */

import java.util.AbstractList;

/**
 * TODO
 * @author Zhixing Jiang
 * @since October 24, 2021
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;
    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            // TODO: complete constructor
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            // TODO: complete implementation
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            // TODO: complete implementation
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            // TODO: complete implementation
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            // TODO: complete implementation
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            // TODO: complete implementation
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            // TODO: complete implementation
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            // TODO: complete implementation
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            // TODO: complete implementation
            this.prev.setNext(this.next);
            this.next.setPrev(this.prev);
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        // TODO: complete default constructor
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        this.nelems = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        if (element == null){
            throw new NullPointerException();
        }
        Node cur = new Node(element);
        Node last = tail.getPrev();
        last.setNext(cur);
        cur.setPrev(last);
        cur.setNext(tail);
        tail.setPrev(cur);
        nelems++;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * TODO: Javadoc comments
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        if(element == null){
            throw new NullPointerException();
        }
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        nelems++;
        Node cur = new Node(element);
        Node original = getNth(index);
        Node last = original.getPrev();
        cur.setPrev(last);
        last.setNext(cur);
        cur.setNext(original);
        original.setPrev(cur);



    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        // TODO: implement clear
        head.setNext(tail);
        tail.setPrev(head);
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;
        // TODO: Fill in implementation
        Node cur = head;
        for (int i = 0; i < nelems; i ++){
            cur = cur.getNext();
            if(cur.getElement() == data){
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation to get the node at index
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node cur = head;
        for (int i = 0; i <= index; i++){
            cur = cur.getNext();
        }
        return (T) cur.getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
     */
    private Node getNth(int index) {
        // TODO: implement
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node cur = head;
        for (int i = 0; i <= index; i++){
            cur = cur.getNext();
        }
        return cur;
    }

    /**
     * Determine if the list empty
     *
     * TODO: javadoc comments
     */
    @Override
    public boolean isEmpty() {
        // TODO: implement isEmpty
        if(nelems == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Remove the element from position index in the list
     *
     * TODO: javadoc comments
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node cur = getNth(index);
        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());
        nelems--;
        return cur.getElement();
        /*
        T output = this.get(index);
        this.remove(index);
        Node cur = new Node(this.get(index));
        if(index == 0){
            cur.setPrev(head);
            cur.setNext(new Node(this.get(index+1)));
        }
        else if(index  == size() - 1){
            cur.setPrev(new Node(this.get(index-1)));
            cur.setNext(tail);
        }
        else{
            cur.setPrev(new Node(this.get(index-1)));
            cur.setNext(new Node(this.get(index+1)));
        }
        nelems--;
        return (T) output;

         */
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Fill in implmentation
        if (element == null){
            throw new NullPointerException();
        }
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node cur = new Node(element);
        Node original = getNth(index);
        original.getPrev().setNext(cur);
        original.getNext().setPrev(cur);
        /*
        this.set(index, element);
        if (index == 0) {
            cur.setPrev(head);
            if (size() == 1) {
                cur.setNext(tail);
            }
            else {
                cur.setNext(new Node(this.get(index + 1)));
            }
        }
        else if (index == size() - 1){
            cur.setNext(tail);
            if (size() == 1){
                cur.setPrev(head);
            }
            else{
                cur.setPrev(new Node(this.get(index - 1)));
            }
        }
        else{
            cur.setNext(new Node(this.get(index+1)));
            cur.setPrev(new Node(this.get(index-1)));
        }
        return (T) original;

         */
        return (T) original.getElement();
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public int size() {
        // TODO: complete implementation
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * TODO: javadoc comments
     */
    @Override
    public String toString() {
        String output = "[(head) ->";
        for (int i = 0; i < size(); i++){
            output = output + get(i) + " ->";
        }
        output += " (tail)]";
        return output;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // TODO: complete implementation
    }

}