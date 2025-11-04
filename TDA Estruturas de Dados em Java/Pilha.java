package TDA;

public class Pilha {

    private int[] elementos = new int[5];
    private int topo = -1;

    // Método para empilhar valores
    public void empilhar(int valor) {
        if (topo < elementos.length - 1) {
            topo++;
            elementos[topo] = valor;
            System.out.println("Valor " + valor + " empilhado.");
        } else {
            System.out.println("A pilha está cheia!");
        }
    }

    // Método para desempilhar o topo
    public void desempilhar() {
        if (topo >= 0) {
            int valor = elementos[topo];
            topo--;
            System.out.println("Valor " + valor + " desempilhado.");
        } else {
            System.out.println("A pilha está vazia!");
        }
    }

    // Método para mostrar a pilha
    public void mostrar() {
        System.out.print("Pilha atual (topo → base): ");
        if (topo == -1) {
            System.out.println("(vazia)");
            return;
        }
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    // Exemplo de uso da classe Pilha
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        System.out.println("\nEmpilhando valores...");
        pilha.empilhar(15);
        pilha.empilhar(25);
        pilha.empilhar(35);
        pilha.empilhar(45);
        pilha.mostrar();

        System.out.println("\nDesempilhando o topo...");
        pilha.desempilhar();
        pilha.mostrar();

        System.out.println("\nEmpilhando mais valores...");
        pilha.empilhar(55);
        pilha.empilhar(65);
        pilha.empilhar(75); // este deve falhar (limite 5)
        pilha.mostrar();

        System.out.println("\nDesempilhando todos...");
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.desempilhar(); // agora pilha vazia
        pilha.desempilhar(); // tentativa extra para testar limite inferior
    }
}

