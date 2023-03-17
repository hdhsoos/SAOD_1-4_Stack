import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину стека: ");
        int size = scanner.nextInt();

        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Проверка пустоты стека");
            System.out.println("2. Проверка заполненности стека");
            System.out.println("3. Добавление элемента в вершину стека");
            System.out.println("4. Удаление элемента из вершина стека");
            System.out.println("5. Вывод текущего стека на экран");
            System.out.println("6. Выход");

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
                    System.out.print("Введите элемент для добавления: ");
                    int elementToAdd = scanner.nextInt();
                    stack.push(elementToAdd);
                    break;
                case 4:
                    stack.pop();
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Неправильный ввод. Попробуйте снова.");
            }
        }
    }
}
