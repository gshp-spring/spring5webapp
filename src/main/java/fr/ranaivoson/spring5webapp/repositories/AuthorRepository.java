package fr.ranaivoson.spring5webapp.repositories;

import fr.ranaivoson.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
