package com.controller;

import com.classes.Uf;
import com.dao.UfDao;

public class FederativaUniController {
	
		  UfDao ufDao = new UfDao();

		  public Uf create(Uf uf) {
		    Uf existingUf = ufDao.getBySigla(uf.getSigla());

		    if(existingUf == null) {
		      ufDao.save(uf);
		    }

		    return uf;
		  }

		  public Uf getByName(String name) {
		    return ufDao.getByName(name);
		  }
}
	
	
