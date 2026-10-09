import java.util.Scanner;
public class LinkedList_Queue {
        // Node of the linked list
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        static class Queue {
            private Node front;   // remove from here
            private Node rear;    // add here
            private int size;

            // 1. ENQUEUE: add element at the rear
            void enqueue(int value) {
                Node newNode = new Node(value);
                if (isEmpty()) {
                    front = rear = newNode;
                } else {
                    rear.next = newNode;
                    rear = newNode;
                }
                size++;
                System.out.println(value + " enqueued.");
            }

            // 2. DEQUEUE: remove element from the front
            void dequeue() {
                if (isEmpty()) {
                    System.out.println("Queue Underflow: queue is empty.");
                    return;
                }
                System.out.println("Dequeued: " + front.data);
                front = front.next;
                if (front == null) {
                    rear = null;   // queue became empty
                }
                size--;
            }

            // 3. PEEK / FRONT: view the front element
            void peek() {
                if (isEmpty()) {
                    System.out.println("Queue is empty.");
                    return;
                }
                System.out.println("Front element: " + front.data);
            }

            // 4. REAR: view the rear element
            void rear() {
                if (isEmpty()) {
                    System.out.println("Queue is empty.");
                    return;
                }
                System.out.println("Rear element: " + rear.data);
            }

            // 5. isEmpty
            boolean isEmpty() {
                return front == null;
            }

            // 6. SIZE
            int size() {
                return size;
            }

            // 7. DISPLAY
            void display() {
                if (isEmpty()) {
                    System.out.println("Queue is empty.");
                    return;
                }
                Node current = front;
                System.out.print("Front -> ");
                while (current != null) {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                }
                System.out.println("Rear");
            }

            // 8. SEARCH: position from the front (1-based)
            void search(int value) {
                Node current = front;
                int position = 1;
                while (current != null) {
                    if (current.data == value) {
                        System.out.println(value + " found at position " + position + " from the front.");
                        return;
                    }
                    current = current.next;
                    position++;
                }
                System.out.println(value + " not found in the queue.");
            }

            // 9. REVERSE the queue
            void reverse() {
                Node prev = null;
                Node current = front;
                rear = front;   // old front becomes the new rear
                while (current != null) {
                    Node next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                front = prev;
                System.out.println("Queue reversed.");
            }

            // 10. CLEAR the queue
            void clear() {
                front = rear = null;
                size = 0;
                System.out.println("Queue cleared.");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Queue queue = new Queue();
            int choice;

            do {
                System.out.println("\n===== QUEUE MENU (Linked List) =====");
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. Peek (Front)");
                System.out.println("4. Rear");
                System.out.println("5. Is Empty?");
                System.out.println("6. Size");
                System.out.println("7. Display");
                System.out.println("8. Search");
                System.out.println("9. Reverse");
                System.out.println("10. Clear");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to enqueue: ");
                        queue.enqueue(sc.nextInt());
                        break;
                    case 2:
                        queue.dequeue();
                        break;
                    case 3:
                        queue.peek();
                        break;
                    case 4:
                        queue.rear();
                        break;
                    case 5:
                        System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                        break;
                    case 6:
                        System.out.println("Size: " + queue.size());
                        break;
                    case 7:
                        queue.display();
                        break;
                    case 8:
                        System.out.print("Enter value to search: ");
                        queue.search(sc.nextInt());
                        break;
                    case 9:
                        queue.reverse();
                        break;
                    case 10:
                        queue.clear();
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
