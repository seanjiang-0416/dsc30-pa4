/*
 * NAME: Zhixing Jiang
 * PID: A16400450
 */

/**
 * RoundRobin class contains two kinds of constructor a handleAllTask method
 * and a main method. It simulates the idea of roundRobin.
 *
 * @author Zhixing Jiang
 * @since October 27, 2021
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";
    private static final int DEFAULT = 4;
    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;
    /**
     * Construct a new RoundRobin object with a DEFAULT quantum
     *
     */
    public RoundRobin(Task[] toHandle) {
        /* TODO */
        this(DEFAULT,toHandle);
    }
    /**
     * Construct a new RoundRobin object with an imported quantum
     *
     * @param quantum the input quantum
     * @param toHandle the Task arraylist
     */
    public RoundRobin(int quantum, Task[] toHandle) {
        /* TODO */
        if(quantum < 1){
            throw new IllegalArgumentException();
        }
        if(toHandle == null || toHandle.length == 0){
            throw new IllegalArgumentException();
        }

        this.waitlist = new DoublyLinkedList<Task>();
        for (int i = 0; i < toHandle.length;i++){
            waitlist.add(toHandle[i]);
        }
        this.finished = new DoublyLinkedList<Task>();
        this.quantum = quantum;
        this.burstTime = 0;
        this.waitTime = 0;
    }
    /**
     * Simulate the roundRobin process and handle all tasks
     *
     * @return the output that demonstrate the result of the simulation
     */
    public String handleAllTasks() {

        if (waitlist.isEmpty()){
            return TASK_HANDLED;
        }
        while(!waitlist.isEmpty()){
            Task cur = waitlist.get(0);
            for (int i = 0; i < quantum; i++) {
                boolean result = cur.handleTask();
                if (result) {
                    burstTime++;
                    waitTime += (waitlist.size() - 1);
                }
            }
            //check if it is finished
            //if it is, remove it from waitlist and add it to finished
            //if it isn't, remove it from waitlist and add it back
                if(cur.isFinished()){
                    finished.add(waitlist.remove(0));
                }
                else{
                    waitlist.add(waitlist.remove(0));
                }

            }

        String output = "All tasks are handled within ";
        output += Integer.toString(burstTime);
        output += " units of burst time and ";
        output += Integer.toString(waitTime);
        output += " units of wait time. The tasks are " +
                "finished in this order:\n";

        for(int i = 0; i < finished.size() - 1; i++){
            output += finished.get(i).toString() + " -> ";
        }
        output += finished.get(finished.size()-1);

        return output;
    }

    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}