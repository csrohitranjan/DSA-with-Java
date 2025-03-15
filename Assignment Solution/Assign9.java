public class Assign9 {

}

class Queue {
    int front;
    int rear;
    int[] ptr;

    public Queue(int size) {
        front = -1;
        rear = -1;
        ptr = new int[size];
    }

    public boolean overflow() {
        return rear + 1 == ptr.length;
    }

    public boolean underflow() {
        return front == -1;
    }

    public void insert(int data) {
        if (!overflow()) {
            if (front == -1) {
                front++;
            }
            rear++;
            ptr[rear] = data;
        }

    }

    public int viewRear() {
        return ptr[rear];
    }

    public int viewFront() {
        return ptr[front];
    }

    public void delete() {
        if (!underflow()) {
            if (rear == front) {
                front = rear = -1;
            } else {
                front++;
            }
        }
    }

    public int countNumberofElement() {
        return rear - front + 1;
    }
}