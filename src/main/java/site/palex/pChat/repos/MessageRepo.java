package site.palex.pChat.repos;

import org.springframework.data.repository.CrudRepository;
import site.palex.pChat.domain.Message;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//Главными компонентами для взаимодействий с БД в Spring Data являются репозитории. Каждый репозиторий работает со своим классом-сущностью.
// Самым простым способом создания репозитория является создание интерфейса с наследованием от CrudRepository, как показано в примере:
public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
}

/*
Волшебные методы

Ещё один способ создания запросов, реализованный в Spring Data — волшебные методы. Если в репозитории существуют методы, поведение которых не описано именованными запросами,
а так же имена которых начинаются с findBy, countBy или deleteBy, то Spring Data автоматически преобразует их именованные запросы.
Например, следующий метод будет преобразован в запрос «from Person p where name like ?»:
public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> findByNameLike(String email);
}
Данный способ предпочтителен для описания запросов, но до тех пор, пока запрос не будет сильно сложным.
 */