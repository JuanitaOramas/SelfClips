package eci.selfClips.web.controller.Comment;

import eci.selfClips.exception.CommentNotFoundException;
import eci.selfClips.models.comment.Comment;
import eci.selfClips.models.comment.CommentDto;
import eci.selfClips.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(@Autowired CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.save(comment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllProducts() {
        List<Comment> comments = commentService.all();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comment> findById(@PathVariable("id") String id) {
        Optional<Comment> optionalComment = commentService.findById(id);
        if(optionalComment.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return ResponseEntity.ok(optionalComment.get());
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Comment> updateComment(@PathVariable("id") String id, @RequestBody CommentDto commentDto){
        Optional<Comment> existingComment = commentService.findById(id);
        if(existingComment.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        Comment comment = existingComment.get();
        comment.update(commentDto);
        Comment updatedComment = commentService.save(comment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id){
        Optional<Comment> existingComment = commentService.findById(id);
        if(existingComment.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}