package net.engineeringdigest.journalApp.Repository;

import com.mongodb.client.MongoDatabase;
import net.engineeringdigest.journalApp.Entity.ConfigJournalAppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface configJournalAppRepository extends MongoRepository<ConfigJournalAppEntity,Id> {
}
