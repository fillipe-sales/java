package lista;

import java.util.*;

public class ex3 {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private Map<Integer, Integer> freq;

    public ex3() {
        minHeap = new PriorityQueue<>(); // menor primeiro
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maior primeiro
        freq = new HashMap<>();
    }

    // ------------ INSERT ------------
    public void insert(int value) {
        minHeap.offer(value);
        maxHeap.offer(value);
        freq.put(value, freq.getOrDefault(value, 0) + 1);
    }

    // ------------ CLEAN HELPERS ------------
    private void cleanMinHeap() {
        while (!minHeap.isEmpty() && freq.getOrDefault(minHeap.peek(), 0) == 0) {
            minHeap.poll();
        }
    }

    private void cleanMaxHeap() {
        while (!maxHeap.isEmpty() && freq.getOrDefault(maxHeap.peek(), 0) == 0) {
            maxHeap.poll();
        }
    }

    // ------------ GET MIN ------------
    public Integer getMin() {
        cleanMinHeap();
        if (minHeap.isEmpty()) return null;
        return minHeap.peek();
    }

    // ------------ GET MAX ------------
    public Integer getMax() {
        cleanMaxHeap();
        if (maxHeap.isEmpty()) return null;
        return maxHeap.peek();
    }

    // ------------ REMOVE MIN ------------
    public Integer removeMin() {
        cleanMinHeap();
        if (minHeap.isEmpty()) return null;

        int val = minHeap.poll();
        freq.put(val, freq.get(val) - 1);
        return val;
    }

    // ------------ REMOVE MAX ------------
    public Integer removeMax() {
        cleanMaxHeap();
        if (maxHeap.isEmpty()) return null;

        int val = maxHeap.poll();
        freq.put(val, freq.get(val) - 1);
        return val;
    }

    // ------------ TEST MAIN ------------
    public static void main(String[] args) {
        ex3 dpq = new ex3();

        dpq.insert(5);
        dpq.insert(2);
        dpq.insert(10);
        dpq.insert(7);

        System.out.println("Min: " + dpq.getMin()); // 2
        System.out.println("Max: " + dpq.getMax()); // 10

        dpq.removeMin();
        dpq.removeMax();

        System.out.println("Min: " + dpq.getMin()); // 5
        System.out.println("Max: " + dpq.getMax()); // 7
    }
}

