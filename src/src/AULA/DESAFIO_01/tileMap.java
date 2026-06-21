package AULA.DESAFIO_01;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class tileMap {
    Tiles pecaDoCenario;
    int[][] cenarioValido;
    private String cenaValida;
    private boolean avisoGrade = false;
    int[][] cenario1DoJogo = {
            { 19, 19, 19, 51, 51, 19, 2, 2, 2, 2, 19, 18, 18, 18, 18, 19 },
            { 19, 13, 14, 49, 50, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
            { 19, 15, 16, 17, 17, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 17, 19, 51, 51, 19, 17, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 18, 17, 17, 17, 17, 17, 17, 17, 17, 18, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19 }
    };

    int[][] cenario2DoJogo = {
            { 51, 19, 19, 51, 19, 19, 51, 19, 19, 51, 19, 19, 51, 19, 19, 51 },
            { 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 17, 19, 19, 19, 19, 17, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
            { 19, 17, 17, 17, 17, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
            { 19, 19, 19, 19, 19, 19, 2, 2, 2, 2, 19, 17, 17, 17, 17, 19 },
    };

    int[][] cenario3DoJogo = {
            { 40, 39, 38, 40, 39, 38, 40, 41, 28, 29, 30, 33, 34, 35, 36, 37 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 11, 11, 42 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 11, 11, 11 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 32, 11, 11 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 31, 11, 43 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 11, 11, 43 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 11, 11, 43 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 11, 11, 43 },
            { 40, 9, 9, 9, 9, 9, 9, 1, 11, 11, 11, 10, 11, 11, 11, 43 },
            { 40, 40, 9, 9, 9, 40, 40, 44, 21, 20, 22, 23, 24, 25, 26, 27 }
    };

    int[][] cenario4DoJogo = {
            { 12, 45, 45, 45, 45, 46, 12, 12, 46, 12, 12, 46, 12, 12, 46, 12 },
            { 48, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 12 },
            { 12, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 3, 3, 3, 12 },
            { 12, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 3, 45, 45, 12 },
            { 48, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 3, 45, 45, 12 },
            { 12, 45, 45, 45, 5, 45, 45, 45, 45, 45, 45, 45, 3, 45, 45, 12 },
            { 12, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 3, 3, 3, 12 },
            { 48, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 12 },
            { 12, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 12 },
            { 12, 12, 47, 12, 12, 47, 12, 12, 47, 12, 12, 47, 45, 45, 45, 12 },
    };

    int[][] cenario5DoJogo = {
            { 12, 12, 46, 12, 12, 46, 12, 12, 46, 12, 12, 46, 54, 54, 54, 12 },
            { 12, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 12 },
            { 48, 54, 54, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 },
            { 12, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 12 },
            { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 57, 54, 12 },
            { 12, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 12 },
            { 48, 54, 54, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 46, 12 },
            { 12, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 7 },
            { 12, 57, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 7 },
            { 12, 47, 12, 12, 47, 12, 12, 47, 12, 12, 47, 12, 12, 12, 47, 12 },
    };

    int[][] cenario6DoJogo = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 46, 12, 46, 12, 46, 12, 46, 12, 46, 12, 46, 12, 0, 0 },
            { 0, 12, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 12, 0 },
            { 12, 55, 55, 55, 55, 55, 56, 56, 56, 55, 55, 55, 55, 55, 55, 12 },
            { 12, 55, 55, 55, 55, 56, 56, 56, 56, 56, 55, 55, 3, 3, 3, 12 },
            { 48, 55, 55, 55, 55, 56, 56, 56, 56, 56, 55, 55, 3, 55, 55, 12 },
            { 55, 55, 55, 55, 55, 55, 56, 56, 56, 55, 55, 55, 3, 3, 3, 12 },
            { 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 12 },
            { 12, 12, 47, 12, 47, 12, 47, 12, 47, 12, 47, 12, 47, 12, 12, 12 }
    };

    public tileMap() {
        this.cenarioValido = this.cenario1DoJogo;
        this.setCenaValida("C1");
        this.pecaDoCenario = new Tiles();
    }

    public void desenhar(Graphics d2) {
        int pecaDaMatriz;

        for (int lin = 0; lin < this.cenarioValido.length; lin++) {
            for (int col = 0; col < this.cenarioValido[0].length; col++) {

                pecaDaMatriz = cenarioValido[lin][col];

                this.pecaDoCenario.carregaPecaDaMatriz(pecaDaMatriz);
                this.pecaDoCenario.desenhaTile(d2, lin, col);
            }
        }
    }

    public String getCenaValida() {
        return cenaValida;
    }

    public void setCenaValida(String cenaValida) {
        this.cenaValida = cenaValida;
        switch (this.cenaValida) {
            case "C1":
                this.cenarioValido = this.cenario1DoJogo;
                break;
            case "C2":
                this.cenarioValido = this.cenario2DoJogo;
                break;
            case "C3":
                this.cenarioValido = this.cenario3DoJogo;
                break;
            case "C4":
                this.cenarioValido = this.cenario4DoJogo;
                break;
            case "C5":
                this.cenarioValido = this.cenario5DoJogo;
                break;
            case "C6":
                this.cenarioValido = this.cenario6DoJogo;
                break;
        }

    }

    public void coletarChaveSeEncostar(Player jogador) {
        for (int lin = 0; lin < this.cenarioValido.length; lin++) {
            for (int col = 0; col < this.cenarioValido[0].length; col++) {

                int tile = this.cenarioValido[lin][col];

                if (tile == 5 || tile == 57) {
                    java.awt.Rectangle areaChave = new java.awt.Rectangle(col * 48, lin * 48, 48, 48);

                    if (jogador.areaColisao.intersects(areaChave)) {

                        if(tile == 5) {
                             jogador.adicionarChaveDourada();
                             this.cenarioValido[lin][col] = 45;
                        }
  

                        if(tile == 57) {
                            jogador.adicionarChavePrateada();
                            avisoGrade = false;
                            this.cenarioValido[lin][col] = 54;
                            }
                        }
                    }
                }
            }
        }
    

   public boolean tentarAbrirPorta(int linha, int coluna, Player jogador) {

    int tile = this.cenarioValido[linha][coluna];

    // Porta dourada
    if(tile == 7) {

        if(jogador.temChaveDourada()) {

            jogador.usarChaveDourada();
            this.cenarioValido[linha][coluna] = 54;

            System.out.println("Porta aberta!");
            return true;
        }
        System.out.println("Você precisa de uma chave dourada para abrir essa porta!");

        return false;
    }

    // Grade / cela (chave prateada)
    if(tile == 3) {

        if(jogador.temChavePrateada()) {

            jogador.usarChavePrateada();
            this.cenarioValido[linha][coluna] = 55;

            System.out.println("Cela aberta!");
            return true;
        }

        System.out.println("Você precisa de uma chave prateada para abrir essa cela!");
        

        return false;
    }

    return false;
}
}
