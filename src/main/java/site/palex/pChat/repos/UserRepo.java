package site.palex.pChat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import site.palex.pChat.domain.User;

//Существует несколько типов репозиториев, различающихся по набору возможностей:
//
//    CrudRepository, указанный в примере, предоставляет базовый набор методов для доступа к данным. Данный интерфейс является универсальным и может быть использован не только в связке с JPA.
//    Repository — базовый тип репозиториев, не содержит каких-либо методов, так же является универсальным.
//    PagingAndSortingRepository — универсальный интерфейс, расширяющий CrudRepository и добавляющий поддержку пейджинации и сортировки.
//    JpaRepository — репозиторий, добавляющий возможности, специфичные для JPA.
//Первый тип User это тип сущности, с которым должен работать данный репозиторий, Long - тип первичного ключа
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
