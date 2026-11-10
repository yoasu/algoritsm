package laba9;

public class BST {
    private Node root;
    public void insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node current = root;
        while (true) {
            if (x == current.value) {
                return;
            }
            if (x < current.value) {
                if (current.left == null) {
                    current.left = new Node(x);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(x);
                    return;
                }
                current = current.right;
            }
        }
    }
    public boolean has(int x) {
        Node current = root;

        while (current != null) {
            if (current.value == x) {
                return true;
            }

            if (x < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }
    public void delete(int x) {
        root = deleteNode(root, x);
    }

    private Node deleteNode(Node node, int x) {
        if (node == null) {
            return null;
        }

        if (x < node.value) {
            node.left = deleteNode(node.left, x);
        } else if (x > node.value) {
            node.right = deleteNode(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node successor = findMin(node.right);

            node.value = successor.value;

            node.right = deleteNode(node.right, successor.value);
        }

        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
    public Integer next(int x) {
        Node current = root;
        Integer answer = null;

        while (current != null) {
            if (current.value > x) {
                answer = current.value;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return answer;
    }
    public Integer prev(int x) {
        Node current = root;
        Integer answer = null;

        while (current != null) {
            if (current.value < x) {
                answer = current.value;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return answer;
    }
}