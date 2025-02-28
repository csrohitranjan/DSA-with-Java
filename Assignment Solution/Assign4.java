public class Assign4 {

}

class DLL {
    class Node {
        private Node prev;
        private int item;
        private Node next;

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
    }

    private Node start;

    public boolean isEmpty() {
        return start == null;
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.setItem(data);
        node.setPrev(null);
        node.setNext(start);
        if (isEmpty()) {
            start = node;
        } else {
            start.setPrev(node);
            start = node;
        }
    }

    public void insertAtLast(int data) {
        Node node = new Node();
        node.setItem(data);
        node.setNext(null);
        if (start == null) {
            node.setPrev(null);
            start = node;
        } else {
            Node temp = start;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            node.setPrev(temp);
            temp.setNext(node);
        }
    }

    public Node search(int data) {
        Node temp = start;
        while (temp != null) {
            if (temp.getItem() == data) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void insertAfter(Node temp, int data) {
        if (temp != null) {
            Node node = new Node();
            node.setItem(data);
            node.setPrev(temp);
            node.setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrev(node);
            }
            temp.setNext(node);
        }
    }

    public void deleteFirst() {
        if (start != null) {
            if (start.getNext() == null) {
                start = null;
            } else {
                start = start.getNext();
                start.setPrev(null);
            }

        }
    }

    public void deleteLast() {
        if (start != null) {
            if (start.getNext() == null) {
                start = null;
            } else {
                Node temp = start;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.getPrev().setNext(null);
            }
        }
    }

    public void deleteNode(int data) {
        Node node = search(data);
        if (node != null) {
            if (node == start) {
                deleteFirst();
            } else if (node.getNext() == null) {
                deleteLast();
            } else {
                node.getNext().setPrev(node.getPrev());
                node.getPrev().setNext(node.getNext());
            }
        }

    }
}
