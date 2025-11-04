package TDA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrincipalJFrame extends JFrame {

    private Lista lista = new Lista();
    private Pilha pilha = new Pilha();
    private Fila fila = new Fila();
    private JTextArea output;

    public PrincipalJFrame() {
        setTitle("TDA – Lista, Pilha e Fila");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de saída
        output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(output);

        // Painel de botões
        JPanel botoes = new JPanel(new GridLayout(4, 3, 5, 5));

        JButton btnListaInserir = new JButton("Inserir Lista");
        JButton btnListaMostrar = new JButton("Mostrar Lista");
        JButton btnEmpilhar = new JButton("Empilhar");
        JButton btnDesempilhar = new JButton("Desempilhar");
        JButton btnMostrarPilha = new JButton("Mostrar Pilha");
        JButton btnEnfileirar = new JButton("Enfileirar");
        JButton btnDesenfileirar = new JButton("Desenfileirar");
        JButton btnMostrarFila = new JButton("Mostrar Fila");
        JButton btnLimpar = new JButton("Limpar Saída");
        JButton btnSair = new JButton("Sair");

        // Adiciona os botões ao painel
        botoes.add(btnListaInserir);
        botoes.add(btnListaMostrar);
        botoes.add(btnEmpilhar);
        botoes.add(btnDesempilhar);
        botoes.add(btnMostrarPilha);
        botoes.add(btnEnfileirar);
        botoes.add(btnDesenfileirar);
        botoes.add(btnMostrarFila);
        botoes.add(btnLimpar);
        botoes.add(btnSair);

        // Ações dos botões
        btnListaInserir.addActionListener(e -> {
            int valor = pedirValor("Digite um valor para inserir na lista:");
            lista.inserir(valor);
            output.append("Inserido na lista: " + valor + "\n");
        });

        btnListaMostrar.addActionListener(e -> {
            output.append("Lista atual: ");
            lista.mostrar();
        });

        btnEmpilhar.addActionListener(e -> {
            int valor = pedirValor("Digite um valor para empilhar:");
            pilha.empilhar(valor);
            output.append("Empilhado: " + valor + "\n");
        });

        btnDesempilhar.addActionListener(e -> pilha.desempilhar());

        btnMostrarPilha.addActionListener(e -> {
            output.append("Pilha atual: ");
            pilha.mostrar();
        });

        btnEnfileirar.addActionListener(e -> {
            int valor = pedirValor("Digite um valor para enfileirar:");
            fila.enfileirar(valor);
            output.append("Enfileirado: " + valor + "\n");
        });

        btnDesenfileirar.addActionListener(e -> fila.desenfileirar());

        btnMostrarFila.addActionListener(e -> {
            output.append("Fila atual: ");
            fila.mostrar();
        });

        btnLimpar.addActionListener(e -> output.setText(""));

        btnSair.addActionListener(e -> System.exit(0));

        // Layout da janela
        add(botoes, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private int pedirValor(String mensagem) {
        String input = JOptionPane.showInputDialog(this, mensagem);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido!");
            return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PrincipalJFrame().setVisible(true);
        });
    }
}
