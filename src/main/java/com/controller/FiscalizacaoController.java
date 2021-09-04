package com.controller;

import java.time.LocalDate;

import com.classes.Bairro;
import com.classes.Empresa;
import com.classes.Fiscalizacao;
import com.classes.Municipio;
import com.classes.Uf;
import com.dao.BairroDao;
import com.dao.EmpresaDao;
import com.dao.FiscalizacaoDao;
import com.dao.MunicipioDao;
import com.dao.UfDao;

public class FiscalizacaoController {
	
		  private UfDao ufDao;
		  private MunicipioDao municipioDao;
		  private BairroDao bairroDao;
		  private EmpresaDao empresaDao;
		  private FiscalizacaoDao fiscalizacaoDao;


		  public FiscalizacaoController() {
		    this.ufDao = new UfDao();
		    this.municipioDao = new MunicipioDao();
		    this.bairroDao = new BairroDao();
		    this.empresaDao = new EmpresaDao();
		    this.fiscalizacaoDao = new FiscalizacaoDao();
		  }

		  public Fiscalizacao createFiscalizacao(
		    Uf uf,
		    Municipio municipio,
		    Bairro bairro,
		    Empresa empresa,
		    LocalDate data,
		    String cep,
		    String logradouro
		  ) throws Exception {
		    try {
		      Fiscalizacao fiscalizacao = fiscalizacaoDao.getFiscalizacaoFromDateAndPostalCodeAndPublicPlace(
		        data, cep, logradouro
		      );
		      if(fiscalizacao == null) {
		          fiscalizacao = new Fiscalizacao(
		            data,
		            logradouro,
		            cep,
		            empresa,
		            bairro,
		            municipio,
		            uf
		          );
		          fiscalizacaoDao.save(fiscalizacao);
		        }

		        return fiscalizacao;
		      } catch (Exception err) {
		        System.out.println(err.getMessage());
		      }

		    return null;
		  }
		  
}




