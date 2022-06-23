package lk.ijse.dep.note.repository;

import lk.ijse.dep.note.entity.SuperEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class CrudRepositoryImpl <T extends SuperEntity,ID extends Serializable> implements CrudRepository<T,ID>{

    @PersistenceContext
    protected EntityManager entityManager;

    private  Class<T> entityClzObj;

    public CrudRepositoryImpl(){
       this.entityClzObj= (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Override
    public T save(T entity) {
       return entityManager.merge(entity);

    }
    @Override
    public void deleteById(ID pk) {

        entityManager.remove(entityManager.getReference(entityClzObj,pk));
    }

    @Override
    public boolean existById(ID pk) {
      return findById(pk).isPresent();
    }

    @Override
    public Optional<T> findById(ID pk) {

      return Optional.ofNullable(entityManager.find(entityClzObj,pk));
    }

    @Override
    public List<T> findAll() {
       return entityManager.createQuery("SELECT e FROM "+entityClzObj.getName()+" e",entityClzObj).getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM "+entityClzObj.getName()+" e",Long.class).getSingleResult();
    }
}
