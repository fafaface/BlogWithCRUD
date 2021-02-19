package lianyuehan.blog.demo.experiences;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class ExperienceController {
    private final ExperienceRepository repository;

    ExperienceController(ExperienceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/experiences")
    @CrossOrigin
    public List<Experience> all() {
        return repository.findAll();
    }
    
    @GetMapping("/api/experiences/{id}")
    @CrossOrigin
    public Experience one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new ExperienceNotFoundException(id));
    }

    @PostMapping("/api/experiences")
    @CrossOrigin
    public Experience newExperience(@RequestBody Experience newExperience) {
        return repository.save(newExperience);
    }
    
    //Single item
    @PutMapping("/api/experiences/{id}")
    @CrossOrigin
    public Experience replaceExperience(@RequestBody Experience newExperience, @PathVariable Long id) {
        return repository.findById(id).map(Experience-> {
            Experience.setTitle(newExperience.getTitle());
            Experience.setStartDate(newExperience.getStartDate());
            Experience.setEndDate(newExperience.getEndDate());
            Experience.setInstitution(newExperience.getInstitution());
            Experience.setRole(newExperience.getRole());
            Experience.setDescription(newExperience.getDescription());
            return repository.save(Experience);
        }).orElseGet(() -> {
            newExperience.setId(id);
            return repository.save(newExperience);
        });
    }

    @DeleteMapping("/api/experiences/{id}")
    @CrossOrigin
    public void deleteExperience(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
