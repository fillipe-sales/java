package lista;

public class ex4 {
	public static boolean isMinHeap(int[] arr) {
    int n = arr.length;

    // Percorremos apenas até o último índice que é pai.
    for (int i = 0; i <= (n / 2) - 1; i++) {
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Verifica filho esquerdo
        if (left < n && arr[i] > arr[left]) {
            return false;
        }

        // Verifica filho direito
        if (right < n && arr[i] > arr[right]) {
            return false;
        }
    }

    return true; 
}


}
