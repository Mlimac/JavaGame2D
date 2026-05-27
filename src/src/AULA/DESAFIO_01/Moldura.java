package AULA.DESAFIO_01;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Moldura extends JFrame {
	public Moldura() {
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("Cap11 - COLLISION_DETECTION");
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Painel PC = new Painel("Centro");
        Painel PS = new Painel("Sul");
        this.add(PC, BorderLayout.CENTER);
        this.add(PS, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

		}
	}
