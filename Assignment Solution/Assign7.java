public class Assign7 {
    public static void main(String[] args) {
        try {
            Stack s1 = new Stack(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StackException extends Exception {
    public static final String STACK_OVERFLOW = "Array Overflow";
    public static final String STACK_UNDERFLOW = "Empty Stack";
    public static final String INVALID_SIZE = "Invalid Stack Size";

    public StackException(String msg) {
        super(msg);
    }
}

class Stack {
    private int top;
    private int[] ptr;

    public Stack(int size) throws StackException {
        if (size < 1) {
            throw new StackException(StackException.INVALID_SIZE);
        }
        ptr = new int[size];
        top = -1;
    }

    public void push(int data) throws StackException {
        if (top == ptr.length) {
            throw new StackException(StackException.STACK_OVERFLOW);
        } else {
            top++;
            ptr[top] = data;
        }
    }

    public int peek() throws StackException {
        if (top == -1) {
            throw new StackException(StackException.STACK_UNDERFLOW);
        }
        return ptr[top];
    }

    public void pop() throws StackException {
        if (top == -1) {
            throw new StackException(StackException.STACK_UNDERFLOW);
        }
        top--;
    }

    public boolean isStackOverflow() {
        return top + 1 == ptr.length;
    }

    public boolean isStackUnderFlow() {
        return top == -1;
    }
}