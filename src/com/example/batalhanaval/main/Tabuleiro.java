package com.example.batalhanaval.main;

import com.example.batalhanaval.enums.TipoCelula;
import com.example.batalhanaval.exceptions.CelulaInvalidaException;
import com.example.batalhanaval.exceptions.CelulaJaDescobertaException;
import com.example.batalhanaval.exceptions.CelulaJaTemNavioException;

public class Tabuleiro {

	private int tamanho;
	private Celula[][] celulas;
			
	public Tabuleiro(int tamanho) {
		this.tamanho = tamanho;
		this.celulas = new Celula[tamanho][tamanho];
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				celulas[i][j] = new Celula();
			}
		}
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public void esconderCelulas() {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				celulas[i][j].setDescoberta(false);
			}
		}
	}
	
	public void validarCoordenada(Coordenada coord) {
	
	}
	
	public void posicionarNavio(Coordenada coord) throws CelulaJaTemNavioException, CelulaInvalidaException {
		int i = coord.getLinha();
		int j = coord.getColuna();
		
		if (i < 0 || i > tamanho || j < 0 || j > tamanho) {
			throw new CelulaInvalidaException(String.format("%d, %d", i, j));
		}
		if (celulas[i][j].getTipo() == TipoCelula.NAVIO) {
			throw new CelulaJaTemNavioException(String.format("%d, %d", i, j));
		}
		
		celulas[i][j].setTipo(TipoCelula.NAVIO);
	}
	
	public boolean marcarTiro(Coordenada coord) throws CelulaJaDescobertaException, CelulaInvalidaException {
		int i = coord.getLinha();
		int j = coord.getColuna();
		
		if (i < 0 || i > tamanho || j < 0 || j > tamanho) {
			throw new CelulaInvalidaException(String.format("%d, %d", i, j));
		}
		Celula celula = celulas[i][j];
		
		if (celula.getDescoberta()) {
			throw new CelulaJaDescobertaException(String.format("%d, %d", i, j));
		}
		celula.setDescoberta(true);
		
		if (celula.getTipo() == TipoCelula.NAVIO) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void mostrar(String nome, boolean oculto) {
		
		// Título
		System.out.println();
		System.out.println("===========================");
		System.out.println("  TABULEIRO DE " + nome.toUpperCase());
		System.out.println("===========================");
		System.out.println();
		
		// Cabeçalho
		System.out.print("  ");
		for (int i = 0; i < tamanho; i++) {
			System.out.print((char) (i + 'A') + " ");
		}
		System.out.println();
		
		// Células
		for (int i = 0; i < tamanho; i++) {
			System.out.print(String.valueOf(i) + " ");
			for (int j = 0; j < tamanho; j++) {
					System.out.print(celulas[j][i].mostrar(oculto) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
	}
	
}
