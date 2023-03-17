import java.util.Random;


public class miniStack {
    private int[] stackArray;
    private int top;
    private int size;

    public miniStack(int size) {
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

    public int pop() {
        if (isEmpty()) {
            System.out.println("Стек пустой.");
            return 0;
        } else {
            int res;
            res = stackArray[top];
            top--;
            return res;
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Стек пустой.");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}