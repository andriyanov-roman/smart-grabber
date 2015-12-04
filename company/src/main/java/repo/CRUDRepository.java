package repo;


public interface CRUDRepository<T> {

    void save(T t);

    T read(Long id);

    void delete(T t);

    T update(T t);

}
