package lianyuehan.blog.demo.spots;

public class SpotNotFoundException extends RuntimeException {
    SpotNotFoundException(Long id) {
        super("Could not find spot " + id);
      }
}