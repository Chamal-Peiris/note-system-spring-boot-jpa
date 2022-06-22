package lk.ijse.dep.notes.repository;


import lk.ijse.dep.notes.entity.SuperEntity;


import java.io.Serializable;
import java.util.Optional;
import java.util.List;

public interface CrudRepository<T extends SuperEntity,ID extends Serializable> extends SuperRepository {

    ID save(T entity);
    void deleteById(ID pk);
    boolean existById(ID pk);
    Optional<T>findById(ID pk);
    List<T> findAll();
    long count();

}
