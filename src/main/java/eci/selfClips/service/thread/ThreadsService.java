package eci.selfClips.service.thread;

import eci.selfClips.repository.thread.Thread;

import java.util.List;
import java.util.Optional;


public interface ThreadsService {

    Thread save(Thread thread);

    Optional<Thread> findById(String id);

    List<Thread> all();

    void deleteById(String id);

    Product update(Thread Thread, String ThreadId);
}