import java.util.Scanner;
public class CircularQueue_Array {
    static Scanner sc = new Scanner(System.in);
    static int[] queu = new int[5];
    static int front = 0;
    static int rare = -1;
    static int size = 0;

    static void enqueu() {
        if (size == queu.length) {
            System.out.println("Queu is full!");
        } else {
            System.out.print("Enter Value to Enque:");
            int value = sc.nextInt();
            rare = (rare + 1) % queu.length;
            queu[rare] = value;
            size++;
            System.out.println(+value + " Enqued Successfully!");
        }
    }

    static void dequeu() {
        if (size == 0) {
            System.out.println("Queu is Empty!");
        } else {
            int value = queu[front];
            front = (front + 1) % queu.length;
            size--;
            System.out.println(+value + " Dequed Successfully!");
        }
    }

    static void peek() {
        if (size == 0) {
            System.out.println("Queu is Empty!");
        } else {
            System.out.println("Peek of Queu:" + queu[front]);
        }
    }

    static void display() {
        if (size == 0) {
            System.out.println("Queu is Empty!");
        } else {
            System.out.println("Elements of Queu.");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % queu.length;
                System.out.println(queu[index]);
            }
        }
    }

    static void isEmpty() {
        if (size == 0) {
            System.out.println("Queu is Empty!");
        } else {
            System.out.println("Queu is not Empty!");
        }
    }

    static void isFull() {
        if (size == queu.length) {
            System.out.println("Queu is full!");
        } else {
            System.out.println("Queu is not full!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean Exit = true;
        while (Exit) {
            System.out.println("----------Queu and its Operations----------");
            System.out.println("1.Enqueu");
            System.out.println("2.Dequeu");
            System.out.println("3.Peek");
            System.out.println("4.Display Elements");
            System.out.println("5.IsEmpty");
            System.out.println("6.IsFull");
            System.out.println("7.Exit");
            System.out.print("Enter Choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    enqueu();
                    break;
                case 2:
                    dequeu();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    isEmpty();
                    break;
                case 6:
                    isFull();
                    break;
                case 7:
                    Exit = false;
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
