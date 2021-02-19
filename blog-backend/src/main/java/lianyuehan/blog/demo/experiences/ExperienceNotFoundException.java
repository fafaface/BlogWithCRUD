package lianyuehan.blog.demo.experiences;

public class ExperienceNotFoundException extends RuntimeException {
    ExperienceNotFoundException(Long id) {
        super("Could not find experience " + id);
      }
}