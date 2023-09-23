package eci.selfClips.models.thread;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

//@Document(collection = "thread_collection")
public class ThreadEntity implements Serializable {

    @Id
    private String id;
    private String question;
    private List<String> tags;
    private Integer likes;


    public ThreadEntity(String id, String question, List<String> tags, Integer likes) {
        this.id = id;
        this.question = question;
        this.tags = tags;
        this.likes = likes;
    }

    public ThreadEntity(ThreadDtoResponse threadDtoResponse) {
        this.id = null;
        this.question = threadDtoResponse.getQuestion();
        this.tags = threadDtoResponse.getTags();
        this.likes = threadDtoResponse.getLikes();
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

    public void update(ThreadDtoRequest threadDtoRequest) {
        if(threadDtoRequest.getQuestion() != null && !threadDtoRequest.getQuestion().isEmpty()){
            this.question = threadDtoRequest.getQuestion();
        }
        if(threadDtoRequest.getTags() != null && !threadDtoRequest.getTags().isEmpty()){
            this.tags = threadDtoRequest.getTags();
        }
    }

    @Override
    public String toString() {
        return "ThreadEntity{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", tags=" + tags +
                ", likes=" + likes +
                '}';
    }
}