package site.palex.pChat.domain.repos;

import org.springframework.data.repository.CrudRepository;
import site.palex.pChat.domain.Message;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}