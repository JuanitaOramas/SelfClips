package eci.selfClips.repository.thread;

import java.util.List;

public class ThreadDto {

    private String question;
    private List<String> tags;
    private Integer likes;

    public ThreadDto() {
        this.question = "";
        this.tags = null;
        this.likes = 0;
    }

    public ThreadDto(String question, List<String> tags, Integer likes) {
        this.question = question;
        this.tags = tags;
        this.likes = likes;
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
}