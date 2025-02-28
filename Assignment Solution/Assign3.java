public class Assign3 {

}

class SLL {
    class Node {
        int item;
        Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

    }

    private Node start;

    public boolean isEmpty() {
        return start == null;
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.setItem(data);
        node.setNext(start);
        start = node;
    }

    public void insertAtLast(int data) {
        Node node = new Node();
        node.setItem(data);
        node.setNext(null);
        if (start == null)
            start = node;
        else {
            Node temp = null;
            temp = start;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    public Node search(int data) {
        Node temp;
        temp = start;
        while (temp != null) {
            if (temp.getItem() == data)
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    public void insertAfter(Node n, int data) {
        if (n == null)
            throw new NullPointerException("Given null instead of node");
        Node node = new Node();
        node.setItem(data);
        node.setNext(n.getNext());
        n.setNext(node);
    }

    public void deleteFirst() {
        if (start != null) {
            start = start.getNext();
        }
    }

    public void deleteLast() {
        if (start != null) {
            if (start.getNext() == null) {
                start = null;
            } else {
                Node temp = start;
                while (temp.getNext().getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(null);
            }
        }
    }

    public void deleteNode(int data) {
        Node n = search(data);
        if (n != null) {
            if (start.getItem() == n.getItem())
                deleteFirst();
            else {
                Node temp = start;
                while (temp.getNext() != n) {
                    temp = temp.getNext();
                }
                temp.setNext(n.getNext());
            }
        }
    }
}