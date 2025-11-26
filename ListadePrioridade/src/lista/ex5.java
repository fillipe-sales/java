package lista;

import java.util.Collections;
import java.util.PriorityQueue;

public class ex5 { 

    private PriorityQueue<Integer> maxHeap; // metade menor (maiores no topo)
    private PriorityQueue<Integer> minHeap; // metade maior (menores no topo)

    // Construtor correto (nome deve ser igual ao da classe!)
    public ex5() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // ---------------- ADD NUMBER ----------------
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balanceamento
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } 
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // ---------------- FIND MEDIAN ----------------
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    // ---------------- TESTE MAIN ----------------
    public static void main(String[] args) {
        ex5 mf = new ex5();

        mf.addNum(5);
        mf.addNum(2);
        mf.addNum(10);
        mf.addNum(7);

        System.out.println("Mediana: " + mf.findMedian()); 
    }
}
