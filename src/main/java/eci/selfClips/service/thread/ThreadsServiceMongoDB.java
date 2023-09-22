package eci.selfClips.service.thread;

import eci.selfClips.repository.thread.Thread;
import eci.selfClips.repository.thread.ThreadMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ThreadsServiceMongoDB implements ThreadsService {

    private final ThreadMongoRepository threadMongoRepository;

    @Autowired
    public ThreadsServiceMongoDB(ThreadMongoRepository threadMongoRepository) {
        this.threadMongoRepository = threadMongoRepository;
    }

    @Override
    public Thread save(Thread thread) {
        return threadMongoRepository.save(thread);
    }

    @Override
    public Optional<Thread> findById(String id) {
        return threadMongoRepository.findById(id);
    }

    @Override
    public List<Thread> all() {
        return threadMongoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        threadMongoRepository.deleteById(id);
    }

    @Override
    public Thread update(Thread thread, String threadId) {
        return null;
    }
}