import java.util.Scanner;
public class Program_03{
    // Maximum capacity of the queue
    static final int MAX_SIZE = 20;
    // Underlying storage array
    static int[] queue = new int[MAX_SIZE];
    // Index of the front (next to be served)
    static int front = 0;
    // Index of the rear (most recently added)
    static int rear = -1;
    // Current number of tokens in the queue
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // ---------------------------------------------------------------------------
    // Entry point: drives the menu loop
    // ---------------------------------------------------------------------------
    public static void main(String[] args) {
        int choice = 0;

        do {
            printMenu();

            // Defensive input handling: reject non-integer menu choices
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // consume the invalid token so we don't loop forever
                continue;
            }
            choice = sc.nextInt();

            // Dispatch to the requested operation
            switch (choice) {
                case 1:
                    enqueue();
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    size();
                    break;
                case 5:
                    isEmpty();
                    break;
                case 6:
                    isFull();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-7.");
            }
        } while (choice != 7);

        sc.close();
    }

    /**
     * Prints the queue management menu to the console.
     */
    static void printMenu() {
        System.out.println("\n----- QUEUE MENU -----");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display");
        System.out.println("4. Size");
        System.out.println("5. isEmpty");
        System.out.println("6. isFull");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * 1. Enqueue — issue a new token number and add it to the back of the queue.
     * Time complexity: O(1)
     */
    static void enqueue() {
        // Guard: reject if the queue has reached maximum capacity
        if (count == MAX_SIZE) {
            System.out.println("Queue is FULL. Cannot issue a new token right now.");
            return;
        }

        System.out.print("Enter token number to enqueue: ");
        int value = sc.nextInt();

        // Move rear forward in circular fashion (wrap around to 0 after MAX_SIZE-1)
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = value;
        count++;

        System.out.println("Token " + value + " added to the back of the queue.");
    }

    /**
     * 2. Dequeue — serve (remove) the token currently at the front of the queue.
     * Time complexity: O(1)
     */
    static void dequeue() {
        // Guard: reject if the queue is empty
        if (count == 0) {
            System.out.println("Queue is EMPTY. No token to serve.");
            return;
        }

        int servedToken = queue[front];

        // Move front forward in circular fashion (wrap around to 0 after MAX_SIZE-1)
        front = (front + 1) % MAX_SIZE;
        count--;

        System.out.println("Serving token: " + servedToken);
    }

    /**
     * 3. Display — list every token currently waiting, in service order
     *    (front of the queue first, rear last).
     * Time complexity: O(n)
     */
    static void display() {
        if (count == 0) {
            System.out.println("Queue is empty. No customers waiting.");
            return;
        }

        System.out.println("Tokens in queue (front to rear):");
        // Walk 'count' elements starting at 'front', wrapping around the array
        for (int i = 0, index = front; i < count; i++, index = (index + 1) % MAX_SIZE) {
            String marker = (index == front) ? "  <-- front" : (i == count - 1 ? "  <-- rear" : "");
            System.out.println("  [" + index + "] = " + queue[index] + marker);
        }
    }


     // 4. Size — report how many tokens are currently waiting in the queue.

    static void size() {
        System.out.println("Current number of tokens in queue: " + count);
        System.out.println("Queue capacity: " + MAX_SIZE);
    }

    //5. isEmpty — check whether the queue currently holds no tokens.
    static void isEmpty() {
        System.out.println(count == 0 ? "Queue is EMPTY." : "Queue is NOT empty.");
    }

    //6. isFull — check whether the queue has reached its maximum capacity.
    static void isFull() {
        System.out.println(count == MAX_SIZE ? "Queue is FULL." : "Queue is NOT full.");
    }
}