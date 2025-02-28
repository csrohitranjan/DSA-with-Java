public class Assign6 {

}

class CDLL {
    class Node {
        Node prev;
        int item;
        Node next;

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

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

    };

    private Node start;

    public boolean isEmpty() {
        return start == null;
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.setItem(data);
        if (isEmpty()) {
            node.setNext(node);
            node.setPrev(node);
            start = node;
        } else {
            node.setPrev(start.getPrev());
            node.setNext(start);
            start.getPrev().setNext(node);
            start.setPrev(node);
            start = node;
        }
    }

    public void insertAtLast(int data) {
        Node node = new Node();
        node.setItem(data);
        if (isEmpty()) {
            node.setNext(node);
            node.setPrev(node);
            start = node;
        } else {
            node.setPrev(start.getPrev());
            node.setNext(start);
            start.getPrev().setNext(node);
            start.setPrev(node);
        }
    }

    public Node search(int data) {
        if (!isEmpty()) {
            Node temp = start;
            do {
                if (temp.getItem() == data)
                    return temp;
                temp = temp.getNext();
            } while (temp != start);
        }
        return null;
    }

    public void insertAfter(Node temp, int data) {
        if (temp != null) {
            Node node = new Node();
            node.setItem(data);
            node.setNext(temp.getNext());
            node.setPrev(temp);
            temp.getNext().setPrev(node);
            temp.setNext(node);
        }
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            if (start == start.getNext()) {
                start = null;
            } else {
                start.getPrev().setNext(start.getNext());
                start.getNext().setPrev(start.getPrev());
                start = start.getNext();
            }
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {
            if (start == start.getNext()) {
                start = null;
            } else {
                start.getPrev().getPrev().setNext(start);
                start.setPrev(start.getPrev().getPrev());
            }
        }
    }

    public void deleteNode(int data) {
        Node node = search(data);
        if (node != null) {
            if (start == node) {
                deleteFirst();
            } else {
                node.getNext().setPrev(node.getPrev());
                node.getPrev().setNext(node.getNext());
            }
        }
    }

}
