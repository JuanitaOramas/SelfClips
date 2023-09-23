package eci.selfClips.services.thread;

import eci.selfClips.models.thread.ThreadDtoRequest;
import eci.selfClips.models.thread.ThreadEntity;
import eci.selfClips.models.thread.ThreadDtoResponse;

import java.util.List;
import java.util.Optional;


public interface ThreadsService {

    ThreadEntity save(ThreadEntity threadEntity);

    Optional<ThreadEntity> findById(String id);

    List<ThreadEntity> all();

    void deleteById(String id);

    ThreadEntity update(ThreadDtoRequest threadDtoRequest, String ThreadId);
}