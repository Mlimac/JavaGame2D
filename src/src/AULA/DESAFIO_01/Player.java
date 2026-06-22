package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {

	private static final int PLAYER_FRAMES = 4;

	Image[] imgPlayerDown = new Image[PLAYER_FRAMES];
	Image[] imgPlayerRight = new Image[PLAYER_FRAMES];
	Image[] imgPlayerLeft = new Image[PLAYER_FRAMES];
	Image[] imgPlayerUp = new Image[PLAYER_FRAMES];

	private int frameJogador = 0;

	Rectangle areaColisao;

	public int posX, posY;

	private int Larg, Altu;

	public int passo = 3;

	private Image imagemPlayer;

	// Quantidade de chaves do jogador
	private int chavesDouradas = 0;
	private int chavesPrateadas = 0;
	private int quantidadePizzas = 0;

	public Player() {
		this.posX = 200;
		this.posY = 100;
		this.Larg = 48;
		this.Altu = 48;

		areaColisao = new Rectangle();

		this.areaColisao.x = this.posX + 3;
		this.areaColisao.y = this.posY + this.Altu / 2;
		this.areaColisao.width = this.Larg - 20;
		this.areaColisao.height = this.Altu / 2;

		for (int i = 0; i < PLAYER_FRAMES; i++) {
			this.imgPlayerDown[i] = loadImage("PLAYERS/baixo/down" + (i + 1) + ".png");
			this.imgPlayerRight[i] = loadImage("PLAYERS/direita/right" + (i + 1) + ".png");
			this.imgPlayerLeft[i] = loadImage("PLAYERS/esquerda/left" + (i + 1) + ".png");
			this.imgPlayerUp[i] = loadImage("PLAYERS/cima/up" + (i + 1) + ".png");
		}

		this.imagemPlayer = this.imgPlayerDown[this.frameJogador];
	}

	private Image loadImage(String resourcePath) {
		String normalizedPath = resourcePath.startsWith("/") ? resourcePath.substring(1) : resourcePath;
		java.net.URL url = this.getClass().getClassLoader().getResource(normalizedPath);

		if (url != null) {
			return new ImageIcon(url).getImage();
		}

		java.io.File f = new java.io.File(normalizedPath);

		if (!f.exists()) {
			f = new java.io.File("JavaGame2D/" + normalizedPath);
		}

		if (f.exists()) {
			return new ImageIcon(f.getAbsolutePath()).getImage();
		}

		return new ImageIcon(
				new java.awt.image.BufferedImage(48, 48, java.awt.image.BufferedImage.TYPE_INT_ARGB)).getImage();
	}

	public void DesenharPlayer(Graphics d2) {
		d2.drawImage(imagemPlayer, posX, posY, Larg, Altu, null);
	}

	public void atualizaPosicaoJogador(boolean ME, boolean MD, boolean MC, boolean MB) {
		if (ME) {
			this.posX -= passo;
		}

		if (MD) {
			this.posX += passo;
		}

		if (MC) {
			this.posY -= passo;
		}

		if (MB) {
			this.posY += passo;
		}

		atualizarAreaColisao();
	}

	public void atualizarAreaColisao() {
		this.areaColisao.x = this.posX + 3;
		this.areaColisao.y = this.posY + this.Altu / 2;
		this.areaColisao.width = this.Larg - 20;
		this.areaColisao.height = this.Altu / 2;
	}

	public void atualizaSprite(boolean moveEsq, boolean moveCima, boolean moveDir, boolean moveBaixo) {
		this.frameJogador++;

		if (moveEsq) {
			if (frameJogador >= this.imgPlayerLeft.length) {
				frameJogador = 0;
			}

			this.imagemPlayer = this.imgPlayerLeft[frameJogador];
		}

		if (moveDir) {
			if (frameJogador >= this.imgPlayerRight.length) {
				frameJogador = 0;
			}

			this.imagemPlayer = this.imgPlayerRight[frameJogador];
		}

		if (moveCima) {
			if (frameJogador >= this.imgPlayerUp.length) {
				frameJogador = 0;
			}

			this.imagemPlayer = this.imgPlayerUp[frameJogador];
		}

		if (moveBaixo) {
			if (frameJogador >= this.imgPlayerDown.length) {
				frameJogador = 0;
			}

			this.imagemPlayer = this.imgPlayerDown[frameJogador];
		}
	}

	public void adicionarChaveDourada() {
		chavesDouradas++;
	}

	public void adicionarChavePrateada() {
		chavesPrateadas++;
	}

	public void adicionarPizza() {
		this.quantidadePizzas++;
	}

	public boolean temChaveDourada() {
		return chavesDouradas > 0;
	}

	public boolean temChavePrateada() {
		return chavesPrateadas > 0;
	}

	public void usarChaveDourada() {
		if (chavesDouradas > 0)
			chavesDouradas--;
	}

	public void usarChavePrateada() {
		if (chavesPrateadas > 0)
			chavesPrateadas--;
	}

	public int getChavesDouradas() {
		return chavesDouradas;
	}

	public int getChavesPrateadas() {
		return chavesPrateadas;
	}

	public int getQuantidadePizzas() {
		return this.quantidadePizzas;
	}
}