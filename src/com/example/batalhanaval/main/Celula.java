package com.example.batalhanaval.main;

import com.example.batalhanaval.enums.TipoCelula;

public class Celula {

	private boolean descoberta = false;
	private TipoCelula tipo = TipoCelula.AGUA;
	
	public boolean getDescoberta() {
		return this.descoberta;
	}
	
	public void setDescoberta(boolean descoberta) {
		this.descoberta = descoberta;
	}
	
	public TipoCelula getTipo() {
		return this.tipo;
	}
	
	public void setTipo(TipoCelula tipo) {
		this.tipo = tipo;
	}
	
	public String mostrar() {
		if (this.descoberta) {
			return this.tipo == TipoCelula.NAVIO ? "#" : "X";
		} else {
			return this.tipo == TipoCelula.NAVIO ? "N" : "-";
		}
	}
	
	public String mostrarOculto() {
		if (this.descoberta) {
			return this.tipo == TipoCelula.NAVIO ? "X" : "-";
		} else {
			return "?";
		}
		
	}
	
}
