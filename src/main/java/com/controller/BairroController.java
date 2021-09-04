package com.controller;

import com.classes.Bairro;
import com.classes.Municipio;
import com.dao.BairroDao;

public class BairroController {
	
	 BairroDao bairroDao = new BairroDao();

	  public Bairro create(String nome, Municipio municipio) {
	    Bairro bairro = bairroDao.getBairroFromNomeAndMunicipio(nome, municipio.getId());
	    if(bairro == null) {
	      bairro = new Bairro(nome, municipio);
	      bairroDao.save(bairro);
	    }

	    return bairro;
	  }

}
