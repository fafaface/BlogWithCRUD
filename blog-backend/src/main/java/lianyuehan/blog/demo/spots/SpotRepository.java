package lianyuehan.blog.demo.spots;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findByType(String type);
}