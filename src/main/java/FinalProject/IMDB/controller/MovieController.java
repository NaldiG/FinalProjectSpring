package FinalProject.IMDB.controller;

import FinalProject.IMDB.Model.Movie;
import FinalProject.IMDB.services.MovieService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value ="/five", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> randomMovies() throws JSONException {
        List<Movie> movies = movieService.findAll();
        Random rand = new Random();
        List<JSONObject> jsonObjects = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            Movie movie = movies.get(rand.nextInt(movies.size()));
            JSONObject json = new JSONObject();
            json.put("id", Integer.toString(movie.getId()));
            json.put("title", movie.getTitle());
            json.put("date", movie.getDate());
            json.put("genre", movie.getGenre());
            json.put("duration", movie.getDuration());
            json.put("plot", movie.getPlot());
            json.put("production", movie.getProduction());
            json.put("score", Double.toString(movie.getScore()));
            json.put("voters", Integer.toString(movie.getVoters()));
            json.put("poster", movie.getPoster());
            json.put("rating", movie.getRating());
            jsonObjects.add(json);
        }
        return ResponseEntity.status(HttpStatus.OK).body(jsonObjects.toString());
    }

    @RequestMapping(value ="/best", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> bestMovies() throws JSONException {
        List<Movie> movies = movieService.findBest();
        List<JSONObject> jsonObjects = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            Movie movie = movies.get(i);
            JSONObject json = new JSONObject();
            json.put("id", Integer.toString(movie.getId()));
            json.put("title", movie.getTitle());
            json.put("date", movie.getDate());
            json.put("genre", movie.getGenre());
            json.put("duration", movie.getDuration());
            json.put("plot", movie.getPlot());
            json.put("production", movie.getProduction());
            json.put("score", Double.toString(movie.getScore()));
            json.put("voters", Integer.toString(movie.getVoters()));
            json.put("poster", movie.getPoster());
            json.put("rating", movie.getRating());
            jsonObjects.add(json);
        }
        return ResponseEntity.status(HttpStatus.OK).body(jsonObjects.toString());
    }

    @RequestMapping(value ="/popular", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> popularMovies() throws JSONException {
        List<Movie> movies = movieService.findPopular();
        List<JSONObject> jsonObjects = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            Movie movie = movies.get(i);
            JSONObject json = new JSONObject();
            json.put("id", Integer.toString(movie.getId()));
            json.put("title", movie.getTitle());
            json.put("date", movie.getDate());
            json.put("genre", movie.getGenre());
            json.put("duration", movie.getDuration());
            json.put("plot", movie.getPlot());
            json.put("production", movie.getProduction());
            json.put("score", Double.toString(movie.getScore()));
            json.put("voters", Integer.toString(movie.getVoters()));
            json.put("poster", movie.getPoster());
            json.put("rating", movie.getRating());
            jsonObjects.add(json);
        }
        return ResponseEntity.status(HttpStatus.OK).body(jsonObjects.toString());
    }

    @RequestMapping(value ="/search/{title}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> searchMovies(@PathVariable(value="title") String title) throws JSONException {
        List<Movie> movies = movieService.findMovieByTitle(title);
        List<JSONObject> jsonObjects = new ArrayList<>();
        for(int i = 0; i < movies.size(); i++){
            Movie movie = movies.get(i);
            JSONObject json = new JSONObject();
            json.put("id", Integer.toString(movie.getId()));
            json.put("title", movie.getTitle());
            json.put("date", movie.getDate());
            json.put("genre", movie.getGenre());
            json.put("duration", movie.getDuration());
            json.put("plot", movie.getPlot());
            json.put("production", movie.getProduction());
            json.put("score", Double.toString(movie.getScore()));
            json.put("voters", Integer.toString(movie.getVoters()));
            json.put("poster", movie.getPoster());
            json.put("rating", movie.getRating());
            jsonObjects.add(json);
        }
        return ResponseEntity.status(HttpStatus.OK).body(jsonObjects.toString());
    }

}
