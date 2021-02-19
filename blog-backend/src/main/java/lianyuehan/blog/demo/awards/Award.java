package lianyuehan.blog.demo.awards;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Award {
    private @Id @GeneratedValue Long id;
    private String title;
    private Date awardDate;

    public Award() {}

    public Award(Date awardDate, String title) {
        this.awardDate = awardDate;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Date getAwardDate() {
        return awardDate;
    }


    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
