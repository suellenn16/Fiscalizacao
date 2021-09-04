package com.importacao;

import java.util.Scanner;

public class LeitorDeArquivos {
	
	private final String arquivo;

	public LeitorDeArquivos(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public void le(Processador processador) {
		Scanner statesScanner;
        try {
        	
        	System.out.println(arquivo);
        	statesScanner = FileReader.read(arquivo);
        }catch (Exception e){
        	System.out.println(e.getMessage());
        	return;
        }
        
        while(statesScanner.hasNext()){
        	String row = statesScanner.next();
        	processador.executa(row);
        }
        statesScanner.close();
		
	}

}
