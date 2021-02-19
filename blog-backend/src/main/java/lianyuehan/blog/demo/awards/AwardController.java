package lianyuehan.blog.demo.awards;

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
public class AwardController {
    private final AwardRepository repository;

    AwardController(AwardRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/awards")
    @CrossOrigin
    public List<Award> all() {
        return repository.findAll();
    }

    @GetMapping("/api/awards/{id}")
    @CrossOrigin
    public Award one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new AwardNotFoundException(id));
    }

    @PostMapping("/api/awards")
    @CrossOrigin
    public Award newAward(@RequestBody Award newAward) {
        return repository.save(newAward);
    }

    // Single item
    @PutMapping("/api/awards/{id}")
    @CrossOrigin
    public Award replaceAward(@RequestBody Award newAward, @PathVariable Long id) {
        return repository.findById(id).map(Award -> {
            Award.setAwardDate(newAward.getAwardDate());
            Award.setTitle(newAward.getTitle());
            return repository.save(Award);
        }).orElseGet(() -> {
            newAward.setId(id);
            return repository.save(newAward);
        });
    }

    @DeleteMapping("/api/awards/{id}")
    @CrossOrigin
    public void deleteAward(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
