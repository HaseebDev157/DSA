import java.util.Scanner;

    public class Program_01{
        //static use so it can be use anywhere in the program
        // Maximum capacity of the shelf (array)
        static final int MAX_SIZE = 100;
        static int[] shelf = new int[MAX_SIZE];
        // Current number of books on the shelf
        static int count = 0;
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            //do-while loop for menu itreration
            int choice=0;
            do {
                System.out.println("\n----- ARRAY MENU -----");
                System.out.println("1. Add value");
                System.out.println("2. Insert at index");
                System.out.println("3. Fill array");
                System.out.println("4. Delete last element");
                System.out.println("5. Delete by index");
                System.out.println("6. Display");
                System.out.println("7. Search value");
                System.out.println("8. Get value at index");
                System.out.println("9. Replace/Update value at index");
                System.out.println("10. size");
                System.out.println("11. Exit");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input.");
                    sc.next(); // discard bad token
                    continue;
                }
                choice = sc.nextInt();
              //switch statement foe user input
                switch (choice) {
                    case 1:
                        addValue();
                        break;
                    case 2:
                        insertAtIndex();
                        break;
                    case 3:
                        fillArray();
                        break;
                    case 4:
                        deleteLast();
                        break;
                    case 5:
                        deleteByIndex();
                        break;
                    case 6:  display();
                        break;
                    case 7:  searchValue();
                        break;
                    case 8:
                        getAtIndex();
                        break;
                    case 9:
                        updateAtIndex();
                        break;
                    case 10:
                        showSize();
                        break;
                    case 11: System.out.println("Exiting program. Goodbye!");
                        break;
                    default: System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 11);

            sc.close();
        }

        /* 1. Add a new value to the end of the array */
        static void addValue() {
            if (count >= MAX_SIZE) {
                System.out.println("Shelf is full! Cannot add more books.");
                return;
            }
            System.out.print("Enter book ID to add: ");
            int value = sc.nextInt();
            shelf[count] = value;
            count++;
            System.out.println("Book ID " + value + " added at index " + (count - 1) + ".");
        }

        /* 2. Insert a value at a specific index, shifting elements right */
        static void insertAtIndex() {
            if (count >= MAX_SIZE) {
                System.out.println("Shelf is full! Cannot insert more books.");
                return;
            }
            System.out.print("Enter index to insert at (0 to " + count + "): ");
            int index = sc.nextInt();

            if (index < 0 || index > count) {
                System.out.println("Invalid index.");
                return;
            }
            System.out.print("Enter book ID to insert: ");
            int value = sc.nextInt();

            for (int i = count; i > index; i--) {
                shelf[i] = shelf[i - 1];
            }
            shelf[index] = value;
            count++;
            System.out.println("Book ID " + value + " inserted at index " + index + ".");
        }

        /* 3. Fill the array with values until full or user stops */
        static void fillArray() {
            while (count < MAX_SIZE) {
                System.out.print("Enter book ID (or -1 to stop): ");
                int value = sc.nextInt();
                if (value == -1) break;
                shelf[count] = value;
                count++;
            }
            if (count >= MAX_SIZE) {
                System.out.println("Shelf is now full.");
            } else {
                System.out.println("Stopped filling. " + count + " book(s) on shelf.");
            }
        }

        /* 4. Delete the last element from the array */
        static void deleteLast() {
            if (count == 0) {
                System.out.println("Shelf is empty. Nothing to delete.");
                return;
            }
            count--;
            System.out.println("Removed book ID " + shelf[count] + " from the end.");
        }

        /* 5. Delete by index, shifting remaining elements left */
        static void deleteByIndex() {
            if (count == 0) {
                System.out.println("Shelf is empty. Nothing to delete.");
                return;
            }
            System.out.print("Enter index to delete (0 to " + (count - 1) + "): ");
            int index = sc.nextInt();

            if (index < 0 || index >= count) {
                System.out.println("Invalid index.");
                return;
            }
            int removed = shelf[index];
            for (int i = index; i < count - 1; i++) {
                shelf[i] = shelf[i + 1];
            }
            count--;
            System.out.println("Removed book ID " + removed + " from index " + index + ".");
        }

        /* 6. Display all elements currently in the array */
        static void display() {
            if (count == 0) {
                System.out.println("Shelf is empty.");
                return;
            }
            System.out.println("Books currently on shelf (" + count + "):");
            for (int i = 0; i < count; i++) {
                System.out.println("  [" + i + "] = " + shelf[i]);
            }
        }

        /* 7. Search for a value; report existence and index */
        static void searchValue() {
            System.out.print("Enter book ID to search: ");
            int value = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (shelf[i] == value) {
                    System.out.println("Book ID " + value + " found at index " + i + ".");
                    return;
                }
            }
            System.out.println("Book ID " + value + " not found on shelf.");
        }

        /* 8. Get the value at a specific index */
        static void getAtIndex() {
            if (count == 0) {
                System.out.println("Shelf is empty.");
                return;
            }
            System.out.print("Enter index (0 to " + (count - 1) + "): ");
            int index = sc.nextInt();

            if (index < 0 || index >= count) {
                System.out.println("Invalid index.");
                return;
            }
            System.out.println("Value at index " + index + " is " + shelf[index] + ".");
        }

        /* 9. Replace/Update the value at a specific index */
        static void updateAtIndex() {
            if (count == 0) {
                System.out.println("Shelf is empty.");
                return;
            }
            System.out.print("Enter index to update (0 to " + (count - 1) + "): ");
            int index = sc.nextInt();

            if (index < 0 || index >= count) {
                System.out.println("Invalid index.");
                return;
            }
            System.out.print("Enter new book ID: ");
            int value = sc.nextInt();

            System.out.println("Index " + index + " updated from " + shelf[index] + " to " + value + ".");
            shelf[index] = value;
        }

        /* 10. Show the current number of elements in the array */
        static void showSize() {
            System.out.println("Current number of books on shelf: " + count);
            System.out.println("Shelf capacity: " + MAX_SIZE);
        }
    }

