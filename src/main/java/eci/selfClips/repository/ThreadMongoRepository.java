package eci.selfClips.repository;

import eci.selfClips.models.thread.ThreadEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadMongoRepository extends MongoRepository<ThreadEntity, String> {
}
