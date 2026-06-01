package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiles  {
	private int posX, posY;
	private final int largura = 48, altura = 48;
	private String caminhoImg;
	private Image imagemAtual;
	private Image imagemGrade, imagemChaoClaro, imagemChaoEscuro, imagemCeuEstrelado;
	private Image imagemBranco, imagemCinza, imagemPortaCenario6;
	private boolean colisao;
	
	
	public Tiles() {
	    this.carregaImagemTile();
	}

public void desenhaTile(Graphics d2, int linha, int coluna) {
	this.posX = coluna * this.largura;
	this.posY = linha * this.altura;
	d2.drawImage(this.imagemAtual, this.posX, this.posY, this.largura, this.altura, null);
	}

private void carregaImagemTile() {
	ImageIcon icon;
	icon = new ImageIcon("res_cenario/tiles/grade.png");
	this.imagemGrade = icon.getImage();
	icon = new ImageIcon("res_cenario/tiles/chao_claro.png");
	this.imagemChaoClaro = icon.getImage();
	icon = new ImageIcon("res_cenario/tiles/chao_escuro.png");
	this.imagemChaoEscuro = icon.getImage();
	icon = new ImageIcon("res_cenario/tiles/ceu_estrelado.png");
	this.imagemCeuEstrelado = icon.getImage();
	icon = new ImageIcon("res_cenario/tiles/grade.png");
	this.imagemBranco = icon.getImage();
	icon = new ImageIcon("res_cenario/tiles/chao_claro.png");
	this.imagemCinza = icon.getImage();
	icon = new ImageIcon("res_cenario/tiles/portacenário6.png");
	this.imagemPortaCenario6 = icon.getImage();
}

public void carregaPecaDaMatriz(int valorDaPeca) {
	if (valorDaPeca == 0) {
		this.imagemAtual = this.imagemCeuEstrelado;
		this.colisao= true; //não permite a passagem.
	}
	if (valorDaPeca == 1) {
		this.imagemAtual = this.imagemChaoClaro;
		this.colisao = true; // não permite a passagem.
	}
	if (valorDaPeca == 2) {
		this.imagemAtual = this.imagemChaoEscuro;
		this.colisao = false; // permite a passagem.
	}
	if (valorDaPeca == 3) {
		this.imagemAtual = this.imagemGrade;
		this.colisao = true; // não permite a passagem.
	}
	
	if (valorDaPeca == 4) {
		this.imagemAtual = this.imagemPortaCenario6;
		this.colisao = true; // ajuste se a porta deve ser atravessável.
	}
	//if (this.colisao == true) this.imgAtual = this.imgGray;
	//else this.imgAtual = this.imgWhite;

}

	public boolean isColisao() {
		return colisao;
	}
	public void setColisao(boolean colisao) {
		this.colisao = colisao;
	}

}
