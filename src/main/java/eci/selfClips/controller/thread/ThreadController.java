package eci.selfClips.controller.thread;

import eci.selfClips.controller.thread.exception.ThreadNotFoundException;
import eci.selfClips.models.thread.ThreadEntity;
import eci.selfClips.models.thread.ThreadDtoResponse;
import eci.selfClips.models.thread.ThreadDtoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eci.selfClips.services.thread.ThreadsService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/threads")
public class ThreadController{

    private final ThreadsService threadsService;

    public ThreadController(@Autowired ThreadsService threadsService) {
        this.threadsService = threadsService;
    }

    @PostMapping
    public ResponseEntity<ThreadEntity> createThread(@RequestBody ThreadDtoResponse threadDtoResponse) {
        var savedThread = threadsService.save(new ThreadEntity(threadDtoResponse));
        URI createdThreadUri = URI.create("/v1/threads/" + savedThread.getId());
        return ResponseEntity.created(createdThreadUri).body(savedThread);
    }

    @GetMapping
    public ResponseEntity<List<ThreadEntity>> getAllThreads() {
        List<ThreadEntity> threadEntities = threadsService.all();
        return ResponseEntity.ok(threadEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThreadEntity> findById(@PathVariable("id") String id) {
        Optional<ThreadEntity> optionalThread = threadsService.findById(id);
        if (optionalThread.isEmpty()) {
            throw new ThreadNotFoundException(id);
        }
        return ResponseEntity.ok(optionalThread.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThreadEntity> updateThread(@PathVariable("id") String id, @RequestBody ThreadDtoRequest threadDtoRequest) {
        return ResponseEntity.ok(threadsService.update(threadDtoRequest, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteThread(@PathVariable("id") String id) {
        Optional<ThreadEntity> existingThread = threadsService.findById(id);
        if (existingThread.isEmpty()) {
            throw new ThreadNotFoundException(id);
        }
        threadsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}