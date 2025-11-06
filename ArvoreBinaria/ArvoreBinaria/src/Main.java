//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // RA = 2403395 → sem repetidos: 2, 4, 0, 3, 9, 5
        int[] ra = {2, 4, 0, 3, 3, 9, 5};

        ArvoreBinariaDeBusca bst = new ArvoreBinariaDeBusca();

        // Inserir cada número na árvore
        for (int num : ra) {
            bst.inserir(num);
        }

        // Exibir resultados
        System.out.println("Raiz: " + bst.raiz.valor);
        System.out.print("Percurso em ordem: ");
        bst.emOrdem();
        System.out.println();
        bst.folhas();
        System.out.println("Altura da árvore: " + bst.altura());
    }
}
