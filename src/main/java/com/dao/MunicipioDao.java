package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.conexao.Conexao;
import com.classes.Municipio;


public class MunicipioDao {

	  private final EntityManager entityManager;

	  public MunicipioDao() {
	    this.entityManager = Conexao.getEntityManager();
	  }

	  public void save(Municipio municipio) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(municipio);
	    entityManager.getTransaction().commit();
	  }

	  public Municipio getByNomeAndUf(String nome, Long uf) {
	    StringBuilder jpql = new StringBuilder();
	    jpql.append("select m from Municipio m ");
	    jpql.append("join m.uf f ");
	    jpql.append("where m.nome = :nome ");
	    jpql.append("and f.id = :uf");

	    TypedQuery<Municipio> query = entityManager.createQuery(jpql.toString(), Municipio.class);

	    query.setParameter("nome", nome);
	    query.setParameter("uf", uf);
	    query.setMaxResults(1);

	    try {
	      return query.getSingleResult();
	    } catch (Exception e) {
	      return null;
	    }
	  }

}
