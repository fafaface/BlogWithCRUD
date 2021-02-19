package lianyuehan.blog.demo.spots;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class SpotController {
    private final SpotRepository repository;

    SpotController(SpotRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/spots")
    @CrossOrigin
    public List<Spot> all(@RequestParam(value = "type",defaultValue = "") String type) {
        if(type.equals("")) {
            return repository.findAll();
        } else {
            return repository.findByType(type);
        }
    }
    
    @GetMapping("/api/spots/{id}")
    @CrossOrigin
    public Spot one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new SpotNotFoundException(id));
    }

    @PostMapping("/api/spots")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    public Spot newSpot(@RequestBody Spot newSpot) {
        return repository.save(newSpot);
    }
    
    //Single item
    @PutMapping("/api/spots/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    public Spot replaceSpot(@RequestBody Spot newSpot, @PathVariable Long id) {
        return repository.findById(id).map(spot-> {
            spot.setType(newSpot.getType());
            spot.setTitle(newSpot.getTitle());
            spot.setDescription(newSpot.getDescription());
            spot.setImgurl(newSpot.getImgurl());
            return repository.save(spot);
        }).orElseGet(() -> {
            newSpot.setId(id);
            return repository.save(newSpot);
        });
    }

    @DeleteMapping("/api/spots/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    public void deleteSpot(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
