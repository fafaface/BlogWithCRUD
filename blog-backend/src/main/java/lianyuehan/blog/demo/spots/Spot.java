package lianyuehan.blog.demo.spots;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Spot {
    private @Id @GeneratedValue Long id;
    private String type;
    private String title;
    private String description;
    private String imgurl;

    public Spot() {
    }

    public Spot(String type, String title, String description, String imgurl) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.imgurl = imgurl;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
