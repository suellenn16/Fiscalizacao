package com.conexao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
  private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fiscalizacao");
  private static EntityManager entityManager = entityManagerFactory.createEntityManager();

  public static EntityManager getEntityManager() {
    return entityManager;
  }
}
