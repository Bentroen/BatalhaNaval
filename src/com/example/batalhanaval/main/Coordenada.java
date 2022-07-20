package com.example.batalhanaval.main;

import java.util.Random;

public class Coordenada {
    private int linha;
    private int coluna;

    public Coordenada(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public Coordenada(char linha, char coluna) {
    	this.linha = linha - 'A';
    	this.coluna = coluna - '0';
    }
    
    public static Coordenada coordenadaAleatoria(int tamanho) {
    	int i = new Random().nextInt(tamanho);
    	int j = new Random().nextInt(tamanho);
    	
    	return new Coordenada(i, j);
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
    
    public String toString() {
    	char linha = (char) (this.linha + 'A');
    	char coluna = (char) (this.coluna + '0');
		return String.valueOf(linha) + coluna;
    }
}
