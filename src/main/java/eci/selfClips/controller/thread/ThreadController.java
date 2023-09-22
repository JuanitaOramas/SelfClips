package eci.selfClips.controller.thread;

import eci.selfClips.repository.thread.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/threads")
public class ThreadController{

    private final ThreadsService threadsService;

    public ThreadController(@Autowired ThreadsService threadsService) {
        this.threadsService = threadsService;
    }

    /*@GetMapping
    public String hello(){
        return "Hello World";
    }*/

    @PostMapping
    public ResponseEntity<Thread> createThread(@RequestBody ThreadDto threadDto) {
        var savedThread = threadsService.save(new Thread(threadDto));
        URI createdThreadUri = URI.create("/v1/threads/" + savedThread.getId());
        return ResponseEntity.created(createdThreadUri).body(savedThread);
    }

    @GetMapping
    public ResponseEntity<List<Thread>> getAllThreads() {
        List<Thread> threads = threadsService.all();
        return ResponseEntity.ok(threads);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id) {
        Optional<Product> optionalProduct = productsService.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        return ResponseEntity.ok(optionalProduct.get());
    }
}