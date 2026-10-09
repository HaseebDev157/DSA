import java.util.Scanner;
public class Linkedlist_Stack {
        // Node of the linked list
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        static class Stack {
            private Node top;
            private int size;

            // 1. PUSH: add element on top
            void push(int value) {
                Node newNode = new Node(value);
                newNode.next = top;
                top = newNode;
                size++;
                System.out.println(value + " pushed onto the stack.");
            }

            // 2. POP: remove and return the top element
            void pop() {
                if (isEmpty()) {
                    System.out.println("Stack Underflow: stack is empty.");
                    return;
                }
                System.out.println("Popped: " + top.data);
                top = top.next;
                size--;
            }

            // 3. PEEK: view the top element
            void peek() {
                if (isEmpty()) {
                    System.out.println("Stack is empty.");
                    return;
                }
                System.out.println("Top element: " + top.data);
            }

            // 4. isEmpty
            boolean isEmpty() {
                return top == null;
            }

            // 5. SIZE
            int size() {
                return size;
            }

            // 6. DISPLAY
            void display() {
                if (isEmpty()) {
                    System.out.println("Stack is empty.");
                    return;
                }
                Node current = top;
                System.out.print("Top -> ");
                while (current != null) {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                }
                System.out.println("null");
            }

            // 7. SEARCH: position from the top (1-based), -1 if not found
            void search(int value) {
                Node current = top;
                int position = 1;
                while (current != null) {
                    if (current.data == value) {
                        System.out.println(value + " found at position " + position + " from the top.");
                        return;
                    }
                    current = current.next;
                    position++;
                }
                System.out.println(value + " not found in the stack.");
            }

            // 8. REVERSE the stack
            void reverse() {
                Node prev = null;
                Node current = top;
                while (current != null) {
                    Node next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                top = prev;
                System.out.println("Stack reversed.");
            }

            // 9. CLEAR the stack
            void clear() {
                top = null;
                size = 0;
                System.out.println("Stack cleared.");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Stack stack = new Stack();
            int choice;

            do {
                System.out.println("\n===== STACK MENU (Linked List) =====");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Is Empty?");
                System.out.println("5. Size");
                System.out.println("6. Display");
                System.out.println("7. Search");
                System.out.println("8. Reverse");
                System.out.println("9. Clear");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        stack.push(sc.nextInt());
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        stack.peek();
                        break;
                    case 4:
                        System.out.println(stack.isEmpty() ? "Stack is empty." : "Stack is not empty.");
                        break;
                    case 5:
                        System.out.println("Size: " + stack.size());
                        break;
                    case 6:
                        stack.display();
                        break;
                    case 7:
                        System.out.print("Enter value to search: ");
                        stack.search(sc.nextInt());
                        break;
                    case 8:
                        stack.reverse();
                        break;
                    case 9:
                        stack.clear();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 0);

            sc.close();
        }
    }

