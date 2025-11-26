package lista;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ex1 {

    public static List<Integer> findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : arr) {

            if (heap.size() < k) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }

        return new ArrayList<>(heap);
    }

    public static void main(String[] args) {

    	int[] arr = {5, 5, 5, 2, 9, 9, 1, 7};
    	int k = 3;
        List<Integer> resultado = findKthLargest(arr, k);

        System.out.println("Os " + k + " maiores elementos são: " + resultado);
    }
}
