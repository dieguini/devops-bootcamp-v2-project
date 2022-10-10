package repositories.interfaces;

import java.util.List;

public interface IRepository<T, CODE> {
    List<T> getAll();
    T getByCode(CODE code);
    <S extends T> S add(S s);
}
