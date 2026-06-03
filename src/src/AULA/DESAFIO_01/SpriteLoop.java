package AULA.DESAFIO_01;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SpriteLoop extends Thread implements Runnable, ActionListener {
	private int FPS = 10;
	private Timer ControleDoTempoDoJogo;
	private long contadorDeFPS;
	private Painel cenaDoJogo;
	private escutadorTeclado ET;
	SpriteLoop SL;	
	
	public SpriteLoop(Painel P, escutadorTeclado eT  ) {
		System.out.println("Sprite Instanciado");
		this.cenaDoJogo = P;
		this.ET = eT; 
	}

	@Override
	public void run() {
		this.contadorDeFPS = 0;
		this.ControleDoTempoDoJogo = new Timer(1000, this);
		this.ControleDoTempoDoJogo.start();
		//---------------------------------
		double frameRate = 1000000000 / this.FPS;
		double tempoDecorrido = 0;
		long tempoUltimaMedidaDoLoop = System.nanoTime();
		long tempoAtualDoLoop;
		//---------------------------------

		while (this.isAlive()) {
			tempoAtualDoLoop = System.nanoTime();
			tempoDecorrido = tempoDecorrido + (tempoAtualDoLoop - tempoUltimaMedidaDoLoop)/frameRate;
			tempoUltimaMedidaDoLoop = tempoAtualDoLoop;
			
			if (tempoDecorrido >= 1) {
			    cenaDoJogo.Jogador.atualizaSprite(
			        ET.movePraEsq,
			        ET.movePraCima,
			        ET.movePraDir,
			        ET.movePraBaixo
			    );

			    cenaDoJogo.repaint();
			    this.contadorDeFPS++;
			    tempoDecorrido = 0;
			
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("FPS GameLoop: " + this.contadorDeFPS);
		this.contadorDeFPS = 0;
		
	}
}
