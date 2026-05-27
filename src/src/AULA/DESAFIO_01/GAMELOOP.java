package AULA.DESAFIO_01;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GAMELOOP extends Thread implements Runnable, ActionListener{
	private int FPS = 60;
	private Timer ControleDeTempoDoJogo;
	private long ContadorDeFPS;
	private escutadorTeclado ET;
	public Painel cenaDoJogo;
	public escutadorTeclado eT;
	
	
	public GAMELOOP(Painel cenaDoJogo, escutadorTeclado eT) {
		System.out.println("Gameloop Instanciado");
		this.cenaDoJogo = cenaDoJogo;
		this.ET = eT;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("FPS GameLoop: " + this.ContadorDeFPS);
		this.ContadorDeFPS = 0;
		
		
	}
	
	public void run() {
		this.ContadorDeFPS = 0;
		this.ControleDeTempoDoJogo = new Timer(1000, this);
		this.ControleDeTempoDoJogo.start();
		//---------------------------------
		double frameRate = 1000000000 / this.FPS;
		double tempoDecorrido =0;
		long tempoUltimaMedidaDoLoop = System.nanoTime();
		long tempoAtualDoLoop;
		//---------------------------------

		while (this.isAlive()) {
			tempoAtualDoLoop = System.nanoTime();
			tempoDecorrido = tempoDecorrido + 
					(tempoAtualDoLoop - tempoUltimaMedidaDoLoop)/frameRate;
			tempoUltimaMedidaDoLoop = tempoAtualDoLoop;
			
			if (tempoDecorrido >= 1) {
				String direcao = "";
				if (ET.movePraCima)		direcao = "cima";
				if (ET.movePraBaixo)		direcao = "baixo";
				if (ET.movePraDir)		direcao = "direita";
				if (ET.movePraEsq)		direcao = "esquerda";
				
				VerificadorDeColisao colisao = new VerificadorDeColisao();
				boolean bateu = colisao.OcorreuColisao(this.cenaDoJogo.Jogador, this.cenaDoJogo.cenario, direcao);
				System.out.println("colisao : " + bateu);
				if (bateu == false ) {
					cenaDoJogo.Jogador.atualizaPosicaoJogador(ET.movePraEsq, ET.movePraDir, 
							ET.movePraCima, ET.movePraBaixo);
				}
				
				cenaDoJogo.repaint();
				this.ContadorDeFPS++;
				tempoDecorrido = 0;
			}
			
		}
		
	}

}
