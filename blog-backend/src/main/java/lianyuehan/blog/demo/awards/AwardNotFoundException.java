package lianyuehan.blog.demo.awards;

public class AwardNotFoundException extends RuntimeException {
    AwardNotFoundException(Long id) {
        super("Could not find award " + id);
      }
}