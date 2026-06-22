package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiles {

	private int posX, posY;

	private final int largura = 48;
	private final int altura = 48;

	private Image imgAtual;

	private Image imgGrass;
	private Image imgSand;
	private Image imgWall;
	private Image imgWater;
	private Image imgDoor;
	private Image imgKey;

	private boolean colisao;

	public Tiles() {
		this.carregaImagemTile();
	}

	public void desenhaTile(Graphics d2, int linha, int coluna) {
		this.posX = coluna * this.largura;
		this.posY = linha * this.altura;

		d2.drawImage(this.imgAtual, this.posX, this.posY, this.largura, this.altura, null);
	}

	private void carregaImagemTile() {
		this.imgGrass = loadImage("/tiles/grade.png");
		this.imgSand = loadImage("/tiles/chao_claro.png");
		this.imgWater = loadImage("/tiles/chao_escuro.png");
		this.imgWall = loadImage("/tiles/ceu_estrelado.png");

		// Imagens da porta e da chave
		this.imgDoor = loadImage("/tiles/door.png");
		this.imgKey = loadImage("/tiles/key.png");
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
				new java.awt.image.BufferedImage(this.largura, this.altura, java.awt.image.BufferedImage.TYPE_INT_ARGB))
				.getImage();
	}

	public void carregaPecaDaMatriz(int valorDaPeca) {

		if (valorDaPeca == 0) {
			this.imgAtual = this.imgWall;
			this.colisao = true;
		}

		if (valorDaPeca == 1) {
			this.imgAtual = this.imgSand;
			this.colisao = true;
		}

		if (valorDaPeca == 2) {
			this.imgAtual = this.imgWater;
			this.colisao = false;
		}

		if (valorDaPeca == 3) {
			this.imgAtual = this.imgGrass;
			this.colisao = true;
		}

		// tile 4 agora é porta trancada
		if (valorDaPeca == 4) {
			this.imgAtual = this.imgDoor;
			this.colisao = true;
		}

		// tile 5 agora é chave
		if (valorDaPeca == 5) {
			this.imgAtual = this.imgKey;
			this.colisao = false;
		}
	}

	public boolean isColisao() {
		return colisao;
	}

	public void setColisao(boolean colisao) {
		this.colisao = colisao;
	}
}