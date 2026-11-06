package laba4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private ArrayList<HeapNode> heap = new ArrayList<>();


    private Map<Long, Integer> positions = new HashMap<>();

    private long operationCounter = 0;
    private long lastOperation;

    @Override
    public void enqueue(Integer value) {

        operationCounter++;

        HeapNode node = new HeapNode(value, operationCounter);

        heap.add(node);

        int index = heap.size() - 1;

        positions.put(operationCounter, index);

        siftUp(index);
    }

    @Override
    public Integer dequeueMax() {

        if (heap.isEmpty()) {
            return null;
        }

        HeapNode max = heap.get(0);

        lastOperation = max.getOperation();

        positions.remove(max.getOperation());

        HeapNode last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {

            heap.set(0, last);

            positions.put(last.getOperation(), 0);

            siftDown(0);
        }

        return max.getValue();
    }

    @Override
    public void increment(long operation, Integer addition) {

        Integer index = positions.get(operation);

        if (index == null) {
            return;
        }

        HeapNode node = heap.get(index);

        int oldValue = node.getValue();
        int newValue = oldValue + addition;

        node.setValue(newValue);

        if (newValue > oldValue) {
            siftUp(index);
        } else if (newValue < oldValue) {
            siftDown(index);
        }
    }

    public long getLastOperation() {
        return lastOperation;
    }

    // Поднимаем элемент вверх
    private void siftUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap.get(index).getValue()<= heap.get(parent).getValue()) {
                break;
            }

            swap(index, parent);

            index = parent;
        }
    }

    // Опускаем элемент вниз
    private void siftDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int largest = index;

            if (left < heap.size() && heap.get(left).getValue() > heap.get(largest).getValue()) {

                largest = left;
            }

            if (right < heap.size() &&
                    heap.get(right).getValue()
                            > heap.get(largest).getValue()) {

                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);

            index = largest;
        }
    }


    private void swap(int first, int second) {

        HeapNode temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
        positions.put(heap.get(first).getOperation(), first);
        positions.put(heap.get(second).getOperation(), second);
    }
}