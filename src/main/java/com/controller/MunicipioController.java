package com.controller;

import com.classes.Municipio;
import com.classes.Uf;
import com.dao.MunicipioDao;

public class MunicipioController {
	
	MunicipioDao municipioDao = new MunicipioDao();

	  public Municipio create(String nome, Uf uf) {
		  Municipio municipio = municipioDao.getByNomeAndUf(nome, uf.getId());
	    if(municipio == null) {
	    	municipio = new Municipio(nome, uf);
	    	municipioDao.save(municipio);
	    }

	    return municipio;
	  }

}
