import java.util.Random;
import java.util.Scanner;

public class Stack {
    private int[] stackArray;
    private int top;
    private int size;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full!");
        } else {
            top++;
            stackArray[top] = element;
        }
    }

    public void pushMultiple(int count) {
        if (count > size - top - 1) {
            System.out.println("Not enough space in stack!");
        } else {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int element = random.nextInt(100);
                push(element);
            }
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            top--;
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Проверка пустоты стека");
            System.out.println("2. Проверка заполненности стека");
            System.out.println("3. Push element");
            System.out.println("4. Push multiple elements");
            System.out.println("5. Pop element");
            System.out.println("6. Print stack");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (stack.isEmpty()) {
                        System.out.println("Стек пустой.");
                    } else {
                        System.out.println("Стек не пустой.");
                    }
                    break;
                case 2:
                    if (stack.isFull()) {
                        System.out.println("Стек полный.");
                    } else {
                        System.out.println("Стек не полный.");
                    }
                    break;
                case 3:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 4:
                    System.out.print("Enter number of elements to push: ");
                    int count = scanner.nextInt();
                    stack.pushMultiple(count);
                    break;
                case 5:
                    stack.pop();
                    break;
                case 6:
                    stack.printStack();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
