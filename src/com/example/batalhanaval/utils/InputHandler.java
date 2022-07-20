package com.example.batalhanaval.utils;

import java.util.Scanner;

import com.example.batalhanaval.main.Coordenada;

public class InputHandler {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String getNome() {
		return sc.nextLine();
	}
	
	public static Coordenada getCoordenada(String mensagem) {
		
		char linha;
		char coluna;
		
		while (true) {
			System.out.print(mensagem);
			
			String input = sc.nextLine();
			if (input.length() != 2) {
				System.out.println("O valor deve conter 2 caracteres!");
				continue;
			}
			
			linha = input.charAt(0);
			coluna = input.charAt(1);
			
			if (linha < 'A' || linha > 'J') {
				System.out.println("A linha deve estar entre A e J!");
				continue;
			}
			
			if (coluna < '0' || coluna > '9') {
				System.out.println("A coluna deve estar entre 0 e 9!");
				continue;
			}
			
			break;
		}

		return new Coordenada(linha, coluna);
	}

}
