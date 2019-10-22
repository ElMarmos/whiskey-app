package co.drillapp.whiskey_app.repositories;

import co.drillapp.whiskey_app.entities.WhiskeyRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WhiskeyRecordRepository extends MongoRepository<WhiskeyRecord, String> {

    List<WhiskeyRecord> findAllByRecordAfter(LocalDateTime localDateTime);
}
