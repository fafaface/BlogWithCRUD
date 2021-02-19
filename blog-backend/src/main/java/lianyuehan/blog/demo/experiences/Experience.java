package lianyuehan.blog.demo.experiences;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//id name grade
@Entity
public class Experience {
    private @Id @GeneratedValue Long id;
    private String title;
    private Date startDate;
    private Date endDate;
    private String institution;
    private String role;
    private String description;

    public Experience() {
    }

    public Experience(String title, Date startDate, Date endDate, String institution, String role, String description) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.institution = institution;
        this.role = role;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getInstitution() {
        return institution;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
