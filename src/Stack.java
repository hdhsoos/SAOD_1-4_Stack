public class Stack {
    private int top;
    private int[] stackArray;
    private int size;

    public Stack(int size) {
        this.top = -1;
        this.size = size;
        this.stackArray = new int[size];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Стек заполнен. Невозможно добавить элемент.");
        } else {
            top++;
            stackArray[top] = element;
            System.out.println("Элемент " + element + " добавлен в стек.");
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Стек пустой. Невозможно удалить элемент.");
        } else {
            int removedElement = stackArray[top];
            top--;
            System.out.println("Элемент " + removedElement + " удален из стека.");
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Стек пуст.");
        } else {
            System.out.print("Текущий стек: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

