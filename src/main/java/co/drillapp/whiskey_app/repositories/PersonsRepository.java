package co.drillapp.whiskey_app.repositories;

import co.drillapp.whiskey_app.entities.Persons;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonsRepository extends MongoRepository<Persons, String> {
}
