package com.dao;


import com.conexao.Conexao;


import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

import com.classes.Bairro;


public class BairroDao {

	 private final EntityManager entityManager;

	  public BairroDao() {
	    this.entityManager = Conexao.getEntityManager();
	  }

	  public void save(Bairro bairro) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(bairro);
	    entityManager.getTransaction().commit();
	  }

	  public Bairro getBairroFromNomeAndMunicipio(String nome, Long municipioId) {
	    StringBuilder jpql = new StringBuilder();
	    jpql.append("select d from Bairro d ");
	    jpql.append("join d.municipio m ");
	    jpql.append("where d.nome = :nome ");
	    jpql.append("and m.id = :municipiod ");

	    TypedQuery<Bairro> query = entityManager.createQuery(jpql.toString(), Bairro.class);

	    query.setParameter("nome", nome);
	    query.setParameter("municipioId", municipioId);
	    query.setMaxResults(1);

	    try {
	      return query.getSingleResult();
	    } catch (Exception e) {
	      return null;
	    }
	  }

}

