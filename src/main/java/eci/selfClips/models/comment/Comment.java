package eci.selfClips.models.comment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "comment_collection")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String description;
    private String userId;
    private Integer likes;

    public Comment(){

    }
    public Comment(String id, String description, String userId, Integer likes) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.likes = likes;
    }

    public Comment(CommentDto commentDto){
        this.id = null;
        this.description = commentDto.getDescription();
        this.userId = commentDto.getUserId();
        this.likes = commentDto.getLikes();
    }

    public String getId() {
        return id;
    }
    public String getDescription() {return description;}
    public void setDescription(String description){ this.description = description;}
    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}
    public Integer getLikes(){return likes;}
    public void setLikes(Integer likes){this.likes = likes;}

    public void update(CommentDto commentDto){
        this.description = commentDto.getDescription();
        this.userId = commentDto.getUserId();
        this.likes = commentDto.getLikes();
    }
    @Override
    public String toString(){
        return "Comment{" +
                "id = '" + id + '\'' +
                ", description = '" + description + '\'' +
                ", userId = '" + userId + '\'' +
                ", likes = '" + likes + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment c = (Comment) o;
        return Objects.equals(c.likes, likes) && Objects.equals(id, c.id) && Objects.equals(description, c.description) && Objects.equals(userId, c.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, userId, likes);
    }
}
