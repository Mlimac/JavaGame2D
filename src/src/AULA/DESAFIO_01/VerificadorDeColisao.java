package AULA.DESAFIO_01;

public class VerificadorDeColisao {
	//atributos privados
	private int colEsqX;
	private int colDirX;
	private int rowTopoY;
	private int rowBaseY;
	private boolean colidiu;
	
	//construtor
	public VerificadorDeColisao() {
	//deve ficar vazio	
	}
	
	public boolean OcorreuColisao (Player Jogador, tileMap CenaDoJogo, String Direcao) {
		colidiu = false;
		/*Calculando o valor dos pontos A, B, C e D do jogador
		 * temos que:
		 * ponto A = (bordaEsqX, bordaTopoY)
		 * ponto B = (bordaDirX, bordaTopoY)
		 * ponto C = (bordaEsqX, bordaBaseY)
		 * ponto D = (bordaDirX, bordaBaseY)
		 */
		
		//calculando com reação à área de colisão do Jogador 
		int bordaEsqX = (int)Jogador.areaColisao.getX();
		int bordaDirX = (int)Jogador.areaColisao.getX() + (int)Jogador.areaColisao.getWidth();
		int bordaTopoY = (int)Jogador.areaColisao.getY();
		int bordaBaseY = (int)Jogador.areaColisao.getY() + (int)Jogador.areaColisao.getHeight(); 
		
		//transformando em linhas e colunas da matriz da cena do jogo
		this.colEsqX = (int)bordaEsqX/48;
		this.colDirX = (int)bordaDirX/48;
		this.rowTopoY = (int)bordaTopoY/48;
		this.rowBaseY = (int)bordaBaseY/48;
		
		if (Direcao == "cima" ) {
			//simula o avanço do jogador  para verificar onde ele vai estar se o movimento acontecer 
			int prox_rowTopoY = (bordaTopoY - Jogador.passo)/48;
			//verifica o topo do jogador pelo lado esquerdo
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowTopoY][colEsqX]);
			if (CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
			//verifica o topo do jogador pelo lado direito 
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowTopoY][colDirX]);
			if (CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
		}
		
		else if (Direcao == "baixo") {
			int prox_rowBaseY = (bordaBaseY + Jogador.passo)/48;
			//verifica a base do jogador pelo lado esquerdo 
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowBaseY][colEsqX]);
			if(CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
			
			//verifica a base do jogador pelo lado direito 
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowBaseY][colDirX]);
			if(CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
		}
		
		else if (Direcao == "direita") {
			int prox_colDirX = (bordaDirX + Jogador.passo)/48;
			//verifica o lado do jogador pela parte inferior 
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBaseY][prox_colDirX]);
			if(CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
			
			//verifica a base do jogador pela parte superior 
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopoY][prox_colDirX]);
			if(CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
		}
		
		else if (Direcao == "esquerda") {
			int prox_colEsqX = (bordaEsqX - Jogador.passo)/48;
			//verifica a base do jogador pela parte inferior
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBaseY][prox_colEsqX]);
			if(CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
		
			//verifica a base do jogador pelo lado esquerdo 
			CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopoY][prox_colEsqX]);
			if(CenaDoJogo.pecaDoCenario.isColisao())
				this.colidiu = true;
		}
			
		
	
		//mostra os dados no console apenas para conferência 
		System.out.println("colEsqX = " + this.colEsqX);
		System.out.println("colDirX = " + this.colDirX);
		System.out.println("rowTopoY = " + this.rowTopoY);
		System.out.println("rowBaseY = " + this.rowBaseY);
		System.out.println("----------------------------");
		return colidiu;

}
	}
