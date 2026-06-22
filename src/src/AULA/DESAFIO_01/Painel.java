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
			setBackground(new Color(0, 0, 0, 0)); // transparente);
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
		this.cenario = new tileMap();
		this.cenario.tileInvent();
		this.setPreferredSize(new Dimension(768, 96));
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

			if (this.cenario.jogoFinalizado) {
				D2.setColor(new java.awt.Color(0, 0, 0, 220));
				D2.fillRect(0, 0, this.getWidth(), this.getHeight());

				// "Cowabunga!"
				D2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 72));
				String titulo = "Cowabunga!";
				int larguraTitulo = D2.getFontMetrics().stringWidth(titulo);
				D2.setColor(new java.awt.Color(0, 255, 0));
				D2.drawString(titulo, (this.getWidth() - larguraTitulo) / 2, 200);

				// "Parabéns por finalizar o jogo!"
				D2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 36));
				String subtitulo = "Parabéns por finalizar o jogo!";
				String subtitulo2 = "Aproveite suas pizzas :)";

				int larguraSubtitulo = D2.getFontMetrics().stringWidth(subtitulo);
				D2.setColor(java.awt.Color.WHITE);
				D2.drawString(subtitulo, (this.getWidth() - larguraSubtitulo) / 2, 300);
				D2.drawString(subtitulo2, (this.getWidth() - D2.getFontMetrics().stringWidth(subtitulo2)) / 2, 350);
			 }
		}

		if (this.Posicao.equals("Sul")) {
			this.cenario.desenhar(D2);
			desenharInventario(D2);
		}
	}

	private void desenharInventario(Graphics2D D2) {
		D2.setColor(Color.GREEN);
		D2.setFont(new Font("Arial", Font.BOLD, 24));

		int douradas = 0;
		int prateadas = 0;
		int pizzas = 0;

		if (painelCentral != null && painelCentral.Jogador != null) {
			douradas = painelCentral.Jogador.getChavesDouradas();
			prateadas = painelCentral.Jogador.getChavesPrateadas();
			pizzas = painelCentral.Jogador.getQuantidadePizzas();
		}

		D2.drawString("Inventário", 30, 35);
		D2.drawString("Chaves Douradas: " + douradas, 30, 70);
		D2.drawString("Chaves Prateadas: " + prateadas, 300, 70);
		D2.drawString("Pizzas: " + pizzas, 570, 70);
	}
}
