package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiles {
	private int posX, posY;
	private final int largura = 48, altura = 48;
	private String caminhoImg;
	private Image imgAtual;
	private Image imgGrass, imgSand, imgWall, imgWater;
	private Image imgWhite, imgGray;
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
		this.imgGrass = loadImage("res_cenario/tiles/grade.png");
		this.imgSand = loadImage("res_cenario/tiles/chao_claro.png");
		this.imgWater = loadImage("res_cenario/tiles/chao_escuro.png");
		this.imgWall = loadImage("res_cenario/tiles/ceu_estrelado.png");
		this.imgWhite = loadImage("res_cenario/tiles/grade.png");
		this.imgGray = loadImage("res_cenario/tiles/chao_claro.png");
	}

	private Image loadImage(String resourcePath) {
		java.net.URL url = this.getClass().getClassLoader().getResource(resourcePath);
		if (url != null)
			return new ImageIcon(url).getImage();
		java.io.File f = new java.io.File(resourcePath);
		if (!f.exists())
			f = new java.io.File("JavaGame2D/" + resourcePath);
		if (f.exists())
			return new ImageIcon(f.getAbsolutePath()).getImage();
		return new javax.swing.ImageIcon(
				new java.awt.image.BufferedImage(this.largura, this.altura, java.awt.image.BufferedImage.TYPE_INT_ARGB))
				.getImage();
	}

	public void carregaPecaDaMatriz(int valorDaPeca) {
		if (valorDaPeca == 0) {
			this.imgAtual = this.imgWall;
			this.colisao = true; // não permite a passagem.
		}
		if (valorDaPeca == 1) {
			this.imgAtual = this.imgSand;
			this.colisao = true; // permite a passagem.
		}
		if (valorDaPeca == 2) {
			this.imgAtual = this.imgWater;
			this.colisao = false; // permite a passagem.
		}
		if (valorDaPeca == 3) {
			this.imgAtual = this.imgGrass;
			this.colisao = true; // não permite a passagem.
		}
		if (valorDaPeca == 4) {
			this.imgAtual = this.imgWhite;
			this.colisao = false; // permite a passagem.
		}
		if (valorDaPeca == 5) {
			this.imgAtual = this.imgGray;
			this.colisao = true; // permite a passagem.
		}
		// if (this.colisao == true) this.imgAtual = this.imgGray;
		// else this.imgAtual = this.imgWhite;

	}

	public boolean isColisao() {
		return colisao;
	}

	public void setColisao(boolean colisao) {
		this.colisao = colisao;
	}

}
