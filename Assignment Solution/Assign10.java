public class Assign10 {

}

class QueueException extends Exception {
    public static final String EMPTY_QUEUE = "Queue is Empty";

    public QueueException(String msg) {
        super(msg);
    }
}

class Queue {
    class Node {
        private int item;
        private Node next;

        public void setItem(int item) {
            this.item = item;
        }

        public int getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void insert(int data) {
        Node node = new Node();
        node.setItem(data);
        node.setNext(null);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
    }

    public int viewRear() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueException.EMPTY_QUEUE);
        }
        return rear.getItem();
    }

    public int viewFront() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueException.EMPTY_QUEUE);
        }
        return front.getItem();
    }

    public void delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.getNext();
        }
    }

    public int countNumberElement() throws QueueException {
        int countElement = 0;
        if (isEmpty()) {
            throw new QueueException(QueueException.EMPTY_QUEUE);
        } else {
            Node temp = front;
            while (temp != null) {
                temp = temp.getNext();
                countElement++;
            }
            return countElement;
        }
    }

}