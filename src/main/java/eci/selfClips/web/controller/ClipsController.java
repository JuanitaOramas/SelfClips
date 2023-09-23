package eci.selfClips.web.controller;

import eci.selfClips.models.clips.Clip;
import eci.selfClips.services.clips.ClipsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clips")
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

}