package com.importacao;

import com.classes.Uf;
import com.dao.UfDao;

public class ImportadorUnidadeFederativas implements Processador {

	private UfDao ufDao = new UfDao();

	public ImportadorUnidadeFederativas() {
		LeitorDeArquivos leitor = new LeitorDeArquivos("estados.txt");
		leitor.le(this);
	}

	public void executa(String row) {
		String[] items = row.split(",");
		String nome = items[0].trim();
		String sigla = items[1].trim();
		Uf uf = new Uf();
		uf.setSigla(sigla);
		uf.setNome(nome);
		ufDao.save(uf);
	}

}
