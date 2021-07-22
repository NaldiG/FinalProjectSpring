package FinalProject.IMDB.Repository;

import FinalProject.IMDB.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
