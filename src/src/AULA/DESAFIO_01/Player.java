package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {

	Image[] imgPlayerDown = new Image[3];
	Image[] imgPlayerRight = new Image[3];
	Image[] imgPlayerLeft = new Image[3];
	Image[] imgPlayerUp = new Image[3];

	private int frameJogador = 0;

	Rectangle areaColisao;

	public int posX, posY;

	private int Larg, Altu;

	public int passo = 3;

	private Image imagemPlayer;

	// Quantidade de chaves do jogador
	private int quantidadeChaves = 0;

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

		for (int i = 0; i < 3; i++) {
			this.imgPlayerDown[i] = loadImage("res_cenario/PLAYERS/down" + (i + 1) + ".png");
			this.imgPlayerRight[i] = loadImage("res_cenario/PLAYERS/right" + (i + 1) + ".png");
			this.imgPlayerLeft[i] = loadImage("res_cenario/PLAYERS/left" + (i + 1) + ".png");
			this.imgPlayerUp[i] = loadImage("res_cenario/PLAYERS/up" + (i + 1) + ".png");
		}

		this.imagemPlayer = this.imgPlayerDown[this.frameJogador];
	}

	private Image loadImage(String resourcePath) {
		java.net.URL url = this.getClass().getClassLoader().getResource(resourcePath);

		if (url != null) {
			return new ImageIcon(url).getImage();
		}

		java.io.File f = new java.io.File(resourcePath);

		if (!f.exists()) {
			f = new java.io.File("JavaGame2D/" + resourcePath);
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

	// Adicionar chave ao jogador
	public void adicionarChave() {
		this.quantidadeChaves++;
		System.out.println("Chave coletada! Total de chaves: " + this.quantidadeChaves);
	}

	// Verifica se tem chave
	public boolean temChave() {
		return this.quantidadeChaves > 0;
	}

	// Usa uma chave para abrir porta
	public boolean usarChave() {
		if (this.quantidadeChaves > 0) {
			this.quantidadeChaves--;
			System.out.println("Chave usada! Chaves restantes: " + this.quantidadeChaves);
			return true;
		}

		return false;
	}

	// Apenas para mostrar ou consultar
	public int getQuantidadeChaves() {
		return this.quantidadeChaves;
	}
}