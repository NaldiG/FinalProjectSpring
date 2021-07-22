package FinalProject.IMDB;

import FinalProject.IMDB.Model.Crew;
import FinalProject.IMDB.Model.Movie;
import FinalProject.IMDB.Model.Review;
import FinalProject.IMDB.Model.User;
import FinalProject.IMDB.Repository.CrewRepository;
import FinalProject.IMDB.Repository.MovieRepository;
import FinalProject.IMDB.Repository.ReviewRepository;
import FinalProject.IMDB.Repository.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class Seed {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CrewRepository crewRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        /*
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        Review review = new Review();
        review.setContent("content");
        review.setScore(3);
        review.setUser(user);
        userRepository.save(user);
        reviewRepository.save(review);

        //0 1 4 5* 6 9* 10* 11* 12* 13 14 15
        try {
            FileReader file = new FileReader("IMDb movies.csv");
            BufferedReader reader = new BufferedReader(file);
            int counter = 0;

            String line;
            while((line = reader.readLine()) != null && counter < 101) {
                // System.out.println(line);
                counter++;
                if(counter == 1){
                    continue;
                }
                String [] tokens = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                tokens[5] = tokens[5].replace('"', ' ');
                tokens[5] = tokens[5].trim();
                tokens[9] = tokens[9].replace('"', ' ');
                tokens[9] = tokens[9].trim();
                tokens[10] = tokens[10].replace('"', ' ');
                tokens[10] = tokens[10].trim();
                tokens[11] = tokens[11].replace('"', ' ');
                tokens[11] = tokens[11].trim();
                tokens[12] = tokens[12].replace('"', ' ');
                tokens[12] = tokens[12].trim();

                Movie movie = new Movie();
                movie.setImdb(tokens[0]);
                movie.setTitle(tokens[1]);
                movie.setDate(tokens[4]);
                movie.setGenre(tokens[5]);
                movie.setDuration(tokens[6]);
                movie.setProduction(tokens[11]);
                movie.setPlot(tokens[13]);
                movie.setScore(Double.parseDouble(tokens[14]));
                movie.setVoters(Integer.parseInt(tokens[15]));

                String[] directors = tokens[9].split(",");
                for (String director: directors) {
                    Crew crew = new Crew();
                    crew.setName(director);
                    crew.setRole("director");
                    movie.getCrew().add(crew);
                    crewRepository.save(crew);
                }

                String[] writers = tokens[10].split(",");
                for (String writer: writers) {
                    Crew crew = new Crew();
                    crew.setName(writer);
                    crew.setRole("writer");
                    movie.getCrew().add(crew);
                    crewRepository.save(crew);
                }

                String[] actors = tokens[12].split(",");
                for (String actor: actors) {
                    Crew crew = new Crew();
                    crew.setName(actor);
                    crew.setRole("actor");
                    movie.getCrew().add(crew);
                    crewRepository.save(crew);
                }
                movieRepository.save(movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        /*
        List<Crew> cast = crewRepository.findAll();
        for(Crew crew: cast){
            try {
                FileReader file = new FileReader("IMDb names.csv");
                BufferedReader reader = new BufferedReader(file);

                String line;
                while ((line = reader.readLine()) != null) {
                    String [] tokens = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                    if(crew.getName().equals(tokens[1])){
                        tokens[5] = tokens[5].replace('"', ' ');
                        tokens[5] = tokens[5].trim();
                        tokens[4] = tokens[4].replace('"', ' ');
                        tokens[4] = tokens[4].trim();
                        crew.setInfo(tokens[5]);
                        crew.setBirth(tokens[4]);
                        crewRepository.save(crew);
                    }
                }
                reader.close();
                file.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        /*
        List<Movie> movies = movieRepository.findAll();
        for(Movie movie: movies) {
            try {
                String movieId = movie.getImdb();
                URL url = new URL("http://www.omdbapi.com/?apikey=6dc7931b&i=" + movieId);
                InputStream inputStream = url.openStream();
                InputStreamReader isReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isReader);

                String response = reader.readLine();
                System.out.println(response);
                JSONObject json = new JSONObject(response);
                String status = json.get("Response").toString();
                if (status.equals("False")) {
                    System.out.println("Movie not found");
                } else {
                    movie.setPoster(json.get("Poster").toString());
                    movie.setRating(json.get("Rated").toString());
                    movieRepository.save(movie);
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
         */
    }

}
