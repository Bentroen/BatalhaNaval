package com.example.batalhanaval;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import com.example.batalhanaval.main.Jogo;

public class Main {
	
	public static void main(String[] args) {
		
		// Permitir que o console mostre emoji
	    String charsetOut = System.out.charset().displayName();
	    if (!"UTF-8".equals(charsetOut)) {
	        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
	    }
		
		Jogo.rodar();
	}
	
}
