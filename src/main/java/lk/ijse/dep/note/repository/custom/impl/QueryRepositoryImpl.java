package lk.ijse.dep.note.repository.custom.impl;

import lk.ijse.dep.note.repository.custom.QueryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryRepositoryImpl implements QueryRepository {
    @PersistenceContext
    private EntityManager em;
}
