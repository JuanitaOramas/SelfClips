package eci.selfClips.controller.thread.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ThreadNotFoundException extends ResponseStatusException {
    public ThreadNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "thread with ID: " + id + " not found");
    }
}
