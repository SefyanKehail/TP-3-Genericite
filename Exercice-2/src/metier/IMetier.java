package metier;

import java.util.List;

public interface IMetier<T, U> {
    void add(T o);

    List<T> getAll();

    T findById(U id);

    void delete(U id);
}
