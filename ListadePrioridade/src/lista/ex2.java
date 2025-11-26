package lista;

import java.util.*;

public class Ex2 {

    // Classe para guardar informações do heap
    static class Node {
        int value;   // valor atual
        int listIndex;  // de qual lista veio
        int elementIndex; // qual índice dentro da lista

        Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.value, b.value)
        );

        List<Integer> result = new ArrayList<>();

        // Inserir o primeiro elemento de cada lista no heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new Node(lists.get(i).get(0), i, 0));
            }
        }

        while (!minHeap.isEmpty()) {

            // Pega o menor elemento atual
            Node node = minHeap.poll();
            result.add(node.value);

            // Pega o próximo elemento da mesma lista
            int nextIndex = node.elementIndex + 1;

            if (nextIndex < lists.get(node.listIndex).size()) {
                int nextValue = lists.get(node.listIndex).get(nextIndex);
                minHeap.offer(new Node(nextValue, node.listIndex, nextIndex));
            }
        }

        return result;
    }

    // ---------- MAIN PARA TESTAR ----------
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();

        input.add(Arrays.asList(1, 4, 7));
        input.add(Arrays.asList(2, 5, 8));
        input.add(Arrays.asList(3, 6, 9));

        List<Integer> resultado = mergeKSortedLists(input);

        System.out.println("Lista mesclada: " + resultado);
    }
}



