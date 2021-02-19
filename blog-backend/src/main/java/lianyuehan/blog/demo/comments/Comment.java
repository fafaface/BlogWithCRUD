package lianyuehan.blog.demo.comments;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
    private @Id @GeneratedValue Long id;
    private String username;
    private Timestamp commentTime;
    private String content;
    
    public Comment() {
    }

    public Comment(String username, Timestamp commentTime, String content) {
        this.username = username;
        this.commentTime = commentTime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
