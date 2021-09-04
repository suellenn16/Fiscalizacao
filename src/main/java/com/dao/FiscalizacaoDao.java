package com.dao;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.conexao.Conexao;

import com.classes.Fiscalizacao;

public class FiscalizacaoDao {
	
	private final EntityManager entityManager;

	  public FiscalizacaoDao() {
	    this.entityManager = Conexao.getEntityManager();
	  }

	  public void save(Fiscalizacao fiscalization) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(fiscalization);
	    entityManager.getTransaction().commit();
	  }

	  public Fiscalizacao getFiscalizacaoFromDateAndPostalCodeAndPublicPlace(
	    LocalDate data,
	    String cep,
	    String logradouro
	  ) {
	    StringBuilder jpql = new StringBuilder();
	    jpql.append("select f from Fiscalizacao f ");
	    jpql.append("where f.data = :data ");
	    jpql.append("and f.cep = :cep ");
	    jpql.append("and f.logradouro = :logradouro");

	    TypedQuery<Fiscalizacao> query = entityManager.createQuery(jpql.toString(), Fiscalizacao.class);

	    query.setParameter("data", data);
	    query.setParameter("cep", cep);
	    query.setParameter("logradouro", logradouro);
	    query.setMaxResults(1);

	    try {
	      return query.getSingleResult();
	    } catch (Exception e) {
	      return null;
	    }
	  }


}
