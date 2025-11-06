public class ArvoreBinariaDeBusca {
    No raiz;

    public ArvoreBinariaDeBusca() {
        raiz = null;
    }

    // Inserir valor na árvore
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }
        // se for igual, não insere (evita repetidos)
        return atual;
    }

    // Percurso em ordem (ordenado)
    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }

    // Altura da árvore
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no) {
        if (no == null) {
            return 0;
        }
        int altEsq = alturaRec(no.esquerda);
        int altDir = alturaRec(no.direita);
        return 1 + Math.max(altEsq, altDir);
    }

    // Exibir folhas (nós sem filhos)
    public void folhas() {
        System.out.print("Folhas: ");
        folhasRec(raiz);
        System.out.println();
    }

    private void folhasRec(No no) {
        if (no != null) {
            if (no.esquerda == null && no.direita == null) {
                System.out.print(no.valor + " ");
            }
            folhasRec(no.esquerda);
            folhasRec(no.direita);
        }
    }
}

