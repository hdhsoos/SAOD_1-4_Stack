import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("1. Push element");
            System.out.println("2. Push multiple elements");
            System.out.println("3. Pop element");
            System.out.println("4. Print stack");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    System.out.print("Enter number of elements to push: ");
                    int count = scanner.nextInt();
                    stack.pushMultiple(count);
                    break;
                case 3:
                    stack.pop();
                    break;
                case 4:
                    stack.printStack();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}