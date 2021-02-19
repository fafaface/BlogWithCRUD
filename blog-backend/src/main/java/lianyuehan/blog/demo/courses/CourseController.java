package lianyuehan.blog.demo.courses;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class CourseController {
    private final CourseRepository repository;

    CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/courses")
    @CrossOrigin
    public List<Course> all() {
        return repository.findAll();
    }
    
    @GetMapping("/api/courses/{id}")
    @CrossOrigin
    public Course one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new CourseNotFoundException(id));
    }

    @PostMapping("/api/courses")
    @CrossOrigin
    public Course newCourse(@RequestBody Course newCourse) {
        return repository.save(newCourse);
    }
    
    //Single item
    @PutMapping("/api/courses/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    public Course replaceCourse(@RequestBody Course newCourse, @PathVariable Long id) {
        return repository.findById(id).map(Course-> {
            Course.setName(newCourse.getName());
            Course.setGrade(newCourse.getGrade());
            return repository.save(Course);
        }).orElseGet(() -> {
            newCourse.setId(id);
            return repository.save(newCourse);
        });
    }

    @DeleteMapping("/api/courses/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    public void deleteCourse(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
