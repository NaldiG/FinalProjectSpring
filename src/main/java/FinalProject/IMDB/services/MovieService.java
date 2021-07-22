package FinalProject.IMDB.services;

import FinalProject.IMDB.Model.Movie;
import FinalProject.IMDB.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMovieByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public List<Movie> findBest() {
        return movieRepository.findAllByOrderByScoreDesc();
    }

    public List<Movie> findPopular() {
        return movieRepository.findAllByOrderByVotersDesc();
    }

    public Movie saveUser(Movie movie) {

        return movieRepository.save(movie);
    }
}
