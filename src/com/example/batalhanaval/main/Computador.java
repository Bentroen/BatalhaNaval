package com.example.batalhanaval.main;

import com.example.batalhanaval.exceptions.CelulaInvalidaException;
import com.example.batalhanaval.exceptions.CelulaJaDescobertaException;
import com.example.batalhanaval.exceptions.CelulaJaTemNavioException;

public class Computador extends Jogador {

	public void definirNome() {
		this.nome = "Computador";
	}
	
	public void posicionarNavios(Tabuleiro t, int contNavios) {
		int naviosRestantes = contNavios;
		int tamanho = t.getTamanho();
		
		while (naviosRestantes > 0) {
			
			Coordenada coord = Coordenada.coordenadaAleatoria(tamanho);
			
			try {
				t.posicionarNavio(coord);
			} catch (CelulaInvalidaException | CelulaJaTemNavioException e) {
				continue;
			}
			
			naviosRestantes--;
		}
	}
	
	public Coordenada atirar(Tabuleiro t) {
		int tamanho = t.getTamanho();
		Coordenada coord;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while (true) {
			
			coord = Coordenada.coordenadaAleatoria(tamanho);
			boolean acertouNavio;
			
			try {
				acertouNavio = t.marcarTiro(coord);
			} catch (CelulaInvalidaException e) {
				e.printStackTrace();
				continue;
			} catch (CelulaJaDescobertaException e) {
				continue;
			}
			
			System.out.println(String.format("%s atirou em %s", getNome(), coord));
			if (acertouNavio) {
				System.out.println(String.format("%s acertou um navio!!", getNome()));
				this.pontuacao++;
			} else {
				System.out.println(String.format("%s atirou na água.", getNome()));
			}
			
			break;
		}
		
		return coord;
	}
	
}
