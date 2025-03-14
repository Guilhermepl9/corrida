package scr.main.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CorridaGUI extends JFrame {
    private JProgressBar progressBarRelampago;
    private JProgressBar progressBarTrovao;
    private JProgressBar progressBarVentania;
    private JProgressBar progressBarFurao;
    private JButton startButton;
    private JLabel labelRelampago;
    private JLabel labelTrovao;
    private JLabel labelVentania;
    private JLabel labelFurao;
    private JLabel imagemRelampago;
    private JLabel imagemTrovao;
    private JLabel imagemVentania;
    private JLabel imagemFurao;

    public CorridaGUI() {
        initComponents();
    }

    private void initComponents() {
        // Configuração da janela
        setTitle("Corrida de Cavalos");
        setSize(800, 400); // Aumentei o tamanho para acomodar as imagens
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2)); // Layout de 5 linhas e 2 colunas

        // Inicialização dos componentes
        progressBarRelampago = new JProgressBar(0, 50);
        progressBarTrovao = new JProgressBar(0, 50);
        progressBarVentania = new JProgressBar(0, 50);
        progressBarFurao = new JProgressBar(0, 50);

        labelRelampago = new JLabel("Relâmpago");
        labelTrovao = new JLabel("Trovão");
        labelVentania = new JLabel("Ventania");
        labelFurao = new JLabel("Furacão");

        // Carregando as imagens dos cavalos
        imagemRelampago = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/relampago.png")));
        // Adicione este código após tentar carregar cada imagem:
if (getClass().getClassLoader().getResource("imagens/relampago.png") == null) {
    System.out.println("Imagem não encontrada!");
}
        imagemTrovao = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/trovao.png")));
        // Adicione este código após tentar carregar cada imagem:
if (getClass().getClassLoader().getResource("imagens/trovao.png") == null) {
    System.out.println("Imagem não encontrada!");
}
        imagemVentania = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/ventania.png")));
        // Adicione este código após tentar carregar cada imagem:
if (getClass().getClassLoader().getResource("imagens/ventania.png") == null) {
    System.out.println("Imagem não encontrada!");
}
        imagemFurao = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/furao.png")));
// Adicione este código após tentar carregar cada imagem:
if (getClass().getClassLoader().getResource("imagens/furao.png") == null) {
    System.out.println("Imagem não encontrada!");
}

        startButton = new JButton("Iniciar Corrida");

        // Adicionando componentes à janela
        add(imagemRelampago);
        add(labelRelampago);
        add(progressBarRelampago);
        add(imagemTrovao);
        add(labelTrovao);
        add(progressBarTrovao);
        add(imagemVentania);
        add(labelVentania);
        add(progressBarVentania);
        add(imagemFurao);
        add(labelFurao);
        add(progressBarFurao);
        add(startButton);

        // Configuração do botão
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarCorrida();
            }
        });
    }

    private void iniciarCorrida() {
        // Lógica da corrida
        new Thread(() -> {
            while (true) {
                moverCavalo(progressBarRelampago);
                moverCavalo(progressBarTrovao);
                moverCavalo(progressBarVentania);
                moverCavalo(progressBarFurao);

                // Verifica se algum cavalo chegou ao final
                if (progressBarRelampago.getValue() >= 50 ||
                    progressBarTrovao.getValue() >= 50 ||
                    progressBarVentania.getValue() >= 50 ||
                    progressBarFurao.getValue() >= 50) {
                    JOptionPane.showMessageDialog(this, "Corrida terminada!");
                    break;
                }

                try {
                    Thread.sleep(200); // Pausa para animação
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void moverCavalo(JProgressBar progressBar) {
        Random rand = new Random();
        int passo = rand.nextInt(3) + 1; // Passo aleatório entre 1 e 3
        progressBar.setValue(progressBar.getValue() + passo);
    }

    public static void main(String[] args) {
        // Executa a interface gráfica
        java.awt.EventQueue.invokeLater(() -> {
            new CorridaGUI().setVisible(true);
        });
    }
}

