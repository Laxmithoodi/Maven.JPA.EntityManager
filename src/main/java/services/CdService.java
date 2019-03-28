package services;

import entities.CdEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CdService {
    EntityManager em = null;
    EntityTransaction tx = null;

    public CdService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }




}
