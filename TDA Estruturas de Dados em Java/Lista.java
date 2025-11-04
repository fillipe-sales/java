package TDA;

public class Lista {

    // Vetor com capacidade para 5 elementos
    private int[] elementos = new int[5];
    private int tamanho = 0;

    // Inserir um valor na lista
    public void inserir(int valor) {
        if (tamanho < elementos.length) {
            elementos[tamanho] = valor;
            tamanho++;
            System.out.println("Valor " + valor + " inserido na lista.");
        } else {
            System.out.println("A lista está cheia!");
        }
    }

    // Mostra todos os valores armazenados
    public void mostrar() {
        System.out.print("Lista atual: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    // Exemplo
    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("Inserindo valores na lista...");
        lista.inserir(5);
        lista.inserir(8);
        lista.inserir(12);
        lista.inserir(20);
        lista.inserir(33);

        // Tentativa de inserir além do limite
        lista.inserir(40);

        // Exibir a lista final
        lista.mostrar();
    }
}
