package AULA.DESAFIO_01;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

public class escutadorTeclado implements KeyListener{
	public boolean movePraBaixo, movePraCima, movePraDir, movePraEsq;

	@Override
	public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == 38) { // CIMA
            movePraCima = true;
        }
        if (tecla == 40) { // BAIXO
            movePraBaixo = true;
        }
        if (tecla == 37) { // ESQUERDA
            movePraEsq = true;
        }
        if (tecla == 39) { // DIREITA
            movePraDir = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();

       if (tecla == 38) {
            movePraCima = false;
        }
        if (tecla == 40) {
            movePraBaixo = false;
        }
        if (tecla == 37) {
            movePraEsq = false;
        }
        if (tecla == 39) {
            movePraDir = false;
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}
