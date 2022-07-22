package com.example.batalhanaval.main;

import com.example.batalhanaval.exceptions.CelulaInvalidaException;
import com.example.batalhanaval.exceptions.TiroRepetidoException;
import com.example.batalhanaval.exceptions.CelulaJaTemNavioException;
import com.example.batalhanaval.utils.InputHandler;

public class Usuario extends Jogador {

	public void definirNome() {
		System.out.println("Digite o seu nome: ");
		this.nome = InputHandler.getNome();
	}
	
	public void posicionarNavios(Tabuleiro t, int contNavios) {
		int naviosRestantes = contNavios;
		
		while (naviosRestantes > 0) {
			
			t.mostrar(getNome(), false);
			System.out.println(String.format("Posicione seus navios (faltando %d)", naviosRestantes));
			
			Coordenada coord = InputHandler.getCoordenada("Insira uma coordenada: ");
			
			System.out.println(coord.getLinha());
			
			
			try {
				t.posicionarNavio(coord);
			} catch (CelulaInvalidaException e) {
				System.out.println("Essa posição é inválida!");
			} catch (CelulaJaTemNavioException e) {
				System.out.println("Você já colocou um navio nessa posição!");
				continue;
			}
			
			System.out.println("Navio posicionado em " + coord);
			naviosRestantes--;	
		}
	}
	
	public Coordenada atirar(Tabuleiro t) {

		System.out.println("Escolha uma posição para atirar:");
		
		Coordenada coord;
		
		while (true) {
			
			coord = InputHandler.getCoordenada("Insira uma coordenada: ");
			boolean acertouNavio;
			
			try {
				acertouNavio = t.marcarTiro(coord);
			} catch (CelulaInvalidaException e) {
				System.out.println("Essa posição é inválida!");
				continue;
			} catch (TiroRepetidoException e) {
				System.out.println("Você já atirou nessa posição!");
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
