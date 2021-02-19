package lianyuehan.blog.demo.comments;

public class CommentNotFoundException extends RuntimeException {
    CommentNotFoundException(Long id) {
        super("Could not find comment " + id);
      }
}