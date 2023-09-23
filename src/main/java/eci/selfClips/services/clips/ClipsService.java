package eci.selfClips.services.clips;

import eci.selfClips.models.clips.Clip;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClipsService {


    Clip save(Clip clip);

    List<Clip> all();

    void deleteById(String id);

    Clip update(Clip clip, String clipId);

}
