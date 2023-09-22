package eci.selfClips.repository.thread;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadMongoRepository extends MongoRepository<Thread, String> {
}
