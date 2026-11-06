package laba4;

public class HeapNode {

    private int value;
    private final long operation;

    public HeapNode(int value, long operation) {
        this.value = value;
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getOperation() {
        return operation;
    }
}