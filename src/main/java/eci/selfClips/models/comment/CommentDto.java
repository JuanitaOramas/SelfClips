package eci.selfClips.models.comment;

public class CommentDto {
    private String id;
    private final String description;
    private final String userId;
    private final Integer likes;

    public CommentDto() {
        this.description = "";
        this.userId = "";
        this.likes = 0;
    }

    public CommentDto(String description, String userId, Integer likes) {
        this.description = description;
        this.userId = userId;
        this.likes = likes;
    }

    public String getDescription(){return description;}
    public String getUserId(){return userId;}
    public Integer getLikes(){return likes;}
}
