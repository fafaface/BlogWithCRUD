package lianyuehan.blog.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import lianyuehan.blog.demo.courses.Course;
import lianyuehan.blog.demo.courses.CourseRepository;
import lianyuehan.blog.demo.spots.Spot;
import lianyuehan.blog.demo.spots.SpotRepository;
import lianyuehan.blog.demo.users.User;
import lianyuehan.blog.demo.users.UserRepository;
@CrossOrigin
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(SpotRepository spotRepo, CourseRepository courseRepo,
    UserRepository userRepo) {
      return args -> {
        
      //  log.info("Preloading " + userRepo.save(new User("lianyuehan","lianyuehan@outlook.com","114514")));
        

      };
    }
}
