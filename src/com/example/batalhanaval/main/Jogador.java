package com.example.batalhanaval.main;

public abstract class Jogador {
	
	protected String nome;
	protected int pontuacao;
	
	public int getPontuacao() {
		return this.pontuacao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract void definirNome();
	
	public abstract void posicionarNavios(Tabuleiro t, int contNavios);
	
	public abstract Coordenada atirar(Tabuleiro t);
	
}
