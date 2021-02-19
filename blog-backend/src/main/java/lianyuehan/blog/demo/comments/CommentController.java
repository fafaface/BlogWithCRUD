package lianyuehan.blog.demo.comments;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class CommentController {
    private final CommentRepository repository;

    CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/comments")
    @CrossOrigin
    public List<Comment> all() {
        return repository.findAll();
    }

    @GetMapping("/api/comments/{id}")
    @CrossOrigin
    public Comment one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
    }

    @PostMapping("/api/comments")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @CrossOrigin
    public Comment newComment(@RequestBody Comment newComment) {
        return repository.save(newComment);
    }

    @DeleteMapping("/api/comments/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    public void deleteComment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
