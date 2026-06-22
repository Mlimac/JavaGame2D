package AULA.DESAFIO_01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Painel extends JPanel {

	private String Posicao;

	Player Jogador = new Player();

	GAMELOOP loopDoJogo;
	escutadorTeclado ET;
	SpriteLoop SL;
	tileMap cenario;

	// referência ao painel central
	private Painel painelCentral;

	// Construtor usado pelo painel central
	public Painel(String Posicao) {
		this.Posicao = Posicao;

		if (Posicao.equals("Centro")) {
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(768, 480));

			ET = new escutadorTeclado();
			this.addKeyListener(ET);
			this.setFocusable(true);

			this.cenario = new tileMap();

			loopDoJogo = new GAMELOOP(this, ET);
			loopDoJogo.start();

			SL = new SpriteLoop(this, ET);
			SL.start();

		} else {
			this.setPreferredSize(new Dimension(768, 100));
			this.setBackground(Color.YELLOW);
		}
	}

	// construtor usado pelo painel sul
	public Painel(String Posicao, Painel painelCentral) {
		this.Posicao = Posicao;
		this.painelCentral = painelCentral;

		this.setPreferredSize(new Dimension(768, 100));
		this.setBackground(Color.YELLOW);
	}

	public void paintComponent(Graphics D) {
		super.paintComponent(D);

		Graphics2D D2 = (Graphics2D) D;

		D2.setColor(this.getBackground());
		D2.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (this.Posicao.equals("Centro")) {
			this.cenario.desenhar(D2);
			Jogador.DesenharPlayer(D2);
		}

		if (this.Posicao.equals("Sul")) {
			desenharInventario(D2);
		}
	}

	private void desenharInventario(Graphics2D D2) {
		D2.setColor(Color.BLACK);
		D2.setFont(new Font("Arial", Font.BOLD, 24));

		int quantidadeChaves = 0;

		if (painelCentral != null && painelCentral.Jogador != null) {
			quantidadeChaves = painelCentral.Jogador.getQuantidadeChaves();
		}

		D2.drawString("Inventário", 30, 35);
		D2.drawString("Chaves: " + quantidadeChaves, 30, 70);
	}
}