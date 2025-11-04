package TDA;

public class Fila {

    private int[] elementos = new int[5];
    private int inicio = 0;
    private int fim = 0;
    private int tamanho = 0;

    // Adiciona um valor no final da fila
    public void enfileirar(int valor) {
        if (tamanho < elementos.length) {
            elementos[fim] = valor;
            fim = (fim + 1) % elementos.length;
            tamanho++;
            System.out.println("Valor " + valor + " enfileirado.");
        } else {
            System.out.println("A fila está cheia!");
        }
    }

    // Remove o valor do início da fila
    public void desenfileirar() {
        if (tamanho > 0) {
            int valor = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            System.out.println("Valor " + valor + " desenfileirado.");
        } else {
            System.out.println("A fila está vazia!");
        }
    }

    // Mostra o conteúdo atual da fila
    public void mostrar() {
        System.out.print("Fila atual: ");
        if (tamanho == 0) {
            System.out.println("(vazia)");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % elementos.length;
            System.out.print(elementos[indice] + " ");
        }
        System.out.println();
    }

    // Exemplo de uso da classe Fila
    public static void main(String[] args) {
        Fila fila = new Fila();

        System.out.println("Enfileirando valores...");
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.enfileirar(40);
        fila.enfileirar(50);
        fila.enfileirar(60); // excede o limite
        fila.mostrar();

        System.out.println("\nDesenfileirando dois valores...");
        fila.desenfileirar();
        fila.desenfileirar();
        fila.mostrar();

        System.out.println("\nEnfileirando mais valores...");
        fila.enfileirar(70);
        fila.enfileirar(80);
        fila.mostrar();
    }
}
