package com.importacao;


import com.classes.Uf;
import com.controller.FederativaUniController;

public class ImportadorUnidadeFederativas implements Processador {
	
private FederativaUniController federativaUniController = new FederativaUniController();
	
	public ImportadorUnidadeFederativas() {
		LeitorDeArquivos leitor = new LeitorDeArquivos("C:/Users/ferre/OneDrive/Documentos/eclipse-workspace/FSMA/estados.txt");
		leitor.le(this);
	}
	
	public void executa(String row) {
		String[] items = row.split(",");
		String UfNome = items[0].trim();
		String UfSigla = items[1].trim();
		Uf uf = new Uf();
		uf.setSigla(UfSigla);
		uf.setNome(UfNome);
		federativaUniController.create(uf);
		
		
	}


}
