package eci.selfClips.repository.thread;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

//@Document(collection = "thread_collection")
public class Thread implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String question;
    private List<String> tags;
    private Integer likes;


    public Thread(String id, String question, List<String> tags, Integer likes) {
        this.id = id;
        this.question = question;
        this.tags = tags;
        this.likes = likes;
    }

    public Thread(ThreadDto threadDto) {
        this.id = null;
        this.question = threadDto.getQuestion();
        this.tags = threadDto.getTags();
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String question) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void update(ThreadDto threadDto) {
        this.question = threadDto.getQuestion();
        this.tags = threadDto.getTags();
        this.likes = likes;
    }
}