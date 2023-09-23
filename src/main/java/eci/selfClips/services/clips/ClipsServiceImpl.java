package eci.selfClips.services.clips;

import eci.selfClips.models.clips.Clip;
import eci.selfClips.repository.ClipsMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClipsServiceImpl implements ClipsService {

    private final ClipsMongoRepository clipsMongoRepository;

    public ClipsServiceImpl(ClipsMongoRepository clipsMongoRepository) {
        this.clipsMongoRepository = clipsMongoRepository;
    }

    @Override
    public Clip save(Clip clip) {
        return this.clipsMongoRepository.save(clip);
    }

    @Override
    public List<Clip> all() {
        return this.clipsMongoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        this.clipsMongoRepository.deleteById(id);
    }

    @Override
    public Clip update(Clip clip, String clipId) {
        return this.clipsMongoRepository.save(clip);
    }
}
