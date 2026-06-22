package AULA.DESAFIO_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaInicio extends JPanel implements KeyListener, Runnable {

    // Estado atual da tela
    private String estado = "HISTORIA"; // HISTORIA → MENU

    private Moldura janela;

    // Linhas da história
    private String[] historia = {
            "Nova York, dias atuais.",
            "O Destruidor atacou o esconderijo",
            "e capturou o Mestre Splinter",
            "e as Tartarugas Ninja.",
            "",
            "Rafael foi o unico",
            "que conseguiu escapar.",
            "",
            "Reuna as chaves, colete as pizzas,",
            "abra os portões e as prisões,",
            "e liberte sua familia!"
    };

    // Controle de digitação
    private int linhaAtual = 0;
    private int charAtual = 0;
    private String[] linhasVisiveis = new String[historia.length];
    private long ultimoTick = 0;

    // Piscar do indicador ENTER
    private boolean mostrarENTER = true;
    private long ultimoPiscar = 0;

    // Menu
    private String[] opcoes = { "Iniciar Jogo", "Sair" };
    private int opcaoSelecionada = 0;

    public TelaInicio(Moldura janela) {
        this.janela = janela;
        this.setPreferredSize(new Dimension(768, 580));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        for (int i = 0; i < linhasVisiveis.length; i++)
            linhasVisiveis[i] = "";

        new Thread(this).start();
    }

    // Loop principal (~60fps)
    public void run() {
        while (true) {
            atualizar();
            repaint();
            try {
                Thread.sleep(16);
            } catch (Exception e) {
            }
        }
    }

    private void atualizar() {
        long agora = System.currentTimeMillis();

        // Pisca o indicador de ENTER a cada 500ms
        if (agora - ultimoPiscar > 500) {
            mostrarENTER = !mostrarENTER;
            ultimoPiscar = agora;
        }

        // Digita a história letra por letra (a cada 40ms)
        if (estado.equals("HISTORIA") && linhaAtual < historia.length) {
            if (agora - ultimoTick > 40) {
                String linha = historia[linhaAtual];

                if (charAtual < linha.length()) {
                    charAtual++;
                    linhasVisiveis[linhaAtual] = linha.substring(0, charAtual);
                } else {
                    // Linha completa: vai para a próxima
                    linhasVisiveis[linhaAtual] = linha;
                    linhaAtual++;
                    charAtual = 0;
                }

                ultimoTick = agora;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Fundo preto
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        if (estado.equals("HISTORIA"))
            desenharHistoria(g2);
        if (estado.equals("MENU"))
            desenharMenu(g2);
    }

    // Método auxiliar: desenha texto com sombra (efeito 2D)
    private void desenharTexto2D(Graphics2D g2, String texto, int x, int y, Color cor) {
        // Sombra (deslocada 2px para baixo e para direita)
        g2.setColor(Color.BLACK);
        g2.drawString(texto, x + 2, y + 2);
        // Texto principal
        g2.setColor(cor);
        g2.drawString(texto, x, y);
    }

    private void desenharHistoria(Graphics2D g2) {
        int w = getWidth();

        // Título com efeito 2D
        g2.setFont(new Font("Monospaced", Font.BOLD, 24));
        String titulo = " TARTARUGAS NINJA - O RESGATE DO MESTRE SPLINTER 🐭 ";
        int xTitulo = (w - g2.getFontMetrics().stringWidth(titulo)) / 2;
        desenharTexto2D(g2, titulo, xTitulo, 50, new Color(220, 180, 60));

        // Linha separadora
        g2.setColor(new Color(220, 180, 60, 80));
        g2.drawLine(60, 62, w - 60, 62);

        // Linhas da história
        g2.setFont(new Font("Monospaced", Font.PLAIN, 22));
        FontMetrics fm = g2.getFontMetrics();
        int startY = 90;
        int alturaLinha = fm.getHeight() + 4;

        for (int i = 0; i < linhasVisiveis.length; i++) {
            if (linhasVisiveis[i].isEmpty())
                continue;
            Color cor = (i < linhaAtual) ? new Color(100, 200, 100) : new Color(200, 255, 200);
            int x = (w - fm.stringWidth(linhasVisiveis[i])) / 2;
            desenharTexto2D(g2, linhasVisiveis[i], x, startY + i * alturaLinha, cor);
        }

        // Indicador piscante quando a história acabou
        if (linhaAtual >= historia.length && mostrarENTER) {
            g2.setFont(new Font("Monospaced", Font.PLAIN, 16));
            String msg = "> ENTER para continuar";
            int x = (w - g2.getFontMetrics().stringWidth(msg)) / 2;
            desenharTexto2D(g2, msg, x, 530, new Color(160, 160, 160));
        }
    }

    private void desenharMenu(Graphics2D g2) {
        int w = getWidth();
        int h = getHeight();

        // Título
        g2.setFont(new Font("Monospaced", Font.BOLD, 24));
        String titulo = " TARTARUGAS NINJA - O RESGATE DO MESTRE SPLINTER 🐭 ";
        int x = (w - g2.getFontMetrics().stringWidth(titulo)) / 2;
        desenharTexto2D(g2, titulo, x, h / 3, new Color(220, 180, 60));

        // Opções do menu
        g2.setFont(new Font("Monospaced", Font.BOLD, 22));
        FontMetrics fm = g2.getFontMetrics();
        for (int i = 0; i < opcoes.length; i++) {
            boolean sel = (i == opcaoSelecionada);
            String texto = (sel && mostrarENTER ? ">  " : "   ") + opcoes[i];
            Color cor = sel ? new Color(180, 255, 180) : new Color(80, 120, 80);
            int ox = (w - fm.stringWidth(texto)) / 2;
            desenharTexto2D(g2, texto, ox, h / 2 + i * 50, cor);
        }

        // Dica
        g2.setFont(new Font("Monospaced", Font.PLAIN, 16));
        String dica = "SETAS: navegar   ENTER: confirmar";
        int xd = (w - g2.getFontMetrics().stringWidth(dica)) / 2;
        g2.setColor(new Color(70, 70, 70));
        g2.drawString(dica, xd, h - 20);
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (estado.equals("HISTORIA")) {
            if (tecla == KeyEvent.VK_ENTER) {
                // Pula a digitação, mostra tudo de uma vez
                for (int i = 0; i < historia.length; i++)
                    linhasVisiveis[i] = historia[i];
                linhaAtual = historia.length;
                estado = "MENU";
            }
        } else if (estado.equals("MENU")) {
            if (tecla == KeyEvent.VK_UP)
                opcaoSelecionada = (opcaoSelecionada - 1 + opcoes.length) % opcoes.length;
            if (tecla == KeyEvent.VK_DOWN)
                opcaoSelecionada = (opcaoSelecionada + 1) % opcoes.length;
            if (tecla == KeyEvent.VK_ENTER) {
                if (opcaoSelecionada == 0)
                    janela.iniciarJogo();
                else
                    System.exit(0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}