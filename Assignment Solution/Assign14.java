public class Assign14 {
    public static void main(String[] args) {
        BST b1 = new BST();
        System.out.println(b1.isEmpty());
    }
}

class BST {
    class Node {
        private Node left;
        private int item;
        private Node right;

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        Node n = new Node();
        n.setLeft(null);
        n.setItem(data);
        n.setRight(null);

        Node ptr = null;

        if (isEmpty()) {
            root = n;
        } else {
            ptr = root;
            while (ptr.getItem() != n.getItem()) {
                if (n.getItem() < ptr.getItem()) { // Left Sub Tree
                    if (ptr.getLeft() != null) {
                        ptr = ptr.getLeft();
                    } else {
                        ptr.setLeft(n);
                        break;
                    }
                } else { // Right sun Tree
                    if (ptr.getRight() != null) {
                        ptr = ptr.getRight();
                    } else {
                        ptr.setRight(n);
                        break;
                    }
                }
            }

        }

    }

    void preorderRec(Node ptr) {
        if (ptr != null) {
            System.out.print(" " + ptr.getItem());
            preorderRec(ptr.getLeft());
            preorderRec(ptr.getRight());
        }
    }

    void inorderRec(Node ptr) {
        if (ptr != null) {
            inorderRec(ptr.getLeft());
            System.out.print(" " + ptr.getItem());
            inorderRec(ptr.getRight());
        }
    }

    void postorderRec(Node ptr) {
        if (ptr != null) {
            postorderRec(ptr.getLeft());
            postorderRec(ptr.getRight());
            System.out.print(" " + ptr.getItem());
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    public void inorder() {
        inorderRec(root);
    }

    public void postorder() {
        postorderRec(root);
    }

    public Node search(int data) {
        Node ptr;
        ptr = root;
        while (ptr != null) {
            if (ptr.getItem() == data) {
                return ptr;
            }
            if (data < ptr.getItem()) {
                ptr = ptr.getLeft();
            } else {
                ptr = ptr.getRight();
            }
        }
        return null;
    }


    
    public void delete(int data){

    }
}