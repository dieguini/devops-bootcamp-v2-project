package repositories.interfaces;

import java.util.List;

public interface IPersonRepository<T, CODE> {
    List<T> getAll();
    T getPersonByCode(CODE code);
    <S extends T> S addPerson(S s);
}
