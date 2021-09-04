package com.importacao;

import com.controller.FiscalizacaoController;

public class ImportadorFiscalizacoes  implements Processador{
	
	private FiscalizacaoController fiscalizacaoController = new FiscalizacaoController();
	
	public ImportadorFiscalizacoes() {
		LeitorDeArquivos leitor = new LeitorDeArquivos("Empresas - Santa Catarina.csv");
		leitor.le(this);
	}
	
	public void executa(String row) {
		String[] items = row.split(";");
		try {
			//fiscalizacaoController.createFiscalizacao(
					
				//	);
	  }catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
	}

}
