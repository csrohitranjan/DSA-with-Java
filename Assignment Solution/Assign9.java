public class Assign9 {

}

class QueueException extends Exception {
    public static final String INVALID_SIZE = "Invalid Queue Size";
    public static final String QUEUE_OVERFLOW = "Queue is Full";
    public static final String QUEUE_UNDERFLOW = "Queue is Empty";

    public QueueException(String msg) {
        super(msg);
    }
}

class Queue {
    int front;
    int rear;
    int[] ptr;

    public Queue(int size) throws QueueException {
        if (size < 1) {
            throw new QueueException(QueueException.INVALID_SIZE);
        }

        front = -1;
        rear = -1;
        ptr = new int[size];
    }

    public boolean isFull() {
        return (front == 0 && rear + 1 == ptr.length) || (rear + 1 == front);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void insert(int data) throws QueueException {

        if (isFull()) {
            throw new QueueException(QueueException.QUEUE_OVERFLOW);
        }
        if (isEmpty()) {
            front = rear = 0;
        } else if (rear + 1 == ptr.length) {
            rear = 0;
        } else {
            rear++;
        }
        ptr[rear] = data;
    }

    public int viewRear() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueException.QUEUE_UNDERFLOW);
        }
        return ptr[rear];
    }

    public int viewFront() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueException.QUEUE_UNDERFLOW);
        }

        return ptr[front];
    }

    public void delete() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(QueueException.QUEUE_UNDERFLOW);
        } else if (rear == front) {
            front = rear = -1;
        } else if (front + 1 == ptr.length) {
            front = 0;
        } else {
            front++;
        }
    }

    public int countNumberofElement() {
        if (isEmpty()) {
            return 0;
        }
        if (front > rear) {
            return ptr.length - (front - rear) + 1;
        } else {
            return rear - front + 1;
        }

    }
}