package eci.selfClips.models.clips;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Clip {

    @Id
    private String id;
    private String description;
    private String title;
    private String tags;
    private String urlClip;
    private String hearts;
}
