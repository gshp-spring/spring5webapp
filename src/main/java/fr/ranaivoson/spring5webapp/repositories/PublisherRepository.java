package fr.ranaivoson.spring5webapp.repositories;

import fr.ranaivoson.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
