package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.conexao.Conexao;

import com.classes.Uf;

public class UfDao {

	 private final EntityManager entityManager;

	  public UfDao() {
	    this.entityManager = Conexao.getEntityManager();
	  }

	  public void save(Uf uf) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(uf);
	    entityManager.getTransaction().commit();
	  }

	  public Uf getBySigla(String sigla) {
	    StringBuilder jpql = new StringBuilder();
	    jpql.append("select uf from Uf uf ");
	    jpql.append("where uf.sigla = :sigla");

	    TypedQuery<Uf> query = entityManager.createQuery(jpql.toString(), Uf.class);

	    query.setParameter("sigla", sigla);

	    try {
	      return query.getSingleResult();
	    } catch (Exception e) {
	      return null;
	    }
	  }

	  public Uf getByName(String name) {
	    StringBuilder jpql = new StringBuilder();
	    jpql.append("select fu from FederatedUnit fu ");
	    jpql.append("where fu.name = :name");

	    TypedQuery<Uf> query = entityManager.createQuery(jpql.toString(), Uf.class);

	    query.setParameter("name", name);

	    try {
	      return query.getSingleResult();
	    } catch (Exception e) {
	      return null;
	    }
	  }
	}


