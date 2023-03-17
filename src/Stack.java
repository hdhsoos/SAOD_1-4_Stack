import java.util.Random;
import java.util.Scanner;

public class Stack {
    private int[] stackArray;
    private int top;
    private int size;
    private miniStack deletedStack;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
        this.size = size;
        deletedStack = new miniStack(size);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Стек наполнен.");
        } else {
            top++;
            stackArray[top] = element;
        }
    }

    public void pushMultiple(int count) {
        if (count > size - top - 1) {
            System.out.println("В стеке не осталось места.");
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
            System.out.println("Стек пуст.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Что сделать с удаленным элементом?");
            System.out.println("1. Удалить полностью.");
            System.out.println("2. Добавить удаленный элемент в стек для удаленных элементов.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    top--;
                    break;
                case 2:
                    int element = stackArray[top];
                    top--;
                    deletedStack.push(element);
                    break;
                default:
                    System.out.println("Ошибка ввода.");
                    break;
            }
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Стек пустой.");
        } else {
            System.out.println("Основной стек:");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void printDeletedStack() {
        if (deletedStack.isEmpty()) {
            System.out.println("Стек для удаленных элементов пустой.");
        } else {
            System.out.println("Стек для удаленных элементов:");
            deletedStack.printStack();
        }
    }
    
    public void pushFromdeletedStack() {
        if (deletedStack.isEmpty()) {
            System.out.println("Стек для удаленных элементов пуст.");
        }
        else {
            push(deletedStack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину стека: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Проверка пустоты стека");
            System.out.println("2. Проверка заполненности стека");
            System.out.println("3. Добавление элемента на вершину стека");
            System.out.println("4. Добавление нескольких случайных элементов на вершину стека");
            System.out.println("5. Удаление элемента из вершина стека");
            System.out.println("6. Вывод основного стека на экран");
            System.out.println("7. Вывод стека удаленных элементов на экран");
            System.out.println("8. Выход");

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
                    System.out.println("Вы хотите взять элемент из стека удаленных элементов или ввести новый элемент?");
                    System.out.println("1. Стек удаленных элементов.");
                    System.out.println("2. Новый элемент.");
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            stack.pushFromdeletedStack();
                            break;
                        case 2:
                            System.out.print("Введите элемент для добавления: ");
                            int element = scanner.nextInt();
                            stack.push(element);
                            break;
                        default:
                            System.out.println("Неверный ввод.");
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Введите количество элементов для добавления: ");
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
                    stack.printDeletedStack();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод.");
                    break;
            }
        }
    }
}
