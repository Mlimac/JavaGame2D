package AULA.DESAFIO_01;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Painel extends JPanel {
	private String Posicao;
	Player Jogador = new Player();
	GAMELOOP loopDoJogo;
	escutadorTeclado ET;
	SpriteLoop SL;	
	tileMap cenario;
	
	public Painel(String Posicao) {
        this.Posicao = Posicao;
            if (Posicao.equals("Centro")) {
                this.setBackground(Color.BLACK);
                this.setPreferredSize(new Dimension(768, 480));

                ET = new escutadorTeclado();
                this.addKeyListener(ET);
                this.setFocusable(true);

                this.cenario = new tileMap();

                loopDoJogo = new GAMELOOP(this, ET);
                loopDoJogo.start();

                SL = new SpriteLoop(this, ET);
                SL.start();
    
        } else {
            this.setPreferredSize(new Dimension(768, 100));
            this.setBackground(Color.YELLOW);
        }
    }
	
	public void paintComponent(Graphics D) {
		Graphics D2 = (Graphics2D) D;
		D2.setColor(this.getBackground());
		D2.fillRect(0,0, this.getWidth(), this.getHeight());
		if(this.Posicao.equals("Centro")) {
			//tile.desenhaTile(D2); 
			this.cenario.desenhar(D2);
			Jogador.DesenharPlayer(D2);
		}
		
	}
}