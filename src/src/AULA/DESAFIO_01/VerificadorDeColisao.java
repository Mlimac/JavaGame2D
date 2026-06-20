package AULA.DESAFIO_01;

public class VerificadorDeColisao {

	private int colEsqX;
	private int colDirX;
	private int rowTopoY;
	private int rowBaseY;
	private boolean colidiu;

	public VerificadorDeColisao() {

	}

	private boolean verificarTile(Player Jogador, tileMap CenaDoJogo, int linha, int coluna) {
		if (linha < 0 || linha >= CenaDoJogo.cenarioValido.length) {
			return true;
		}

		if (coluna < 0 || coluna >= CenaDoJogo.cenarioValido[0].length) {
			return true;
		}

		int valorTile = CenaDoJogo.cenarioValido[linha][coluna];

		// tile 7 é porta trancada
		if (valorTile == 7) {
			boolean abriu = CenaDoJogo.tentarAbrirPorta(linha, coluna, Jogador);

			// Se abriu, não colide.
			// Se não abriu, colide.
			return !abriu;
		}

		CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(valorTile);

		return CenaDoJogo.pecaDoCenario.isColisao();
	}

	public boolean OcorreuColisao(Player Jogador, tileMap CenaDoJogo, String Direcao) {
		colidiu = false;

		int bordaEsqX = (int) Jogador.areaColisao.getX();
		int bordaDirX = (int) Jogador.areaColisao.getX() + (int) Jogador.areaColisao.getWidth();
		int bordaTopoY = (int) Jogador.areaColisao.getY();
		int bordaBaseY = (int) Jogador.areaColisao.getY() + (int) Jogador.areaColisao.getHeight();

		this.colEsqX = bordaEsqX / 48;
		this.colDirX = bordaDirX / 48;
		this.rowTopoY = bordaTopoY / 48;
		this.rowBaseY = bordaBaseY / 48;

		if (Direcao.equals("cima")) {
			int prox_rowTopoY = (bordaTopoY - Jogador.passo) / 48;

			if (Jogador.areaColisao.y < 0) {
				if (CenaDoJogo.getCenaValida().equals("C1")) {
					CenaDoJogo.setCenaValida("C2");
				} else if (CenaDoJogo.getCenaValida().equals("C4")) {
					CenaDoJogo.setCenaValida("C3");
				} else if (CenaDoJogo.getCenaValida().equals("C5")) {
					CenaDoJogo.setCenaValida("C4");
				}

				int alturaCenario = CenaDoJogo.cenarioValido.length * 48;
				Jogador.posY = alturaCenario - (int) Jogador.areaColisao.getHeight();
				Jogador.atualizarAreaColisao();

			} else {
				if (verificarTile(Jogador, CenaDoJogo, prox_rowTopoY, colEsqX)) {
					this.colidiu = true;
				}

				if (verificarTile(Jogador, CenaDoJogo, prox_rowTopoY, colDirX)) {
					this.colidiu = true;
				}
			}
		}

		else if (Direcao.equals("baixo")) {
			int prox_rowBaseY = (bordaBaseY + Jogador.passo) / 48;

			if (prox_rowBaseY < CenaDoJogo.cenarioValido.length) {
				if (verificarTile(Jogador, CenaDoJogo, prox_rowBaseY, colEsqX)) {
					this.colidiu = true;
				}

				if (verificarTile(Jogador, CenaDoJogo, prox_rowBaseY, colDirX)) {
					this.colidiu = true;
				}

			} else {
				if (CenaDoJogo.getCenaValida().equals("C2")) {
					CenaDoJogo.setCenaValida("C1");
				} else if (CenaDoJogo.getCenaValida().equals("C3")) {
					CenaDoJogo.setCenaValida("C4");
				} else if (CenaDoJogo.getCenaValida().equals("C4")) {
					CenaDoJogo.setCenaValida("C5");
				}

				Jogador.posY = -(int) Jogador.areaColisao.getHeight();
				Jogador.atualizarAreaColisao();
			}
		}

		else if (Direcao.equals("direita")) {
			int prox_colDirX = (bordaDirX + Jogador.passo) / 48;

			if (prox_colDirX < CenaDoJogo.cenarioValido[0].length) {
				if (verificarTile(Jogador, CenaDoJogo, rowBaseY, prox_colDirX)) {
					this.colidiu = true;
				}

				if (verificarTile(Jogador, CenaDoJogo, rowTopoY, prox_colDirX)) {
					this.colidiu = true;
				}

			} else {
				if (CenaDoJogo.getCenaValida().equals("C3")) {
					CenaDoJogo.setCenaValida("C2");
				} else if (CenaDoJogo.getCenaValida().equals("C5")) {
					CenaDoJogo.setCenaValida("C6");
				}

				Jogador.posX = -(int) Jogador.areaColisao.getWidth();
				Jogador.atualizarAreaColisao();
			}
		}

		else if (Direcao.equals("esquerda")) {
			int prox_colEsqX = (bordaEsqX - Jogador.passo) / 48;

			if (Jogador.areaColisao.x < 0) {
				if (CenaDoJogo.getCenaValida().equals("C2")) {
					CenaDoJogo.setCenaValida("C3");
				} else if (CenaDoJogo.getCenaValida().equals("C6")) {
					CenaDoJogo.setCenaValida("C5");
				}

				int comprimentoCenario = CenaDoJogo.cenarioValido[0].length * 48;
				Jogador.posX = comprimentoCenario - (int) Jogador.areaColisao.getWidth();
				Jogador.atualizarAreaColisao();

			} else {
				if (verificarTile(Jogador, CenaDoJogo, rowBaseY, prox_colEsqX)) {
					this.colidiu = true;
				}

				if (verificarTile(Jogador, CenaDoJogo, rowTopoY, prox_colEsqX)) {
					this.colidiu = true;
				}
			}
		}

		System.out.println("colEsqX  = " + this.colEsqX);
		System.out.println("colDirX  = " + this.colDirX);
		System.out.println("rowTopoY = " + this.rowTopoY);
		System.out.println("rowBaseY = " + this.rowBaseY);
		System.out.println("Chaves   = " + Jogador.getQuantidadeChaves());
		System.out.println("-------------------------------");

		return colidiu;
	}
}