package repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository<T, CODE> {
    List<T> getAll();
    Optional<T> getPersonByCode(CODE code);
    <S extends T> S addPerson(S s);
}
