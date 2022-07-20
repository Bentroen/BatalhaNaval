package com.example.batalhanaval.main;

public class Jogo {
	
	public static final int TAMANHO_TABULEIRO = 10;
	public static final int CONT_NAVIOS = 3;
	
	private static Jogador j1 = new Usuario();
	private static Jogador j2 = new Computador();
	
	private static Tabuleiro t1 = new Tabuleiro(TAMANHO_TABULEIRO);
	private static Tabuleiro t2 = new Tabuleiro(TAMANHO_TABULEIRO);

	public static void solicitarNome() {
		j1.definirNome();
		j2.definirNome();
	}
	
	public static void posicionarNavios() {		
		j1.posicionarNavios(t1, CONT_NAVIOS);
		j2.posicionarNavios(t2, CONT_NAVIOS);
	}
	
	public static void iniciarJogo() {
		while (!verificarVitoria()) {
			t1.mostrar(j1.getNome());
			t2.mostrar(j2.getNome());
			
			j1.atirar(t2);
			j2.atirar(t1);
		}
	}

	public static boolean verificarVitoria() {
		if (j1.getPontuacao() == CONT_NAVIOS) {
			System.out.println(j1.getNome() + " venceu o jogo!!");
			return true;
		}
		else if (j2.getPontuacao() == CONT_NAVIOS) {
			System.out.println(j2.getNome() + " venceu o jogo!!");
			return true;
		}
		return false;
	}
	
	public static void rodar() {
		System.out.println("==========================");
		System.out.println("===== BATALHA NAVAL ======");
		System.out.println("==========================");
		System.out.println();
		
		solicitarNome();
		posicionarNavios();
		iniciarJogo();
		
		System.out.println("Fim do jogo");
	}
	
}
