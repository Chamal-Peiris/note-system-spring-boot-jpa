package lk.ijse.dep.notes.repository.custom.impl;

import lk.ijse.dep.notes.repository.custom.QueryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryRepositoryImpl implements QueryRepository {
    @PersistenceContext
    private EntityManager em;
}
