package AULA.DESAFIO_01;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Moldura extends JFrame {

    public Moldura() {
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setTitle("Cap11 - COLLISION_DETECTION");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Começa na tela de início em vez do jogo direto
        TelaInicio telaInicio = new TelaInicio(this);
        this.add(telaInicio, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        telaInicio.requestFocusInWindow();
    }

    // Chamado pela TelaInicio quando o jogador escolhe "Iniciar Jogo"
    public void iniciarJogo() {
        SwingUtilities.invokeLater(() -> {
            this.getContentPane().removeAll();

            Painel PC = new Painel("Centro");
            Painel PS = new Painel("Sul", PC);

            this.add(PC, BorderLayout.CENTER);
            this.add(PS, BorderLayout.SOUTH);

            this.revalidate();
            this.repaint();
            this.pack();
            this.setLocationRelativeTo(null);

            PC.requestFocusInWindow();
        });
    }
}