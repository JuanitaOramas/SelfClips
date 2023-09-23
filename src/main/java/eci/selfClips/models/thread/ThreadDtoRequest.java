package eci.selfClips.models.thread;

import java.util.List;

public class ThreadDtoRequest {

    private String question;
    private List<String> tags;

    public ThreadDtoRequest(String question, List<String> tags) {
        this.question = question;
        this.tags = tags;
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

}