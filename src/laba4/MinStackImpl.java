package laba4;
public class MinStackImpl implements MinStack<Integer> {


    private static class Node {
        Integer value;
        Integer min;
        Node next;

        Node(Integer value, Integer min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    @Override
    public void push(Integer value) {
            int currentMin;
            if (head == null) {
                currentMin = value;
            } else {
                currentMin = Math.min(value, head.min);
            }
            head = new Node(value, currentMin, head);
        }


    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }
        Integer value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public Integer top() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) {
            return null;
        }
        return head.min;
    }
}