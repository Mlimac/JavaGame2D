package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiles {

	private int posX, posY;

	private final int largura = 48;
	private final int altura = 48;

	private Image imgAtual;

	private Image imggrade;
	private Image imgSand;
	private Image imgWall;
	private Image imgAguaEsgoto;
	private Image imgDoor;
	private Image imgKey;
	private Image imgSilverKey;
	private Image imgBueiro;
	private Image imgCama;
	private Image imgPortaCenario5;
	private Image imgGrama;
	private Image imgLinhaAmarela;
	private Image imgRua;
	private Image imgChaoEscuro;
	private Image imgCamaSuperiorE;
	private Image imgCamaSuperiorD;
	private Image imgCamaInferiorE;
	private Image imgCamaInferiorD;
	private Image imgChaoCenario1;
	private Image imgbueirocenario1;
	private Image imgparedeescura;
	private Image imgcaminhao_verdeF;
	private Image imgcaminhao_verdeT;
	private Image imgonibus_T;
	private Image imgonibus_M;
	private Image imgonibus_F;
	private Image imgcaminhao_brancoT;
	private Image imgcaminhao_brancoM;
	private Image imgcaminhao_brancoF;
	private Image imgonibus_cinzaTImage;
	private Image imgonibus_cinzaMImage;
	private Image imgonibus_cinzaFImage;
	private Image imgcarrovermelhoT;
	private Image imgcarrovermelhoF;
	private Image imgcaminhaotanque1;
	private Image imgcaminhaotanque2;
	private Image imgcaminhaotanque3;
	private Image imgcaminhaotanque4;
	private Image imgcaminhaotanque5;
	private Image imgbancoD;
	private Image imgbancoE;
	private Image imgmoita;
	private Image imglixeira;
	private Image imgplacacuidado;
	private Image imgbarreira;
	private Image imgbicicleta;
	private Image imgchaocenario4;
	private Image imgtocha;
	private Image imgtocha2;
	private Image imgtocha3;
	private Image imgmesa1;
	private Image imgmesa2;
	private Image imglampada;
	private Image imglampada2;
	private Image imgparedeescura2;
	private Image imgchaocenario5;
	private Image imgchao1cenario6;
	private Image imgchao2cenario6;
    private Image imgpizza;

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
		this.imggrade = loadImage("res_cenario/tiles/grade.png");
		this.imgSand = loadImage("res_cenario/tiles/chao_claro.png");
		java.net.URL urlAg = this.getClass().getClassLoader().getResource("res_cenario/tiles/agua_esgoto.png");
		java.io.File fileAg = new java.io.File("res_cenario/tiles/agua_esgoto.png");
		if (urlAg != null || fileAg.exists()) {
			this.imgAguaEsgoto = loadImage("res_cenario/tiles/agua_esgoto.png");
		} else {
			this.imgAguaEsgoto = loadImage("res_cenario/tiles/chao_escuro.png");
		}

		// register other available tiles
		this.imgChaoEscuro = loadImage("res_cenario/tiles/chao_escuro.png");
		this.imgBueiro = loadImage("res_cenario/tiles/Bueiro.jpeg");
		this.imgCama = loadImage("res_cenario/tiles/cama.png");
		// try both possible porta filenames
		java.net.URL urlPorta = this.getClass().getClassLoader().getResource("res_cenario/tiles/porta_cenario05.png");
		if (urlPorta != null) {
			this.imgPortaCenario5 = loadImage("res_cenario/tiles/porta_cenario05.png");
		} else {
			this.imgPortaCenario5 = loadImage("res_cenario/tiles/porta_cenario5.png");
		}
		this.imgGrama = loadImage("res_cenario/tiles/grama.png");
		this.imgLinhaAmarela = loadImage("res_cenario/tiles/linha_amarela_rua.png");
		this.imgRua = loadImage("res_cenario/tiles/rua.png");
		this.imgWall = loadImage("res_cenario/tiles/ceu_estrelado.png");
		this.imgbancoD = loadImage("res_cenario/tiles/banco_D.png");
		this.imgbancoE = loadImage("res_cenario/tiles/banco_E.png");
		this.imgmoita = loadImage("res_cenario/tiles/moita.png");
		this.imglixeira = loadImage("res_cenario/tiles/lixeira.png");
		this.imgplacacuidado = loadImage("res_cenario/tiles/placa_cuidado.png");
		this.imgbarreira = loadImage("res_cenario/tiles/barreira.png");
		this.imgbicicleta = loadImage("res_cenario/tiles/bicicleta.png");
		this.imgchaocenario4 = loadImage("res_cenario/tiles/chao_cenario4.png");
		this.imgtocha = loadImage("res_cenario/tiles/tocha.jpeg");
		this.imgtocha2 = loadImage("res_cenario/tiles/tocha2.jpeg");
		this.imgtocha3 = loadImage("res_cenario/tiles/tocha3.png");
		this.imgmesa1 = loadImage("res_cenario/tiles/mesa1.png");
		this.imgmesa2 = loadImage("res_cenario/tiles/mesa2.png");
		this.imglampada = loadImage("res_cenario/tiles/lampada.png");
		this.imglampada2 = loadImage("res_cenario/tiles/lampada2.png");
		this.imgparedeescura2 = loadImage("res_cenario/tiles/parede_escura2.png");
		this.imgchaocenario5 = loadImage("res_cenario/tiles/chao_cenario5.png");
		this.imgPortaCenario5 = loadImage("res_cenario/tiles/porta_cenario05.png");
		this.imgchao1cenario6 = loadImage("res_cenario/tiles/chao1_cenario6.png");
		this.imgchao2cenario6 = loadImage("res_cenario/tiles/chao2_cenario6.png");


		//veiculos
		this.imgcaminhao_verdeF = loadImage("res_cenario/tiles/caminhao_verde_F.png");
		this.imgcaminhao_verdeT = loadImage("res_cenario/tiles/caminhao_verde_T.png");
		this.imgonibus_T = loadImage("res_cenario/tiles/onibus_T.png");
		this.imgonibus_M = loadImage("res_cenario/tiles/onibus_M.png");
		this.imgonibus_F = loadImage("res_cenario/tiles/onibus_F.png");
		this.imgcaminhao_brancoT = loadImage("res_cenario/tiles/caminhao_branco_T.png");
		this.imgcaminhao_brancoM = loadImage("res_cenario/tiles/caminhao_branco_M.png");
		this.imgcaminhao_brancoF = loadImage("res_cenario/tiles/caminhao_branco_F.png");
		this.imgonibus_cinzaTImage = loadImage("res_cenario/tiles/onibus_cinza_T.png");
		this.imgonibus_cinzaMImage = loadImage("res_cenario/tiles/onibus_cinza_M.png");
		this.imgonibus_cinzaFImage = loadImage("res_cenario/tiles/onibus_cinza_F.png");
		this.imgcarrovermelhoT = loadImage("res_cenario/tiles/carro_vermelho_T.png");
		this.imgcarrovermelhoF = loadImage("res_cenario/tiles/carro_vermelho_F.png");
		this.imgcaminhaotanque1 = loadImage("res_cenario/tiles/caminhao_tanque_1.png");
		this.imgcaminhaotanque2 = loadImage("res_cenario/tiles/caminhao_tanque_2.png");
		this.imgcaminhaotanque3 = loadImage("res_cenario/tiles/caminhao_tanque_3.png");
		this.imgcaminhaotanque4 = loadImage("res_cenario/tiles/caminhao_tanque_4.png");
		this.imgcaminhaotanque5 = loadImage("res_cenario/tiles/caminhao_tanque_5.png");

		// Imagens para a cama do cenário 1
		this.imgCamaSuperiorE = loadImage("res_cenario/tiles/cama_superiorE.png");
		this.imgCamaSuperiorD = loadImage("res_cenario/tiles/cama_superiorD.png");
		this.imgCamaInferiorE = loadImage("res_cenario/tiles/cama_inferiorE.png");
		this.imgCamaInferiorD = loadImage("res_cenario/tiles/cama_inferiorD.png");

		// Imagens do cenário 1
		this.imgChaoCenario1 = loadImage("res_cenario/tiles/chao_cenario1.png");
		this.imgbueirocenario1 = loadImage("res_cenario/tiles/bueiro_cenario1.png");
		this.imgparedeescura = loadImage("res_cenario/tiles/parede_escura.png");

		// Imagens da porta e da chave
		this.imgDoor = loadImage("res_cenario/tiles/door.png");
		this.imgKey = loadImage("res_cenario/tiles/key.png");
		this.imgSilverKey = loadImage("res_cenario/tiles/silver-key.png");
		this.imgpizza = loadImage("res_cenario/tiles/pizza.png");
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
			this.colisao = false;
		}

		if (valorDaPeca == 2) {
			this.imgAtual = this.imgAguaEsgoto;
			this.colisao = false;
		}
		//tile 3: grade
		if (valorDaPeca == 3) {
			this.imgAtual = this.imggrade;
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

		// tile 6: cama (colisao)
		if (valorDaPeca == 6) {
			this.imgAtual = this.imgCama;
			this.colisao = true;
		}

		// tile 7: porta_cenario5
		if (valorDaPeca == 7) {
			this.imgAtual = this.imgPortaCenario5;
			this.colisao = true;
		}

		// tile 8: bueiro
		if (valorDaPeca == 8) {
			this.imgAtual = this.imgBueiro;
			this.colisao = false;
		}

		// tile 9: grama
		if (valorDaPeca == 9) {
			this.imgAtual = this.imgGrama;
			this.colisao = false;
		}

		// tile 10: linha amarela da rua
		if (valorDaPeca == 10) {
			this.imgAtual = this.imgLinhaAmarela;
			this.colisao = false;
		}

		// tile 11: Rua
		if (valorDaPeca == 11) {
			this.imgAtual = this.imgRua;
			this.colisao = false;
		}

		// tile 12: chao_escuro 
		if (valorDaPeca == 12) {
			this.imgAtual = this.imgChaoEscuro;
			this.colisao = true;
		}
		// tile 13: cama do cenário 1
		if (valorDaPeca == 13) {
			this.imgAtual = this.imgCamaSuperiorE;
			this.colisao = true;
		}
		// tile 14: cama do cenário 1
		if (valorDaPeca == 14) {
			this.imgAtual = this.imgCamaSuperiorD;
			this.colisao = true;
		}
		// tile 15: cama do cenário 1
		if (valorDaPeca == 15) {
			this.imgAtual = this.imgCamaInferiorE;
			this.colisao = true;
		}
		 // tile 16: cama do cenário 1
		if (valorDaPeca == 16) {
			this.imgAtual = this.imgCamaInferiorD;
			this.colisao = true;
		}

		// tile 17: chao cenario 1 e 2
		if (valorDaPeca == 17) {
			this.imgAtual = this.imgChaoCenario1;
			this.colisao = false;
		}

		// tile 18: bueiro cenario 1 e 2
		if (valorDaPeca == 18) {
			this.imgAtual = this.imgbueirocenario1;
			this.colisao = false;
		}
		// tile 19: parede escura cenario 1 e 2
		if (valorDaPeca == 19) {
			this.imgAtual = this.imgparedeescura;
			this.colisao = true;
		}
		// tile 20: caminhão verde (frente)
		if (valorDaPeca == 20) {
			this.imgAtual = this.imgcaminhao_verdeF;
			this.colisao = true;
		}
		// tile 21: caminhão verde (traseira)
		if (valorDaPeca == 21) {
			this.imgAtual = this.imgcaminhao_verdeT;
			this.colisao = true;
		}
		// tile 22: ônibus (traseira)
		if (valorDaPeca == 22) {
			this.imgAtual = this.imgonibus_T;
			this.colisao = true;
		}
		// tile 23: ônibus (meio)
		if (valorDaPeca == 23) {
			this.imgAtual = this.imgonibus_M;
			this.colisao = true;
		}
		// tile 24: ônibus (frente)
		if (valorDaPeca == 24) {
			this.imgAtual = this.imgonibus_F;
			this.colisao = true;
		}
		// tile 25: caminhão branco (traseira)
		if (valorDaPeca == 25) {
			this.imgAtual = this.imgcaminhao_brancoT;
			this.colisao = true;
		}
		// tile 26: caminhão branco (meio)
		if (valorDaPeca == 26) {
			this.imgAtual = this.imgcaminhao_brancoM;
			this.colisao = true;
		}
		// tile 27: caminhão branco (frente)
		if (valorDaPeca == 27) {
			this.imgAtual = this.imgcaminhao_brancoF;
			this.colisao = true;
		}
		// tile 28: ônibus cinza (traseira)
		if (valorDaPeca == 28) {
			this.imgAtual = this.imgonibus_cinzaTImage;
			this.colisao = true;
		}
		// tile 29: ônibus cinza (meio)
		if (valorDaPeca == 29) {
			this.imgAtual = this.imgonibus_cinzaMImage;
			this.colisao = true;
		}
		// tile 30: ônibus cinza (frente)
		if (valorDaPeca == 30) {
			this.imgAtual = this.imgonibus_cinzaFImage;
			this.colisao = true;
		}
		// tile 31: carro vermelho (traseira)
		if (valorDaPeca == 31) {
			this.imgAtual = this.imgcarrovermelhoT;
			this.colisao = true;
		}
		// tile 32: carro vermelho (frente)
		if (valorDaPeca == 32) {
			this.imgAtual = this.imgcarrovermelhoF;
			this.colisao = true;
		}
		// tile 33: caminhão tanque (1)
		if (valorDaPeca == 33) {
			this.imgAtual = this.imgcaminhaotanque1;
			this.colisao = true;
		}
		// tile 34: caminhão tanque (2)
		if (valorDaPeca == 34) {
			this.imgAtual = this.imgcaminhaotanque2;
			this.colisao = true;
		}
		// tile 35: caminhão tanque (3)
		if (valorDaPeca == 35) {
			this.imgAtual = this.imgcaminhaotanque3;
			this.colisao = true;
		}
		// tile 36: caminhão tanque (4)
		if (valorDaPeca == 36) {
			this.imgAtual = this.imgcaminhaotanque4;
			this.colisao = true;
		}
		// tile 37: caminhão tanque (5)
		if (valorDaPeca == 37) {
			this.imgAtual = this.imgcaminhaotanque5;
			this.colisao = true;
		}
		// tile 38: banco (lado direito)
		if (valorDaPeca == 38) {
			this.imgAtual = this.imgbancoD;
			this.colisao = true;
		}
		// tile 39: banco (lado esquerdo)
		if (valorDaPeca == 39) {
			this.imgAtual = this.imgbancoE;
			this.colisao = true;
		}
		 // tile 40: moita
		if (valorDaPeca == 40) {
			this.imgAtual = this.imgmoita;
			this.colisao = true;
		}
		 // tile 41: lixeira
		if (valorDaPeca == 41) {
			this.imgAtual = this.imglixeira;
			this.colisao = true;
		
		}
		//tile 42: placa cuidado
		if(valorDaPeca == 42) {
			this.imgAtual = this.imgplacacuidado;
			this.colisao = true;
		}
		//tile 43: barreira
		if(valorDaPeca == 43) {
			this.imgAtual = this.imgbarreira;
			this.colisao = true;
		}
		 // tile 44: bicicleta
		if(valorDaPeca == 44) {
			this.imgAtual = this.imgbicicleta;
			this.colisao = true;
		}
		 // tile 45: chão xadrez		
		if(valorDaPeca == 45) {
			this.imgAtual = this.imgchaocenario4;
			this.colisao = false;
		}
		 // tile 46: tocha
		if(valorDaPeca == 46) {
			this.imgAtual = this.imgtocha;
			this.colisao = true;
		}
		 // tile 47: tocha2
		if(valorDaPeca == 47) {
			this.imgAtual = this.imgtocha2;
			this.colisao = true;
		}
		 // tile 48: tocha3
		if(valorDaPeca == 48) {
			this.imgAtual = this.imgtocha3;
			this.colisao = true;
		}
		 // tile 49: mesa1
		if(valorDaPeca == 49) {
			this.imgAtual = this.imgmesa1;
			this.colisao = true;
		}
		 // tile 50: mesa2
		if(valorDaPeca == 50) {
			this.imgAtual = this.imgmesa2;
			this.colisao = true;
		}
		 // tile 51: lampada
		if(valorDaPeca == 51) {
			this.imgAtual = this.imglampada;
			this.colisao = true;
		}
		 // tile 52: lampada2
		if(valorDaPeca == 52) {
			this.imgAtual = this.imglampada2;
			this.colisao = true;
		}
		 // tile 53: parede escura 2
		if(valorDaPeca == 53) {
			this.imgAtual = this.imgparedeescura2;
			this.colisao = true;
		}
		 // tile 54: chão cenário 5
		if(valorDaPeca == 54) {
			this.imgAtual = this.imgchaocenario5;
			this.colisao = false;
		}
		 // tile 55: chão1 cenário 6 (tipo 1)
		if(valorDaPeca == 55) {
			this.imgAtual = this.imgchao1cenario6;
			this.colisao = false;
		}
		 // tile 56: chão2 cenário 6 
		if(valorDaPeca == 56) {
			this.imgAtual = this.imgchao2cenario6;
			this.colisao = false;
		}
		//	tile 57: chave prateada
		if (valorDaPeca == 57) {
			this.imgAtual = this.imgSilverKey;
			this.colisao = false;
		}
		// tile 58: pizza
		if (valorDaPeca == 58) {
			this.imgAtual = this.imgpizza;
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

