import java.util.Scanner;
public class Program_02{

    // Maximum capacity of the stack
    static final int MAX_SIZE = 100;
    // Array holding the plate values
    static int[] stack = new int[MAX_SIZE];
    // Index of the top element; -1 means empty
    static int top = -1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            // Display the menu
            System.out.println("\n----- STACK MENU -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Guard against non-integer input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input.");
                sc.next(); // discard the bad token
                continue;
            }
            choice = sc.nextInt();

            // Route to the requested operation
            switch (choice) {
                case 1:
                    push();
                    break;
                case 2:
                    pop();
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
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        sc.close();
    }

    /* 1. Push - add a new plate on top of the stack */
    static void push() {
        // Check for overflow before inserting
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack Overflow! The pile is full, cannot add more plates.");
            return;
        }
        System.out.print("Enter plate value to push: ");
        int value = sc.nextInt();
        // Move top pointer up first
        top++;
        // Place the new plate at the new top position
        stack[top] = value;
        System.out.println("Plate " + value + " pushed onto the stack at position " + top + ".");
    }

    /* 2. Pop - remove and show the value from the top of the stack */
    static void pop() {
        // Check for underflow before removing
        if (top == -1) {
            System.out.println("Stack Underflow! The pile is empty, nothing to pop.");
            return;
        }
        int removed = stack[top]; // Read the top value
        top--;                    // Move top pointer down, "removing" the plate
        System.out.println("Popped plate value: " + removed);
    }

    /* 3. Display - show all values currently in the stack (top to bottom) */
    static void display() {
        if (top == -1) {
            System.out.println("Stack is empty. No plates in the pile.");
            return;
        }
        System.out.println("Stack contents (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  [" + i + "] = " + stack[i] + (i == top ? "  <-- top" : ""));
        }
    }

    /* 4. Size - show the current number of elements in the stack */
    static void size() {
        // top is index-based, so size = top + 1
        int currentSize = top + 1;
        System.out.println("Current number of plates in stack: " + currentSize);
        System.out.println("Stack capacity: " + MAX_SIZE);
    }

    /* 5. isEmpty - check whether the stack is empty */
    static void isEmpty() {
        if (top == -1) {
            System.out.println("Stack is EMPTY.");
        } else {
            System.out.println("Stack is NOT empty.");
        }
    }

    /* 6. isFull - check whether the stack has reached its maximum capacity */
    static void isFull() {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack is FULL.");
        } else {
            System.out.println("Stack is NOT full.");
        }
    }
}