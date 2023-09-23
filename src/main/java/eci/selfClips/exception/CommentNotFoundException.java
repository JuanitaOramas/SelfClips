package eci.selfClips.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommentNotFoundException extends ResponseStatusException{

    public CommentNotFoundException(String id){ super(HttpStatus.NOT_FOUND, "product with ID: " + id + "not found"); }
}
