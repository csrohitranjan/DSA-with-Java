public class Assign8 {
    public static void main(String[] args) {
        // Code
    }

    public static Stack reverseStack(Stack s1) {
        Stack s2 = new Stack();
        try {
            while (!s1.isEmpty()) {
                s2.push(s1.peek());
                s1.pop();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return s2;
    }
}

class StackException extends Exception {
    public static final String STACK_EMPTY = "Stack is Empty";

    public StackException(String msg) {
        super(msg);
    }
}

class Stack {
    class Node {
        private int item;
        private Node next;

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private Node top;

    public void push(int data) {
        Node node = new Node();
        node.setItem(data);
        node.setNext(top);
        top = node;
    }

    public int peek() throws StackException {
        if (top == null) {
            throw new StackException(StackException.STACK_EMPTY);
        } else {
            return top.getItem();
        }
    }

    public void pop() throws StackException {
        if (top == null) {
            throw new StackException(StackException.STACK_EMPTY);
        } else {
            top = top.getNext();
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}