package eci.selfClips.services.comment;

import eci.selfClips.models.comment.Comment;
import eci.selfClips.repository.Comment.CommentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceMongoDb implements CommentService{

    private final CommentMongoRepository commentMongoRepository;

    @Autowired
    public CommentServiceMongoDb(CommentMongoRepository commentMongoRepository){
        this.commentMongoRepository = commentMongoRepository;
    }
    @Override
    public Comment save(Comment comment){
        return commentMongoRepository.save(comment);
    }

    @Override
    public Optional<Comment> findById(String id){
        return commentMongoRepository.findById(id);
    }

    @Override
    public List<Comment> all(){
        return commentMongoRepository.findAll();
    }

    @Override
    public void deleteById(String id){
        commentMongoRepository.deleteById(id);
    }

    @Override
    public Comment update(Comment comment, String commentId){
        Comment commentToUpdate = commentMongoRepository.findById(commentId).orElse(null);
        if (commentToUpdate != null){
            commentToUpdate.setDescription(comment.getDescription());
            return commentMongoRepository.save(commentToUpdate);
        }
        else{
            return null;
        }
    }
}
