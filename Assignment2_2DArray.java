import java.util.Scanner;
public class Array_2D_Shifting {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter rows: ");
            int rows = sc.nextInt();
            System.out.print("Enter columns: ");
            int cols = sc.nextInt();

            int[][] a = new int[rows][cols];
            System.out.println("Enter elements:");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    a[i][j] = sc.nextInt();

            int choice;
            do {
                System.out.println("\n1. Shift Left");
                System.out.println("2. Shift Right");
                System.out.println("3. Shift Up");
                System.out.println("4. Shift Down");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) {                       // LEFT
                    for (int i = 0; i < rows; i++) {
                        int first = a[i][0];
                        for (int j = 0; j < cols - 1; j++)
                            a[i][j] = a[i][j + 1];
                        a[i][cols - 1] = first;
                    }
                } else if (choice == 2) {                // RIGHT
                    for (int i = 0; i < rows; i++) {
                        int last = a[i][cols - 1];
                        for (int j = cols - 1; j > 0; j--)
                            a[i][j] = a[i][j - 1];
                        a[i][0] = last;
                    }
                } else if (choice == 3) {                // UP
                    for (int j = 0; j < cols; j++) {
                        int first = a[0][j];
                        for (int i = 0; i < rows - 1; i++)
                            a[i][j] = a[i + 1][j];
                        a[rows - 1][j] = first;
                    }
                } else if (choice == 4) {                // DOWN
                    for (int j = 0; j < cols; j++) {
                        int last = a[rows - 1][j];
                        for (int i = rows - 1; i > 0; i--)
                            a[i][j] = a[i - 1][j];
                        a[0][j] = last;
                    }
                }

                if (choice >= 1 && choice <= 4) {
                    System.out.println("Result:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++)
                            System.out.print(a[i][j] + " ");
                        System.out.println();
                    }
                }
            } while (choice != 0);

            sc.close();
        }
}
