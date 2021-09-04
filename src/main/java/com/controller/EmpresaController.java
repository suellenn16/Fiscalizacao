package com.controller;


import com.classes.Empresa;
import com.dao.EmpresaDao;

public class EmpresaController {
	
	EmpresaDao empresaDao = new EmpresaDao();

	  public Empresa create(String cnpj, String razaoSocial) {
	    Empresa empresa = empresaDao.getEmpresaFromCnpj(cnpj);
	    if(empresa == null) {
	      empresa = new Empresa (cnpj, razaoSocial);
	      empresaDao.save(empresa);
	    }

	    return empresa;
	  }

}
