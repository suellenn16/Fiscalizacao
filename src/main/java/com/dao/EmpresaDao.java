package com.dao;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

import com.classes.Empresa;
import com.conexao.Conexao;

public class EmpresaDao {

	  private final EntityManager entityManager;

	  public EmpresaDao() {
	    this.entityManager = Conexao.getEntityManager();
	  }

	  public void save(Empresa empresa) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(empresa);
	    entityManager.getTransaction().commit();
	  }

	  public Empresa getEmpresaFromCnpj(String cnpj) {
	    StringBuilder jpql = new StringBuilder();
	    jpql.append("select c from Empresa c ");
	    jpql.append("where c.cnpj = :cnpj");

	    TypedQuery<Empresa> query = entityManager.createQuery(jpql.toString(), Empresa.class);

	    query.setParameter("cnpj", cnpj);
	    query.setMaxResults(1);
	    try {
	      return query.getSingleResult();
	    } catch (Exception e) {
	      return null;
	    }
	  }
	 
}
