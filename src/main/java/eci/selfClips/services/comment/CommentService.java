package eci.selfClips.services.comment;

import eci.selfClips.models.comment.Comment;

import java.util.List;
import java.util.Optional;
public interface CommentService {

    Comment save(Comment comment);
    Optional<Comment> findById(String id);
    List<Comment> all();
    void deleteById(String id);
    Comment update(Comment comment, String commentId);
}
