package lianyuehan.blog.demo.courses;

public class CourseNotFoundException extends RuntimeException {
    CourseNotFoundException(Long id) {
        super("Could not find course " + id);
      }
}