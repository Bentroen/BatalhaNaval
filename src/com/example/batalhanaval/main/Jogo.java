package com.example.batalhanaval.main;

public class Jogo {
	
	public static final int TAMANHO_TABULEIRO = 10;
	public static final int CONT_NAVIOS = 10;
	
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
		while (true) {
			t1.mostrar(j1.getNome(), false);
			t2.mostrar(j2.getNome(), true);
			
			j1.atirar(t2);
			if (verificarVitoria(j1)) break;
			j2.atirar(t1);
			if (verificarVitoria(j2)) break;
		}
	}

	public static boolean verificarVitoria(Jogador j) {
		if (j.getPontuacao() >= CONT_NAVIOS) {
			System.out.println(j.getNome() + " venceu o jogo!!");
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
