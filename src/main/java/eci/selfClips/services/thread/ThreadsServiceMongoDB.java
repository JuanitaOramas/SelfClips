package eci.selfClips.services.thread;

import eci.selfClips.controller.thread.exception.ThreadNotFoundException;
import eci.selfClips.models.thread.ThreadDtoRequest;
import eci.selfClips.models.thread.ThreadDtoResponse;
import eci.selfClips.models.thread.ThreadEntity;
import eci.selfClips.repository.ThreadMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreadsServiceMongoDB implements ThreadsService{
    private final ThreadMongoRepository threadMongoRepository;

    @Autowired
    public ThreadsServiceMongoDB(ThreadMongoRepository threadMongoRepository) {
        this.threadMongoRepository = threadMongoRepository;
    }


    @Override
    public ThreadEntity save(ThreadEntity threadEntity) {
        return threadMongoRepository.save(threadEntity);
    }

    @Override
    public Optional<ThreadEntity> findById(String id) {
        return threadMongoRepository.findById(id);
    }

    @Override
    public List<ThreadEntity> all() {
        return threadMongoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        threadMongoRepository.deleteById(id);
    }

    @Override
    public ThreadEntity update(ThreadDtoRequest threadDtoRequest, String threadId) {
        Optional<ThreadEntity> savedThread = threadMongoRepository.findById(threadId);
        if(savedThread.isEmpty()) {
            throw new ThreadNotFoundException(threadId);
        }
        ThreadEntity newThread = savedThread.get();
        newThread.update(threadDtoRequest);
        return threadMongoRepository.save(newThread);
    }
}
