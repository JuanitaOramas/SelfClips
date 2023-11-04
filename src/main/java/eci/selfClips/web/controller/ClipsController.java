package eci.selfClips.web.controller;

import eci.selfClips.models.clips.Clip;
import eci.selfClips.services.clips.ClipsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clips")
class ClipsController {

    private final ClipsService clipsService;

    ClipsController(ClipsService clipsService) {
        this.clipsService = clipsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clip>> getAllClip(){
        return ResponseEntity.ok(this.clipsService.all());
    }


    @PostMapping("/save")
    public ResponseEntity<Clip> saveClip(@RequestBody Clip clip){
        return ResponseEntity.ok(this.clipsService.save(clip));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Clip> deleteClip(@PathVariable("id") String clipId){
        this.clipsService.deleteById(clipId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Clip> updateClip(@RequestBody Clip clip,@PathVariable("id") String clipId){
        return ResponseEntity.ok(this.clipsService.update(clip, clipId));
    }

}