package eci.selfClips.repository.Comment;

import eci.selfClips.models.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMongoRepository extends MongoRepository<Comment, String>{
}
