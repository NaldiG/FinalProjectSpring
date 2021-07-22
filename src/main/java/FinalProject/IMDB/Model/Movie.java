package FinalProject.IMDB.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imdb;
    private String title;
    private String date;
    private String genre;
    private String duration;
    private String plot;
    private String production;
    private double score;
    private int voters;
    private String poster;
    private String rating;

    @ManyToMany
    @JoinTable
    private Set<Crew> crew = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews = new HashSet<>();

}